CREATE TABLE tb_holiday_optinal (
    id SERIAL PRIMARY KEY,
    description VARCHAR(100) NOT NULL,
    createdAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updatedAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    holiday_id INT,
    CONSTRAINT fk_holiday
        FOREIGN KEY (holiday_id) 
        REFERENCES tb_holiday (id)
);

CREATE INDEX idx_description ON tb_holiday_optinal (description);