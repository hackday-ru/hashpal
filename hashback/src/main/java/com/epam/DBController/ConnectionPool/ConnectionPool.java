package com.epam.DBController.ConnectionPool;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Locale;
import java.util.Properties;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ConnectionPool {
    public BlockingQueue<Connection> getFreeConnections() {
        return freeConnections;
    }

    public BlockingQueue<Connection> getReservedConnections() {
        return reservedConnections;
    }

    private BlockingQueue<Connection> freeConnections;
    private BlockingQueue<Connection> reservedConnections;

    private static ConnectionPool instance;

    public static ConnectionPool getInstance() {
        return (instance == null)?(instance = new ConnectionPool()):instance;
    }

    private String driverName;
    private String url;
    private String user;
    private String password;

    private int poolSize;

    private ConnectionPool() {
        Properties properties = new Properties();

        driverName = "org.postgresql.Driver";
        url = "jdbc:postgresql://127.0.0.1/Hashpal";
        user = "hashpal";
        password = "holokost";
        poolSize = 16;

        initPoolData();
    }

    private void initPoolData() {
        Locale.setDefault(Locale.ENGLISH);

        try {
            Class.forName(driverName);
            reservedConnections = new ArrayBlockingQueue<>(poolSize);
            freeConnections = new ArrayBlockingQueue<>(poolSize);

            for (int i = 0; i < poolSize; i++) {
                Connection connection = DriverManager.getConnection(url, user, password);
                PooledConnection pooledConnection =
                        PooledConnection.wrap(connection, freeConnections, reservedConnections);
                freeConnections.add(pooledConnection);
            }
        } catch (SQLException e) {
            throw new RuntimeException("SQLException in ConnectionPool", e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Can't find database driver class", e);
        }
    }

    public Connection takeConnection() {
        Connection connection = null;
        try {
            connection = freeConnections.take();
            reservedConnections.add(connection);
        } catch (InterruptedException e) {
            throw new RuntimeException("Error connecting to the data source.", e);
        }
        return connection;
    }
}
