package com.ayerscarpe.xivstratz.util.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class Swagger2Config {
    @Bean
    public Docket createRestApi(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com"))//com包下所有API交给Swagger2管理
                .paths(PathSelectors.any()).build();
    }
    private ApiInfo apiInfo(){//API文档显示页面信息
        return new ApiInfoBuilder()
                .title("")//网站标题
                .description("")//描述
                .version("")//版本
                .build();
    }
}
