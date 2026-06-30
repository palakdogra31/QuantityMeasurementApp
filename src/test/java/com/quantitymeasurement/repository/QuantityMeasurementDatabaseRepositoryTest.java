package com.quantitymeasurement.repository;

import com.quantitymeasurement.model.QuantityMeasurementEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class QuantityMeasurementDatabaseRepositoryTest {
    private QuantityMeasurementDatabaseRepository repository;
    @BeforeEach
    void setUp() {

        repository =
                QuantityMeasurementDatabaseRepository
                        .getInstance();

        repository.deleteAll();
    }

    @Test
    void shouldSaveMeasurementSuccessfully() {

        QuantityMeasurementEntity entity =
                new QuantityMeasurementEntity();

        entity.setThisValue(10);

        entity.setThisUnit("FEET");

        entity.setThisMeasurementType("LENGTH");

        entity.setOperation("SAVE");

        entity.setResultValue(10.0);

        entity.setResultUnit("FEET");

        entity.setResultMeasurementType("LENGTH");

        entity.setResultString("10 FEET");

        entity.setError(false);

        repository.save(entity);

        assertEquals(
                1,
                repository.getTotalCount());
    }
    @Test
    void shouldReturnAllMeasurements() {

        QuantityMeasurementEntity entity1 =
                new QuantityMeasurementEntity();

        entity1.setThisValue(10);
        entity1.setThisUnit("FEET");
        entity1.setThisMeasurementType("LENGTH");
        entity1.setOperation("SAVE");
        entity1.setResultValue(10.0);
        entity1.setResultUnit("FEET");
        entity1.setResultMeasurementType("LENGTH");
        entity1.setResultString("10 FEET");
        entity1.setError(false);

        QuantityMeasurementEntity entity2 =
                new QuantityMeasurementEntity();

        entity2.setThisValue(20);
        entity2.setThisUnit("INCH");
        entity2.setThisMeasurementType("LENGTH");
        entity2.setOperation("SAVE");
        entity2.setResultValue(20.0);
        entity2.setResultUnit("INCH");
        entity2.setResultMeasurementType("LENGTH");
        entity2.setResultString("20 INCH");
        entity2.setError(false);

        repository.save(entity1);
        repository.save(entity2);

        List<QuantityMeasurementEntity> result =
                repository.getAllMeasurements();

        assertEquals(2, result.size());
    }
    @Test
    void shouldDeleteAllMeasurements() {

        QuantityMeasurementEntity entity =
                new QuantityMeasurementEntity();

        entity.setThisValue(15);
        entity.setThisUnit("FEET");
        entity.setThisMeasurementType("LENGTH");
        entity.setOperation("SAVE");
        entity.setResultValue(15.0);
        entity.setResultUnit("FEET");
        entity.setResultMeasurementType("LENGTH");
        entity.setResultString("15 FEET");
        entity.setError(false);

        repository.save(entity);

        repository.deleteAll();

        assertEquals(
                0,
                repository.getTotalCount());
    }
    @Test
    void shouldReturnTotalCount() {

        QuantityMeasurementEntity entity =
                new QuantityMeasurementEntity();

        entity.setThisValue(30);
        entity.setThisUnit("KG");
        entity.setThisMeasurementType("WEIGHT");
        entity.setOperation("SAVE");
        entity.setResultValue(30.0);
        entity.setResultUnit("KG");
        entity.setResultMeasurementType("WEIGHT");
        entity.setResultString("30 KG");
        entity.setError(false);

        repository.save(entity);

        assertEquals(
                1,
                repository.getTotalCount());
    }
    @Test
    void shouldGetMeasurementsByOperation() {

        QuantityMeasurementEntity entity =
                new QuantityMeasurementEntity();

        entity.setThisValue(10);
        entity.setThisUnit("FEET");
        entity.setThisMeasurementType("LENGTH");
        entity.setOperation("SAVE");
        entity.setResultValue(10.0);
        entity.setResultUnit("FEET");
        entity.setResultMeasurementType("LENGTH");
        entity.setResultString("10 FEET");
        entity.setError(false);

        repository.save(entity);

        List<QuantityMeasurementEntity> result =
                repository.getMeasurementsByOperation("SAVE");

        assertEquals(1, result.size());
    }
    @Test
    void shouldGetMeasurementsByType() {

        QuantityMeasurementEntity entity =
                new QuantityMeasurementEntity();

        entity.setThisValue(50);
        entity.setThisUnit("KG");
        entity.setThisMeasurementType("WEIGHT");
        entity.setOperation("SAVE");
        entity.setResultValue(50.0);
        entity.setResultUnit("KG");
        entity.setResultMeasurementType("WEIGHT");
        entity.setResultString("50 KG");
        entity.setError(false);

        repository.save(entity);

        List<QuantityMeasurementEntity> result =
                repository.getMeasurementsByType("WEIGHT");

        assertEquals(1, result.size());
    }
    @Test
    void shouldReturnPoolStatistics() {

        String stats =
                repository.getPoolStatistics();

        assertNotNull(stats);

        assertFalse(stats.isEmpty());
    }

}