

DROP DATABASE IF EXISTS Hochbau_sv01;

CREATE DATABASE Hochbau_sv01;

USE Hochbau_sv01;

CREATE TABLE Abteilung (
    Abteilungsnummer int PRIMARY KEY,
    Abteilungsname varchar(50) NOT NULL
);

CREATE TABLE Mitarbeiter (
	MANummer char(4) PRIMARY KEY,
    Maschinenberechtigung bit,
    Vorname varchar(50),
    Nachname varchar(50) NOT NULL,
    PLZ char(5),
    Abteilungsnummer int NOT NULL,
    FOREIGN KEY(Abteilungsnummer) REFERENCES Abteilung(Abteilungsnummer)
);

CREATE TABLE Baustelle (
	Baustellennummer char(4) PRIMARY KEY,
    Bezeichnung varchar(100) NOT NULL
);

CREATE TABLE MA_auf_Baustelle (
	MANummer char(4) NOT NULL,
    Baustellennummer char(4) NOT NULL,
    Einsatzzeit decimal(6,2),
    FOREIGN KEY(MANummer) REFERENCES Mitarbeiter(MANummer),
    FOREIGN KEY(Baustellennummer) REFERENCES Baustelle(Baustellennummer),
    PRIMARY KEY(MANummer, Baustellennummer)
);

INSERT INTO Abteilung(Abteilungsnummer, Abteilungsname) VALUES
	(12, 'Ausbau'),
	(9, 'Hochbau'),
	(10, 'Haustechnik');

INSERT INTO baustelle(Baustellennummer, Bezeichnung) VALUES
	('B021','MIDL'),
    ('B112','Kaufstadt'),
    ('B253','GaleiaX'),
    ('B056','Brutto');

INSERT INTO mitarbeiter(MANnummer, Nachname, maschinenberechtigung, abteilungsnummer, PLZ) VALUES
	('M010','Stein',true,12,'04838'),
	('M009','Örtel',0,9,'04105'),
	('M021','Hahn',1,10,'04509'),
	('M024','Holzer',false,9,'04119');

INSERT INTO MA_auf_Baustelle(MANummer,baustellennummer,Einsatzzeit) VALUES
	('M010','B021',12),('M010','B112',23),
	('M009','B253',37),
	('M021','B056',21),('M021','B112',24),('M021','B253',34),
	('M024','B056',8),('M024','B253',24);



