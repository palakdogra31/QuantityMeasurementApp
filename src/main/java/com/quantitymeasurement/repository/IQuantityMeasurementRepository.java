package com.quantitymeasurement.repository;

import com.quantitymeasurement.interfaces.IMeasurable;
import com.quantitymeasurement.model.QuantityMeasurementEntity;

import java.util.List;

public interface IQuantityMeasurementRepository<T extends IMeasurable> {

    void save(QuantityMeasurementEntity entity);

    List<QuantityMeasurementEntity> getAllMeasurements();

    List<QuantityMeasurementEntity> getMeasurementsByOperation(
            String operation);

    List<QuantityMeasurementEntity> getMeasurementsByType(
            String measurementType);

    int getTotalCount();

    void deleteAll();

    String getPoolStatistics();

    void releaseResources();
}