package com.quantitymeasurement.service;

import com.quantitymeasurement.interfaces.IMeasurable;
import com.quantitymeasurement.model.Quantity;
import com.quantitymeasurement.model.QuantityDTO;
import com.quantitymeasurement.model.QuantityMeasurementEntity;
import com.quantitymeasurement.model.QuantityModel;
import com.quantitymeasurement.repository.IQuantityMeasurementRepository;

public class QuantityMeasurementServiceImpl<T extends IMeasurable>
        implements IQuantityMeasurementService<T> {

    private final IQuantityMeasurementRepository<T> repository;

    public QuantityMeasurementServiceImpl(
            IQuantityMeasurementRepository<T> repository) {

        this.repository = repository;
    }

    @Override
    public QuantityModel<T> createQuantity(
            QuantityDTO<T> dto) {

        Quantity<T> quantity =
                new Quantity<>(
                        dto.getValue(),
                        dto.getUnit());

        return new QuantityModel<>(quantity);
    }

    @Override
    public void save(
            QuantityDTO<T> dto) {

        Quantity<T> quantity =
                new Quantity<>(
                        dto.getValue(),
                        dto.getUnit());

        QuantityMeasurementEntity<T> entity =
                new QuantityMeasurementEntity<>(
                        quantity);

        repository.save(entity);
    }

    @Override
    public boolean compare(
            QuantityDTO<T> first,
            QuantityDTO<T> second) {

        Quantity<T> q1 =
                new Quantity<>(
                        first.getValue(),
                        first.getUnit());

        Quantity<T> q2 =
                new Quantity<>(
                        second.getValue(),
                        second.getUnit());

        return q1.equals(q2);
    }

    @Override
    public double convert(
            QuantityDTO<T> quantity,
            T targetUnit) {

        Quantity<T> q =
                new Quantity<>(
                        quantity.getValue(),
                        quantity.getUnit());

        return q.convertTo(targetUnit);
    }

    @Override
    public QuantityModel<T> add(
            QuantityDTO<T> first,
            QuantityDTO<T> second) {

        Quantity<T> q1 =
                new Quantity<>(first.getValue(),
                        first.getUnit());

        Quantity<T> q2 =
                new Quantity<>(second.getValue(),
                        second.getUnit());

        Quantity<T> result = q1.add(q2);

        return new QuantityModel<>(result);
    }

    @Override
    public QuantityModel<T> add(
            QuantityDTO<T> first,
            QuantityDTO<T> second,
            T targetUnit) {

        Quantity<T> q1 =
                new Quantity<>(first.getValue(),
                        first.getUnit());

        Quantity<T> q2 =
                new Quantity<>(second.getValue(),
                        second.getUnit());

        Quantity<T> result =
                q1.add(q2, targetUnit);

        return new QuantityModel<>(result);
    }

    @Override
    public QuantityModel<T> subtract(
            QuantityDTO<T> first,
            QuantityDTO<T> second) {

        Quantity<T> q1 =
                new Quantity<>(first.getValue(),
                        first.getUnit());

        Quantity<T> q2 =
                new Quantity<>(second.getValue(),
                        second.getUnit());

        Quantity<T> result = q1.subtract(q2);

        return new QuantityModel<>(result);
    }

    @Override
    public QuantityModel<T> subtract(
            QuantityDTO<T> first,
            QuantityDTO<T> second,
            T targetUnit) {

        Quantity<T> q1 =
                new Quantity<>(first.getValue(),
                        first.getUnit());

        Quantity<T> q2 =
                new Quantity<>(second.getValue(),
                        second.getUnit());

        Quantity<T> result =
                q1.subtract(q2, targetUnit);

        return new QuantityModel<>(result);
    }

    @Override
    public double divide(
            QuantityDTO<T> first,
            QuantityDTO<T> second) {

        Quantity<T> q1 =
                new Quantity<>(first.getValue(),
                        first.getUnit());

        Quantity<T> q2 =
                new Quantity<>(second.getValue(),
                        second.getUnit());

        return q1.divide(q2);
    }
}