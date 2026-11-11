package com.tacautac.progression.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI progressionOpenApi() {
        return new OpenAPI().info(new Info()
                .title("MS5 progression-service - Tac au Tac")
                .version("0.0.1")
                .description("Historique des scores, niveau CECRL estimé et alertes formateur."));
    }

}
