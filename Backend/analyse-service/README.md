# MS-IA analyse-service (Tac au Tac)

Évaluation automatique d'une prise de parole. Service en **Python 3.12 + FastAPI**, port **8087**, inscrit dans Eureka sous le nom `ANALYSE-SERVICE` avec `py-eureka-client`.

## Installation (une seule fois)

```bash
cd Backend/analyse-service
python3.12 -m venv .venv
source .venv/bin/activate
pip install -r requirements.txt
```

## Lancement

```bash
source .venv/bin/activate
uvicorn app.main:app --host 0.0.0.0 --port 8087
```

- API : http://localhost:8087/ et Swagger : http://localhost:8087/docs
- Santé et informations (équivalent d'Actuator) : http://localhost:8087/health renvoie `{"status": "UP"}` et http://localhost:8087/info le nom et la version du service. Ces deux adresses sont déclarées à Eureka (`health_check_url` et `status_page_url`) : le lien de l'instance dans le dashboard ouvre `/info`.
- `EUREKA_ENABLED=false` pour lancer le service seul, sans Eureka ; `EUREKA_URL` pour changer l'adresse d'Eureka ; `INSTANCE_HOST` pour l'adresse annoncée à Eureka (`localhost` par défaut, nom du conteneur sous Docker).
- `--host 0.0.0.0` : Eureka annonce l'adresse réseau de la machine, le service doit donc écouter sur toutes les adresses.