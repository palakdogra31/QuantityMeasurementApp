package com.apps.quantitymeasurement;

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

    public Quantity<U> add(Quantity<U> other) {

        double thisBase = unit.convertToBaseUnit(value);

        double otherBase =
                other.unit.convertToBaseUnit(other.value);

        double sumBase = thisBase + otherBase;

        double result =
                unit.convertFromBaseUnit(sumBase);

        return new Quantity<>(result, unit);
    }
// explicit target unit
    public Quantity<U> add(Quantity<U> other,
                           U targetUnit) {

        double thisBase = unit.convertToBaseUnit(value);

        double otherBase =
                other.unit.convertToBaseUnit(other.value);

        double sumBase = thisBase + otherBase;

        double result =
                targetUnit.convertFromBaseUnit(sumBase);

        return new Quantity<>(result, targetUnit);
    }

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
                other.unit.convertToBaseUnit(other.value);

        return Math.abs(thisBase - otherBase) < 0.01;
    }

    @Override
    public int hashCode() {

        double baseValue =
                unit.convertToBaseUnit(value);

        return Double.hashCode(baseValue);
    }
    public static void main(String[] args) {

    // Length Example
    Quantity<LengthUnit> feet =
            new Quantity<>(10.0, LengthUnit.FEET);

    Quantity<LengthUnit> inches =
            new Quantity<>(120.0, LengthUnit.INCHES);

    System.out.println(
            "10 feet equals 120 inches: "
                    + feet.equals(inches)
    );



    // Weight Example
    Quantity<WeightUnit> kilogram =
            new Quantity<>(1.0, WeightUnit.KILOGRAM);

    Quantity<WeightUnit> grams =
            new Quantity<>(1000.0, WeightUnit.GRAM);

    System.out.println(
            "1 kilogram equals 1000 grams: "
                    + kilogram.equals(grams)
    );



    // =========================
    // UC11 VOLUME EXAMPLES
    // =========================

    Quantity<VolumeUnit> litre =
            new Quantity<>(1.0, VolumeUnit.LITRE);

    Quantity<VolumeUnit> millilitre =
            new Quantity<>(1000.0,
                    VolumeUnit.MILLILITRE);

    System.out.println(
            "1 litre equals 1000 mL: "
                    + litre.equals(millilitre)
    );



    double gallonToLitre =
            new Quantity<>(1.0, VolumeUnit.GALLON)
                    .convertTo(VolumeUnit.LITRE);

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
}
}