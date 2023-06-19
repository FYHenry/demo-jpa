DROP DATABASE IF EXISTS banque;
CREATE DATABASE banque;
USE banque;

CREATE TABLE Client (id INTEGER(10) NOT NULL AUTO_INCREMENT PRIMARY KEY,
    nom VARCHAR(255) NOT NULL,
    prenom VARCHAR(255) NOT NULL,
    date_naissance DATE NOT NULL,
    id_adresse INTEGER(10) NOT NULL,
    id_banque INTEGER(10) NOT NULL);
CREATE TABLE Banque (id INTEGER(10) NOT NULL AUTO_INCREMENT PRIMARY KEY,
    nom VARCHAR(255) NOT NULL);
CREATE TABLE Adresse (id INTEGER(10) NOT NULL AUTO_INCREMENT PRIMARY KEY,
    numero INTEGER(10) NOT NULL,
    rue VARCHAR(255) NOT NULL,
    code_postal INTEGER(10) NOT NULL,
    ville VARCHAR(255) NOT NULL);
CREATE TABLE Livret_a (id INTEGER(10) NOT NULL AUTO_INCREMENT PRIMARY KEY,
    numero VARCHAR(255) NOT NULL,
    solde DOUBLE(10,2) NOT NULL,
    taux DOUBLE(10,2) NOT NULL);
CREATE TABLE Assurance_vie (id INTEGER(10) NOT NULL AUTO_INCREMENT PRIMARY KEY,
    numero VARCHAR(255) NOT NULL,
    solde DOUBLE(10,2) NOT NULL,
    date_fin DATE NOT NULL,
    taux DOUBLE(10,2) NOT NULL);
CREATE TABLE Virement (id INTEGER(10) NOT NULL AUTO_INCREMENT PRIMARY KEY,
    date_operation DATE NOT NULL,
    montant DOUBLE(10,2) NOT NULL,
    motif VARCHAR(255) NOT NULL,
    beneficiaire VARCHAR(255) NOT NULL,
    id_livret_a INTEGER(10),
    id_assurance_vie INTEGER(10));
CREATE TABLE Compo_Client_Livret_a (
    id_client INTEGER(10) NOT NULL PRIMARY KEY,
    id_livret_a INTEGER(10) NOT NULL UNIQUE KEY);
CREATE TABLE Compo_Client_Assurance_vie (
    id_client INTEGER(10) NOT NULL PRIMARY KEY,
    id_assurance_vie INTEGER(10) NOT NULL UNIQUE KEY);

ALTER TABLE Client ADD CONSTRAINT fk_Client_Adresse
    FOREIGN KEY (id_adresse) REFERENCES Adresse (id);
ALTER TABLE Client ADD CONSTRAINT fk_Client_Banque
    FOREIGN KEY (id_banque) REFERENCES Banque (id);
ALTER TABLE Virement ADD CONSTRAINT fk_Virement_Livret_a
    FOREIGN KEY (id_livret_a) REFERENCES Livret_a (id);
ALTER TABLE Virement ADD CONSTRAINT fk_Virement_Assurance_vie
    FOREIGN KEY (id_assurance_vie) REFERENCES Assurance_vie (id);
ALTER TABLE Compo_Client_Livret_a ADD CONSTRAINT fk_Compo_Client_Livret_a_Client
    FOREIGN KEY (id_client) REFERENCES Client (id);
ALTER TABLE Compo_Client_Livret_a ADD CONSTRAINT fk_Compo_Client_Livret_a_Livret_a
    FOREIGN KEY (id_livret_a) REFERENCES Livret_a (id);
ALTER TABLE Compo_Client_Assurance_vie ADD CONSTRAINT fk_Compo_Client_Assurance_vie_Client
    FOREIGN KEY (id_client) REFERENCES Client (id);
ALTER TABLE Compo_Client_Assurance_vie ADD CONSTRAINT fk_Compo_Client_Assurance_vie_Assurance_vie
    FOREIGN KEY (id_assurance_vie) REFERENCES Assurance_vie (id);

SHOW TABLES;
DESC Client;
SHOW INDEX FROM Client;
DESC Banque;
SHOW INDEX FROM Banque;
DESC Adresse;
SHOW INDEX FROM Adresse;
DESC Livret_a;
SHOW INDEX FROM Livret_a;
DESC Assurance_vie;
SHOW INDEX FROM Assurance_vie;
DESC Virement;
SHOW INDEX FROM Virement;
DESC Compo_Client_Livret_a;
SHOW INDEX FROM Compo_Client_Livret_a;
DESC Compo_Client_Assurance_vie;
SHOW INDEX FROM Compo_Client_Assurance_vie