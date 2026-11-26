-- MS1 profil-service : base tacautac_profil et utilisateur dédié profil_user, qui n'a de droits que sur cette base.
-- Sous Docker : exécuté automatiquement au premier démarrage du conteneur MySQL (dossier /docker-entrypoint-initdb.d).
-- Avec XAMPP : à exécuter une fois depuis la racine du dépôt, par exemple
--   /Applications/XAMPP/xamppfiles/bin/mysql -u root -h 127.0.0.1 < Backend/mysql-init/01-profil.sql
-- L'utilisateur est créé pour '%' (connexion depuis un autre conteneur) et pour 'localhost' :
-- XAMPP a un utilisateur anonyme ''@'localhost' qui passerait avant '%' et provoquerait un « Access denied ».
CREATE DATABASE IF NOT EXISTS tacautac_profil CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
CREATE USER IF NOT EXISTS 'profil_user'@'%' IDENTIFIED BY 'profil_pwd';
CREATE USER IF NOT EXISTS 'profil_user'@'localhost' IDENTIFIED BY 'profil_pwd';
GRANT ALL PRIVILEGES ON tacautac_profil.* TO 'profil_user'@'%';
GRANT ALL PRIVILEGES ON tacautac_profil.* TO 'profil_user'@'localhost';
FLUSH PRIVILEGES;
