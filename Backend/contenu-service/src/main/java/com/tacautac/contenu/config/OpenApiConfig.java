package com.tacautac.contenu.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI contenuOpenApi() {
        return new OpenAPI().info(new Info()
                .title("MS2 contenu-service - Tac au Tac")
                .version("0.0.1")
                .description("Banque de sujets d'oral, questions de relance, parcours, modules et exercices."));
    }

}
