/* Erstellen Sie eine Konsolenanwendung zur Verwaltung von Benutzeraccounts.
    In diesem Beispiel werden Benutzer nur mit Benutzername und Profilbild gespeichert.
    Erstellen Sie eine Datenbank mit passender Tabelle für Benutzer.
    Erstellen Sie in Java eine passende Model-Klasse mit Methoden zum Erstellen von Accounts und dem Aktualisieren mit Profilbild.
    Testen Sie Ihr Programm, indem Sie einen Benutzer erstellen und anschließend diesen mit einem Bild (z.B. der WBS Bildmarke) aktualisieren.
*/

DROP DATABASE IF EXISTS benutzeraccounts;

CREATE DATABASE benutzeraccounts;

USE benutzeraccounts;

CREATE TABLE benutzer
(
	id INT PRIMARY KEY AUTO_INCREMENT,
	benutzername VARCHAR(100) NOT NULL, 
	profilbild LONGBLOB
);

DELIMITER $$
CREATE PROCEDURE insertAccountOhneBild(benutzerN VARCHAR(100), OUT benutzerID INT)
BEGIN
	INSERT INTO benutzer (benutzername) VALUES (benutzerN);
	SELECT LAST_INSERT_ID() INTO benutzerID;
END $$

DELIMITER ;

INSERT INTO benutzer (benutzername) VALUES ('Müller'), ('Schneider');