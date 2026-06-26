package com.quantitymeasurement.repository;

import com.quantitymeasurement.interfaces.IMeasurable;
import com.quantitymeasurement.model.QuantityMeasurementEntity;

import java.util.List;

public interface IQuantityMeasurementRepository<T extends IMeasurable> {

    void save(QuantityMeasurementEntity<T> entity);

    List<QuantityMeasurementEntity<T>> findAll();

    void clear();
}