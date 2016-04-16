package com.epam.DBController.DAO;

import com.epam.DBController.ConnectionPool.ConnectionPool;
import com.epam.DBController.ConnectionPool.PooledConnection;
import com.epam.DBController.Entities.Post;
import com.epam.DBController.Entities.SearchHash;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by vrama on 16.04.2016.
 */
public class SearchHashDAO {

    private SearchHashDAO() {}
    private static SearchHashDAO instance;

    public static SearchHashDAO getInstance() {
        return (instance==null)?(instance = new SearchHashDAO()):instance;
    }

    private ConnectionPool pool = ConnectionPool.getInstance();

    public boolean addSearchHash(SearchHash searchHash) {
        try(PooledConnection conn = PooledConnection.wrap(pool.takeConnection(),
                pool.getFreeConnections(), pool.getReservedConnections())) {
            String sql = "INSERT INTO search (id, hashtag, user_id) VALUES (?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setLong(1, searchHash.getId());
            ps.setString(2, searchHash.getHashtag());
            ps.setLong(3, searchHash.getUserId());
            if (ps.executeUpdate() == 0) throw new SQLException("Nothing was added");
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
