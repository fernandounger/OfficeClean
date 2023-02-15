-- -----------------------------------------------------
-- DATABASE estoqueBD
-- -----------------------------------------------------
DROP DATABASE IF EXISTS estoquebd;
CREATE DATABASE IF NOT EXISTS estoquebd DEFAULT CHARACTER SET UTF8;
USE estoquebd;

-- -----------------------------------------------------
-- Table Usuario
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS Usuario (
  Id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  Nome VARCHAR(100) NOT NULL,
  Login VARCHAR(45) NOT NULL,
  Senha VARCHAR(45) NOT NULL
);

SELECT * FROM Usuario;

insert into Usuario (Nome, Login, Senha) values ("Administrador", "admin@admin.com", "admin123");

-- -----------------------------------------------------
-- Table Endereco
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS Endereco (
    Id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    Logradouro VARCHAR(100) NOT NULL,
    Numero INT NOT NULL,
    Complemento VARCHAR(45) NULL,
    Bairro VARCHAR(45) NOT NULL,
    Cidade VARCHAR(45) NOT NULL,
    Estado CHAR(2) NOT NULL,
		CHECK (Estado IN ('AC', 'AL', 'AP', 'AM', ' BA', 'CE', 'DF', 'ES', 'GO', 'MA', 'MT', 'MS', 'MG', 'PA', 'PB', 'PR', 'PE', 'PI', 'RJ', 'RN', 'RS', 'RO', 'RR', 'SC', 'SP', 'SE', 'TO')),    
	CEP VARCHAR(45) NOT NULL
);

SELECT * FROM Endereco;

-- -----------------------------------------------------
-- Table Fornecedor
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS Fornecedor (
    Id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    CNPJ VARCHAR(45) NOT NULL,
    Nome VARCHAR(100) NOT NULL,
    Telefone VARCHAR(45) NOT NULL,
    Email VARCHAR(45) NOT NULL,
    Site VARCHAR(100) NOT NULL,
    Endereco_Id INT NOT NULL,
    FOREIGN KEY (Endereco_Id)
        REFERENCES Endereco (Id)
        ON DELETE CASCADE ON UPDATE CASCADE
);

SELECT * FROM Fornecedor;

create or replace view listagemFornecedor as 
select 
f.Id, f.CNPJ, f.Nome, f.Telefone, f.Email, f.Site,
end.Logradouro, end.Numero, end.Complemento, end.Bairro, end.Cidade, end.Estado, end.CEP  
from Fornecedor f
inner join Endereco end
on f.Endereco_Id = end.Id;

select f.Id as fId, f.CNPJ, f.Nome, f.Telefone, f.Email, f.Site, f.Endereco_Id, end.Id as endId, end.Logradouro, end.Numero, end.Complemento, end.Bairro, end.Cidade, end.Estado, end.CEP  from Fornecedor f inner join Endereco end on end.Id = f.Endereco_Id  order by f.Nome;

/*delete f.*, end.* from Fornecedor as f, Endereco as end where f.Endereco_Id = 3 AND e.Id = 3;*/

select * from listagemFornecedor order by Nome;

select * from listagemFornecedor where Nome like 'Isoneide Maria Gomes Lameirão' order by Nome;

/*delete from Fornecedor where Id = 2;*/

-- -----------------------------------------------------
-- Table Produto
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS Produto (
    Id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    Nome VARCHAR(100) NOT NULL,
    Categoria VARCHAR(45) NOT NULL,
		CHECK (Categoria IN ('Equipamentos de Limpeza' , 'Acessórios de Limpeza', 'Produtos Químicos de Limpeza', 'Papéis')),
    Fornecedor_Id INT NOT NULL,
    EstoqueMinimo INT NOT NULL,
    EstoqueMaximo INT NOT NULL,
    Descricao VARCHAR(100) NOT NULL,
    FOREIGN KEY (Fornecedor_Id)
        REFERENCES Fornecedor (Id)
        ON DELETE CASCADE ON UPDATE CASCADE
);

SELECT * FROM Produto;

create or replace view listagemProduto as 
select 
p.Id, p.Nome, p.Categoria, p.EstoqueMinimo, p.EstoqueMaximo, p.Descricao,
f.Nome as Fornecedor
from Produto p
inner join Fornecedor f
on p.Fornecedor_Id = f.Id;

select * from listagemProduto;

select * from listagemProduto order by Nome;

-- -----------------------------------------------------
-- Table Estoque
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS Estoque (
    Id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    Produto_Id INT NOT NULL,
    Fornecedor_Id INT NOT NULL,
    Quantidade INT NOT NULL,
    ValorUnitario DOUBLE(8,2) NULL,
    LocalizacaoEstoque VARCHAR(45) NOT NULL,
    FOREIGN KEY (Produto_Id)
        REFERENCES Produto (Id)
        ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (Fornecedor_Id)
        REFERENCES Fornecedor (Id)
        ON DELETE CASCADE ON UPDATE CASCADE
);

