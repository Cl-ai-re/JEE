drop trigger check_concurrent_dj;
drop trigger trajet;
DELIMITER //

CREATE TRIGGER check_concurrent_dj
BEFORE INSERT ON Evenement
FOR EACH ROW
BEGIN
    DECLARE dj_count INT;
    (	SELECT COUNT(*) FROM Evenement
        WHERE ID_Lieu = NEW.ID_Lieu AND Date_Evenement = NEW.Date_Evenement AND (Debut <= NEW.Debut < Fin  OR Debut < NEW.Fin <= Fin)
        AND (NEW.ID_DJ != ID_DJ)) into dj_count;
    
    IF dj_count > 0 THEN
        SIGNAL SQLSTATE '45000' 
        SET MESSAGE_TEXT = 'Un autre DJ est déjà affecté simultanément à un événement à cette date.';
    END IF;
END;//


CREATE TRIGGER Trajet
BEFORE INSERT ON Evenement
FOR EACH ROW
BEGIN
	DECLARE cont_tmp VARCHAR(50);
	Declare id_av int;
	declare id_ap int;
	declare cont_av varchar(50);
	declare cont_ap varchar(50);
	declare date_av date;
	declare date_ap date;
	select Continent into cont_tmp from Lieu where id_lieu=new.id_lieu;
	select ID_Evenement into id_av from Evenement where New.ID_DJ=ID_DJ and New.Date_evenement>=Date_evenement order by Date_evenement asc limit 1;
	select ID_Evenement into id_ap from Evenement where new.ID_DJ=ID_DJ and New.Date_evenement<Date_evenement order by Date_evenement desc limit 1;
	Select Date_Evenement into date_av from Evenement where ID_Evenement=id_av;
	Select Date_Evenement into date_ap from Evenement where ID_Evenement=id_ap;
    Select Continent into cont_av from Lieu where ID_Lieu in (Select ID_Lieu from Evenement where ID_Evenement=id_av);
	Select Continent into cont_ap from Lieu where ID_Lieu in (Select ID_Lieu from Evenement where Id_Evenement=id_ap);

	If (cont_tmp=cont_av and DateDiff(New.Date_Evenement,date_av)<=1) OR ( cont_tmp<>cont_av and DateDiff(New.Date_Evenement,date_av)<=2) OR  (cont_tmp=cont_ap and DateDiff(date_ap,New.Date_Evenement)<=1) OR ( cont_tmp<>cont_ap and DateDiff(date_ap,New.Date_Evenement)<=2) OR (NEW.Date_Evenement = date_av) Then
		Signal SQLstate '45000'
			Set Message_text="la téléportation n'a pas encore été inventé";
	END IF;
END;//
DELIMITER ;
		