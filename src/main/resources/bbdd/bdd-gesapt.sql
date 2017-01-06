-- cambio minimo prueba home
-- DROP TABLES
DROP TABLE `gesapt`.`prices`;
DROP TABLE `gesapt`.`requests`;
DROP TABLE `gesapt`.`rentals`;
DROP TABLE `gesapt`.`languages`;
DROP TABLE `gesapt`.`states`;

-- DELETE FROM TABLES

-- CREATE TABLES
CREATE  TABLE `gesapt`.`prices` (
`idPrice` INT NOT NULL AUTO_INCREMENT ,
`startDate` DATE NULL ,
`endDate` DATE NULL ,
`priceNight` DECIMAL(6,2) NULL ,
`priceNightWeekend` DECIMAL(6,2) NULL ,
`priceWeek` DECIMAL(6,2) NULL ,
`priceForty` DECIMAL(6,2) NULL ,
`priceMonth` DECIMAL(6,2) NULL ,
`priceExtraNight` DECIMAL(6,2) NULL ,
`minimumRental` INT NULL ,
`offer` TINYINT NULL ,
`modificationDate` DATETIME NULL ,
PRIMARY KEY (`idPrice`) ,
UNIQUE INDEX `idPrice_UNIQUE` (`idPrice` ASC) );

CREATE  TABLE `gesapt`.`languages` (
	`idLanguage` VARCHAR(45) NOT NULL ,
	`descLanguage` VARCHAR(45) NULL ,
	PRIMARY KEY (`idLanguage`) ,
	UNIQUE INDEX `idLanguage_UNIQUE` (`idLanguage` ASC) );

CREATE TABLE `gesapt`.`requests` (
  `idRequest` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  `entryDate` DATE NOT NULL,
  `departureDate` DATE NOT NULL,
  `idLanguage` VARCHAR(45) NOT NULL ,
  `phone` VARCHAR(45) NULL,
  `creationDate` DATETIME NOT NULL,
  PRIMARY KEY (`idRequest`),
  UNIQUE INDEX `idRequest_UNIQUE` (`idRequest` ASC),
INDEX `idLanguage_idx` (`idLanguage` ASC) ,
CONSTRAINT `PK_idLanguage`
  FOREIGN KEY (`idLanguage` )
  REFERENCES `gesapt`.`languages` (`idLanguage` )
  ON DELETE NO ACTION
  ON UPDATE NO ACTION);

CREATE  TABLE `gesapt`.`states` (
	`idState` INT NOT NULL AUTO_INCREMENT ,
	`descState` VARCHAR(45) NULL ,
	PRIMARY KEY (`idState`) ,
	UNIQUE INDEX `idState_UNIQUE` (`idState` ASC) );

CREATE  TABLE `gesapt`.`rentals` (
`idRental` INT NOT NULL AUTO_INCREMENT ,
`firstName` VARCHAR(45) NOT NULL ,
`lastName` VARCHAR(45) NULL ,
`entryDate` DATE NOT NULL ,
`departureDate` DATE NOT NULL ,
`phone` VARCHAR(45) NULL ,
`numPeople` INT NULL ,
`price` DECIMAL(6,2) NOT NULL ,
`booking` DECIMAL(6,2) NULL ,
`deposit` DECIMAL(6,2) NULL ,
`idLanguage` VARCHAR(45) NOT NULL ,
`idState` INT NOT NULL ,
`creationDate` DATETIME NOT NULL ,
`modificationDate` DATETIME NOT NULL ,
PRIMARY KEY (`idRental`) ,
UNIQUE INDEX `idRental_UNIQUE` (`idRental` ASC) ,
INDEX `idState_idx` (`idState` ASC) ,
CONSTRAINT `PK_idState`
  FOREIGN KEY (`idState` )
  REFERENCES `gesapt`.`states` (`idState` )
  ON DELETE NO ACTION
  ON UPDATE NO ACTION,
INDEX `idLanguage_idx2` (`idLanguage` ASC) ,
CONSTRAINT `PK_idLanguage2`
  FOREIGN KEY (`idLanguage` )
  REFERENCES `gesapt`.`languages` (`idLanguage` )
  ON DELETE NO ACTION
  ON UPDATE NO ACTION);

-- INSERT DATA TABLES
INSERT INTO `gesapt`.`languages` (`idLanguage`, `descLanguage`) VALUES ('es', 'Spanish');
INSERT INTO `gesapt`.`languages` (`idLanguage`, `descLanguage`) VALUES ('en', 'English');
INSERT INTO `gesapt`.`languages` (`idLanguage`, `descLanguage`) VALUES ('fr', 'French');

