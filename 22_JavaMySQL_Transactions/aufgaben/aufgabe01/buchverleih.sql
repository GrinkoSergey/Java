
/*
    Bücherverleihen
    Bücher werden gespeichert mit ID und Titel. Jedes Buch ist nur ein Mal im Bestand.
    Kunden haben Nummer, Name und Guthaben.
    Ausleihe ist gespeichert mit Buch, Kunde, Datum, Dauer.
    Wird ein Buch ausgeliehen, wird es in Ausleihe eingetragen und für die Dauer in Tagen je 1€ vom Guthaben des Kunden abgezogen.
    Wird das Buch zurückgebracht, wird es aus der Ausleihe gelöscht.

    Um ein Buch ausleihen zu können, muss geprüft werden, ob das Buch bereits ausgeliehen ist.
    Dann muss geprüft werden, ob Kunde genug Guthaben für die Dauer hat.
    Ist beides Okay, kann das Buch ausgeliehen werden.

    Dieser Vorgang soll innerhalb einer Transaktion stattfinden. Tritt ein Fehler auf, wird der Vorgang rückgängig gemacht.

*/


DROP DATABASE IF EXISTS buchverleihen;
CREATE DATABASE buchverleihen;
USE buchverleihen;


CREATE TABLE buch 
(
	buchID INT AUTO_INCREMENT PRIMARY KEY,
	titel VARCHAR(100) NOT NULL
);

CREATE TABLE kunde
(
	kundenNummer INT AUTO_INCREMENT PRIMARY KEY,
	nachname VARCHAR(100) NOT NULL,
	guthaben INT NOT NULL
);

CREATE TABLE ausleihe
(
	ID INT AUTO_INCREMENT PRIMARY KEY,
	buchID INT,
	kundenNummer INT,
	datum DATE,
	dauer INT NOT NULL,
	FOREIGN KEY(buchID) REFERENCES buch(buchID),
	FOREIGN KEY(kundenNummer) REFERENCES kunde(kundenNummer)
);

INSERT INTO buch (titel) VALUES
('Krieg und Frieden'), ('Anna Karenina');

INSERT INTO kunde (nachname, guthaben) VALUES
('Müller', 10), ('Schmidt', 20);