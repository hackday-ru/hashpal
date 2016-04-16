package com.epam.DBController.DAO;

import com.epam.DBController.ConnectionFactory;
import com.epam.DBController.ConnectionPool.ConnectionPool;
import com.epam.DBController.ConnectionPool.PooledConnection;
import com.epam.DBController.Entities.Token;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by vrama on 16.04.2016.
 */
public class TokenDAO {
    private TokenDAO() {}
    private static TokenDAO instance;
    public static TokenDAO getInstance() {
        return (instance==null)?(instance = new TokenDAO()):instance;
    }

    private ConnectionPool pool = ConnectionPool.getInstance();

    public boolean addToken(Long userId, Long socialId, String token) {
        try(PooledConnection conn = PooledConnection.wrap(pool.takeConnection(),
                pool.getFreeConnections(), pool.getReservedConnections())) {
            String sql = "INSERT INTO user_tokens (user_id, soc_id, token) VALUES (?,?,?);";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setLong(1, userId);
            ps.setLong(2, socialId);
            ps.setString(3, token);
            if (ps.executeUpdate() == 0) throw new SQLException("Nothing was added");
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean deleteToken(Long userId, Long socialId) {
        try(PooledConnection conn = PooledConnection.wrap(pool.takeConnection(),
                pool.getFreeConnections(), pool.getReservedConnections())) {
            String sql = "DELETE FROM user_tokens WHERE soc_id=(?) AND user_id=(?);";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setLong(1, socialId);
            ps.setLong(2, userId);
            if (ps.executeUpdate() == 0) throw new SQLException("Nothing was added")
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
    public List<Token> getTokensByUser(Long userID) {
        List<Token> tokens = new ArrayList<>();

        try(PooledConnection con = PooledConnection.wrap(pool.takeConnection(),
                pool.getFreeConnections(), pool.getReservedConnections())) {
            String sql = "SELECT * FROM user_tokens WHERE users_id=(?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setLong(1, userID);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                tokens.add(new Token(
                        rs.getLong("user_id"),
                        rs.getLong("soc_id"),
                        rs.getString("token")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
        return tokens;
    }
}