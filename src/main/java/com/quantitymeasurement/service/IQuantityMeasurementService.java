package com.quantitymeasurement.service;

import com.quantitymeasurement.interfaces.IMeasurable;
import com.quantitymeasurement.model.QuantityDTO;
import com.quantitymeasurement.model.QuantityModel;

public interface IQuantityMeasurementService<T extends IMeasurable> {

    QuantityModel<T> createQuantity(QuantityDTO<T> dto);

    boolean compare(QuantityDTO<T> first,
                    QuantityDTO<T> second);

    double convert(QuantityDTO<T> quantity,
                   T targetUnit);

    QuantityModel<T> add(QuantityDTO<T> first,
                         QuantityDTO<T> second);

    QuantityModel<T> add(QuantityDTO<T> first,
                         QuantityDTO<T> second,
                         T targetUnit);

    QuantityModel<T> subtract(QuantityDTO<T> first,
                              QuantityDTO<T> second);

    QuantityModel<T> subtract(QuantityDTO<T> first,
                              QuantityDTO<T> second,
                              T targetUnit);

    double divide(QuantityDTO<T> first,
                  QuantityDTO<T> second);

    void save(QuantityDTO<T> dto);
}