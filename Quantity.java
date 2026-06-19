package com.apps.quantitymeasurement;

import java.util.function.DoubleBinaryOperator;

public class Quantity<U extends IMeasurable> {

    private final double value;
    private final U unit;

    public Quantity(double value, U unit) {
        this.value = value;
        this.unit = unit;
    }

    public double getValue() {
        return value;
    }

    public U getUnit() {
        return unit;
    }

    public double convertTo(U targetUnit) {

        if (unit.getClass() != targetUnit.getClass()) {
            throw new IllegalArgumentException("Incompatible unit types");
        }

        double baseValue = unit.convertToBaseUnit(value);

        return targetUnit.convertFromBaseUnit(baseValue);
    }

    // =========================
    // UC13 ADD
    // =========================

    public Quantity<U> add(Quantity<U> other) {
        return add(other, unit);
    }

    public Quantity<U> add(
            Quantity<U> other,
            U targetUnit) {

        validateArithmeticOperands(
                other,
                targetUnit,
                true);

        double resultBase =
                performArithmetic(
                        other,
                        ArithmeticOperation.ADD);

        double result =
                targetUnit.convertFromBaseUnit(
                        resultBase);

       return new Quantity<>(
        roundToTwoDecimals(result),
        targetUnit);
    }

    // =========================
    // UC13 SUBTRACT
    // =========================

    public Quantity<U> subtract(
            Quantity<U> other) {

        return subtract(other, unit);
    }

    public Quantity<U> subtract(
            Quantity<U> other,
            U targetUnit) {

        validateArithmeticOperands(
                other,
                targetUnit,
                true);

        double resultBase =
                performArithmetic(
                        other,
                        ArithmeticOperation.SUBTRACT);

        double result =
                targetUnit.convertFromBaseUnit(
                        resultBase);

        return new Quantity<>(
        roundToTwoDecimals(result),
        targetUnit);
    }

    // =========================
    // UC13 DIVIDE
    // =========================

    public double divide(
            Quantity<U> other) {

        validateArithmeticOperands(
                other,
                null,
                false);

        return performArithmetic(
                other,
                ArithmeticOperation.DIVIDE);
    }

    // =========================
    // CENTRALIZED VALIDATION
    // =========================

    private void validateArithmeticOperands(
            Quantity<U> other,
            U targetUnit,
            boolean targetUnitRequired) {

        if (other == null) {
            throw new IllegalArgumentException(
                    "Quantity cannot be null");
        }

        if (unit.getClass() != other.unit.getClass()) {
            throw new IllegalArgumentException(
                    "Incompatible unit types");
        }

        if (!Double.isFinite(value)
                || !Double.isFinite(other.value)) {

            throw new IllegalArgumentException(
                    "Values must be finite");
        }

        if (targetUnitRequired &&
                targetUnit == null) {

            throw new IllegalArgumentException(
                    "Target unit cannot be null");
        }
    }

    // =========================
    // CENTRALIZED ARITHMETIC
    // =========================

    private double performArithmetic(
            Quantity<U> other,
            ArithmeticOperation operation) {

        double thisBase =
                unit.convertToBaseUnit(value);

        double otherBase =
                other.unit.convertToBaseUnit(
                        other.value);

        return operation.compute(
                thisBase,
                otherBase);
    }

    // =========================
    // EQUALS
    // =========================

    @Override
    public boolean equals(Object obj) {

        if (this == obj) {
            return true;
        }

        if (!(obj instanceof Quantity<?> other)) {
            return false;
        }

        if (unit.getClass() != other.unit.getClass()) {
            return false;
        }

        double thisBase =
                unit.convertToBaseUnit(value);

        double otherBase =
                other.unit.convertToBaseUnit(
                        other.value);

        return Math.abs(
                thisBase - otherBase) < 0.01;
    }

    // =========================
    // HASHCODE
    // =========================

    @Override
    public int hashCode() {

        double baseValue =
                unit.convertToBaseUnit(value);

        return Double.hashCode(baseValue);
    }
    private double roundToTwoDecimals(double value) {
    return Math.round(value * 100.0) / 100.0;
}

    // =========================
    // UC13 ENUM
    // =========================

    private enum ArithmeticOperation {

        ADD((a, b) -> a + b),

        SUBTRACT((a, b) -> a - b),

        DIVIDE((a, b) -> {
            if (b == 0.0) {
                throw new ArithmeticException(
                        "Cannot divide by zero");
            }
            return a / b;
        });

        private final DoubleBinaryOperator operation;

        ArithmeticOperation(
                DoubleBinaryOperator operation) {

            this.operation = operation;
        }

        public double compute(
                double a,
                double b) {

            return operation.applyAsDouble(a, b);
        }
    }

    // =========================
    // MAIN METHOD
    // =========================

    public static void main(String[] args) {

        // Length Example
        Quantity<LengthUnit> feet =
                new Quantity<>(10.0,
                        LengthUnit.FEET);

        Quantity<LengthUnit> inches =
                new Quantity<>(120.0,
                        LengthUnit.INCHES);

        System.out.println(
                "10 feet equals 120 inches: "
                        + feet.equals(inches)
        );

        // Weight Example
        Quantity<WeightUnit> kilogram =
                new Quantity<>(1.0,
                        WeightUnit.KILOGRAM);

        Quantity<WeightUnit> grams =
                new Quantity<>(1000.0,
                        WeightUnit.GRAM);

        System.out.println(
                "1 kilogram equals 1000 grams: "
                        + kilogram.equals(grams)
        );

        // Volume Example
        Quantity<VolumeUnit> litre =
                new Quantity<>(1.0,
                        VolumeUnit.LITRE);

        Quantity<VolumeUnit> millilitre =
                new Quantity<>(1000.0,
                        VolumeUnit.MILLILITRE);

        System.out.println(
                "1 litre equals 1000 mL: "
                        + litre.equals(millilitre)
        );

        double gallonToLitre =
                new Quantity<>(1.0,
                        VolumeUnit.GALLON)
                        .convertTo(
                                VolumeUnit.LITRE);

        System.out.println(
                "1 gallon in litre: "
                        + gallonToLitre
        );

        Quantity<VolumeUnit> totalVolume =
                litre.add(millilitre);

        System.out.println(
                "Total volume: "
                        + totalVolume.getValue()
                        + " "
                        + totalVolume.getUnit()
        );

        // UC12 / UC13 SUBTRACT

        Quantity<LengthUnit> difference =
                feet.subtract(
                        new Quantity<>(
                                24.0,
                                LengthUnit.INCHES));

        System.out.println(
                "Difference: "
                        + difference.getValue()
                        + " "
                        + difference.getUnit()
        );

        // UC12 / UC13 DIVIDE

        double ratio =
                feet.divide(
                        new Quantity<>(
                                5.0,
                                LengthUnit.FEET));

        System.out.println(
                "Ratio: " + ratio
        );
    }
}