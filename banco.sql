CREATE DATABASE aula;

USE aula;

-- DROP TABLE cliente;
CREATE TABLE cliente(
	id_cliente INTEGER NOT NULL auto_increment,
	nome VARCHAR(60),
    endereco VARCHAR(60),
    CONSTRAINT pk_cliente primary key(id_cliente));
    
SELECT * FROM cliente;

SELECT last_insert_id();