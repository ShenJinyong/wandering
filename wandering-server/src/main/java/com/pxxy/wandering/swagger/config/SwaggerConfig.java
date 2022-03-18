package com.pxxy.wandering.swagger.config;

import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@EnableOpenApi // 该注解是 Springfox-swagger 框架提供的使用 Swagger 注解，该注解必须加
@EnableKnife4j // 该注解是 knife4j 提供的增强注解，UI 提供了例如动态参数、参数过滤、接口排序等增强功能，如果你想使用这些增强功能就必须加该注解，否则可以不用加
@Configuration // 该注解说明是配置类
public class SwaggerConfig {

    @Bean
    public Docket docket(){
        return new Docket(DocumentationType.OAS_30)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.pxxy.wandering.core.controller"))
                .paths(PathSelectors.any())
                .build()
                .groupName("沈金勇")
                .enable(true);
    }

    private ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                .title("流浪所-博客系统")
                .description("新技术整合学习及配置案例DEMO")
                .contact(new Contact("沈金勇","","438217638@qq.com"))
                .version("v1.0")
                .build();
    }

}
