package com.epam.DBController;

import javax.sql.DataSource;

/**
 * Created by vrama on 16.04.2016.
 */
public class ConnectionFabric {
    private static ConnectionFabric ourInstance = new ConnectionFabric();

    public static DataSource getDataSource() {

        DataSource ds = new DataSource();
        ds.setDriverClassName("org.postgresql.Driver");
        ds.setUrl("jdbc:postgresql://192.168.43.175/MagazineShop");
        ds.setUsername("hashpal");
        ds.setPassword("holokost");

        return ds;
    }

    private ConnectionFabric() {
    }
}
