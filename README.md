Este repositório apresenta a resolução de um problema de uma clínica veterinária que gerenciava o cadastro de pets e consultas em fichas de papel, um processo lento e sujeito a erros. Para modernizar e agilizar a operação, desenvolvi um programa em Java seguindo o padrão de arquitetura MVC. Este sistema permite a digitalização de todos os registros de forma organizada e eficiente, utilizando SQL para garantir o armazenamento e a recuperação segura das informações.


SCRIPT DO BANCO DE DADOS:

CREATE DATABASE db_petvida;
USE db_petvida;
-- Tabela Funcionarios
CREATE TABLE Funcionarios (
 id INT PRIMARY KEY AUTO_INCREMENT,
 cargo VARCHAR(255) NOT NULL,
 nome VARCHAR(255) NOT NULL,
 email VARCHAR(255) UNIQUE,
 senha VARCHAR(255) NOT NULL
);
-- Tabela Veterinario
CREATE TABLE Veterinario (
 id_funcionario INT PRIMARY KEY,
 crmv INT UNIQUE NOT NULL,
 CONSTRAINT fk_veterinario_func FOREIGN KEY (id_funcionario) REFERENCES Funcionarios(id)
);
-- Tabela Recepcionista
CREATE TABLE Recepcionista (
 id_funcionario INT PRIMARY KEY,
 cpf VARCHAR(14) UNIQUE NOT NULL,
 CONSTRAINT fk_recepcionista_func FOREIGN KEY (id_funcionario) REFERENCES Funcionarios(id)
);
-- Tabela Tutor
CREATE TABLE Tutor (
 id INT PRIMARY KEY AUTO_INCREMENT,
 nome VARCHAR(255) NOT NULL,
 cpf VARCHAR(14) UNIQUE NOT NULL,
 endereco VARCHAR(255),
 telefone VARCHAR(20)
);
-- Tabela Animal
CREATE TABLE Animal (
 id INT PRIMARY KEY AUTO_INCREMENT,
 nome_pet VARCHAR(255) NOT NULL,
 porte VARCHAR(50),
 peso DECIMAL(10,2),
 sexo CHAR(1),
 especie VARCHAR(100),
 idade INT,
 id_tutor INT NOT NULL,
 CONSTRAINT fk_animal_tutor FOREIGN KEY (id_tutor) REFERENCES Tutor(id)
);
-- Tabela Prontuario
CREATE TABLE Prontuario (
 id INT PRIMARY KEY AUTO_INCREMENT
);
-- Tabela Consultas
CREATE TABLE Consultas (
 id INT PRIMARY KEY AUTO_INCREMENT,
 valor DECIMAL(10,2),
 id_prontuario INT NOT NULL,
 id_animal INT NOT NULL,
 CONSTRAINT fk_consultas_prontuario FOREIGN KEY (id_prontuario) REFERENCES Prontuario(id),
 CONSTRAINT fk_consultas_animal FOREIGN KEY (id_animal) REFERENCES Animal(id)
);
-- Tabela Agendar_consulta
CREATE TABLE Agendar_consulta (
 id INT PRIMARY KEY AUTO_INCREMENT,
 data_hora VARCHAR(20) NOT NULL,
 id_tutor INT NOT NULL,
 id_veterinario INT NOT NULL,
 id_animal INT NOT NULL,
 CONSTRAINT fk_agendar_tutor FOREIGN KEY (id_tutor) REFERENCES Tutor(id),
 CONSTRAINT fk_agendar_veterinario FOREIGN KEY (id_veterinario) REFERENCES
Veterinario(id_funcionario),
 CONSTRAINT fk_agendar_animal FOREIGN KEY (id_animal) REFERENCES Animal(id)
);
-- Opcional: resetar o AUTO_INCREMENT do Tutor (use apenas se a tabela estiver vazia)
ALTER TABLE Tutor AUTO_INCREMENT = 1;
