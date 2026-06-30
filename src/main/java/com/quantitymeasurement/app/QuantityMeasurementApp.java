//package com.quantitymeasurement.app;
//
//import com.quantitymeasurement.enums.LengthUnit;
//import com.quantitymeasurement.enums.TemperatureUnit;
//import com.quantitymeasurement.enums.VolumeUnit;
//import com.quantitymeasurement.enums.WeightUnit;
//import com.quantitymeasurement.interfaces.IMeasurable;
//import com.quantitymeasurement.model.Quantity;
//
//public class QuantityMeasurementApp {
//
//    public static <U extends IMeasurable>
//    boolean demonstrateEquality(
//            Quantity<U> quantity1,
//            Quantity<U> quantity2) {
//
//        return quantity1.equals(quantity2);
//    }
//
//    public static <U extends IMeasurable>
//    Quantity<U> demonstrateConversion(
//            Quantity<U> quantity,
//            U targetUnit) {
//
//        double convertedValue =
//                quantity.convertTo(targetUnit);
//
//        return new Quantity<>(
//                convertedValue,
//                targetUnit
//        );
//    }
//
//    public static <U extends IMeasurable>
//    Quantity<U> demonstrateAddition(
//            Quantity<U> quantity1,
//            Quantity<U> quantity2) {
//
//        return quantity1.add(quantity2);
//    }
//
//    public static <U extends IMeasurable>
//    Quantity<U> demonstrateAddition(
//            Quantity<U> quantity1,
//            Quantity<U> quantity2,
//            U targetUnit) {
//
//        return quantity1.add(quantity2, targetUnit);
//    }
//    public static <U extends IMeasurable>
//Quantity<U> demonstrateSubtraction(
//        Quantity<U> q1,
//        Quantity<U> q2) {
//
//    return q1.subtract(q2);
//}
//public static <U extends IMeasurable>
//Quantity<U> demonstrateSubtraction(
//        Quantity<U> q1,
//        Quantity<U> q2,
//        U targetUnit) {
//
//    return q1.subtract(
//            q2,
//            targetUnit
//    );
//}
//public static <U extends IMeasurable>
//double demonstrateDivision(
//        Quantity<U> q1,
//        Quantity<U> q2) {
//
//    return q1.divide(q2);
//}
//
//   public static void main(String[] args) {
//
//    // ==========================
//    // WEIGHT OPERATIONS
//    // ==========================
//
//    Quantity<WeightUnit> weightInGrams =
//            new Quantity<>(1000.0,
//                    WeightUnit.GRAM);
//
//    Quantity<WeightUnit> weightInKilograms =
//            new Quantity<>(1.0,
//                    WeightUnit.KILOGRAM);
//
//    boolean areEqual =
//            demonstrateEquality(
//                    weightInGrams,
//                    weightInKilograms
//            );
//
//    System.out.println(
//            "Are weights equal? "
//                    + areEqual
//    );
//
//    Quantity<WeightUnit> convertedWeight =
//            demonstrateConversion(
//                    weightInGrams,
//                    WeightUnit.KILOGRAM
//            );
//
//    System.out.println(
//            "Converted Weight: "
//                    + convertedWeight.getValue()
//                    + " "
//                    + convertedWeight.getUnit()
//    );
//
//    Quantity<WeightUnit> weightInPounds =
//            new Quantity<>(2.20462,
//                    WeightUnit.POUND);
//
//    Quantity<WeightUnit> sumWeight =
//            demonstrateAddition(
//                    weightInKilograms,
//                    weightInPounds
//            );
//
//    System.out.println(
//            "Sum Weight: "
//                    + sumWeight.getValue()
//                    + " "
//                    + sumWeight.getUnit()
//    );
//
//    Quantity<WeightUnit> sumWeightInGrams =
//            demonstrateAddition(
//                    weightInKilograms,
//                    weightInPounds,
//                    WeightUnit.GRAM
//            );
//
//    System.out.println(
//            "Sum Weight In Grams: "
//                    + sumWeightInGrams.getValue()
//                    + " "
//                    + sumWeightInGrams.getUnit()
//    );
//
//    // ==========================
//    // VOLUME OPERATIONS
//    // ==========================
//
//    Quantity<VolumeUnit> volume1 =
//            new Quantity<>(1.0,
//                    VolumeUnit.LITRE);
//
//    Quantity<VolumeUnit> volume2 =
//            new Quantity<>(1000.0,
//                    VolumeUnit.MILLILITRE);
//
//    System.out.println(
//            "Are volumes equal? "
//                    + demonstrateEquality(
//                    volume1,
//                    volume2
//            )
//    );
//
//    Quantity<VolumeUnit> convertedVolume =
//            demonstrateConversion(
//                    volume1,
//                    VolumeUnit.MILLILITRE
//            );
//
//    System.out.println(
//            "Converted Volume: "
//                    + convertedVolume.getValue()
//                    + " "
//                    + convertedVolume.getUnit()
//    );
//
//    Quantity<VolumeUnit> sumVolume =
//            demonstrateAddition(
//                    volume1,
//                    volume2
//            );
//
//    System.out.println(
//            "Sum Volume: "
//                    + sumVolume.getValue()
//                    + " "
//                    + sumVolume.getUnit()
//    );
//
//    // ==========================
//    // UC12 SUBTRACTION
//    // ==========================
//
//    Quantity<LengthUnit> tenFeet =
//            new Quantity<>(10.0,
//                    LengthUnit.FEET);
//
//    Quantity<LengthUnit> sixInches =
//            new Quantity<>(6.0,
//                    LengthUnit.INCHES);
//
//    Quantity<LengthUnit> difference =
//            demonstrateSubtraction(
//                    tenFeet,
//                    sixInches
//            );
//
//    System.out.println(
//            "Difference: "
//                    + difference.getValue()
//                    + " "
//                    + difference.getUnit()
//    );
//
//    Quantity<LengthUnit> differenceInInches =
//            demonstrateSubtraction(
//                    tenFeet,
//                    sixInches,
//                    LengthUnit.INCHES
//            );
//
//    System.out.println(
//            "Difference In Inches: "
//                    + differenceInInches.getValue()
//                    + " "
//                    + differenceInInches.getUnit()
//    );
//
//    // ==========================
//    // UC12 DIVISION
//    // ==========================
//
//    Quantity<LengthUnit> twoFeet =
//            new Quantity<>(2.0,
//                    LengthUnit.FEET);
//
//    double divisionResult =
//            demonstrateDivision(
//                    tenFeet,
//                    twoFeet
//            );
//
//    System.out.println(
//            "Division Result: "
//                    + divisionResult
//    );
//    Quantity<TemperatureUnit> celsius =
//        new Quantity<>(0.0,
//                TemperatureUnit.CELSIUS);
//
//Quantity<TemperatureUnit> fahrenheit =
//        new Quantity<>(32.0,
//                TemperatureUnit.FAHRENHEIT);
//
//System.out.println(
//        "Temperature Equal: "
//                + celsius.equals(
//                        fahrenheit));
//                        double temp =
//        celsius.convertTo(
//                TemperatureUnit.FAHRENHEIT);
//
//System.out.println(
//        "0 Celsius in Fahrenheit: "
//                + temp);
//                try {
//    celsius.add(fahrenheit);
//}
//catch (UnsupportedOperationException e) {
//    System.out.println(
//            e.getMessage());
//}
//
//}
//
//}

