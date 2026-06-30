package com.quantitymeasurement.service;

import com.quantitymeasurement.interfaces.IMeasurable;
import com.quantitymeasurement.model.Quantity;
import com.quantitymeasurement.model.QuantityDTO;
import com.quantitymeasurement.model.QuantityMeasurementEntity;
import com.quantitymeasurement.model.QuantityModel;
import com.quantitymeasurement.repository.IQuantityMeasurementRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class QuantityMeasurementServiceImpl<T extends IMeasurable>
        implements IQuantityMeasurementService<T> {
    private static final Logger LOGGER =
            LoggerFactory.getLogger(
                    QuantityMeasurementServiceImpl.class);

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
        LOGGER.info("Creating Quantity");

        return new QuantityModel<>(quantity);
    }

    @Override
    public void save(
            QuantityDTO<T> dto) {

        LOGGER.info(
                "Saving quantity measurement.");

        QuantityMeasurementEntity entity =
                new QuantityMeasurementEntity();

        entity.setThisValue(
                dto.getValue());

        entity.setThisUnit(
                dto.getUnit().toString());

        entity.setThisMeasurementType(
                dto.getUnit()
                        .getClass()
                        .getSimpleName());

        entity.setOperation(
                "SAVE");

        entity.setResultValue(
                dto.getValue());

        entity.setResultUnit(
                dto.getUnit().toString());

        entity.setResultMeasurementType(
                dto.getUnit()
                        .getClass()
                        .getSimpleName());

        entity.setResultString(
                dto.getValue() + " "
                        + dto.getUnit());

        entity.setError(false);

        repository.save(entity);

        LOGGER.info(
                "Quantity measurement saved successfully.");
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
        LOGGER.info("Comparing quantities");

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
        LOGGER.info("Converting quantity");
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
        LOGGER.info("Performing addition");

        return new QuantityModel<>(result);
    }

    @Override
    public QuantityModel<T> add(
            QuantityDTO<T> first,
            QuantityDTO<T> second,
            T targetUnit) {
        LOGGER.info("Processing add request with target unit");
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
        LOGGER.info("Performing subtraction");
        return new QuantityModel<>(result);
    }

    @Override
    public QuantityModel<T> subtract(
            QuantityDTO<T> first,
            QuantityDTO<T> second,
            T targetUnit) {
        LOGGER.info("Processing subtraction request with target unit");
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
        LOGGER.info("Performing division");
        return q1.divide(q2);
    }
}