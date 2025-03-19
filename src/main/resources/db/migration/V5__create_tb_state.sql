CREATE TABLE tb_states (
    code SMALLINT PRIMARY KEY CHECK (code >= 10 AND code <= 99),
    abbreviation CHAR(2)
);