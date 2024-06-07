
USE onlineshop;

DROP VIEW IF EXISTS selectAlles;
DROP VIEW IF EXISTS selectanzahlgekaufterprodukte;
DROP PROCEDURE IF EXISTS insertArtikel;
DROP PROCEDURE IF EXISTS updateArtikelPreis;


CREATE VIEW selectAlles AS
	SELECT k.kundennummer AS kunde, k.name AS kunde_name,
    	b.bestellnummer AS bestellung, b.datum,
        ad1.straßeNr AS rechnung, ad2.straßeNr AS lieferung,
        a.artikelnummer AS artikel, a.bezeichnung,
        bp.anzahl,
        h.herstellernummer AS hersteller, h.name AS hersteller_name    
    FROM kunde AS k
    JOIN bestellung AS b ON k.kundennummer = b.kundennummer
    JOIN adresse AS ad1 ON b.rechnungsadresse = ad1.id
    JOIN adresse AS ad2 ON b.lieferadresse = ad2.id
    JOIN bestellposition AS bp ON b.bestellnummer = bp.bestellnummer
    JOIN artikel AS a ON bp.artikelnummer = a.artikelnummer
    JOIN hersteller AS h ON a.herstellernummer = h.herstellernummer;
    

SELECT * FROM selectAlles;

SELECT * FROM selectAlles WHERE kunde = 123123124;

CREATE VIEW selectAnzahlGekaufterProdukte AS
	SELECT k.kundennummer, IFNULL (SUM(bp.anzahl), 0) anzahl 
    FROM kunde k
    LEFT JOIN bestellung b on k.kundennummer = b.kundennummer
    LEFT JOIN bestellposition bp ON b.bestellnummer = bp.bestellnummer    
    GROUP BY k.kundennummer;
    
SELECT * FROM selectAnzahlGekaufterProdukte;
	

DELIMITER $$
                

CREATE PROCEDURE insertArtikel (bez VARCHAR(100), p DECIMAL(8,2), h INT, OUT n INT)  # bez = bezeichnung, p = preis, h = herstellernummer, n = artikelnummer 
BEGIN 
	INSERT INTO artikel (bezeichnung, preis, herstellernummer)
    VALUES (bez, p, h); 
	
    SELECT LAST_INSERT_ID() INTO n;

END$$

DELIMITER ;

# Aufruf der Prozedur mit CALL
CALL insertArtikel('BluRay Player Ultra-Deluxe', 149.90, 1, @nummer);
SELECT @nummer;
SELECT * FROM artikel;


DELIMITER $$
CREATE PROCEDURE updateArtikelPreis (nummer INT, preis DECIMAL(8,1))
BEGIN
	UPDATE artikel SET artikel.preis = preis WHERE artikel.artikelnummer = nummer;
END$$artikelnummer
DELIMITER ;




