//package com.bookmyappointment.util;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import springfox.documentation.builders.ApiInfoBuilder;
//import springfox.documentation.builders.PathSelectors;
//import springfox.documentation.builders.RequestHandlerSelectors;
//import springfox.documentation.service.ApiInfo;
//import springfox.documentation.service.Contact;
//import springfox.documentation.spi.DocumentationType;
//import springfox.documentation.spring.web.plugins.Docket;
//import springfox.documentation.swagger.web.UiConfiguration;
//import springfox.documentation.swagger.web.UiConfigurationBuilder;
//import springfox.documentation.swagger2.annotations.EnableSwagger2;
//
//@Configuration
//@EnableSwagger2
//public class SwaggerConfig {
//
//    @Bean
//    public Docket documentation() {
//        return new Docket(DocumentationType.SWAGGER_2)
//                .select()
//                .apis(RequestHandlerSelectors.basePackage("com.bookmyappointment"))
//                .paths(PathSelectors.any())
//                .build()
//               // .pathMapping("/api")
//                .apiInfo(metadata());
//    }
//
//    private ApiInfo metadata() {
//        return new ApiInfoBuilder()
//                .title("BookMyAppointment")
//                .description("Use this documentation as a reference how to interact with app's API")
//                .contact(new Contact("Dev-Team", "https://github.com/rohitkolapkar/", "rohitkolapkar333@gmail.com"))
//                .build();
//    }
//    
//    @Bean
//    public UiConfiguration tryItOutConfig() {
//            final String[] methodsWithTryItOutButton = { "" };
//            return UiConfigurationBuilder.builder().supportedSubmitMethods(methodsWithTryItOutButton).build();
//        }
//}