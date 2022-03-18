package com.pxxy.wandering.mybatis;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.VelocityTemplateEngine;
import com.baomidou.mybatisplus.generator.fill.Column;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@SpringBootTest
public class GeneratorCodeTests {

    // 处理 all 情况
    protected static List<String> getTables(String tables) {
        return "all".equals(tables) ? Collections.emptyList() : Arrays.asList(tables.split(","));
    }

    @Test
    public void generatorCode(){

        FastAutoGenerator
                // 1.配置数据源
                .create("jdbc:mysql://124.70.38.234:3306/wandering?useSSL=false&useUnicode=true&characterEncoding=UTF-8&allowMultiQueries=true","root","123456")
                // 2.全局配置
                .globalConfig((scanner, builder) -> builder
                        // 设置作者名
                        .author(scanner.apply("请输入作者名称？"))
                        // 生成代码存放的目录
                        .outputDir(System.getProperty("user.dir") + "/src/main/java")
                        // 注释日期
                        .commentDate("yyyy-MM-dd hh:mm:ss")
                        // 定义生成的实体类中日期的类型 TIME_PACK=LocalDateTime;ONLY_DATE=Date
                        .dateType(DateType.ONLY_DATE)
                        // 开启Swagger模式
                        .enableSwagger()
                        // 覆盖之前的文件，默认不覆盖
                        .fileOverride()
                        // 禁止打开输出目录，默认打开
                        .disableOpenDir()

                )
                // 3.包配置
                .packageConfig((scanner, builder) -> builder
                        // 设置父包名
                        .parent("com.pxxy.wandering")
                        // 设置模块名
                        .moduleName(scanner.apply("请输入模块名？"))
                        // pojo 实体类
                        .entity("entity.dao")
                        // Service 包名
                        .service("service")
                        // ***ServiceImpl 包名
                        .serviceImpl("service.impl")
                        // Mapper 包名
                        .mapper("mapper")
                        // Mapper XML 包名
                        .xml("mapper")
                        // Controller 包名
                        .controller("controller")
                        // 自定义文件包名
                        .other("utils")
                        // 把mapper放到resources目录下
                        .pathInfo(Collections.singletonMap(OutputFile.other, System.getProperty("user.dir")+"/src/main/resources/mapper"))
                )
                // 4.策略配置
                .strategyConfig((scanner, builder) -> builder
                        // 设置需要生成的数据表名
                        .addInclude(getTables(scanner.apply("请输入表名，多个英文逗号分隔？所有输入 all")))
                        // 设置过滤前缀
                        .addTablePrefix("t_","c_")

                        // Mapper 策略配置
                        .mapperBuilder()
                        // 设置父类
                        .superClass(BaseMapper.class)
                        // 格式化 mapper 文件名称
                        .formatMapperFileName("%sMapper")
                        // 开启 @Mapper 注解
                        .enableMapperAnnotation()
                        // 格式化 Xml 文件名称
                        .formatXmlFileName("%sMapper")

                        // Service 策略配置
                        .serviceBuilder()
                        // 格式化 service 接口文件名称，%s进行匹配表名，如 UserService
                        .formatServiceFileName("%sService")
                        // 格式化 service 实现类文件名称，%s进行匹配表名，如 UserServiceImpl
                        .formatServiceImplFileName("%sServiceImpl")

                        // Controller 策略配置
                        .controllerBuilder()
                        // 格式化 Controller 类文件名称，%s进行匹配表名，如 UserController
                        .formatFileName("%sController")
                        // 开启生成 @RestController 控制器
                        .enableRestStyle()

                        // 实体类策略配置
                        .entityBuilder()
                        .formatFileName("%sDao")
                        // 开启 Lombok
                        .enableLombok()
                        // 不实现 Serializable 接口，不生成 SerialVersionUID
                        .disableSerialVersionUID()
                        // 逻辑删除字段名
                        .logicDeleteColumnName("deleted")
                        // 乐观锁
                        .versionColumnName("version")
                        // 数据库表映射到实体的命名策略，下划线转驼峰命
                        .naming(NamingStrategy.underline_to_camel)
                        // 数据库表字段映射到实体的命名策略：下划线转驼峰命
                        .columnNaming(NamingStrategy.underline_to_camel)
                        // 自动填充配置,"create_time"字段自动填充为插入时间，"update_time"字段自动填充为插入修改时间
                        .addTableFills(new Column("create_time", FieldFill.INSERT),new Column("update_time", FieldFill.INSERT_UPDATE))
                        // 开启生成实体时生成字段注解
                        .enableTableFieldAnnotation()
                )
                // 5.模板引擎配置，默认 Velocity 可选模板引擎 Beetl 或 Freemarker
                .templateEngine(new VelocityTemplateEngine())
                // 6.执行
                .execute();

    }

}
