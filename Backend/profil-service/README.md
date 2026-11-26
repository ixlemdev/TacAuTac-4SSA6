# MS1 — profil-service (Tac au Tac)

Profils d'apprentissage, consentement vocal, groupes et établissements.
Spring Boot 3.5 · Java 17 · MySQL (`tacautac_profil`) · port **8081**.

## Structure

```
src/main/java/com/tacautac/profil/
├── client/        clients OpenFeign (MS1 n'appelle aucun service)
├── config/        sécurité, Swagger, données de démonstration
├── controller/    API REST
├── dto/           objets de requête et de réponse
├── entity/        Profil, Groupe, Etablissement
├── exception/     erreurs au format ProblemDetail (RFC 7807)
├── messaging/     consommateur Kafka niveau.estime.maj (MS5)
├── repository/    repositories JPA
└── service/       logique métier
```

## Lancer

1. MySQL démarré dans XAMPP : en local, le service se connecte en `root` sans mot de passe. L'utilisateur dédié `profil_user` (utilisé sous Docker) est créé par `Backend/mysql-init/01-profil.sql`.
2. `./mvnw spring-boot:run`
