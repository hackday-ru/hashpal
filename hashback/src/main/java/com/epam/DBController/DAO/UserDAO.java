package com.epam.DBController.DAO;

import com.epam.DBController.ConnectionPool.ConnectionPool;
import com.epam.DBController.ConnectionPool.PooledConnection;
import com.epam.DBController.Entities.Token;
import com.epam.DBController.Entities.User;

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
    
    public boolean addUser(User user) {
        try (PooledConnection conn = PooledConnection.wrap(pool.takeConnection(),
                pool.getFreeConnections(), pool.getReservedConnections())) {
            String sql = "INSERT INTO users (login, password) VALUES (?,?);";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, user.getLogin());
            ps.setString(2, user.getPassword());
            if (ps.executeUpdate() == 0) throw new SQLException("Nothing was added");
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
