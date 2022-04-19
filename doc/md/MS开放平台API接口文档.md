#  MS开放平台API接口文档

##  一、概述

MS开放平台目标是建立数据共享与交换中心。为新建系统提供数据交换与共享服务。本API接口标准文档适用于MS的信息共享与交换的信息化工作领域。

## 二、接口约定

### 2.1 接口方式约定

MS开放平台借鉴了互联网上的开发平台，服务开放平台的所有服务URL是相同的，请求参数分为系统级参数和业务级参数两部分。系统级参数是所有服务API都拥有的参数，而业务级参数由具体服务API定义。共支持三种方式：HTTP短连接方式、Rest API 短连接方式、WebService方法、Http Socket 长连接方式。

**注意：短链接请求频率默认30秒一次**

#### 2.1.1 统一服务URL

所有的服务都使用统一的URL，通过method系统参数将请求路由到指定的服务方法中完成服务受理。

**Http短连接方式（统一入口）：**http://ServiceIP:Port/msdata/router

**Rest API 短连接方式：**http://ServiceIP:Port/msdata/reseapi/{version}/{method}

**Web Service方式（统一入口）：**http://ServiceIP:Port/msdata/services/router?wsdl

**Http Socket 长连接方式（监听端口）：**ServiceIP:18080

> 说明：这里使用Http短连接方式实现

#### 2.1.2 系统级别参数

系统级参数是由开发平台定义的一组参数，每个服务都拥有这些参数，用以传送框架级的参数信息。平台共有8个系统级参数：

| 名称      | 类型   | 是否必需 | 默认值 | 描述                                           | 签名 |
| --------- | ------ | -------- | ------ | ---------------------------------------------- | ---- |
| appkey    | String | 必需     |        | 分配给引用的应用标识                           | 必需 |
| sessionid | String | 必需     |        | 会话ID，一般是36位的UUID，在登录服务平台后获取 | 必需 |
| method    | String | 必需     |        | API接口名称                                    | 必需 |
| v         | String | 必需     |        | API协议版本，如1.0                             | 必需 |
| format    | String | 可选     | xml    | 指定响应格式，目前支持格式为xml、json          | 必需 |
| locate    | String | 可选     | zh_CN  | 本地化类型，默认zh_CN                          | 必需 |
| _invoke   | String | 可选     |        | Jsonp参数                                      |      |
| sign      | String | 必需     |        | API输入参数签名结果                            |      |

#### 2.1.3 业务级参数

业务及参数，顾名思义是由业务逻辑需要自动定义的，每个服务API都可以定义若干个自己的业务级参数。

#### 2.1.4 接口调用流程

