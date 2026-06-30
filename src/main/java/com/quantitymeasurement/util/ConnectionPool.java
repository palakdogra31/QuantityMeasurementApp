package com.quantitymeasurement.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.Queue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConnectionPool {
    private static final Logger LOGGER =
            LoggerFactory.getLogger(
                    ConnectionPool.class);
    private static ConnectionPool instance;

    private final Queue<Connection> availableConnections;

    private final int maxPoolSize;

    private final long timeout;

    private ConnectionPool() {

        availableConnections = new LinkedList<>();

        maxPoolSize = ApplicationConfig.getPoolSize();

        timeout = ApplicationConfig.getPoolTimeout();

        initializePool();
    }

    public static synchronized ConnectionPool getInstance() {

        if (instance == null) {
            instance = new ConnectionPool();
        }

        return instance;
    }

    private void initializePool() {
        LOGGER.info("Initializing connection pool");
        try {

            for (int i = 0; i < maxPoolSize; i++) {

                Connection connection =
                        DriverManager.getConnection(
                                ApplicationConfig.getDbUrl(),
                                ApplicationConfig.getUsername(),
                                ApplicationConfig.getPassword());

                availableConnections.offer(connection);
            }

        } catch (SQLException e) {

            throw new RuntimeException(
                    "Unable to initialize connection pool.",
                    e);
        }
    }

    public synchronized Connection acquireConnection() {
        LOGGER.info("Connection acquired");
        long startTime = System.currentTimeMillis();

        while (availableConnections.isEmpty()) {

            long elapsed =
                    System.currentTimeMillis() - startTime;

            if (elapsed >= timeout) {

                throw new RuntimeException(
                        "Timeout while waiting for database connection.");
            }

            try {

                wait(timeout - elapsed);

            } catch (InterruptedException e) {

                Thread.currentThread().interrupt();

                throw new RuntimeException(
                        "Interrupted while waiting for connection.",
                        e);
            }
        }

        return availableConnections.poll();
    }

    public synchronized void releaseConnection(
            Connection connection) {
        LOGGER.info("Connection released");
        if (connection != null) {

            availableConnections.offer(connection);

            notifyAll();
        }
    }

    public synchronized int getAvailableConnectionCount() {

        return availableConnections.size();
    }

    public int getTotalConnections() {

        return maxPoolSize;
    }

    public synchronized void closePool() {
        LOGGER.info("Connection pool closed");
        while (!availableConnections.isEmpty()) {

            try {

                Connection connection =
                        availableConnections.poll();

                if (connection != null &&
                        !connection.isClosed()) {

                    connection.close();
                }

            } catch (SQLException e) {

                throw new RuntimeException(
                        "Failed to close connection.",
                        e);
            }
        }
    }
}