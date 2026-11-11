# Tac au Tac: plateforme d'entraînement à l'expression orale 

Module Architecture Web Distribuée Mini-Projet 

## Sujet

L'oral est la compétence la plus déterminante aux examens de langue, et la moins entraînée. **Tac au Tac** fait parler l'apprenant depuis son navigateur, analyse chaque prise de parole par intelligence artificielle (transcription, prononciation, fluidité, intonation, lexique, grammaire, cohérence) et le prépare, niveau par niveau, aux certifications orales (DELF, DALF, TCF, Cambridge, IELTS, TOEFL). Le formateur suit ses groupes et garde la décision finale sur les notes.

## Membres

| Membre | Microservice | Port | Tâche commune 

| Nada Matoussi | MS1 `profil-service` | 8081 
| Hafsi Ramez | MS2 `contenu-service` | 8082 
| Mohamed Islam Athmani | MS3 `seance-service` | 8083 
| Adam Chebaaane | MS4 `examen-service` | 8084 
| Aziz Kthiri | MS5 `progression-service` | 8085 
| Groupe | MS-IA `analyse-service` (+ `moteur-ia` Python) | 8087 (+ 8000)  

## Architecture

![Architecture globale](Documentation/Diagrams/architecture-globale.png)

| Composant | Technologie | Port |

| Frontend | Angular + MediaRecorder API | 4200 |
| API Gateway | Spring Cloud Gateway | 8080 |
| Eureka | Spring Cloud Netflix Eureka Server | 8761 |
| Config Server | Spring Cloud Config (`Backend/config-repo`) | 8888 |
| Keycloak | realm `tacautac` | 8180 |
| Kafka | mode KRaft | 9092 |
| MySQL | un schéma + un utilisateur par service | 3306 |
| MongoDB | base `tacautac_analyse` | 27017 |

- Interactions (appels synchrones et topics Kafka) : [Documentation/Diagrams/interactions.png](Documentation/Diagrams/interactions.png)
- Fiches de conception de chaque service : [Documentation/services](Documentation/services)
- Dossier technique complet : [Documentation/Dossier_Technique_TacAuTac.docx](Documentation/Dossier_Technique_TacAuTac.docx)

## Lancement

Prérequis : Java 17, Maven 3.9+, MySQL 8 sur le port 3306.

```bash
# 1. Infrastructure (dans l'ordre)
cd Backend/eureka-server && mvn spring-boot:run
cd Backend/config-server && mvn spring-boot:run

# 2. Chaque microservice, par exemple MS3
cd Backend/seance-service && mvn spring-boot:run
```

Lancer un service seul, sans Eureka : `EUREKA_ENABLED=false mvn spring-boot:run`.

Swagger de chaque service : `http://localhost:<port>/swagger-ui.html` (par exemple http://localhost:8083/swagger-ui.html).
Tableau de bord Eureka : http://localhost:8761.




