-- -----------------------------------------------------
-- Schema loja
-- -----------------------------------------------------
DROP DATABASE estoqueBD;
CREATE SCHEMA IF NOT EXISTS estoqueBD DEFAULT CHARACTER SET utf8 ;
USE estoqueBD ;

-- -----------------------------------------------------
-- Table loja.Endereco
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS Endereco (
  Id INT NOT NULL AUTO_INCREMENT,
  CEP VARCHAR(45) NOT NULL,
  Estado CHAR(2) NOT NULL,
  Cidade VARCHAR(45) NOT NULL,
  Bairro VARCHAR(45) NOT NULL,
  Logradouro VARCHAR(100) NOT NULL,
  Número INT NOT NULL,
  Complemento VARCHAR(45) NULL,
  PRIMARY KEY (Id))
ENGINE = InnoDB;

SELECT * FROM Endereco;


-- -----------------------------------------------------
-- Table loja.Fornecedor
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS Fornecedor (
  Id INT NOT NULL AUTO_INCREMENT,
  CNPJ VARCHAR(45) NOT NULL,
  Nome VARCHAR(100) NOT NULL,
  Telefone VARCHAR(45) NOT NULL,
  Email VARCHAR(45) NOT NULL,
  Site VARCHAR(45) NOT NULL,
  Endereco_Id INT NOT NULL,
  PRIMARY KEY (Id),
  INDEX fk_Fornecedor_Endereco1_idx (Endereco_Id ASC) ,
  CONSTRAINT fk_Fornecedor_Endereco1
    FOREIGN KEY (Endereco_Id)
    REFERENCES Endereco (Id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

SELECT * FROM Fornecedor;

-- -----------------------------------------------------
-- Table loja.Produto
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS Produto (
  CodigoBarra INT NOT NULL,
  Nome VARCHAR(100) NOT NULL,
  Categoria VARCHAR(45) NOT NULL,
  EstoqueMinimo INT NOT NULL,
  EstoqueAtual INT NOT NULL,
  EstoqueMaximo INT NOT NULL,
  Descricao VARCHAR(100) NOT NULL,
  LocalizacaoEstoque VARCHAR(45) NOT NULL,
  ValorUnitario DOUBLE NOT NULL,
  PRIMARY KEY (CodigoBarra))
ENGINE = InnoDB;

SELECT * FROM Produto;

-- -----------------------------------------------------
-- Table loja.ControleEntrada
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS ControleEntrada (
  Id INT NOT NULL AUTO_INCREMENT,
  DataEntrada DATE NOT NULL,
  Quantidade INT NOT NULL,
  ValorPago DOUBLE NOT NULL,
  Produto_CodigoBarra INT NOT NULL,
  PRIMARY KEY (Id),
  INDEX fk_ControleEntrada_Produto1_idx (Produto_CodigoBarra ASC) ,
  CONSTRAINT fk_ControleEntrada_Produto1
    FOREIGN KEY (Produto_CodigoBarra)
    REFERENCES Produto (CodigoBarra)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

SELECT * FROM ControleEntrada;

-- -----------------------------------------------------
-- Table loja.Funcionario
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS Funcionario (
  Id INT NOT NULL AUTO_INCREMENT,
  Nome VARCHAR(100) NOT NULL,
  Login VARCHAR(45) NOT NULL,
  Senha VARCHAR(45) NOT NULL,
  NivelAcesso VARCHAR(45) NOT NULL,
  Endereco_Id INT NOT NULL,
  Fornecedor_Id INT NOT NULL,
  ControleEntrada_Id INT NOT NULL,
  Produto_CodigoBarra INT NOT NULL,
  PRIMARY KEY (Id, ControleEntrada_Id, Produto_CodigoBarra),
  INDEX fk_Funcionario_Endereco1_idx (Endereco_Id ASC) ,
  INDEX fk_Funcionario_Fornecedor1_idx (Fornecedor_Id ASC) ,
  INDEX fk_Funcionario_ControleEntrada1_idx (ControleEntrada_Id ASC) ,
  INDEX fk_Funcionario_Produto1_idx (Produto_CodigoBarra ASC) ,
  CONSTRAINT fk_Funcionario_Endereco1
    FOREIGN KEY (Endereco_Id)
    REFERENCES loja.Endereco (Id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_Funcionario_Fornecedor1
    FOREIGN KEY (Fornecedor_Id)
    REFERENCES Fornecedor (Id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_Funcionario_ControleEntrada1
    FOREIGN KEY (ControleEntrada_Id)
    REFERENCES ControleEntrada (Id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_Funcionario_Produto1
    FOREIGN KEY (Produto_CodigoBarra)
    REFERENCES Produto (CodigoBarra)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

SELECT * FROM Funcionario;

-- -----------------------------------------------------
-- Table loja.ControleSaida
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS ControleSaida (
  Id INT NOT NULL AUTO_INCREMENT,
  DataSaida DATE NOT NULL,
  Quantidade INT NOT NULL,
  Justificativa VARCHAR(100) NOT NULL,
  PRIMARY KEY (Id))
ENGINE = InnoDB;

SELECT * FROM ControleSaida;


-- -----------------------------------------------------
-- Table loja.Produto_has_ControleSaida
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS Produto_has_ControleSaida (
  Produto_CodigoBarra INT NOT NULL,
  ControleSaida_Id INT NOT NULL,
  PRIMARY KEY (Produto_CodigoBarra, ControleSaida_Id),
  INDEX fk_Produto_has_ControleSaida_ControleSaida1_idx (ControleSaida_Id ASC) ,
  INDEX fk_Produto_has_ControleSaida_Produto1_idx (Produto_CodigoBarra ASC) ,
  CONSTRAINT fk_Produto_has_ControleSaida_Produto1
    FOREIGN KEY (Produto_CodigoBarra)
    REFERENCES Produto (CodigoBarra)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_Produto_has_ControleSaida_ControleSaida1
    FOREIGN KEY (ControleSaida_Id)
    REFERENCES loja.ControleSaida (Id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table loja.Produto_has_Fornecedor
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS Produto_has_Fornecedor (
  Produto_CodigoBarra INT NOT NULL,
  Fornecedor_Id INT NOT NULL,
  PRIMARY KEY (Produto_CodigoBarra, Fornecedor_Id),
  INDEX fk_Produto_has_Fornecedor_Fornecedor1_idx (Fornecedor_Id ASC) ,
  INDEX fk_Produto_has_Fornecedor_Produto1_idx (Produto_CodigoBarra ASC) ,
  CONSTRAINT fk_Produto_has_Fornecedor_Produto1
    FOREIGN KEY (Produto_CodigoBarra)
    REFERENCES Produto (CodigoBarra)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_Produto_has_Fornecedor_Fornecedor1
    FOREIGN KEY (Fornecedor_Id)
    REFERENCES Fornecedor (Id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table loja.Funcionario_has_ControleSaida
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS Funcionario_has_ControleSaida (
  Funcionario_Id INT NOT NULL,
  Funcionario_ControleEntrada_Id INT NOT NULL,
  ControleSaida_Id INT NOT NULL,
  PRIMARY KEY (Funcionario_Id, Funcionario_ControleEntrada_Id, ControleSaida_Id),
  INDEX fk_Funcionario_has_ControleSaida_ControleSaida1_idx (ControleSaida_Id ASC) ,
  INDEX fk_Funcionario_has_ControleSaida_Funcionario1_idx (Funcionario_Id ASC, Funcionario_ControleEntrada_Id ASC) ,
  CONSTRAINT fk_Funcionario_has_ControleSaida_Funcionario1
    FOREIGN KEY (Funcionario_Id , Funcionario_ControleEntrada_Id)
    REFERENCES Funcionario (Id , ControleEntrada_Id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_Funcionario_has_ControleSaida_ControleSaida1
    FOREIGN KEY (ControleSaida_Id)
    REFERENCES ControleSaida (Id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;
