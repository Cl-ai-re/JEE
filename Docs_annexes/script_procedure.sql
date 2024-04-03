drop procedure ajout_Evenement;
drop procedure ajout_DJ;
drop procedure ajout_Lieu;
drop procedure supp_Evenement;
drop procedure supp_DJ;
drop procedure supp_Lieu;

create procedure ajout_evenement(date_event date,debut int, fin int, dj int, lieu int)
insert into Evenement(Date_evenement,Debut,Fin,ID_DJ,ID_Lieu) values (date_event,debut,fin,dj,lieu);

create procedure ajout_DJ(nom varchar(50),prenom varchar(50),pseudo varchar(50),date_naissance date, adresse varchar(50), continent varchar(50),style varchar(50),actif int)
insert into DJ(Nom,Prenom,Pseudo,Date_de_naissance,Adresse,Continent,Style,Actif) values (nom,prenom,pseudo,date_naissance,adresse,continent,style,actif);

create procedure ajout_Lieu(nom varchar(50),ville varchar(50), pays varchar(50),continent varchar(50))
insert into Lieu(Nom_Lieu,Ville,Pays,Continent) values (nom,ville,pays,continent);

create procedure supp_Evenement(id int)
delete from Evenement where ID_Evenement=id;

create procedure supp_DJ(id int)
delete from DJ where ID_DJ=id;

create procedure supp_Lieu(id int)
delete from Lieu where ID_Lieu=id;

