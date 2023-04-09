package com.kiss.restful_api.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class OpenApiConfig {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .servers(List.of(
                        new Server().url("http://localhost:8080").description("Localhost"),
                        new Server().url("https://user.kiss.me").description("kiss.me")
                ))
                .info(new Info()
                        .title("Kiss Application API")
                        .description("Sample OpenAPI 3.0")
                        .contact(new Contact()
                                .email("honthfx14144@funix.edu.vn")
                                .name("kiss")
                                .url("https://kiss.me/"))
                        .license(new License()
                                .name("Apache 2.0")
                                .url("http://www.apache.org/licenses/LICENSE-2.0.html"))
                        .version("1.0.0"));
    }
}
