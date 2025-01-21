/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.github.paulojava_coffee.libraryapi.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author santa
 */
@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "Library API",
                version = "V1",
                contact = @Contact(
                        name = "Paulo Oliveira",
                        email = "paulo@oliveira.com",
                        url = "library.com"
                )     
        ),
        security = {
            @SecurityRequirement(name = "bearerAuth")
        }
)
@SecurityScheme(
     name = "bearerAuth",
     type = SecuritySchemeType.HTTP,
     bearerFormat = "JWT",
     scheme = "bearer",
     in = SecuritySchemeIn.HEADER
)
public class OpenApiConfig {

}
