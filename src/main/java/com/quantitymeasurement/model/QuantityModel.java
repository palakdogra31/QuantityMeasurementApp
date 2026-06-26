package com.quantitymeasurement.model;

import com.quantitymeasurement.interfaces.IMeasurable;

public class QuantityModel<T extends IMeasurable> {

    private Quantity<T> quantity;

    public QuantityModel() {
    }

    public QuantityModel(Quantity<T> quantity) {
        this.quantity = quantity;
    }

    public Quantity<T> getQuantity() {
        return quantity;
    }

    public void setQuantity(Quantity<T> quantity) {
        this.quantity = quantity;
    }
}