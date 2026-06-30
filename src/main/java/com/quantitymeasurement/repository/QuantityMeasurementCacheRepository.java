package com.quantitymeasurement.repository;

import com.quantitymeasurement.exception.QuantityMeasurementException;
import com.quantitymeasurement.interfaces.IMeasurable;
import com.quantitymeasurement.model.QuantityMeasurementEntity;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class QuantityMeasurementCacheRepository<T extends IMeasurable>
        implements IQuantityMeasurementRepository<T> {
    private static final Logger LOGGER =
            LoggerFactory.getLogger(
                    QuantityMeasurementCacheRepository.class);
    private static final String FILE_NAME = "quantity-cache.ser";

    private static QuantityMeasurementCacheRepository<?> instance;

    private List<QuantityMeasurementEntity> cache;

    private QuantityMeasurementCacheRepository() {
        cache = new ArrayList<>();
        loadFromDisk();
    }

    @SuppressWarnings("unchecked")
    public static <T extends IMeasurable>
    QuantityMeasurementCacheRepository<T> getInstance() {

        if (instance == null) {
            instance = new QuantityMeasurementCacheRepository<>();
        }

        return (QuantityMeasurementCacheRepository<T>) instance;
    }

    @Override
    public void save(QuantityMeasurementEntity entity) {
        LOGGER.info("Saving entity to cache");
        cache.add(entity);
        saveToDisk();
        LOGGER.info("Entity saved successfully");
    }

    @Override
    public List<QuantityMeasurementEntity> getAllMeasurements() {
        return new ArrayList<>(cache);
    }

    @Override
    public void deleteAll() {

        cache.clear();
        saveToDisk();
    }

    @Override
    public int getTotalCount() {
        return cache.size();
    }
    @Override
    public List<QuantityMeasurementEntity>
    getMeasurementsByOperation(String operation) {

        return new ArrayList<>();
    }

    @Override
    public List<QuantityMeasurementEntity>
    getMeasurementsByType(String measurementType) {

        return new ArrayList<>();
    }

    private void saveToDisk() {
        LOGGER.info("Writing cache to disk");

        try (ObjectOutputStream outputStream =
                     new ObjectOutputStream(
                             new FileOutputStream(FILE_NAME))) {

            outputStream.writeObject(cache);

        } catch (IOException e) {

            throw new QuantityMeasurementException(
                    "Unable to save cache.",
                    e);

        }

    }

    @SuppressWarnings("unchecked")
    private void loadFromDisk() {

        File file = new File(FILE_NAME);
        LOGGER.info("Loading cache from disk");
        if (!file.exists()) {
            return;
        }

        try (ObjectInputStream inputStream =
                     new ObjectInputStream(
                             new FileInputStream(file))) {

            cache =
                    (List<QuantityMeasurementEntity>)
                            inputStream.readObject();

        } catch (IOException | ClassNotFoundException e) {

            throw new QuantityMeasurementException(
                    "Unable to load cache.",
                    e);
        }
    }



    @Override
    public String getPoolStatistics() {

        return "Cache Repository - No Connection Pool";
    }


    @Override
    public void releaseResources() {

        LOGGER.info("Cache repository resources released.");
    }
}