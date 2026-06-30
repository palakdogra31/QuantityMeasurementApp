CREATE TABLE IF NOT EXISTS quantity_measurement_entity (

    id BIGINT AUTO_INCREMENT PRIMARY KEY,

   measurement_type VARCHAR(50),

    operation VARCHAR(50),

    operand1 DOUBLE,

    operand2 DOUBLE,

    unit1 VARCHAR(50),

    unit2 VARCHAR(50),

    result DOUBLE,

    result_unit VARCHAR(50),

    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP

    );