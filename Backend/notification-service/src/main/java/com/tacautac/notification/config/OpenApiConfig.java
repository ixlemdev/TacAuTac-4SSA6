package com.tacautac.notification.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI notificationOpenApi() {
        return new OpenAPI().info(new Info()
                .title("MS6 notification-service - Tac au Tac")
                .version("0.0.1")
                .description("Notifications en temps réel et par e-mail, préférences et rappels d'entraînement."));
    }

}
