package com.tiquetera.catalog.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI catalogOpenApi() {
        return new OpenAPI()
            .info(new Info()
                .title("Tiquetera Catalog API")
                .version("0.1.0")
                .description("REST API for managing Events and Venues — In-memory catalog")
                .contact(new Contact()
                    .name("Tiquetera Team")
                    .email("devs@tiquetera.local")))
            .addServersItem(new Server()
                .url("http://localhost:8080")
                .description("Local server"));
    }

    @Bean
    public GroupedOpenApi publicApi() {
        return GroupedOpenApi.builder()
                .group("public")
                .pathsToMatch("/venues/**", "/events/**")
                .build();
    }
}
