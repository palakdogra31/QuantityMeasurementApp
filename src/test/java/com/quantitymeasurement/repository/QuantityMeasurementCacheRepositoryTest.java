package com.quantitymeasurement.repository;

import com.quantitymeasurement.model.QuantityMeasurementEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class QuantityMeasurementCacheRepositoryTest {

    private QuantityMeasurementCacheRepository<?> repository;

    @BeforeEach
    void setUp() {

        repository =
                QuantityMeasurementCacheRepository
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

        QuantityMeasurementEntity entity =
                new QuantityMeasurementEntity();

        entity.setThisValue(20);
        entity.setThisUnit("KG");
        entity.setThisMeasurementType("WEIGHT");
        entity.setOperation("SAVE");
        entity.setResultValue(20.0);
        entity.setResultUnit("KG");
        entity.setResultMeasurementType("WEIGHT");
        entity.setResultString("20 KG");
        entity.setError(false);

        repository.save(entity);

        List<QuantityMeasurementEntity> result =
                repository.getAllMeasurements();

        assertEquals(1, result.size());
    }

    @Test
    void shouldDeleteAllMeasurements() {

        QuantityMeasurementEntity entity =
                new QuantityMeasurementEntity();

        entity.setThisValue(30);
        entity.setThisUnit("LITER");
        entity.setThisMeasurementType("VOLUME");
        entity.setOperation("SAVE");
        entity.setResultValue(30.0);
        entity.setResultUnit("LITER");
        entity.setResultMeasurementType("VOLUME");
        entity.setResultString("30 LITER");
        entity.setError(false);

        repository.save(entity);

        repository.deleteAll();

        assertEquals(
                0,
                repository.getTotalCount());
    }

    @Test
    void shouldReturnPoolStatistics() {

        String statistics =
                repository.getPoolStatistics();

        assertNotNull(statistics);
    }
}