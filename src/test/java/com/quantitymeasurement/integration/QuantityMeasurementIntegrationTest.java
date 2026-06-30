package com.quantitymeasurement.integration;

import com.quantitymeasurement.controller.QuantityMeasurementController;
import com.quantitymeasurement.enums.LengthUnit;
import com.quantitymeasurement.factory.QuantityMeasurementFactory;
import com.quantitymeasurement.model.QuantityDTO;
import com.quantitymeasurement.model.QuantityModel;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QuantityMeasurementIntegrationTest {

    @Test
    void shouldCreateQuantitySuccessfully() {

        QuantityMeasurementController<LengthUnit> controller =
                QuantityMeasurementFactory.createController();

        QuantityDTO<LengthUnit> dto =
                new QuantityDTO<>(
                        10,
                        LengthUnit.FEET);

        QuantityModel<LengthUnit> result =
                controller.createQuantity(dto);

        assertNotNull(result);

        assertEquals(
                10,
                result.getQuantity().getValue());
    }
}