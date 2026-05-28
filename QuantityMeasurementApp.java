package com.apps.quantitymeasurement;

public class QuantityMeasurementApp {

    public static <U extends IMeasurable>
    boolean demonstrateEquality(
            Quantity<U> quantity1,
            Quantity<U> quantity2) {

        return quantity1.equals(quantity2);
    }

    public static <U extends IMeasurable>
    Quantity<U> demonstrateConversion(
            Quantity<U> quantity,
            U targetUnit) {

        double convertedValue =
                quantity.convertTo(targetUnit);

        return new Quantity<>(
                convertedValue,
                targetUnit
        );
    }

    public static <U extends IMeasurable>
    Quantity<U> demonstrateAddition(
            Quantity<U> quantity1,
            Quantity<U> quantity2) {

        return quantity1.add(quantity2);
    }

    public static <U extends IMeasurable>
    Quantity<U> demonstrateAddition(
            Quantity<U> quantity1,
            Quantity<U> quantity2,
            U targetUnit) {

        return quantity1.add(quantity2, targetUnit);
    }

    public static void main(String[] args) {

        Quantity<WeightUnit> weightInGrams =
                new Quantity<>(1000.0,
                        WeightUnit.GRAM);

        Quantity<WeightUnit> weightInKilograms =
                new Quantity<>(1.0,
                        WeightUnit.KILOGRAM);

        boolean areEqual =
                demonstrateEquality(
                        weightInGrams,
                        weightInKilograms
                );

        System.out.println(
                "Are weights equal? " + areEqual
        );

        Quantity<WeightUnit> convertedWeight =
                demonstrateConversion(
                        weightInGrams,
                        WeightUnit.KILOGRAM
                );

        System.out.println(
                "Converted Weight: "
                        + convertedWeight.getValue()
                        + " "
                        + convertedWeight.getUnit()
        );

        Quantity<WeightUnit> weightInPounds =
                new Quantity<>(2.20462,
                        WeightUnit.POUND);

        Quantity<WeightUnit> sumWeight =
                demonstrateAddition(
                        weightInKilograms,
                        weightInPounds
                );

        System.out.println(
                "Sum Weight: "
                        + sumWeight.getValue()
                        + " "
                        + sumWeight.getUnit()
        );

        Quantity<WeightUnit> sumWeightInGrams =
                demonstrateAddition(
                        weightInKilograms,
                        weightInPounds,
                        WeightUnit.GRAM
                );

        System.out.println(
                "Sum Weight In Grams: "
                        + sumWeightInGrams.getValue()
                        + " "
                        + sumWeightInGrams.getUnit()
        );
        // Volume Equality
Quantity<VolumeUnit> volume1 =
        new Quantity<>(1.0, VolumeUnit.LITRE);

Quantity<VolumeUnit> volume2 =
        new Quantity<>(1000.0, VolumeUnit.MILLILITRE);

System.out.println(
        "Are volumes equal? "
                + demonstrateEquality(volume1, volume2)
);

// Volume Conversion
Quantity<VolumeUnit> convertedVolume =
        demonstrateConversion(
                volume1,
                VolumeUnit.MILLILITRE
        );

System.out.println(
        "Converted Volume: "
                + convertedVolume.getValue()
                + " "
                + convertedVolume.getUnit()
);

// Volume Addition
Quantity<VolumeUnit> sumVolume =
        demonstrateAddition(volume1, volume2);

System.out.println(
        "Sum Volume: "
                + sumVolume.getValue()
                + " "
                + sumVolume.getUnit()
);
    }
}