package com.efiom.ecommerce.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI customizeOpenApi(){
        //final String securitySchemaName = "bearerAuth";
        return new OpenAPI()
                .info(new Info()
                        .title("Backend Ecommerce App API")
                        .version("1.1")
                        .description("Backend Ecommerce App API Documentation")
                );
//                .addSecurityItem(new SecurityRequirement().addList(securitySchemaName))
//                .components(new Components()
//                        .addSecuritySchemes(securitySchemaName, new SecurityScheme()
//                                .name(securitySchemaName)
//                                .type(SecurityScheme.Type.HTTP)
//                                .scheme("bearer")
//                                .bearerFormat("JWT")));
    }

}
