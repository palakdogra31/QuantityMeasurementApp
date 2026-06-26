package com.quantitymeasurement.controller;

import com.quantitymeasurement.interfaces.IMeasurable;
import com.quantitymeasurement.model.QuantityDTO;
import com.quantitymeasurement.model.QuantityModel;
import com.quantitymeasurement.service.IQuantityMeasurementService;

public class QuantityMeasurementController<T extends IMeasurable> {

    private final IQuantityMeasurementService<T> service;

    public QuantityMeasurementController(
            IQuantityMeasurementService<T> service) {

        this.service = service;
    }

    public QuantityModel<T> createQuantity(
            QuantityDTO<T> dto) {

        return service.createQuantity(dto);
    }

    public void save(
            QuantityDTO<T> dto) {

        service.save(dto);
    }

    public boolean compare(
            QuantityDTO<T> first,
            QuantityDTO<T> second) {

        return service.compare(first, second);
    }

    public double convert(
            QuantityDTO<T> quantity,
            T targetUnit) {

        return service.convert(quantity, targetUnit);
    }

    public QuantityModel<T> add(
            QuantityDTO<T> first,
            QuantityDTO<T> second) {

        return service.add(first, second);
    }

    public QuantityModel<T> add(
            QuantityDTO<T> first,
            QuantityDTO<T> second,
            T targetUnit) {

        return service.add(first, second, targetUnit);
    }

    public QuantityModel<T> subtract(
            QuantityDTO<T> first,
            QuantityDTO<T> second) {

        return service.subtract(first, second);
    }

    public QuantityModel<T> subtract(
            QuantityDTO<T> first,
            QuantityDTO<T> second,
            T targetUnit) {

        return service.subtract(first, second, targetUnit);
    }

    public double divide(
            QuantityDTO<T> first,
            QuantityDTO<T> second) {

        return service.divide(first, second);
    }
}