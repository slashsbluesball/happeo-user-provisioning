package com.happeo.userprovisioning.demo2api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
// import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
// @EnableSwagger2
@EnableWebMvc
public class SpringFoxConfig implements WebMvcConfigurer {
    
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2).select()
         .apis(RequestHandlerSelectors.basePackage("com.happeo.userprovisioning.demo2api"))
         .paths(PathSelectors.any())
         .build();
        // return new Docket(DocumentationType.SWAGGER_2)
        //   .select()                                  
        //   .apis(RequestHandlerSelectors.any())              
        //   .paths(PathSelectors.any())                          
        //   .build();                                           
    }

    // private ApiInfo apiInfoMetaData() {
    //     return new ApiInfoBuilder().title("NAME OF SERVICE")
    //             .description("API Endpoint Decoration")
    //             .contact(new Contact("Dev-Team", "https://www.dev-team.com/", "dev-team@gmail.com"))
    //             .license("Apache 2.0")
    //             .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html")
    //             .version("1.0.0")
    //             .build();
    // }
}