package com.tacautac.analyse.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI analyseOpenApi() {
        return new OpenAPI().info(new Info()
                .title("MS-IA analyse-service - Tac au Tac")
                .version("0.0.1")
                .description("Analyse vocale par IA, feedback et validation par le formateur."));
    }

}
