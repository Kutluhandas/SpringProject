package com.example7.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2).groupName("rentcars-api")
                   .apiInfo(apiInfo())
                   .select()
                   .paths(PathSelectors.ant("/api/v3/**"))
                   .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("Cars API")
                        .description("Cars API with CRUD Operations")
                        .license("MIT License")
                        .licenseUrl("kutluhan@gmail.com")
                        .version("3.0").build();
    }   
}