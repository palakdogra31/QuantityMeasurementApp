package com.quantitymeasurement.model;

import com.quantitymeasurement.interfaces.IMeasurable;

import java.io.Serializable;

public class QuantityMeasurementEntity<T extends IMeasurable>
        implements Serializable {

    private static final long serialVersionUID = 1L;

    private Quantity<T> quantity;

    public QuantityMeasurementEntity() {
    }

    public QuantityMeasurementEntity(
            Quantity<T> quantity) {

        this.quantity = quantity;
    }

    public Quantity<T> getQuantity() {
        return quantity;
    }

    public void setQuantity(
            Quantity<T> quantity) {

        this.quantity = quantity;
    }
}