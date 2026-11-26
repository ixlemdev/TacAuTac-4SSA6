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
- `EUREKA_ENABLED=false` pour lancer le service seul, sans Eureka ; `EUREKA_URL` pour changer l'adresse d'Eureka.
- `--host 0.0.0.0` : Eureka annonce l'adresse réseau de la machine, le service doit donc écouter sur toutes les adresses.