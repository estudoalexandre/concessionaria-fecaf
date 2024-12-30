create database concessionaria_fecaf;


use concessionaria_fecaf;

CREATE TABLE Veiculo (
                         id INT AUTO_INCREMENT PRIMARY KEY,
                         modelo VARCHAR(50),
                         marca VARCHAR(50),
                         ano INT,
                         rodas VARCHAR(10),
                         tipo VARCHAR(20),
                         combustivel VARCHAR(20),
                         cor VARCHAR(20),
                         cambio_automatico BOOLEAN
);

CREATE TABLE Moto (
                      id INT PRIMARY KEY,
                      cilindradas INT,
                      bau_carga BOOLEAN,
                      FOREIGN KEY (id) REFERENCES Veiculo (id) ON DELETE CASCADE
);

CREATE TABLE Carro (
                       id INT PRIMARY KEY,
                       motor DOUBLE PRECISION,
                       ar_condicionado BOOLEAN,
                       FOREIGN KEY (id) REFERENCES Veiculo (id) ON DELETE CASCADE
);

INSERT INTO Veiculo (modelo, marca, ano, rodas, tipo, combustivel, cor, cambio_automatico)
VALUES ('Civic', 'Honda', 2021, '4', 'Carro', 'Gasolina', 'Preto', TRUE);

INSERT INTO Carro (id, motor, ar_condicionado, portas)
VALUES (LAST_INSERT_ID(), 2.0, TRUE, 4);

INSERT INTO Veiculo (modelo, marca, ano, rodas, tipo, combustivel, cor, cambio_automatico)
VALUES ('CB500', 'Honda', 2021, '2', 'Moto', 'Gasolina', 'Vermelha', FALSE);

INSERT INTO Moto (id, cilindradas, bau_carga)
VALUES (LAST_INSERT_ID(), 500, FALSE);
