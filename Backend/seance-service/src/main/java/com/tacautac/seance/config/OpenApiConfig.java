package com.tacautac.seance.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/** Titre et description de la page Swagger : http://localhost:8083/swagger-ui.html */
@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI seanceOpenApi() {
        return new OpenAPI().info(new Info()
                .title("MS3 seance-service: Tac au Tac")
                .version("0.0.1")
                .description("Séances d'entraînement oral, dépôt et réécoute des enregistrements audio."));
    }
}