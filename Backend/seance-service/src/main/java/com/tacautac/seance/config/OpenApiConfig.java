package com.tacautac.seance.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import java.util.List;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI seanceOpenApi() {
        return new OpenAPI().info(new Info()
                .title("MS3 seance-service - Tac au Tac")
                .version("0.0.1")
                .description("Séances d'entraînement oral, dépôt et réécoute des enregistrements audio."))
                // adresse relative : par la Gateway (8080) ou directement sur le port du service
                .servers(List.of(new Server().url("/")));
    }

}
