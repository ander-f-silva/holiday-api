CREATE TABLE tb_city (
    code INTEGER PRIMARY KEY CHECK (code >= 1000000 AND code <= 9999999),
    name VARCHAR(80) NOT NULL
);