

DROP DATABASE IF EXISTS ticketautomat;

CREATE DATABASE ticketautomat;

USE ticketautomat;

CREATE TABLE ticket 
(
	ticketID INT AUTO_INCREMENT PRIMARY KEY,
	zufNummer INT NOT NULL
);