SELECT * FROM Estoque;

-- -----------------------------------------------------
-- Table ControleEntrada
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS ControleEntrada (
    Id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    DataEntrada DATETIME NULL DEFAULT CURRENT_TIMESTAMP,
    Produto_Id INT NOT NULL,
    Fornecedor_Id INT NOT NULL,
    Quantidade INT NOT NULL,
    ValorUnitario DOUBLE(8,2) NOT NULL,
    FOREIGN KEY (Produto_Id)
        REFERENCES Produto (Id)
        ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (Fornecedor_Id)
        REFERENCES Fornecedor (Id)
        ON DELETE CASCADE ON UPDATE CASCADE
);

SELECT * FROM ControleEntrada;

-- -----------------------------------------------------
-- Table ControleSaida
-- -----------------------------------------------------
	CREATE TABLE IF NOT EXISTS ControleSaida (
		Id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
		DataSaida DATETIME NULL DEFAULT CURRENT_TIMESTAMP,
		Produto_Id INT NOT NULL,
		Quantidade INT NOT NULL,
		ValorUnitario DOUBLE(8,2) NOT NULL,
		Justificativa VARCHAR(100) NOT NULL,
		FOREIGN KEY (Produto_Id)
			REFERENCES Produto (Id)
			ON DELETE CASCADE ON UPDATE CASCADE
	);

SELECT * FROM ControleSaida;

-- -----------------------------------------------------
-- Table Procedure Atualiza Estoque
-- -----------------------------------------------------
DELIMITER //
  CREATE PROCEDURE SP_AtualizaEstoque (ES_Produto_Id INT, ES_Quantidade INT, ES_ValorUnitario decimal(8,2))
BEGIN
    DECLARE Contador INT(11);

    SELECT count(*) INTO Contador FROM Estoque WHERE Produto_Id = ES_Produto_Id;

    IF Contador > 0 THEN
        UPDATE Estoque SET Quantidade=Quantidade + ES_Quantidade, ValorUnitario= ES_ValorUnitario
        WHERE Produto_Id = ES_Produto_Id;
    ELSE
        INSERT INTO Estoque (Produto_Id, Quantidade, ValorUnitario) values (ES_Produto_Id, ES_Quantidade, ES_ValorUnitario);
    END IF;
END //
DELIMITER ;

-- -----------------------------------------------------
-- Table Trigger Entrada Produto After Insert
-- -----------------------------------------------------
DELIMITER //
CREATE TRIGGER TRG_EntradaProduto_AI AFTER INSERT ON ControleEntrada
FOR EACH ROW
BEGIN
      CALL SP_AtualizaEstoque (new.Produto_Id, new.Quantidade, new.ValorUnitario);
END //
DELIMITER ;

-- -----------------------------------------------------
-- Table Trigger Entrada Produto After Update
-- -----------------------------------------------------
DELIMITER //
CREATE TRIGGER TRG_EntradaProduto_AU AFTER UPDATE ON ControleEntrada
FOR EACH ROW
BEGIN
      CALL SP_AtualizaEstoque (new.Produto_Id, new.Quantidade - old.Quantidade, new.ValorUnitario);
END //
DELIMITER ;

-- -----------------------------------------------------
-- Table Trigger Entrada Produto After Delete
-- -----------------------------------------------------
DELIMITER //
CREATE TRIGGER TRG_EntradaProduto_AD AFTER DELETE ON ControleEntrada
FOR EACH ROW
BEGIN
      CALL SP_AtualizaEstoque (old.Produto_Id, old.Quantidade * -1, old.ValorUnitario);
END //
DELIMITER ;

-- -----------------------------------------------------
-- Table Trigger Saída Produto After Insert
-- -----------------------------------------------------
DELIMITER //
CREATE TRIGGER TRG_SaidaProduto_AI AFTER INSERT ON ControleSaida
FOR EACH ROW
BEGIN
      CALL SP_AtualizaEstoque (new.Produto_Id, new.Quantidade * -1, new.ValorUnitario);
END //
DELIMITER ;

-- -----------------------------------------------------
-- Table Trigger Saída Produto After Update
-- -----------------------------------------------------
DELIMITER //
CREATE TRIGGER TRG_SaidaProduto_AU AFTER UPDATE ON ControleSaida
FOR EACH ROW
BEGIN
      CALL SP_AtualizaEstoque (new.Produto_Id, old.Quantidade - new.Quantidade, new.ValorUnitario);
END //
DELIMITER ;

-- -----------------------------------------------------
-- Table Trigger Saída Produto After Delete
-- -----------------------------------------------------
DELIMITER //
CREATE TRIGGER TRG_SaidaProduto_AD AFTER DELETE ON ControleSaida
FOR EACH ROW
BEGIN
      CALL SP_AtualizaEstoque (old.Produto_Id, old.Quantidade, old.ValorUnitario);
END //
DELIMITER ;


