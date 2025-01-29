package com.las.moduler.application.basemodule.utils;



//import io.swagger.v3.oas.models.OpenAPI;
//import io.swagger.v3.oas.models.info.Info;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Document Management API")
                        .version("1.0.0")
                        .description("APIs for managing documents")
                        .contact(new io.swagger.v3.oas.models.info.Contact()
                                .name("nadeem")
                                .email("support@example.com")));
    }
}
