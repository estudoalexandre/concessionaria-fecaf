create database concessionaria_fecaf;


use concessionaria_fecaf;

CREATE TABLE veiculo (
                         id BIGINT(20) NOT NULL AUTO_INCREMENT,
                         modelo VARCHAR(255) DEFAULT NULL,
                         marca VARCHAR(255) DEFAULT NULL,
                         ano INT(11) DEFAULT NULL,
                         tipo VARCHAR(255) DEFAULT NULL,
                         combustivel VARCHAR(255) DEFAULT NULL,
                         cor VARCHAR(255) DEFAULT NULL,
                         cambio_automatico TINYINT(1) DEFAULT NULL,
                         imagem VARCHAR(255) DEFAULT NULL,
                         preco DECIMAL(10,2) NOT NULL,
                         quilometragem BIGINT(20) NOT NULL,
                         disponibilidade TINYINT(1) NOT NULL,
                         PRIMARY KEY (id)
);

CREATE TABLE carro (
                       id BIGINT(20) NOT NULL,
                       motor DOUBLE DEFAULT NULL,
                       ar_condicionado TINYINT(1) DEFAULT NULL,
                       portas INT(11) DEFAULT NULL,
                       PRIMARY KEY (id),
                       FOREIGN KEY (id) REFERENCES veiculo(id) ON DELETE CASCADE
);

CREATE TABLE moto (
                      id BIGINT(20) NOT NULL,
                      cilindradas INT(11) DEFAULT NULL,
                      bau_carga TINYINT(1) DEFAULT NULL,
                      PRIMARY KEY (id),
                      FOREIGN KEY (id) REFERENCES veiculo(id) ON DELETE CASCADE
);

-- Inserindo o primeiro veículo (Civic)
INSERT INTO veiculo (modelo, marca, ano, tipo, combustivel, cor, cambio_automatico, imagem, preco, quilometragem, disponibilidade)
VALUES
    ('Civic', 'Honda', 2020, 'Carro', 'Gasolina', 'Preto', 1, 'https://upload.wikimedia.org/wikipedia/commons/thumb/1/1e/2015_Honda_Civic_Si_Coupe_Orange.JPG/800px-2015_Honda_Civic_Si_Coupe_Orange.JPG?20150703135328', 95000.00, 30000, 1);

-- Usando LAST_INSERT_ID() para associar o Civic na tabela carro
INSERT INTO carro (id, motor, ar_condicionado, portas)
VALUES
    (LAST_INSERT_ID(), 2.0, 1, 4);

-- Inserindo o segundo veículo (Corolla)
INSERT INTO veiculo (modelo, marca, ano, tipo, combustivel, cor, cambio_automatico, imagem, preco, quilometragem, disponibilidade)
VALUES
    ('Corolla', 'Toyota', 2019, 'Carro', 'Flex', 'Branco', 1, 'https://static.wixstatic.com/media/3304d4_b5cc611056f34707b2135d99a24ea852~mv2.jpeg/v1/fill/w_420,h_271,al_c,q_80,usm_2.00_1.00_0.00,enc_avif,quality_auto/corolla.jpeg', 85000.00, 40000, 1);

-- Usando LAST_INSERT_ID() para associar o Corolla na tabela carro
INSERT INTO carro (id, motor, ar_condicionado, portas)
VALUES
    (LAST_INSERT_ID(), 1.8, 1, 4);

-- Inserindo o terceiro veículo (CB 500)
INSERT INTO veiculo (modelo, marca, ano, tipo, combustivel, cor, cambio_automatico, imagem, preco, quilometragem, disponibilidade)
VALUES
    ('CB 500', 'Honda', 2021, 'Moto', 'Gasolina', 'Vermelho', 0, 'https://www.honda.com.br/motos/sites/hda/files/2023-09/moto-honda-cb-500f-vermelho-victory-red.webp', 35000.00, 5000, 1);

-- Usando LAST_INSERT_ID() para associar a CB 500 na tabela moto
INSERT INTO moto (id, cilindradas, bau_carga)
VALUES
    (LAST_INSERT_ID(), 500, 1);

-- Inserindo o quarto veículo (MT-07)
INSERT INTO veiculo (modelo, marca, ano, tipo, combustivel, cor, cambio_automatico, imagem, preco, quilometragem, disponibilidade)
VALUES
    ('MT-07', 'Yamaha', 2022, 'Moto', 'Gasolina', 'Azul', 0, 'https://www.cycleworld.com/resizer/0tqxAJDO_U0GDnnFPigMiJq1Dak=/cloudfront-us-east-1.images.arcpublishing.com/octane/DB5SVIJ3PRCYJIF7BVRAFGPLMY.jpg', 45000.00, 1000, 1);

-- Usando LAST_INSERT_ID() para associar a MT-07 na tabela moto
INSERT INTO moto (id, cilindradas, bau_carga)
VALUES
    (LAST_INSERT_ID(), 689, 0);

