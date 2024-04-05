drop procedure ajout_Evenement;
drop procedure ajout_DJ;
drop procedure supp_DJ;
drop procedure modif_DJ;
drop procedure EvenementMois;
drop procedure Top5;
delimiter //

CREATE PROCEDURE ajout_evenement(IN date_event DATE, IN debut INT, IN fin INT, IN Pseudo_dj VARCHAR(50), IN lieu_nom VARCHAR(50))
BEGIN    
    DECLARE idd INTEGER;
    DECLARE idL INTEGER;

    SELECT ID_DJ INTO idd FROM DJ WHERE Pseudo_dj = Pseudo LIMIT 1;
    SELECT ID_Lieu INTO idL FROM Lieu WHERE Nom_Lieu = lieu_nom LIMIT 1;

    INSERT INTO Evenement (Date_evenement, Debut, Fin, ID_DJ, ID_Lieu) VALUES (date_event, debut, fin, idd, idL);
END//


create procedure ajout_DJ(nom varchar(50),prenom varchar(50),pseudo varchar(50),date_naissance date, adresse varchar(50), continent varchar(50),style varchar(50),actif int)
BEGIN 
	insert into DJ(Nom,Prenom,Pseudo,Date_de_naissance,Adresse,Continent,Style,Actif) values (nom,prenom,pseudo,date_naissance,adresse,continent,style,actif);
END //

create procedure supp_DJ(id int)
BEGIN
		DECLARE nomDJ varchar(50);
        DECLARE prenomDJ varchar(50);
        DECLARE pseudoDJ varchar(50);
        DECLARE date_naissance Date;
        DECLARE adresseDJ varchar(50);
        DECLARE continentDJ varchar(50);
        DECLARE styleDJ varchar(50);
        SELECT Nom INTO nomDJ FROM DJ WHERE ID_DJ = id;
        SELECT Prenom INTO prenomDJ FROM DJ WHERE ID_DJ = id;
        SELECT Pseudo INTO pseudoDJ FROM DJ WHERE ID_DJ = id;
        SELECT Date_de_naissance INTO date_naissance FROM DJ WHERE ID_DJ = id;
        SELECT Adresse INTO adresseDJ FROM DJ WHERE ID_DJ = id;
        SELECT Continent INTO continentDJ FROM DJ WHERE ID_DJ = id;
        SELECT Style INTO styleDJ FROM DJ WHERE ID_DJ = id;
		update DJ
		SET Nom = nomDJ, Prenom = prenomDJ, Pseudo = pseudoDJ, Date_de_naissance = date_naissance, Adresse = adresseDJ, Continent = continentDJ, Style = styleDJ, Actif = 0
        WHERE ID_DJ = id;
END//

create procedure modif_DJ(id int, nomDJ varchar(50),prenomDJ varchar(50),pseudoDJ varchar(50),date_naissance date, adresseDJ varchar(50), continentDJ varchar(50),styleDJ varchar(50),actifDJ int)
BEGIN
	update DJ
		SET Nom = nomDJ, Prenom = prenomDJ, Pseudo = pseudoDJ, Date_de_naissance = date_naissance, Adresse = adresseDJ, Continent = continentDJ, Style = styleDJ, Actif = actifDJ
        WHERE ID_DJ = id;
END//


create procedure EvenementMois(mois int)
BEGIN 
	SELECT * from Evenement WHERE MONTH(Evenement.Date_evenement) = mois AND year(Evenement.Date_evenement) = year(now());
END//

create procedure Top5()
BEGIN
	SELECT D.Pseudo, COUNT(H.ID_Evenement) AS nb_event FROM DJ D JOIN Historique H ON D.ID_DJ=H.ID_DJ GROUP BY D.ID_DJ, D.Pseudo ORDER BY nb_event DESC;
END//

delimiter ;

CALL ajout_evenement('2024-04-11','2','4','Pseudo_DJ_1','Berghain');
CALL ajout_evenement('2024-04-15','2','4','Pseudo_DJ_3','Space');
CALL ajout_evenement('2024-04-19','2','4','Pseudo_DJ_5','Pacha');
CALL ajout_evenement('2024-04-23','2','4','Pseudo_DJ_6','Ushuaïa');
