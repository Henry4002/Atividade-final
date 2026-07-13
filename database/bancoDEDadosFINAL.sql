CREATE DATABASE atividade_final;
USE atividade_final;

CREATE TABLE fornecedor (
    id_fornecedor INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    telefone VARCHAR(20) NOT NULL,
    email VARCHAR(100) NOT NULL
);

CREATE TABLE produto (
    id_produto INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    descricao VARCHAR(200) NOT NULL,
    id_fornecedor INT NOT NULL,
    CONSTRAINT fk_produto_fornecedor
        FOREIGN KEY (id_fornecedor)
        REFERENCES fornecedor(id_fornecedor)
);

CREATE TABLE estoque (
    id_estoque INT AUTO_INCREMENT PRIMARY KEY,
    quantidade INT NOT NULL DEFAULT 0,
    id_produto INT NOT NULL UNIQUE,
    CONSTRAINT fk_estoque_produto
        FOREIGN KEY (id_produto)
        REFERENCES produto(id_produto)
);

CREATE TABLE transacoes (
    id_transacoes INT AUTO_INCREMENT PRIMARY KEY,
    tipo ENUM('ENTRADA','SAIDA') NOT NULL,
    quantidade INT NOT NULL,
    data_hora DATETIME NOT NULL,
    id_produto INT NOT NULL,
    CONSTRAINT fk_transacao_produto
        FOREIGN KEY (id_produto)
        REFERENCES produto(id_produto)
);