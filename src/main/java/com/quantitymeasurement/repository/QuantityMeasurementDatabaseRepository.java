package com.quantitymeasurement.repository;

import com.quantitymeasurement.exception.DatabaseException;
import com.quantitymeasurement.model.QuantityMeasurementEntity;
import com.quantitymeasurement.util.ConnectionPool;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;

public class QuantityMeasurementDatabaseRepository
        implements IQuantityMeasurementRepository {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(
                    QuantityMeasurementDatabaseRepository.class);

    private static QuantityMeasurementDatabaseRepository instance;
    private static final String INSERT_QUERY =
            "INSERT INTO quantity_measurement_entity (" +
                    "this_value, this_unit, this_measurement_type, " +
                    "that_value, that_unit, that_measurement_type, " +
                    "operation, result_value, result_unit, " +
                    "result_measurement_type, result_string, " +
                    "is_error, error_message, created_at, updated_at) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP)";

    private static final String SELECT_ALL_QUERY =
            "SELECT * FROM quantity_measurement_entity " +
                    "ORDER BY created_at DESC";


    private static final String SELECT_BY_OPERATION =
            "SELECT * FROM quantity_measurement_entity " +
                    "WHERE operation = ? " +
                    "ORDER BY created_at DESC";


    private static final String SELECT_BY_MEASUREMENT_TYPE =
            "SELECT * FROM quantity_measurement_entity " +
                    "WHERE this_measurement_type = ? " +
                    "ORDER BY created_at DESC";


    private static final String DELETE_ALL_QUERY =
            "DELETE FROM quantity_measurement_entity";

    private static final String COUNT_QUERY =
            "SELECT COUNT(*) FROM quantity_measurement_entity";
    private ConnectionPool connectionPool;

    private QuantityMeasurementDatabaseRepository() {

        LOGGER.info(
                "Initializing Database Repository...");

        connectionPool =
                ConnectionPool.getInstance();

        initializeDatabase();

        LOGGER.info(
                "Database Repository Initialized Successfully.");
    }
    private void initializeDatabase() {

        Connection connection = null;
        Statement statement = null;

        try {

            connection = connectionPool.acquireConnection();

            statement = connection.createStatement();

            statement.execute(
                    "CREATE TABLE IF NOT EXISTS quantity_measurement_entity (" +
                            "id BIGINT AUTO_INCREMENT PRIMARY KEY," +
                            "this_value DOUBLE," +
                            "this_unit VARCHAR(50)," +
                            "this_measurement_type VARCHAR(50)," +
                            "that_value DOUBLE," +
                            "that_unit VARCHAR(50)," +
                            "that_measurement_type VARCHAR(50)," +
                            "operation VARCHAR(50)," +
                            "result_value DOUBLE," +
                            "result_unit VARCHAR(50)," +
                            "result_measurement_type VARCHAR(50)," +
                            "result_string VARCHAR(255)," +
                            "is_error BOOLEAN," +
                            "error_message VARCHAR(255)," +
                            "created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP," +
                            "updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP" +
                            ")");

            LOGGER.info("Database initialized successfully.");

        } catch (Exception e) {

            LOGGER.error("Database initialization failed.", e);

            throw new DatabaseException(
                    "Failed to initialize database.",
                    e);

        } finally {

            closeResources(statement, connection);
        }
    }

    public static synchronized
    QuantityMeasurementDatabaseRepository getInstance() {

        if (instance == null) {
            instance =
                    new QuantityMeasurementDatabaseRepository();
        }

        return instance;
    }

    @Override
    public void save(QuantityMeasurementEntity entity) {

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {

            connection = connectionPool.acquireConnection();

            preparedStatement =
                    connection.prepareStatement(INSERT_QUERY);

            preparedStatement.setDouble(
                    1,
                    entity.getThisValue());

            preparedStatement.setString(
                    2,
                    entity.getThisUnit());

            preparedStatement.setString(
                    3,
                    entity.getThisMeasurementType());

            if (entity.getThatValue() != null) {

                preparedStatement.setDouble(
                        4,
                        entity.getThatValue());

            } else {

                preparedStatement.setNull(
                        4,
                        Types.DOUBLE);
            }

            preparedStatement.setString(
                    5,
                    entity.getThatUnit());

            preparedStatement.setString(
                    6,
                    entity.getThatMeasurementType());

            preparedStatement.setString(
                    7,
                    entity.getOperation());

            if (entity.getResultValue() != null) {

                preparedStatement.setDouble(
                        8,
                        entity.getResultValue());

            } else {

                preparedStatement.setNull(
                        8,
                        Types.DOUBLE);
            }

            preparedStatement.setString(
                    9,
                    entity.getResultUnit());

            preparedStatement.setString(
                    10,
                    entity.getResultMeasurementType());

            preparedStatement.setString(
                    11,
                    entity.getResultString());

            preparedStatement.setBoolean(
                    12,
                    entity.isError());

            preparedStatement.setString(
                    13,
                    entity.getErrorMessage());

            preparedStatement.executeUpdate();

            LOGGER.info(
                    "Measurement saved successfully.");

        } catch (SQLException e) {

            LOGGER.error(
                    "Unable to save measurement.",
                    e);

            throw new DatabaseException(
                    "Database save failed.",
                    e);

        } finally {

            closeResources(
                    preparedStatement,
                    connection);
        }
    }

    @Override
    public List<QuantityMeasurementEntity>
    getAllMeasurements() {

        List<QuantityMeasurementEntity> measurements =
                new ArrayList<>();

        Connection connection = null;

        Statement statement = null;

        ResultSet resultSet = null;

        try {

            connection =
                    connectionPool.acquireConnection();

            statement =
                    connection.createStatement();

            resultSet =
                    statement.executeQuery(
                            SELECT_ALL_QUERY);

            while (resultSet.next()) {

                measurements.add(
                        mapResultSetToEntity(
                                resultSet));
            }

            LOGGER.info(
                    "Retrieved {} measurements.",
                    measurements.size());

            return measurements;

        } catch (SQLException e) {

            LOGGER.error(
                    "Unable to retrieve measurements.",
                    e);

            throw new DatabaseException(
                    "Failed to retrieve measurements.",
                    e);

        } finally {

            closeResources(
                    resultSet,
                    statement,
                    connection);
        }
    }

    @Override
    public List<QuantityMeasurementEntity>
    getMeasurementsByOperation(
            String operation) {

        List<QuantityMeasurementEntity> measurements =
                new ArrayList<>();

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {

            connection =
                    connectionPool.acquireConnection();

            preparedStatement =
                    connection.prepareStatement(
                            SELECT_BY_OPERATION);

            preparedStatement.setString(
                    1,
                    operation);

            resultSet =
                    preparedStatement.executeQuery();

            while (resultSet.next()) {

                measurements.add(
                        mapResultSetToEntity(
                                resultSet));
            }

            LOGGER.info(
                    "Retrieved {} measurements for operation {}",
                    measurements.size(),
                    operation);

            return measurements;

        } catch (SQLException e) {

            LOGGER.error(
                    "Failed to retrieve measurements by operation.",
                    e);

            throw new DatabaseException(
                    "Database query failed.",
                    e);

        } finally {

            closeResources(
                    resultSet,
                    preparedStatement,
                    connection);
        }
    }

    @Override
    public List<QuantityMeasurementEntity>
    getMeasurementsByType(
            String measurementType) {

        List<QuantityMeasurementEntity> measurements =
                new ArrayList<>();

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {

            connection =
                    connectionPool.acquireConnection();

            preparedStatement =
                    connection.prepareStatement(
                            SELECT_BY_MEASUREMENT_TYPE);

            preparedStatement.setString(
                    1,
                    measurementType);

            resultSet =
                    preparedStatement.executeQuery();

            while (resultSet.next()) {

                measurements.add(
                        mapResultSetToEntity(
                                resultSet));
            }

            LOGGER.info(
                    "Retrieved {} measurements for type {}",
                    measurements.size(),
                    measurementType);

            return measurements;

        } catch (SQLException e) {

            LOGGER.error(
                    "Failed to retrieve measurements by type.",
                    e);

            throw new DatabaseException(
                    "Database query failed.",
                    e);

        } finally {

            closeResources(
                    resultSet,
                    preparedStatement,
                    connection);
        }
    }

    @Override
    public int getTotalCount() {

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {

            connection =
                    connectionPool.acquireConnection();

            statement =
                    connection.createStatement();

            resultSet =
                    statement.executeQuery(
                            COUNT_QUERY);

            if (resultSet.next()) {

                return resultSet.getInt(1);
            }

            return 0;

        } catch (SQLException e) {

            throw new DatabaseException(
                    "Unable to count records.",
                    e);

        } finally {

            closeResources(
                    resultSet,
                    statement,
                    connection);
        }
    }

    @Override
    public void deleteAll() {

        Connection connection = null;
        Statement statement = null;

        try {

            connection =
                    connectionPool.acquireConnection();

            statement =
                    connection.createStatement();

            statement.executeUpdate(
                    DELETE_ALL_QUERY);

            LOGGER.info(
                    "All measurements deleted.");

        } catch (SQLException e) {

            throw new DatabaseException(
                    "Delete failed.",
                    e);

        } finally {

            closeResources(
                    statement,
                    connection);
        }
    }

    @Override
    public String getPoolStatistics() {

        return "Available Connections: "
                + connectionPool.getAvailableConnectionCount()
                + ", Total Connections: "
                + connectionPool.getTotalConnections();
    }

    @Override
    public void releaseResources() {

        connectionPool.closePool();

        LOGGER.info(
                "Repository resources released.");
    }

    private QuantityMeasurementEntity
    mapResultSetToEntity(
                    ResultSet rs) {

        try {

            QuantityMeasurementEntity entity =
                    new QuantityMeasurementEntity();

            entity.setId(
                    rs.getLong("id"));

            entity.setThisValue(
                    rs.getDouble("this_value"));

            entity.setThisUnit(
                    rs.getString("this_unit"));

            entity.setThisMeasurementType(
                    rs.getString(
                            "this_measurement_type"));

            entity.setThatValue(
                    rs.getDouble("that_value"));

            entity.setThatUnit(
                    rs.getString("that_unit"));

            entity.setThatMeasurementType(
                    rs.getString(
                            "that_measurement_type"));

            entity.setOperation(
                    rs.getString("operation"));

            entity.setResultValue(
                    rs.getDouble("result_value"));

            entity.setResultUnit(
                    rs.getString("result_unit"));

            entity.setResultMeasurementType(
                    rs.getString(
                            "result_measurement_type"));

            entity.setResultString(
                    rs.getString(
                            "result_string"));

            entity.setError(
                    rs.getBoolean(
                            "is_error"));

            entity.setErrorMessage(
                    rs.getString(
                            "error_message"));

            return entity;

        } catch (SQLException e) {

            throw new DatabaseException(
                    "Failed to map ResultSet.",
                    e);
        }
    }

    private void closeResources(
            ResultSet rs,
            Statement stmt,
            Connection conn) {

        try {

            if (rs != null) {
                rs.close();
            }

        } catch (SQLException ignored) {
        }

        closeResources(
                stmt,
                conn);
    }

    private void closeResources(
            Statement stmt,
            Connection conn) {

        try {

            if (stmt != null) {
                stmt.close();
            }

        } catch (SQLException ignored) {
        }

        if (conn != null) {

            connectionPool.releaseConnection(
                    conn);
        }
    }
}