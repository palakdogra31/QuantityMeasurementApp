package com.quantitymeasurement.repository;

import com.quantitymeasurement.exception.QuantityMeasurementException;
import com.quantitymeasurement.interfaces.IMeasurable;
import com.quantitymeasurement.model.QuantityMeasurementEntity;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class QuantityMeasurementCacheRepository<T extends IMeasurable>
        implements IQuantityMeasurementRepository<T> {

    private static final String FILE_NAME = "quantity-cache.ser";

    private static QuantityMeasurementCacheRepository<?> instance;

    private List<QuantityMeasurementEntity<T>> cache;

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
    public void save(QuantityMeasurementEntity<T> entity) {

        cache.add(entity);
        saveToDisk();
    }

    @Override
    public List<QuantityMeasurementEntity<T>> findAll() {

        return new ArrayList<>(cache);
    }

    @Override
    public void clear() {

        cache.clear();
        saveToDisk();
    }

    private void saveToDisk() {

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

        if (!file.exists()) {
            return;
        }

        try (ObjectInputStream inputStream =
                     new ObjectInputStream(
                             new FileInputStream(file))) {

            cache =
                    (List<QuantityMeasurementEntity<T>>)
                            inputStream.readObject();

        } catch (IOException | ClassNotFoundException e) {

            throw new QuantityMeasurementException(
                    "Unable to load cache.",
                    e);
        }
    }
}