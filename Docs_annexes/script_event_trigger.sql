drop event check_evenement;


DELIMITER //
Create EVENT check_evenement
ON SCHEDULE EVERY 1 DAY
DO
BEGIN
    DECLARE done BOOLEAN DEFAULT FALSE;
    DECLARE id_tmp int;
    DECLARE date_event_tmp date;
    DECLARE fin_tmp int;
    DECLARE dj_tmp int;
    DECLARE lieu_tmp int;

    DECLARE cur CURSOR FOR SELECT ID_Evenement,Date_evenement,Fin,ID_DJ,ID_Lieu FROM Evenement;

    DECLARE CONTINUE HANDLER FOR NOT FOUND SET done=TRUE;

    OPEN cur;

    read_loop: LOOP
        FETCH cur INTO id_tmp,date_event_tmp,fin_tmp,dj_tmp,lieu_tmp;

        IF done THEN
            LEAVE read_loop;
        END IF;
        IF DATEDIFF(CURDATE(),date_event_tmp)>0 THEN
            Insert into Historique values (id_tmp,date_event_tmp,fin_tmp,dj_tmp,lieu_tmp);
            Delete from Evenement where ID_Evenement=id_tmp;
        END IF:
    END LOOP;

    CLOSE cur;
END;
//

DELIMITER ;