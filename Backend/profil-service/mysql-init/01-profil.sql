-- À ajouter dans Backend/mysql-init : schéma et utilisateur propres à MS1
CREATE DATABASE IF NOT EXISTS tacautac_profil CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
CREATE USER IF NOT EXISTS 'profil_user'@'%' IDENTIFIED BY 'profil_pwd';
GRANT ALL PRIVILEGES ON tacautac_profil.* TO 'profil_user'@'%';
FLUSH PRIVILEGES;
