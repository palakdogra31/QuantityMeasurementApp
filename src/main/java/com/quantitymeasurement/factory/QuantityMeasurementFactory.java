package com.quantitymeasurement.factory;

import com.quantitymeasurement.controller.QuantityMeasurementController;
import com.quantitymeasurement.interfaces.IMeasurable;
import com.quantitymeasurement.repository.IQuantityMeasurementRepository;
import com.quantitymeasurement.repository.QuantityMeasurementCacheRepository;
import com.quantitymeasurement.repository.QuantityMeasurementDatabaseRepository;
import com.quantitymeasurement.service.QuantityMeasurementServiceImpl;
import com.quantitymeasurement.util.ApplicationConfig;

public class QuantityMeasurementFactory {

    private QuantityMeasurementFactory() {
    }

    @SuppressWarnings("unchecked")
    public static <T extends IMeasurable>
    IQuantityMeasurementRepository<T> createRepository() {

        String repositoryType =
                ApplicationConfig.getRepositoryType();

        if ("database".equalsIgnoreCase(
                repositoryType)) {

            return (IQuantityMeasurementRepository<T>)
                    QuantityMeasurementDatabaseRepository
                            .getInstance();
        }

        return (IQuantityMeasurementRepository<T>)
                QuantityMeasurementCacheRepository
                        .getInstance();
    }

    public static <T extends IMeasurable>
    QuantityMeasurementController<T> createController() {

        return new QuantityMeasurementController<>(

                new QuantityMeasurementServiceImpl<>(

                        createRepository()
                )
        );
    }
}