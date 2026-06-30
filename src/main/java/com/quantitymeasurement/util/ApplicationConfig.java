package com.quantitymeasurement.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ApplicationConfig {

    private static final Properties properties =
            new Properties();

    static {

        try (InputStream inputStream =
                     ApplicationConfig.class
                             .getClassLoader()
                             .getResourceAsStream(
                                     "application.properties")) {

            if (inputStream == null) {
                throw new RuntimeException(
                        "application.properties not found");
            }

            properties.load(inputStream);

        } catch (IOException e) {

            throw new RuntimeException(
                    "Failed to load application.properties",
                    e);
        }
    }

    public static String getDbUrl() {
        return properties.getProperty("db.url");
    }

    public static String getUsername() {
        return properties.getProperty("db.username");
    }

    public static String getPassword() {
        return properties.getProperty("db.password");
    }

    public static int getPoolSize() {
        return Integer.parseInt(
                properties.getProperty("db.pool.size"));
    }

    public static long getPoolTimeout() {
        return Long.parseLong(
                properties.getProperty("db.pool.timeout"));
    }
    public static String getRepositoryType() {

        return properties.getProperty(
                "repository.type",
                "cache");
    }
}