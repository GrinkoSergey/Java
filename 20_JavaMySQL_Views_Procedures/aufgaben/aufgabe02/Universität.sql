
DROP DATABASE IF EXISTS Universität;

CREATE DATABASE Universität;

USE Universität;

CREATE TABLE Zimmer (
	ZimmerNummer INT PRIMARY KEY,
	Telefonnummer INT UNIQUE
);

CREATE TABLE Kurs (
	KursKürzel CHAR(6) PRIMARY KEY,
	Name VARCHAR(255) NOT NULL
);

CREATE TABLE Student (
    StudentNummer INT PRIMARY KEY CHECK(StudentNummer > 0 AND StudentNummer < 99999),
    Nachname VARCHAR(255) NOT NULL,
    Vorname VARCHAR(255) NOT NULL,
    Geburtsdatum DATE NOT NULL,
    ZimmerNummer INT,
    FOREIGN KEY (ZimmerNummer) REFERENCES Zimmer (ZimmerNummer)
);

CREATE TABLE Kursbelegung (
    StudentNummer INT,
    KursKürzel CHAR(6),
    Semester CHAR(3) NOT NULL,
    Note DECIMAL(2,1),
    PRIMARY KEY (StudentNummer, KursKürzel),
    FOREIGN KEY (StudentNummer) REFERENCES Student (StudentNummer),
    FOREIGN KEY (KursKürzel) REFERENCES Kurs (KursKürzel)
);

INSERT INTO Zimmer (ZimmerNummer, Telefonnummer) VALUES
(120, 2136),
(237, 3127);
SELECT * FROM Zimmer;

INSERT INTO Kurs (KursKürzel, Name) VALUES
('Mat122', 'Zählen bis 10'),
('Phy120', 'Grundlagen der Schwerkraft'),
('Wiw330', 'Geldausgeben ganz leicht'),
('Mat130', 'Rechnen mit Fingern'),
('Phy230', 'Schweben für Anfänger'),
('Mat120', 'Zählen bis 3');
SELECT * FROM Kurs;

INSERT INTO Student (StudentNummer, Nachname, Vorname, Geburtsdatum, ZimmerNummer) VALUES
(3215, 'Jonas', 'Mike', '1991-02-23', 120),
(3456, 'Klaus', 'Schmidt', '1990-03-05', 237),
(4576, 'Paul', 'Neider', '1989-07-17', 120),
(1111, 'Lisa', 'Müller', '1990-04-15', 237);


SELECT * FROM Student;

INSERT INTO Kursbelegung (StudentNummer, KursKürzel, Semester, Note) VALUES
(3215,'Mat122','W88',1.4),
(3215,'Phy120','S88',2.5),
(3215,'Wiw330','W89',3.1),
(3456,'Mat122','W87',3.2),
(3456,'Mat130','S87',2.9),
(4576,'Phy230','W88',2.8),
(4576,'Mat120','S88',2.1);
SELECT * FROM Kursbelegung;

-- Durch die Check-Einschränkung bei Student können keine Studenten mit Nummer > 99.999 und <= 0 angelegt werden
## INSERT INTO Student (StudentNummer, Vorname, Nachname, Geburtsdatum) VALUES (100000, 'Vorname', 'Nachname', '1990-01-01');



###################################
/*Erstellen Sie zur Aufgabe Universität ein Java Programm
Verwenden Sie für die Kursbelegungen Views und Stored Procedures!

Die View der Kursbelegung soll KursKürzel, KursName, StudentNummer, StudentVorname, StudentNachname, Semester und Note beinhalten.
Eine Prozedur soll neue Kursbelegungen anlegen und eine andere Prozedur soll die Note der Kursbelegung ändern können.*/

-- ---------- VIEW

CREATE VIEW kursbelegungView AS
SELECT k.KursKürzel, Name as KursName, s.StudentNummer, Vorname as StudenVorname, Nachname as StudentNachname, Semester, Note
	FROM Kurs k
		join Kursbelegung kb ON k.kurskürzel = kb.kurskürzel
		join Student s on kb.studentnummer = s.studentnummer;


-- --------- PROCEDURES

DELIMITER $$

CREATE PROCEDURE insertKursbelegung (stdNum INT, kk CHAR(6), sem CHAR(3), n DECIMAL(2,1)) -- stdNum - StudentNummer, kk - KursKürzel, sem - Semester, n - Note
BEGIN
	INSERT INTO Kursbelegung (StudentNummer, KursKürzel, Semester, Note) 
	VALUES (stdNum, kk, sem, n);
END $$


CREATE PROCEDURE updateKursbelegung (stdNum INT, kk CHAR(6), n DECIMAL(2,1)) -- stdNum - StudentNummer, kk - KursKürzel, n - Note
BEGIN
	UPDATE Kursbelegung kb 
	SET Note = n WHERE kb.StudentNummer = stdNum AND kb.KursKürzel = kk;
END $$

DELIMITER ;

CALL insertKursbelegung (3456, 'Wiw330', 'XYZ', 1.0);
CALL updateKursbelegung (3456, 'Wiw330', 5.5);