CREATE TABLE tb_holiday_territory (
    holiday_id INT NOT NULL,
    territory_id INT NOT NULL,
    createdAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updatedAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (holiday_id, territory_id),
    CONSTRAINT fk_holiday
        FOREIGN KEY (holiday_id) 
        REFERENCES tb_holiday (id),
    CONSTRAINT fk_territory
        FOREIGN KEY (territory_id) 
        REFERENCES tb_territory (id)
);