package com.epam.DBController.DAO;

import com.epam.DBController.ConnectionPool.ConnectionPool;
import com.epam.DBController.ConnectionPool.PooledConnection;
import com.epam.DBController.Entities.Token;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by vrama on 16.04.2016.
 */
public class UserDAO {

    private UserDAO() {}
    private static UserDAO instance;
    public static UserDAO getInstance() {
        return (instance==null)?(instance = new UserDAO()):instance;
    }
    private ConnectionPool pool = ConnectionPool.getInstance();

}
