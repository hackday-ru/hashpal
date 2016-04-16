package com.epam.DBController.DAO;

import com.epam.DBController.ConnectionPool.ConnectionPool;
import com.epam.DBController.ConnectionPool.PooledConnection;
import com.epam.DBController.Entities.FavoriteHash;
import com.epam.DBController.Entities.SearchHash;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by vrama on 16.04.2016.
 */
public class FavoriteHashDAO {

    private FavoriteHashDAO() {}
    private static FavoriteHashDAO instance;

    public static FavoriteHashDAO getInstance() {
        return (instance==null)?(instance = new FavoriteHashDAO()):instance;
    }

    private ConnectionPool pool = ConnectionPool.getInstance();

    public boolean addFavoriteHash(FavoriteHash favoriteHash) {
        try(PooledConnection conn = PooledConnection.wrap(pool.takeConnection(),
                pool.getFreeConnections(), pool.getReservedConnections())) {
            String sql = "INSERT INTO favorites (id, hashtag, user_id) VALUES (?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setLong(1, favoriteHash.getId());
            ps.setString(2, favoriteHash.getHashtag());
            ps.setLong(3, favoriteHash.getUserId());
            if (ps.executeUpdate() == 0) throw new SQLException("Nothing was added");
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

}
