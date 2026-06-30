package com.quantitymeasurement.factory;

import com.quantitymeasurement.controller.QuantityMeasurementController;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QuantityMeasurementFactoryTest {

    @Test
    void shouldCreateController() {

        QuantityMeasurementController<?> controller =
                QuantityMeasurementFactory.createController();

        assertNotNull(controller);
    }
}