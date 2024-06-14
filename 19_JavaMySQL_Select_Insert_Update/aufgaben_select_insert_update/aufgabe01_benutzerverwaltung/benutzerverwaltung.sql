DROP DATABASE benutzerverwaltung;
CREATE DATABASE IF NOT EXISTS benutzerverwaltung;

USE benutzerverwaltung;

CREATE TABLE IF NOT EXISTS benutzer (
    name VARCHAR(100) PRIMARY KEY,
    passwort VARBINARY(255), #VARBINARY entspricht einem Byte-Array
    vorname VARCHAR(100),
    nachname VARCHAR(100)
    );
