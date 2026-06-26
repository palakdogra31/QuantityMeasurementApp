package com.quantitymeasurement.factory;

import com.quantitymeasurement.controller.QuantityMeasurementController;
import com.quantitymeasurement.interfaces.IMeasurable;
import com.quantitymeasurement.repository.QuantityMeasurementCacheRepository;
import com.quantitymeasurement.service.QuantityMeasurementServiceImpl;

public class QuantityMeasurementFactory {

    private QuantityMeasurementFactory() {
    }

    public static <T extends IMeasurable>
    QuantityMeasurementController<T> createController() {

        return new QuantityMeasurementController<>(
                new QuantityMeasurementServiceImpl<>(
                        QuantityMeasurementCacheRepository.getInstance()
                )
        );
    }
}