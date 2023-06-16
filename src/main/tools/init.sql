DROP DATABASE IF EXISTS bibliotheque;
CREATE DATABASE bibliotheque;
USE bibliotheque;

DROP TABLE IF EXISTS Client ;
DROP TABLE IF EXISTS Livre ;
DROP TABLE IF EXISTS Emprunt ;
DROP TABLE IF EXISTS Compo ;

CREATE TABLE Client (id integer(10) NOT NULL AUTO_INCREMENT PRIMARY KEY,
    nom varchar(50) NOT NULL,
    prenom varchar(50) NOT NULL);
CREATE TABLE Livre (id integer(10) NOT NULL AUTO_INCREMENT PRIMARY KEY,
    titre varchar(255) NOT NULL,
    auteur varchar(50) NOT NULL);
CREATE TABLE Emprunt (id integer(10) NOT NULL AUTO_INCREMENT PRIMARY KEY,
    date_debut DATETIME NOT NULL,
    date_fin DATETIME,
    delai integer(10),
    id_client integer(10) NOT NULL,
    CONSTRAINT `fk_Emprunt_Client`
        FOREIGN KEY (id_client) REFERENCES Client (id));
CREATE TABLE Compo (id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    id_liv integer(10) NOT NULL,
    id_emp integer(10) NOT NULL,
    CONSTRAINT `fk_Compo_Livre`
        FOREIGN KEY (id_liv) REFERENCES Livre (id),
    CONSTRAINT `fk_Compo_Emprunt`
        FOREIGN KEY (id_emp) REFERENCES Emprunt (id));

INSERT INTO Client (nom, prenom) VALUES ('Brigand', 'Pierre');
INSERT INTO Client (nom, prenom) VALUES ('YU', 'Cheng');
INSERT INTO Client (nom, prenom) VALUES ('BERRAD', 'Hicham');
INSERT INTO Livre (titre, auteur)
    VALUES ('Vingt mille lieues sous les mers', 'Jules Verne');
INSERT INTO Livre (titre, auteur)
    VALUES ('Germinal', 'Emile Zola');
INSERT INTO Livre (titre, auteur)
    VALUES ('Guerre et paix', 'Léon Tolstoï');
INSERT INTO Livre (titre, auteur)
    VALUES ('Apprendre à parler aux animaux', 'Gaston Pouet');
INSERT INTO Livre (titre, auteur)
    VALUES ('1001 recettes de Cuisine', 'Jean-Pierre Coffe');
INSERT INTO Emprunt (date_debut, date_fin, delai, id_client)
    VALUES ('2017-11-12', '2017-11-18', 15, 1);
INSERT INTO Emprunt (date_debut, date_fin, delai, id_client)
    VALUES ('2017-12-08', '2017-12-23', 30, 2);
INSERT INTO Emprunt (date_debut, date_fin, delai, id_client)
    VALUES ('2017-12-09', '2018-01-04', 30, 3);
INSERT INTO Emprunt (date_debut, date_fin, delai, id_client)
    VALUES ('2018-01-03', NULL, 21, 1);
INSERT INTO Emprunt (date_debut, date_fin, delai, id_client)
    VALUES ('2018-01-13', NULL, 21, 3);
INSERT INTO Compo (id_liv, id_emp) VALUES (1, 1);
INSERT INTO Compo (id_liv, id_emp) VALUES (4, 1);
INSERT INTO Compo (id_liv, id_emp) VALUES (2, 2);
INSERT INTO Compo (id_liv, id_emp) VALUES (3, 2);
INSERT INTO Compo (id_liv, id_emp) VALUES (1, 3);
INSERT INTO Compo (id_liv, id_emp) VALUES (5, 4);
INSERT INTO Compo (id_liv, id_emp) VALUES (2, 4);
INSERT INTO Compo (id_liv, id_emp) VALUES (3, 5);

SHOW TABLES;
DESC Client;
DESC Livre;
DESC Emprunt;
DESC Compo;