-- definicion de base de datos

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

CREATE TABLE `gesapt`.`requests` (
  `idRequest` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  `entryDate` DATE NOT NULL,
  `departureDate` DATE NOT NULL,
  `foreign` TINYINT NULL,
  `phone` VARCHAR(45) NULL,
  `creationDate` DATETIME NOT NULL,
  PRIMARY KEY (`idRequest`),
  UNIQUE INDEX `idRequest_UNIQUE` (`idRequest` ASC));

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
  ON UPDATE NO ACTION);

