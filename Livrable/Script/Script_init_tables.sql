drop database Projet_JEE_DJ;
create database Projet_JEE_DJ;
use Projet_JEE_DJ;

CREATE TABLE DJ
(
    ID_DJ int auto_increment,
    Nom varchar(50),
    Prenom varchar(50),
    Pseudo varchar(50),
    Date_de_naissance date,
    Adresse varchar(50),
    Continent enum('Europe', 'Asie', 'Afrique', 'Océanie', 'Amérique du Nord', 'Amérique du Sud', 'Amérique Centrale'),
    Style enum('Electro', 'House', 'Hard Style', 'EDM'),
    Actif int,
    Primary key(ID_DJ, Nom, Prenom)
);


CREATE TABLE Lieu
(
    ID_Lieu int auto_increment,
    Nom_Lieu varchar(50),
    Ville varchar(50),
    Pays varchar(50),
    Continent enum('Europe', 'Asie', 'Afrique', 'Océanie', 'Amérique du Nord', 'Amérique du Sud', 'Amérique Centrale'),
    Primary key(ID_Lieu, Nom_Lieu)
);

CREATE TABLE Evenement
(
    ID_Evenement int auto_increment,
    Date_evenement date,
    Debut int,
    Fin int,
    ID_DJ int,
    ID_Lieu int,
    primary key (ID_Evenement),
    Foreign key (ID_DJ) references DJ(ID_DJ),
    Foreign key (ID_Lieu) references Lieu(ID_Lieu)
);

CREATE TABLE Historique
(
    ID_Evenement int,
    Date_evenement date,
    Fin int,
    ID_DJ int,
    ID_Lieu int,
    primary key (ID_Evenement),
    Foreign key (ID_DJ) references DJ(ID_DJ),
    Foreign key (ID_Lieu) references Lieu(ID_Lieu)
);
