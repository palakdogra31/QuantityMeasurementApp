package com.quantitymeasurement.util;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Connection;

import static org.junit.jupiter.api.Assertions.*;

class ConnectionPoolTest {

    private ConnectionPool connectionPool;

    @BeforeEach
    void setUp() {

        connectionPool =
                ConnectionPool.getInstance();
    }

    @Test
    void shouldAcquireConnection() {

        Connection connection =
                connectionPool.acquireConnection();

        assertNotNull(connection);

        connectionPool.releaseConnection(connection);
    }

    @Test
    void shouldReleaseConnection() {

        Connection connection =
                connectionPool.acquireConnection();

        connectionPool.releaseConnection(connection);

        assertEquals(
                connectionPool.getTotalConnections(),
                connectionPool.getAvailableConnectionCount());
    }

    @Test
    void shouldReturnCorrectPoolStatistics() {

        assertTrue(
                connectionPool.getAvailableConnectionCount() >= 0);

        assertTrue(
                connectionPool.getTotalConnections() > 0);
    }
}