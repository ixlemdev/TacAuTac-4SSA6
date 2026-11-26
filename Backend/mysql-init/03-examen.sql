-- MS4 examen-service : base tacautac_examen et utilisateur dédié examen_user, qui n'a de droits que sur cette base.
-- Sous Docker : exécuté automatiquement au premier démarrage du conteneur MySQL (dossier /docker-entrypoint-initdb.d).
-- Avec XAMPP : à exécuter une fois depuis la racine du dépôt, par exemple
--   /Applications/XAMPP/xamppfiles/bin/mysql -u root -h 127.0.0.1 < Backend/mysql-init/03-examen.sql
-- L'utilisateur est créé pour '%' (connexion depuis un autre conteneur) et pour 'localhost' :
-- XAMPP a un utilisateur anonyme ''@'localhost' qui passerait avant '%' et provoquerait un « Access denied ».
CREATE DATABASE IF NOT EXISTS tacautac_examen CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
CREATE USER IF NOT EXISTS 'examen_user'@'%' IDENTIFIED BY 'examen_pwd';
CREATE USER IF NOT EXISTS 'examen_user'@'localhost' IDENTIFIED BY 'examen_pwd';
GRANT ALL PRIVILEGES ON tacautac_examen.* TO 'examen_user'@'%';
GRANT ALL PRIVILEGES ON tacautac_examen.* TO 'examen_user'@'localhost';
FLUSH PRIVILEGES;
