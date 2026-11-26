"""MS-IA analyse-service : application FastAPI.
"""
import os
from contextlib import asynccontextmanager

import py_eureka_client.eureka_client as eureka_client
from fastapi import FastAPI

# Configuration lue dans les variables d'environnement, avec une valeur par défaut pour le poste local
NOM_SERVICE = "analyse-service"
VERSION = "0.1.0"
PORT = int(os.getenv("PORT", "8087"))
EUREKA_URL = os.getenv("EUREKA_URL", "http://localhost:8761/eureka")
EUREKA_ENABLED = os.getenv("EUREKA_ENABLED", "true").lower() == "true"
# Adresse à laquelle Eureka (et son dashboard) peut joindre ce service
INSTANCE_HOST = os.getenv("INSTANCE_HOST", "localhost")
URL_SERVICE = f"http://{INSTANCE_HOST}:{PORT}"


@asynccontextmanager
async def cycle_de_vie(app: FastAPI):
    # au demarrage inscription dans Eureka
    if EUREKA_ENABLED:
        await eureka_client.init_async(
            eureka_server=EUREKA_URL,
            app_name=NOM_SERVICE,
            instance_port=PORT,
            health_check_url=f"{URL_SERVICE}/health",
            status_page_url=f"{URL_SERVICE}/info",
        )
    yield
    # a l'arret désinscription
    if EUREKA_ENABLED:
        await eureka_client.stop_async()


app = FastAPI(
    title="MS-IA analyse-service",
    description="Évaluation automatique d'une prise de parole (Tac au Tac)",
    version=VERSION,
    lifespan=cycle_de_vie,
)


@app.get("/")
def accueil():
    return {"service": NOM_SERVICE, "message": "MS-IA analyse-service est en marche"}


@app.get("/health")
def sante():
    # Pour l'instant : le service est UP dès qu'il répond.
    # Plus tard : DOWN (code 503) tant que les modèles d'IA ne sont pas chargés ou si MongoDB est injoignable.
    return {"status": "UP"}


@app.get("/info")
def informations():
    # Même format que /actuator/info des services Spring (info.app.*)
    return {
        "app": {
            "name": NOM_SERVICE,
            "version": VERSION,
            "description": "MS-IA : evaluation automatique de la prise de parole",
            "team": "Tac au Tac",
        }
    }