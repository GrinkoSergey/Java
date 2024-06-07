
DROP DATABASE IF EXISTS Onlineshop; 

CREATE DATABASE Onlineshop;

USE Onlineshop;

CREATE TABLE Kunde (
    kundennummer INT PRIMARY KEY AUTO_INCREMENT, 
    name VARCHAR(100) NOT NULL 
);

CREATE TABLE Adresse (
    id INT PRIMARY KEY AUTO_INCREMENT, 
    straßeNr VARCHAR(100) NOT NULL, 
    plz CHAR(5) NOT NULL, 
    ort VARCHAR(100) NOT NULL,
    kundennummer INT NOT NULL,
    FOREIGN KEY (kundennummer) REFERENCES kunde (kundennummer)
);

CREATE TABLE Bestellung (
    bestellnummer INT PRIMARY KEY AUTO_INCREMENT,
    datum DATETIME NOT NULL DEFAULT NOW(), 
    kundennummer INT NOT NULL,
    rechnungsadresse INT NOT NULL,
    lieferadresse INT NOT NULL, 
    FOREIGN KEY (kundennummer) REFERENCES Kunde (kundennummer),
    FOREIGN KEY (rechnungsadresse) REFERENCES Adresse (id),
    FOREIGN KEY (lieferadresse) REFERENCES Adresse (id)
);

CREATE TABLE hersteller (
    herstellernummer INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL
);

CREATE TABLE artikel (
    artikelnummer INT PRIMARY KEY AUTO_INCREMENT,
    bezeichnung VARCHAR(100) NOT NULL,
    preis DECIMAL(8,2) NOT NULL CHECK (preis >= 0), 
    herstellernummer INT NOT NULL,
    FOREIGN KEY (herstellernummer) REFERENCES hersteller (herstellernummer)
);

CREATE TABLE bestellposition (
    bestellnummer INT,
    artikelnummer INT,
    anzahl INT NOT NULL CHECK (anzahl > 0),
    FOREIGN KEY (bestellnummer) REFERENCES Bestellung (bestellnummer), 
    FOREIGN KEY (artikelnummer) REFERENCES artikel (artikelnummer),
    PRIMARY KEY (bestellnummer, artikelnummer) # Zusammengesetzer Primärschlüssel
);


INSERT INTO Kunde (kundennummer, name) VALUES
(123123123, 'Wilson');

INSERT INTO Kunde (name) VALUES
('Sanchez'), ('Bashir');

INSERT INTO Adresse (straßeNr, plz, ort, kundennummer) VALUES
('Hauptstraße 1', '12345', 'Hauptstadt', 123123123),
('Nebenstraße 2', '12345', 'Hauptstadt', 123123124),
('Nebenstraße 8', '12345', 'Hauptstadt', 123123125);

INSERT INTO Bestellung (kundennummer, rechnungsadresse, lieferadresse) VALUES
(123123123, 1, 1),
(123123123, 1, 2),
(123123124, 2, 2);

INSERT INTO Hersteller (name) VALUES
('Technik Supreme'),
('Dein Garten'),
('Kino und mehr');

INSERT INTO Artikel (bezeichnung, preis, herstellernummer) VALUES
('Flatscreen 50 Zoll', 599.99, 1),
('Gießkanne Blau 5L', 6.90, 2),
('Into the Spiderverse BluRay Special Edition', 9.99, 3),
('Soundblaster 5.1', 99.95, 1);

INSERT INTO Bestellposition (bestellnummer, artikelnummer, anzahl) VALUES
(1, 1, 1),
(1, 2, 1),
(2, 2, 2),
(3, 3, 1);


SELECT * FROM Kunde;
SELECT * FROM Artikel;

SELECT kunde.kundennummer 'kunde', kunde.name,
	bestellung.bestellnummer 'bestellung', bestellung.datum,
    a1.straßeNr 'rechnung', a2.straßeNr 'lieferung',
    artikel.artikelnummer 'artikel', artikel.bezeichnung, artikel.preis,
    bp.anzahl,
    hersteller.herstellernummer 'hersteller', hersteller.name
FROM Kunde
JOIN Bestellung ON Kunde.Kundennummer = Bestellung.Kundennummer
JOIN Adresse a1 ON Bestellung.rechnungsadresse = a1.id
JOIN Adresse a2 ON Bestellung.lieferadresse = a2.id
JOIN Bestellposition bp ON Bestellung.bestellnummer = bp.bestellnummer
JOIN Artikel ON bp.artikelnummer = Artikel.artikelnummer
JOIN Hersteller ON Artikel.herstellernummer = Hersteller.herstellernummer;


