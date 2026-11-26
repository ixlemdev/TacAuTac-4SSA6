-- MS3 seance-service : base tacautac_seance et utilisateur dédié seance_user, qui n'a de droits que sur cette base.
-- Sous Docker : exécuté automatiquement au premier démarrage du conteneur MySQL (dossier /docker-entrypoint-initdb.d).
-- Avec XAMPP : à exécuter une fois depuis la racine du dépôt, par exemple
--   /Applications/XAMPP/xamppfiles/bin/mysql -u root -h 127.0.0.1 < Backend/mysql-init/02-seance.sql
-- L'utilisateur est créé pour '%' (connexion depuis un autre conteneur) et pour 'localhost' :
-- XAMPP a un utilisateur anonyme ''@'localhost' qui passerait avant '%' et provoquerait un « Access denied ».
CREATE DATABASE IF NOT EXISTS tacautac_seance CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
CREATE USER IF NOT EXISTS 'seance_user'@'%' IDENTIFIED BY 'seance_pwd';
CREATE USER IF NOT EXISTS 'seance_user'@'localhost' IDENTIFIED BY 'seance_pwd';
GRANT ALL PRIVILEGES ON tacautac_seance.* TO 'seance_user'@'%';
GRANT ALL PRIVILEGES ON tacautac_seance.* TO 'seance_user'@'localhost';
FLUSH PRIVILEGES;
