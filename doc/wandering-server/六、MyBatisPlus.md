# 六、MyBatisPlus

```xml
<!--mybatis-plus-->
<dependency>
    <groupId>com.baomidou</groupId>
    <artifactId>mybatis-plus-boot-starter</artifactId>
    <version>3.5.1</version>
</dependency>
<!--generator-->
<dependency>
    <groupId>com.baomidou</groupId>
    <artifactId>mybatis-plus-generator</artifactId>
    <version>3.5.2</version>
</dependency>
<!--velocity-->
<dependency>
    <groupId>org.apache.velocity</groupId>
    <artifactId>velocity-engine-core</artifactId>
    <version>2.3</version>
</dependency>
<!--mysql-->
<dependency>
    <groupId>mysql</groupId>
    <artifactId>mysql-connector-java</artifactId>
    <version>8.0.28</version>
</dependency>
```

MybatisPlusConfig

```java
package com.pxxy.wandering.mybatis.config;

import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.OptimisticLockerInnerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement // 事务管理，默认开启
@Configuration // 该注解说明是配置类
public class MybatisPlusConfig {

    // 注册乐观锁插件
    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor() {
        MybatisPlusInterceptor mybatisPlusInterceptor = new MybatisPlusInterceptor();
        mybatisPlusInterceptor.addInnerInterceptor(new OptimisticLockerInnerInterceptor());
        return mybatisPlusInterceptor;
    }

    // 分页插件

    public PaginationInnerInterceptor paginationInnerInterceptor() {
        return new PaginationInnerInterceptor();
    }

    // 逻辑删除插件，新版已经帮我们添加了

}
```

MyMetaObjectHandler

```java
package com.pxxy.wandering.mybatis.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

@Slf4j // 该注解说明可以使用slf4j日志打印
@Component // 该注解说明把处理器加载到IOC容器中
public class MyMetaObjectHandler implements MetaObjectHandler {

    // 插入时的填充策略
    @Override
    public void insertFill(MetaObject metaObject) {
        log.info("start insert fill ");
        // setFieldValByName(String fieldName, Object fieldVal, MetaObject metaObject)
        this.setFieldValByName("createTime",new Date(),metaObject);
        this.setFieldValByName("updateTime",new Date(),metaObject);
    }

    // 填充时的填充策略
    @Override
    public void updateFill(MetaObject metaObject) {
        log.info("start update fill ");
        this.setFieldValByName("updateTime", new Date(), metaObject);
    }

}
```

配置

```yml
spring:  
  # 数据源
  datasource:
    url: jdbc:mysql://124.70.38.234:3306/wandering?useSSL=false&useUnicode=true&characterEncoding=UTF-8&allowMultiQueries=true
    driver-class-name: com.mysql.cj.jdbc.Driver
    username: ******
    password: ******
    hikari:
      pool-name: Retail_HikariCP #连接池名称
      minimum-idle: 10 #最小空闲连接数量
      idle-timeout: 120000 #空闲连接存活最大时间，默认600000（10分钟）
      maximum-pool-size: 20 #连接池最大连接数，默认是10
      auto-commit: true  #此属性控制从池返回的连接的默认自动提交行为,默认值：true
      max-lifetime: 1800000 #此属性控制池中连接的最长生命周期，值0表示无限生命周期，默认1800000即30分钟
      connection-timeout: 30000 #数据库连接超时时间,默认30秒，即30000
      connection-test-query: SELECT 1
mybatis-plus:
  # 配置日志
  configuration:
    log-impl: org.apache.ibatis.logging.stdout.StdOutImpl
  # 配置逻辑删除
  global-config:
    db-config:
      logic-delete-field: flag # 全局逻辑删除的实体字段名(since 3.3.0,配置后可以忽略不配置步骤2)
      logic-delete-value: 1 # 逻辑已删除值(默认为 1)
      logic-not-delete-value: 0 # 逻辑未删除值(默认为 0)
```

