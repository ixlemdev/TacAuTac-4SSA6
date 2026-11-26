"""MS-IA analyse-service : application FastAPI.
"""
import os
from contextlib import asynccontextmanager

import py_eureka_client.eureka_client as eureka_client
from fastapi import FastAPI

# Configuration lue dans les variables d'environnement, avec une valeur par défaut pour le poste local
NOM_SERVICE = "analyse-service"
PORT = int(os.getenv("PORT", "8087"))
EUREKA_URL = os.getenv("EUREKA_URL", "http://localhost:8761/eureka")
EUREKA_ENABLED = os.getenv("EUREKA_ENABLED", "true").lower() == "true"


@asynccontextmanager
async def cycle_de_vie(app: FastAPI):
    # au demarrage inscription dans Eureka
    if EUREKA_ENABLED:
        await eureka_client.init_async(
            eureka_server=EUREKA_URL,
            app_name=NOM_SERVICE,
            instance_port=PORT,
        )
    yield
    # a l'arret désinscription
    if EUREKA_ENABLED:
        await eureka_client.stop_async()


app = FastAPI(
    title="MS-IA analyse-service",
    description="Évaluation automatique d'une prise de parole (Tac au Tac)",
    version="0.1.0",
    lifespan=cycle_de_vie,
)


@app.get("/")
def accueil():
    return {"service": NOM_SERVICE, "message": "MS-IA analyse-service est en marche"}