package com.quantitymeasurement.app;
import com.quantitymeasurement.util.ApplicationConfig;
import com.quantitymeasurement.controller.QuantityMeasurementController;
import com.quantitymeasurement.enums.LengthUnit;
import com.quantitymeasurement.enums.TemperatureUnit;
import com.quantitymeasurement.enums.VolumeUnit;
import com.quantitymeasurement.enums.WeightUnit;
import com.quantitymeasurement.factory.QuantityMeasurementFactory;
import com.quantitymeasurement.model.QuantityDTO;
import com.quantitymeasurement.model.QuantityModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class QuantityMeasurementApp {
    private static void closeResources() {

        QuantityMeasurementFactory
                .createRepository()
                .releaseResources();
    }
    private static final Logger LOGGER =
            LoggerFactory.getLogger(
                    QuantityMeasurementApp.class);


    public static void main(String[] args) {
        LOGGER.info("Quantity Measurement Application Started");

        // ==========================
        // CONTROLLERS
        // ==========================

        QuantityMeasurementController<WeightUnit> weightController =
                QuantityMeasurementFactory.createController();

        QuantityMeasurementController<VolumeUnit> volumeController =
                QuantityMeasurementFactory.createController();

        QuantityMeasurementController<LengthUnit> lengthController =
                QuantityMeasurementFactory.createController();

        QuantityMeasurementController<TemperatureUnit> temperatureController =
                QuantityMeasurementFactory.createController();
        LOGGER.info(
                "Repository Type : {}",
                ApplicationConfig.getRepositoryType());



        // ==========================
        // WEIGHT
        // ==========================

        QuantityDTO<WeightUnit> grams =
                new QuantityDTO<>(1000.0, WeightUnit.GRAM);

        QuantityDTO<WeightUnit> kilograms =
                new QuantityDTO<>(1.0, WeightUnit.KILOGRAM);

        System.out.println("Are weights equal? "
                + weightController.compare(grams, kilograms));

        System.out.println("Converted Weight: "
                + weightController.convert(grams, WeightUnit.KILOGRAM)
                + " KILOGRAM");

        QuantityDTO<WeightUnit> pounds =
                new QuantityDTO<>(2.20462, WeightUnit.POUND);

        QuantityModel<WeightUnit> weightSum =
                weightController.add(kilograms, pounds);

        System.out.println("Sum Weight: "
                + weightSum.getQuantity().getValue()
                + " "
                + weightSum.getQuantity().getUnit());

        QuantityModel<WeightUnit> weightSumGram =
                weightController.add(
                        kilograms,
                        pounds,
                        WeightUnit.GRAM);

        System.out.println("Sum Weight In Grams: "
                + weightSumGram.getQuantity().getValue()
                + " "
                + weightSumGram.getQuantity().getUnit());

        // ==========================
        // VOLUME
        // ==========================

        QuantityDTO<VolumeUnit> litre =
                new QuantityDTO<>(1.0, VolumeUnit.LITRE);

        QuantityDTO<VolumeUnit> ml =
                new QuantityDTO<>(1000.0, VolumeUnit.MILLILITRE);

        System.out.println("Are volumes equal? "
                + volumeController.compare(litre, ml));

        System.out.println("Converted Volume: "
                + volumeController.convert(litre,
                VolumeUnit.MILLILITRE)
                + " MILLILITRE");

        QuantityModel<VolumeUnit> volumeSum =
                volumeController.add(litre, ml);

        System.out.println("Sum Volume: "
                + volumeSum.getQuantity().getValue()
                + " "
                + volumeSum.getQuantity().getUnit());

        // ==========================
        // LENGTH
        // ==========================

        QuantityDTO<LengthUnit> tenFeet =
                new QuantityDTO<>(10.0, LengthUnit.FEET);

        QuantityDTO<LengthUnit> sixInches =
                new QuantityDTO<>(6.0, LengthUnit.INCHES);

        QuantityModel<LengthUnit> difference =
                lengthController.subtract(
                        tenFeet,
                        sixInches);

        System.out.println("Difference: "
                + difference.getQuantity().getValue()
                + " "
                + difference.getQuantity().getUnit());

        QuantityModel<LengthUnit> differenceInches =
                lengthController.subtract(
                        tenFeet,
                        sixInches,
                        LengthUnit.INCHES);

        System.out.println("Difference In Inches: "
                + differenceInches.getQuantity().getValue()
                + " "
                + differenceInches.getQuantity().getUnit());

        QuantityDTO<LengthUnit> twoFeet =
                new QuantityDTO<>(2.0, LengthUnit.FEET);

        System.out.println("Division Result: "
                + lengthController.divide(
                tenFeet,
                twoFeet));

        // ==========================
        // TEMPERATURE
        // ==========================

        QuantityDTO<TemperatureUnit> celsius =
                new QuantityDTO<>(0.0,
                        TemperatureUnit.CELSIUS);

        QuantityDTO<TemperatureUnit> fahrenheit =
                new QuantityDTO<>(32.0,
                        TemperatureUnit.FAHRENHEIT);

        System.out.println("Temperature Equal: "
                + temperatureController.compare(
                celsius,
                fahrenheit));

        System.out.println("0 Celsius in Fahrenheit: "
                + temperatureController.convert(
                celsius,
                TemperatureUnit.FAHRENHEIT));

        try {

            temperatureController.add(
                    celsius,
                    fahrenheit);

        } catch (UnsupportedOperationException e) {

            System.out.println(e.getMessage());
        }

        // ==========================
        // SAVE TO CACHE
        // ==========================

        weightController.save(kilograms);
        volumeController.save(litre);
        lengthController.save(tenFeet);
        temperatureController.save(celsius);

        System.out.println("\nData saved successfully.");
        LOGGER.info("Application Finished");
        closeResources();
    }
}