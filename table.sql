CREATE TABLE `vanzator` (
	`nume` VARCHAR(255) NOT NULL,
	`varsta` INTEGER NOT NULL,
	`vechime` INTEGER NOT NULL,
	`nrVanzari` INTEGER NOT NULL,
	`contract` INTEGER NOT NULL,
	`salariu` INTEGER NOT NULL,
	PRIMARY KEY (`nume`)
);
CREATE TABLE `economist` (
    `nume` VARCHAR(255) NOT NULL,
    `varsta` INTEGER NOT NULL,
    `vechime` INTEGER NOT NULL,
    `contract` INTEGER NOT NULL,
	`salariu` INTEGER NOT NULL,
    PRIMARY KEY (`nume`)
);
CREATE TABLE `mecanic` (
    `nume` VARCHAR(255) NOT NULL,
    `varsta` INTEGER NOT NULL,
    `vechime` INTEGER NOT NULL,
    `nrLucrari` INTEGER NOT NULL,
    `contract` INTEGER NOT NULL,
    `salariu` INTEGER NOT NULL,
    PRIMARY KEY (`nume`)
);
CREATE TABLE `director_general` (
    `nume` VARCHAR(255) NOT NULL,
    `varsta` INTEGER NOT NULL,
    `vechime` INTEGER NOT NULL,
    `contract` INTEGER NOT NULL,
    `salariu` INTEGER NOT NULL,
    PRIMARY KEY (`nume`)
);