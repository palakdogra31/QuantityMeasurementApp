package com.quantitymeasurement.model;

import com.quantitymeasurement.interfaces.IMeasurable;

public class QuantityDTO<T extends IMeasurable> {

    private double value;
    private T unit;

    public QuantityDTO() {
    }

    public QuantityDTO(double value, T unit) {
        this.value = value;
        this.unit = unit;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public T getUnit() {
        return unit;
    }

    public void setUnit(T unit) {
        this.unit = unit;
    }
}