1. 获取appkey（应用标识）、appsecret（应用密钥）、username（接口用户）、password(接口密码）
2. 调用“会话登录”接口，取得sessionid
3. 调用其他需要调用的接口

> 默认情况下sessionid长期有效，只需要调用一次即可。但要考虑平台重启服务，因此如果判断到主错误号：21，即无效的sessionid参数时，可重调调用第二步）

### 2.2 签名算法约定

#### 2.2.1 签名算法描述

 系统默认情况下会启动签名功能，因此所有传入参数必需签名，否则平台将会提示签名无效错误。具体签名算法描述如下：

1. 所有请求参数按参数名升序排序；
2. 按请求参数名及参数值相互连接组成一个字符串：<paramName1><paramValue1><paramName2><paramValue2>……；
3. 将应用密钥分别添加到以上请求参数串的头部和尾部：<appsecret><请求参数字符串><appsecret>；
4. 对该字符串进行SHA1运算，得到一个二进制数组；
5. 将该二进制数组转换为十六进制的字符串，该字符串即是这些请求参数对应的签名;
6. 该签名值使用sign系统级参数一起和其它请求参数一起发送给服务开放平台。

#### 2.2.2  SHA1算法函数

```java
/**
 * SHA1算法
 * @param data
 * @return
 */
private static byte[] getSHA1Digest(String data) throws IOException {
    byte[] bytes = null;
    try {
        MessageDigest md = MessageDigest.getInstance("SHA-1");
        bytes = md.digest(data.getBytes("UTF8"));
    } catch (GeneralSecurityException gse) {
        throw new IOException(gse.getMessage());
    }
    return bytes;
}
```

#### 2.2.3 Sign算法函数

```java
/**
 * 对paramValues进行签名，其中ignoreParamNames这些参数不参与签名
 * @param paramValues
 * @param ignoreParamNames
 * @param secret
 * @return
 */
@SneakyThrows
public static String sign(Map<String, String> paramValues, List<String> ignoreParamNames, String secret){
    try {
        StringBuilder sb = new StringBuilder();
        List<String> paramNames = new ArrayList<String>(paramValues.size());
        paramNames.addAll(paramValues.keySet());
        if(ignoreParamNames != null && ignoreParamNames.size() > 0){
            for (String ignoreParamName : ignoreParamNames) {
                paramNames.remove(ignoreParamName);
            }
        }
        Collections.sort(paramNames);

        sb.append(secret);
        for (String paramName : paramNames) {
            sb.append(paramName).append(paramValues.get(paramName));
        }
        sb.append(secret);

        byte[] sha1Digest = getSHA1Digest(sb.toString());
        return byte2hex(sha1Digest);
    } catch (IOException e) {
        throw new RopException(e);
    }
}

/**
 * 二进制转十六进制字符串
 *
 * @param bytes
 * @return
 */
private static String byte2hex(byte[] bytes) {
    StringBuilder sign = new StringBuilder();
    for (int i = 0; i < bytes.length; i++) {
        String hex = Integer.toHexString(bytes[i] & 0xFF);
        if (hex.length() == 1) {
            sign.append("0");
        }
        sign.append(hex.toUpperCase());
    }
    return sign.toString();
}
```

> 注意：这里throw RopException(e)

### 2.3 数据类型约定

类型约定近指通用数据上传、通用数据下载、通用数据查询等相关数据库中的资源表操作API涉及的数据类型。

| 类型  | 定义                                                         |
| ----- | ------------------------------------------------------------ |
| ID    | 32位16进制整数（占16个字节），用作数据记录的唯一标识数据库中用RAW类型 |
| N     | 有符号4字节整数，范围：[02147483648,214783647] NUMBER(大于5,0) |
| F     | 浮点数 FLOAT DOUBLE                                          |
| D     | 日期 Date                                                    |
| DT    | 日期+时间，根据应用决定时间的标识精度 数据库中用TIMESTAMP类型 |
| M     | 货币，IEEE64位（占8个字节）数据标准 数据库中用 DECIMALl类型  |
| C数字 | 字符串类型，数字表示最大长度。比如：C100表示最大长度为100个拉丁字符（字符）的字符串 |
| BB    | 用BASE64编码（二进制大数据量对象），数据库中用BLOB类型       |
| CB    | 字符大数据量对象，数据库中用CLOB类型                         |

### 2.4 异常返回约定

对于服务开发平台服务来说，不管发生了什么错误，都必须返回响应的错误报文以便客户端应用能够根据错误报文做出相应的响应。每个服务都可能存在各种错误，如服务参数不合法、访问权限不足、版本不正确和访问超限等等。

#### 2.4.1 返回结果

主错误

| 名称       | 类型       | 是否必需 | 默认值 | 描述                                |
| ---------- | ---------- | -------- | ------ | ----------------------------------- |
| code       | int        | 必需     |        | 主错误码（ISP平台提供服务方返回）   |
| errorToken | String     | 必需     |        | 主错误编码（ISP平台服务方返回）     |
| message    | String     | 必需     |        | 主错误信息（ISP平台提供服务方返回） |
| solution   | String     | 必需     |        | 主错误原因（ISP平台提供服务方返回） |
| subErrors  | SubError[] |          |        | 子错误（节点）数组                  |

子错误

| 名称     | 类型   | 是否必需 | 默认值 | 描述                          |
| -------- | ------ | -------- | ------ | ----------------------------- |
| code     | String |          |        | 子错误码（ISV服务开发方返回） |
| meassage | String |          |        | 子错误码（ISV服务开发方返回） |

异常封装

```java
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExceptionResult {
    private int code;
    private String errorToken;
    private String message;
    private String solution;
    private List<SubError> subErrors;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    private class SubError {
        private String code;
        private String message;
    }
}
```

#### 2.4.2 主错误编码

| 编码 | 错误说明               |
| ---- | ---------------------- |
| 1    | 服务不可用             |
| 2    | 开发者权限不足         |
| 3    | 用户权限不足           |
| 4    | 图片上传失败           |
| 5    | HTTP方法被禁止         |
| 6    | 编码错误               |
| 7    | 请求禁止               |
| 8    | 服务已作废             |
| 9    | 业务逻辑出错           |
| 20   | 缺少sessionid参数      |
| 21   | 无效sessionid参数      |
| 22   | 缺少appkey参数         |
| 23   | 无效appkey参数         |
| 24   | 缺少签名参数           |
| 25   | 无效签名               |
| 26   | 缺少方法名参数         |
| 27   | 不存在的方法名         |
| 28   | 缺少版本参数           |
| 29   | 非法的版本参数         |
| 30   | 不支持的版本号         |
| 31   | 无效报文格式类型       |
| 32   | 缺少必选参数           |
| 33   | 非法的参数             |
| 34   | 用户调用服务的次数超限 |
| 35   | 会话调用服务次数超限   |
| 36   | 应用调用服务的次数超限 |
| 37   | 应用调用服务的频率超限 |

### 2.5 数据加密约定

注意：加密密钥是appkey前16位值

1. 介于某些数据可能涉密需要加密传输来防止传输过程被劫持，因此平台提供了数据加解密工具类AESUtil（注：如需开启数据加密请告知平台管理开启数据加密）
2. 调用工具类encrypt方法对数据加密（注：需要将数据转成JSON字符串然后再进行加密，否则平台对数据进行解密时，会解密失败）
3. 调用工具类decode方法对数据进行解密

**工具类AESUtil**

```java
public class AESUtil {
    //"算法/模式/补码方式"
    private static final String ALGORITHM = "AES/ECB/PKCS5Padding";

    /*****************************************************
     * AES加密
     * @param content 加密内容
     * @param key 加密密码，由字母或数字组成
    此方法使用AES-128-ECB加密模式，key需要为16位
    加密解密key必须相同，如：abcd1234abcd1234
     * @return 加密密文
     ****************************************************/

    public static String encrypt(String content, String key) {
        try {
            byte[] raw = key.getBytes();  //获得密码的字节数组
            SecretKeySpec skey = new SecretKeySpec(raw, "AES"); //根据密码生成AES密钥
            Cipher cipher = Cipher.getInstance(ALGORITHM);  //根据指定算法ALGORITHM自成密码器
            cipher.init(Cipher.ENCRYPT_MODE, skey); //初始化密码器，第一个参数为加密(ENCRYPT_MODE)或者解密(DECRYPT_MODE)操作，第二个参数为生成的AES密钥
            byte [] byte_content = content.getBytes("utf-8"); //获取加密内容的字节数组(设置为utf-8)不然内容中如果有中文和英文混合中文就会解密为乱码
            byte [] encode_content = cipher.doFinal(byte_content); //密码器加密数据
            return Base64.encodeBase64String(encode_content).replaceAll(System.lineSeparator(), "");//将换行符替换为空; //将加密后的数据转换为字符串返回
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /*****************************************************
     * AES解密
     * @param content 加密密文
     * @param key 加密密码,由字母或数字组成
        此方法使用AES-128-ECB加密模式，key需要为16位
        加密解密key必须相同
     * @return 解密明文
     ****************************************************/
    public static String decrypt(String content, String key) {
        try {
            byte[] raw = key.getBytes();  //获得密码的字节数组
            SecretKeySpec skey = new SecretKeySpec(raw, "AES"); //根据密码生成AES密钥
            Cipher cipher = Cipher.getInstance(ALGORITHM);  //根据指定算法ALGORITHM自成密码器
            cipher.init(Cipher.DECRYPT_MODE, skey); //初始化密码器，第一个参数为加密(ENCRYPT_MODE)或者解密(DECRYPT_MODE)操作，第二个参数为生成的AES密钥
            byte [] encode_content = Base64.decodeBase64(content); //把密文字符串转回密文字节数组
            byte [] byte_content = cipher.doFinal(encode_content); //密码器解密数据
            return new String(byte_content,"utf-8"); //将解密后的数据转换为字符串返回
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
```

## 三、接口描述

### 3.1会话登录（user.login）

登录主要用于获取sessionid，其他接口必需传入sessionid才可调用，即必需先的登录才可以调用其他接口。

#### 3.1.1 授权类型

应用授权（appkey）、用户授权（username）

#### 3.1.2 系统级输入参数

| 名称    | 类型   | 是否必需 | 默认值 | 描述                                                         | 签名 |
| ------- | ------ | -------- | ------ | ------------------------------------------------------------ | ---- |
| appkey  | String | 必需     |        | 分配给应用的appkey                                           | 必需 |
| method  | String | 必需     |        | API接口名称（注：如使用webService方式来请求，方法命名中的"."变成"_",如：user.login --- user_login） | 必需 |
| v       | String | 必需     |        | API协议版本，如：1.0                                         | 必需 |
| format  | String | 可选     | xml    | 指定响应格式，目前支持格式为xml、json                        | 必需 |
| locate  | String | 可选     | zh_CN  | 本地化类型，默认zh_CN                                        | 必需 |
| _invoke | String | 可选     |        | Jsonp回调函数名称                                            |      |
| sign    | String | 必需     |        | API输入参数签名结果                                          |      |

#### 3.1.3 应用级输入参数

| 名称     | 类型   | 是否必需 | 默认值 | 描述                      | 签名 |
| -------- | ------ | -------- | ------ | ------------------------- | ---- |
| username | String | 必需     |        | 接口用户                  | 必需 |
| password | String | 必需     |        | 街某密码，使用md5（）加密 | 必需 |

#### 3.1.4 返回结果

| 名称       | 类型   | 是否必需 | 默认值 | 描述                  |
| ---------- | ------ | -------- | ------ | --------------------- |
| sessionid  | String | 必需     |        | 分配给用户的sessionid |
| servertime | Date   |          |        | 服务器时间            |
| version    | String |          |        | 平台版本              |

#### 3.1.5 请求示例

**假设数据内容：**

```json
{
  "appkey": "00001",
  "format": "json",
  "method": "user.login",
  "v": "1.0",
  "username": "test",
  "password": "123",
  "sign": "A2066F28732CD50D30101E255D7F5FF50C2B38D5"
}
```

**URL访问格式：**

http://127.0.0.1:8080/msdata/router?sign=A2066F28732CD50D30101E255D7F5FF50C2B38D5&v=1.0&username=test&appkey=00001&method=user.login&format=json&password=123

**WebService访问格式：**

参数WSDL描述文件，按名称传入参数即可。

**Http Socket请求格式:**

http://127.0.0.1:8080/msdata/router?sign=A2066F28732CD50D30101E255D7F5FF50C2B38D5&v=1.0&username=test&appkey=00001&method=user.login&format=json&password=123

#### 3.1.6 返回示例

**xml 数据格式**

```xml
<?xml version="1.0" encoding="utf-8" standalone="yes"?>
<user_logon_response>
    <sessionid>9aa8ba647fb6dd1ddbc3353da0402462</sessionid>
</user_logon_response>
```

**json数据格式：**

```json
{
  "sessionid": "9aa8ba647fb6dd1ddbc3353da0402462"
}
```

#### 3.1.7 错误编码

| 错误代码       | 描述                |
| -------------- | ------------------- |
| USERNAME-WRONG | 接口用户错误！      |
| PASSWORD-WRONG | 接口密码错误！      |
| UNAVAILABLE    | 服务异常，原因：{0} |

### 3.2 会话退出（user.logout）

退出主要用于清除sessionid

#### 3.2.1 授权类型

应用授权（appkey）、用户授权（username）、会话授权（session）

#### 3.2.2 系统级输入参数

| 名称      | 类型   | 是否必需 | 默认值 | 描述                                           | 签名 |
| --------- | ------ | -------- | ------ | ---------------------------------------------- | ---- |
| appkey    | String | 必需     |        | 分配给引用的应用标识                           | 必需 |
| sessionid | String | 必需     |        | 会话ID，一般是36位的UUID，在登录服务平台后获取 | 必需 |
| method    | String | 必需     |        | API接口名称                                    | 必需 |
| v         | String | 必需     |        | API协议版本，如1.0                             | 必需 |
| format    | String | 可选     | xml    | 指定响应格式，目前支持格式为xml、json          | 必需 |
| locate    | String | 可选     | zh_CN  | 本地化类型，默认zh_CN                          | 必需 |
| _invoke   | String | 可选     |        | Jsonp参数                                      |      |
| sign      | String | 必需     |        | API输入参数签名结果                            |      |

#### 3.2.3 应用级输入参数

无

#### 3.2.4 返回结果

| 名称       | 类型   | 是否必需 | 默认值 | 描述     |
| ---------- | ------ | -------- | ------ | -------- |
| successful | String | 必需     |        | 成功信息 |

#### 3.2.5 请求示例

**假设数据内容：**

```json
{
  "appkey": "00001",
  "format": "json",
  "method": "user.logout",
  "v": "1.0",
  "sessionid": "9aa8ba647fb6dd1ddbc3353da0402462",
  "sign": "268A7EBCA34CCFC6B6652692DB38C656468B0DF5"
}
```

**URL访问格式：**

http://127.0.0.1:8080/msdata/router?appkey=00001&sign=268A7EBCA34CCFC6B6652692DB38C656468B0DF5&v=1.0&method=user.logout&format=json&sessionid=9aa8ba647fb6dd1ddbc3353da0402462

**WebService访问格式:**

参数WSDL描述文件，按名称传入参数即可。

**Http Socket请求格式:**

http://127.0.0.1:8080/msdata/router?appkey=00001&sign=268A7EBCA34CCFC6B6652692DB38C656468B0DF5&v=1.0&method=user.logout&format=json&sessionid=9aa8ba647fb6dd1ddbc3353da0402462

#### 3.2.6 返回示例

**xml数据格式：**

```xml
<?xml version="1.0" encoding="utf-8" standalone="yes"?>
<user_logout_response>
<successful>true</successful>
</user_logout_response>
```

**json数据格式:**

```json
{
  "successful": true
}s
```

#### 3.2.7 错误编码

无

### 3.3 通用数据下载（data.getdata）

通用数据下载用于获取平台所有数据表的数据，分页下载。默认不传入时间参数（start_created、end_created）,将会分页返回此表的所有记录。如果传入时间参数（start_created、end_created）将会分页返回此段时间内的修改或新增的记录。

#### 3.3.1 授权类型

应用授权（appkey）、用户授权（username）、会话授权（session）

#### 3.3.2 系统级输入参数

| 名称    | 类型   | 是否必需 | 默认值 | 描述                                                         | 签名 |
| ------- | ------ | -------- | ------ | ------------------------------------------------------------ | ---- |
| appkey  | String | 必需     |        | 分配给应用的appkey                                           | 必需 |
| method  | String | 必需     |        | API接口名称（注：如使用webService方式来请求，方法命名中的"."变成"_",如：user.login --- user_login） | 必需 |
| v       | String | 必需     |        | API协议版本，如：1.0                                         | 必需 |
| format  | String | 可选     | xml    | 指定响应格式，目前支持格式为xml、json                        | 必需 |
| locate  | String | 可选     | zh_CN  | 本地化类型，默认zh_CN                                        | 必需 |
| _invoke | String | 可选     |        | Jsonp回调函数名称                                            |      |
| sign    | String | 必需     |        | API输入参数签名结果                                          |      |

#### 3.3.3 应用级输入参数

| 名称          | 类型   | 是否必需 | 默认值         | 描述                                                         | 签名 |
| ------------- | ------ | -------- | -------------- | ------------------------------------------------------------ | ---- |
| tablename     | String | 必需     |                | 表名，如：syuser                                             | 必需 |
| fields        | String | 必需     |                | 字段名称，如：id，name,status                                | 必需 |
| dbtype        | String | 可选     |                | 数据源标识，默认时数据中心数据源标识                         |      |
| start_created | Date   | 可选     | 19000000000000 | 查询数据创建时间开始，格式：yyyyMMddHHmmss，默认19000000000000 | 必需 |
| end_created   | Date   | 可选     |                | 查询数据创建时间结束，格式：yyyyMMddHHmmss                   | 必需 |
| page_no       | int    | 可选     | 1              | 页码。取值范围：大于零的整数，默认值：1                      | 必需 |
| page_size     | int    | 可选     | 40             | 每页条数。取值范围：大于零的整数：默认值：40；最大值：100    | 必需 |

#### 3.3.4 请求示例

**假设数据内容：**

```json
{
  "appkey": "00001",
  "format": "json",
  "method": "data.getdata",
  "page_no": 2,
  "page_size": 50,
  "v": "1.0",
  "sessionid": "9aa8ba647fb6dd1ddbc3353da0402462",
  "tablename": "syuser",
  "fields": "id,name",
  "sign": "B7D6707025991DC896AA7EEEDD4F245FB51D3819"
}
```

**URL访问格式:**

http://127.0.0.1:8080/msdata/router?sign=B7D6707025991DC896AA7EEEDD4F245FB51D3819&v=1.0&page_size=50&tablename=syuser&appkey=00001&method=data.getdata&page_no=2&format=json&sessionid=9aa8ba647fb6dd1ddbc3353da0402462&fields=id,name

**WebService访问格式:**

参数WSDL描述文件，按名称传入参数即可。

**Http Socket请求格式:**

http://127.0.0.1:8080/msdata/router?sign=B7D6707025991DC896AA7EEEDD4F245FB51D3819&v=1.0&page_size=50&tablename=syuser&appkey=00001&method=data.getdata&page_no=2&format=json&sessionid=9aa8ba647fb6dd1ddbc3353da0402462&fields=id,name

#### 3.3.5 返回结果

| 名称         | 类型    | 是否必需 | 默认值 | 描述                                                         |
| ------------ | ------- | -------- | ------ | ------------------------------------------------------------ |
| dataver      | Date    |          |        | 数据版本，指查询的数据版本。例如：下载第二页数据时，第一页数据变化了会导致第二页数据也会变化。以致影响到第二页数据。因此服务器会根据传入的start_created、end_created生成查询指定时间的版本。这样即使数据库数据变化率，查询的数据任然是同一个版本，不会受影响。默认请求第一页时，会生成dataver,第二页的dataver与第一页一样 |
| types        | Types[] | 必需     |        | 数据类型对象（rows节点一下的内容是根据各表结构生成的，生成方式：<字段名>类型<字段名>） |
| datas        | Datas[] | 必需     |        | 数据信息对象（rows节点一下的内容是根据各表结构生成的，生成方式：<字段名>类型<字段名>）（注意：如果不是加密数据则必需返回，否则不返回） |
| datacode     | String  | 不必需   |        | 加密数据串（注意：如果是加密数据则必需返回，否则不返回）     |
| isencryption | String  | 不必需   |        | 是否是加密数据：Y（注意：如果是加密数据则必需返回，否则不返回） |
| page         | Page[]  | 必需     |        | 页码信息对象                                                 |

**Page[]**

| 名称        | 类型 | 是否必需 | 默认值 | 描述           |
| ----------- | ---- | -------- | ------ | -------------- |
| pageno      | int  | 必需     |        | 当前页数       |
| pagesize    | int  | 必需     |        | 每页返回记录数 |
| pagecount   | int  | 必需     |        | 总共页数       |
| recordcount | int  | 必需     |        | 总共记录数     |

#### 3.3.6 返回示例

```xml
<?xml version="1.0" encoding="utf-8" standalone="yes"?>
<data_getdata_response>
	<types>
		<id>C32</id>
		<name>C50</name>
		<sqlrowsetdata_num>SN</sqlrowsetdata_num>
	</types>
	<datas>
		<rows>
			<id>C280B3E2966CB688E040007F010026DC</id>
			<name>黄XX</name>
			<sqlrowsetdata_num>51</sqlrowsetdata_num>
		</rows>
		<rows>
			<id>C280B3E29661B688E040007F010026DC</id>
			<name>黄XX</name>
			<sqlrowsetdata_num>52</sqlrowsetdata_num>
		</rows>
		<rows>
			<id>C280B3E29662B688E040007F010026DC</id>
			<name>卢XX</name>
			<sqlrowsetdata_num>53</sqlrowsetdata_num>
		</rows>
	</datas>
	<page>
		<pageNo>1</pageNo>
		<pageSize>3</pageSize>
		<pageCount>267</pageCount>
		<recordCount>799</recordCount>
	</page>
</data_getdata_response>
```

**json数据格式:**

```json
{
  "types": {
    "id": "C32",
    "name": "C50",
    "sqlrowsetdata_num": "SN"
  },
  "datas": [
    {
      "id": "C280B3E2966CB688E040007F010026DC",
      "name": "黄XX ",
      "sqlrowsetdata_num": "1"
    },
    {
      "id": "C280B3E29661B688E040007F010026DC",
      "name": "黄XX ",
      "sqlrowsetdata_num": "2"
    },
    {
      "id": "C280B3E29662B688E040007F010026DC",
      "name": "卢XX",
      "sqlrowsetdata_num": "3"
    }
  ],
  "page": {
    "pageno": 1,
    "pagesize": 3,
    "pagecount": 267,
    "recordcount": 799
  }
}
```

**加密数据格式:**

```json
{
  "isencryption": "Y",
  "datacode": "1D6280CFB5C8DF07ABE8E8A198FE8C552EC5FCA06AB485AEDB0CC2B7C1E82C0F0068D53EE81F420E269027C092226FBD2ECF3476BFA6D4CBEB0BC5C4F9CFFFB570A054502BFE7828813283"
}
```

#### 3.3.7 错误编码

| 子错误码                | 描述                                         |
| ----------------------- | -------------------------------------------- |
| ACCESS-TABLE-PERMISSION | 未向{0}接口用户，开放{1}表的{2}权限。        |
| ACCESS-FIELD-PERMISSION | 未向{0}接口用户，开放{1}表{2}字段的{3}权限。 |
| ACCESS-TABLE-NOTEXIST   | {0} 表不存在。                               |
| ACCESS-FIELD-NOTEXIST   | 在{0}表中，{1}字段不存在。                   |
| UNAVAILABLE             | 服务异常，原因：{0}                          |

### 3.4 通用数据上传（data.setdata）

数据上传用于向平台提交数据，在数据提交过程中需要特别注意必需包含主键。另外两还需要注意数据格式。因为提交给平台后，平台会根据数据类型进行转换，如果数据类型不符合也会导致错误。

注意：

1. 提交中文时必需转为unicode编码。否则服务器收到是乱码，导致计算签名时与客户端不对，会提示签名错误。
2. 由于http对get方式有提交内容限制，因此请在数据上传时采用post方式

#### 3.4.1 授权类型

应用授权（appkey）、用户授权（username）、会话授权（session）

#### 3.4.2 系统级输入参数

| 名称    | 类型   | 是否必需 | 默认值 | 描述                                                         | 签名 |
| ------- | ------ | -------- | ------ | ------------------------------------------------------------ | ---- |
| appkey  | String | 必需     |        | 分配给应用的appkey                                           | 必需 |
| method  | String | 必需     |        | API接口名称（注：如使用webService方式来请求，方法命名中的"."变成"_",如：user.login --- user_login） | 必需 |
| v       | String | 必需     |        | API协议版本，如：1.0                                         | 必需 |
| format  | String | 可选     | xml    | 指定响应格式，目前支持格式为xml、json                        | 必需 |
| locate  | String | 可选     | zh_CN  | 本地化类型，默认zh_CN                                        | 必需 |
| _invoke | String | 可选     |        | Jsonp回调函数名称                                            |      |
| sign    | String | 必需     |        | API输入参数签名结果                                          |      |

#### 3.4.3 应用级输入参数

| 名称      | 类型    | 是否必需 | 默认值 | 描述                                                         | 签名 |
| --------- | ------- | -------- | ------ | ------------------------------------------------------------ | ---- |
| tablename | String  | 必需     |        | 表名                                                         | 必需 |
| datas     | Datas[] | 必需     |        | 数据信息对象（每次最大上传200条记录，建议是每次50条）（注意：如开启加密上传可不填） | 必需 |
| datacode  | String  | 必需     |        | 如开启加密上传需要调用加密工具类对数据进行加密（注意：如没开启加密上传可不填） | 必需 |
| dbtype    | String  | 可选     |        | 数据源标识，默认时数据中心数据源标识                         | 必需 |

#### 3.4.4 返回结果

| 名称    | 类型   | 是否必需 | 默认值 | 描述                                                         |
| ------- | ------ | -------- | ------ | ------------------------------------------------------------ |
| 主键    | String | 必需     |        | 如果一个主键：<主键>主键值</主键>如果多个主键：<主键>主键值</主键>……<主键>主键值</主键> |
| status  | int    | 必需     |        | 影响行数，大于0位执行成功                                    |
| message | String | 必需     |        | 执行消息，分别为（insert、update或其他异常提示信息）         |

#### 3.4.5 请求示例

**假设数据内容:**

```json
{
  "appkey": "00001",
  "format": "xml",
  "method": "data.setdata",
  "page_no": 2,
  "page_size": 50,
  "v": "1.0",
  "sessionid": "9aa8ba647fb6dd1ddbc3353da0402462",
  "tablename": "syuser",
  "datas": [
    {
      "id": "1180B3E2966CB688E040007F01002611",
      "code": "tset11",
      "name": "\\u6d4b\\u8bd511",
      "syoufk": "0D5C500A376741A492FE9CE1DECF913A"
    },
    {
      "id": "1180B3E2966CB688E040007F01002612",
      "code": "tset12",
      "name": "\\u6d4b\\u8bd512",
      "syoufk": "0D5C500A376741A492FE9CE1DECF913A"
    },
    {
      "id": "1180B3E2966CB688E040007F01002613",
      "code": "tset13",
      "name": "\\u6d4b\\u8bd513",
      "syoufk": "0D5C500A376741A492FE9CE1DECF913A"
    }
  ],
  "sign": "777A89B17ACB64CBCE54292EF16CBDF00E4B8169"
}
```

**URL访问格式:**

```text
http://127.0.0.1:8080/msdata/router?page_size=50&datas[0][syoufk]=0D5C500A376741A492FE9CE1DECF913A&appkey=00001&datas[0][name]=\u6d4b\u8bd511&format=xml&datas[0][id]=1180B3E2966CB688E040007F01002611&sessionid=9aa8ba647fb6dd1ddbc3353da0402462&datas[0][code]=tset11&sign=777A89B17ACB64CBCE54292EF16CBDF00E4B8169&v=1.0&datas[1][code]=tset12&datas[2][name]=\u6d4b\u8bd513&datas[2][code]=tset13&datas[1][name]=\u6d4b\u8bd512&tablename=syuser&datas[1][syoufk]=0D5C500A376741A492FE9CE1DECF913A&datas[2][syoufk]=0D5C500A376741A492FE9CE1DECF913A&datas[1][id]=1180B3E2966CB688E040007F01002612&method=data.setdata&page_no=2&datas[2][id]=1180B3E2966CB688E040007F01002613
```

**WebService访问格式:**

参数WSDL描述文件，按名称传入参数即可。

**Http Socket请求格式:**

```text
http://127.0.0.1:8080/msdata/router?page_size=50&datas[0][syoufk]=0D5C500A376741A492FE9CE1DECF913A&appkey=00001&datas[0][name]=\u6d4b\u8bd511&format=xml&datas[0][id]=1180B3E2966CB688E040007F01002611&sessionid=9aa8ba647fb6dd1ddbc3353da0402462&datas[0][code]=tset11&sign=777A89B17ACB64CBCE54292EF16CBDF00E4B8169&v=1.0&datas[1][code]=tset12&datas[2][name]=\u6d4b\u8bd513&datas[2][code]=tset13&datas[1][name]=\u6d4b\u8bd512&tablename=syuser&datas[1][syoufk]=0D5C500A376741A492FE9CE1DECF913A&datas[2][syoufk]=0D5C500A376741A492FE9CE1DECF913A&datas[1][id]=1180B3E2966CB688E040007F01002612&method=data.setdata&page_no=2&datas[2][id]=1180B3E2966CB688E040007F01002613
```

#### 3.4.6 响应示例

**xml数据格式:**

```xml
<?xml version="1.0" standalone="yes"?>
<data_getdata_response>
	<datas>
		<rows>
			<id>1180B3E2966CB688E040007F01002611</id>
			<status>1</status>
			<message>insert</message>
		</rows>
		<rows>
			<id>1180B3E2966CB688E040007F01002612</id>
			<status>1</status>
			<message>update</message>
		</rows>
		<rows>
			<id>1180B3E2966CB688E040007F01002613</id>
			<status>1</status>
			<message>update</message>
		</rows>
	</datas>
</data_getdata_response>
```

**json数据格式:**

```json
{
  "datas": [
    {
      "id": "1180B3E2966CB688E040007F01002611",
      "status": "1",
      "message": "insert"
    },
    {
      "id": "1180B3E2966CB688E040007F01002612",
      "status": "1",
      "message": "update"
    },
    {
      "id": "1180B3E2966CB688E040007F01002613",
      "status": "1",
      "message": "update"
    }
  ]
}
```

#### 3.4.7 错误编码

| 子错误代码              | 描述                                         |
| ----------------------- | -------------------------------------------- |
| ACCESS-TABLE-PERMISSION | 未向{0}接口用户，开放{1}表的{2}权限。        |
| ACCESS-FIELD-PERMISSION | 未向{0}接口用户，开放{1}表{2}字段的{3}权限。 |
| ACCESS-TABLE-NOTEXIST   | {0} 表不存在。                               |
| ACCESS-FIELD-NOTEXIST   | 在{0}表中，{1}字段不存在。                   |
| DATA-ROWS-TOOLARGE      | 提交数据过大，每次提交要小于200条记录。      |
| DATA-NOT-PRIMARYKEY     | 上传数据时，必需包括{0}主键字段              |
| UNAVAILABLE             | 服务异常，原因：{0}                          |

