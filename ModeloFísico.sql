-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema agencia
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema agencia
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `agencia` DEFAULT CHARACTER SET utf8 ;
USE `agencia` ;

-- -----------------------------------------------------
-- Table `Cadastro`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Cadastro` (
  `Id_Cadastro` INT NOT NULL AUTO_INCREMENT,
  `Nome` VARCHAR(50) NOT NULL,
  `Email` VARCHAR(50) NOT NULL,
  `Senha` INT NOT NULL,
  PRIMARY KEY (`Id_Cadastro`),
  UNIQUE INDEX `Email_UNIQUE` (`Email` ASC) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Entrar`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Entrar` (
  `Id_Entrar` INT NOT NULL AUTO_INCREMENT,
  `Email` VARCHAR(50) NOT NULL,
  `Senha` INT NOT NULL,
  `Id_Cadastro` INT NOT NULL,
  PRIMARY KEY (`Id_Entrar`),
  UNIQUE INDEX `Email_UNIQUE` (`Email` ASC) ,
  INDEX `Id_Cadastro_idx` (`Id_Cadastro` ASC) ,
  CONSTRAINT `Id_Cadastro`
    FOREIGN KEY (`Id_Cadastro`)
    REFERENCES `Cadastro` (`Id_Cadastro`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Destino`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Destino` (
  `Id_Destino` INT NOT NULL AUTO_INCREMENT,
  `Nome_Destino` VARCHAR(45) NOT NULL,
  `Cidade` VARCHAR(45) NOT NULL,
  `Estado` VARCHAR(45) NOT NULL,
  `Ida` VARCHAR(45) NOT NULL,
  `Volta` VARCHAR(45) NOT NULL,
  `Id_Cadastro` INT NOT NULL,
  PRIMARY KEY (`Id_Destino`),
  INDEX `Id_Cadastro_idx` (`Id_Cadastro` ASC) ,
  CONSTRAINT `Id_Cadastro`
    FOREIGN KEY (`Id_Cadastro`)
    REFERENCES `Cadastro` (`Id_Cadastro`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Contato`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Contato` (
  `Id_Contato` INT NOT NULL AUTO_INCREMENT,
  `Nome` VARCHAR(45) NOT NULL,
  `Email` VARCHAR(45) NULL,
  `Mensagem` NCHAR(200) NOT NULL,
  `Id_Cadastro` INT NOT NULL,
  PRIMARY KEY (`Id_Contato`),
  INDEX `Id_Cadastro_idx` (`Id_Cadastro` ASC) ,
  CONSTRAINT `Id_Cadastro`
    FOREIGN KEY (`Id_Cadastro`)
    REFERENCES `Cadastro` (`Id_Cadastro`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
