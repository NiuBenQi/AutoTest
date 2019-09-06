package com.course.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.validation.constraints.Email;

//配置文件
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                . pathMapping("/")
                .select()
                .paths(PathSelectors.regex("/.*"))
                .build();
    }

    public ApiInfo apiInfo(){
        return  new ApiInfoBuilder().title("我的借口文档")
                .contact(new Contact("niubenqi","www.baidu.com","962475388@qq.com"))
                .description("这是我的Swagger生成的借口文档")
                .version("1.0.0")
                .build();
    }

}