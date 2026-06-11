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
    public static <U extends IMeasurable>
Quantity<U> demonstrateSubtraction(
        Quantity<U> q1,
        Quantity<U> q2) {

    return q1.subtract(q2);
}
public static <U extends IMeasurable>
Quantity<U> demonstrateSubtraction(
        Quantity<U> q1,
        Quantity<U> q2,
        U targetUnit) {

    return q1.subtract(
            q2,
            targetUnit
    );
}
public static <U extends IMeasurable>
double demonstrateDivision(
        Quantity<U> q1,
        Quantity<U> q2) {

    return q1.divide(q2);
}

   public static void main(String[] args) {

    // ==========================
    // WEIGHT OPERATIONS
    // ==========================

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
            "Are weights equal? "
                    + areEqual
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

    // ==========================
    // VOLUME OPERATIONS
    // ==========================

    Quantity<VolumeUnit> volume1 =
            new Quantity<>(1.0,
                    VolumeUnit.LITRE);

    Quantity<VolumeUnit> volume2 =
            new Quantity<>(1000.0,
                    VolumeUnit.MILLILITRE);

    System.out.println(
            "Are volumes equal? "
                    + demonstrateEquality(
                    volume1,
                    volume2
            )
    );

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

    Quantity<VolumeUnit> sumVolume =
            demonstrateAddition(
                    volume1,
                    volume2
            );

    System.out.println(
            "Sum Volume: "
                    + sumVolume.getValue()
                    + " "
                    + sumVolume.getUnit()
    );

    // ==========================
    // UC12 SUBTRACTION
    // ==========================

    Quantity<LengthUnit> tenFeet =
            new Quantity<>(10.0,
                    LengthUnit.FEET);

    Quantity<LengthUnit> sixInches =
            new Quantity<>(6.0,
                    LengthUnit.INCHES);

    Quantity<LengthUnit> difference =
            demonstrateSubtraction(
                    tenFeet,
                    sixInches
            );

    System.out.println(
            "Difference: "
                    + difference.getValue()
                    + " "
                    + difference.getUnit()
    );

    Quantity<LengthUnit> differenceInInches =
            demonstrateSubtraction(
                    tenFeet,
                    sixInches,
                    LengthUnit.INCHES
            );

    System.out.println(
            "Difference In Inches: "
                    + differenceInInches.getValue()
                    + " "
                    + differenceInInches.getUnit()
    );

    // ==========================
    // UC12 DIVISION
    // ==========================

    Quantity<LengthUnit> twoFeet =
            new Quantity<>(2.0,
                    LengthUnit.FEET);

    double divisionResult =
            demonstrateDivision(
                    tenFeet,
                    twoFeet
            );

    System.out.println(
            "Division Result: "
                    + divisionResult
    );
}
}