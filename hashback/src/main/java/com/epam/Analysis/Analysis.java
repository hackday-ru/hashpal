package com.epam.Analysis;

import com.epam.DBController.ConnectionPool.ConnectionPool;
import com.epam.DBController.ConnectionPool.PooledConnection;
import com.epam.DBController.Entities.Post;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by vrama on 16.04.2016.
 */
public class Analysis {
    private static Analysis ourInstance = new Analysis();

    public static Analysis getInstance() {
        return ourInstance;
    }

    private Analysis() {
    }
    private ConnectionPool pool = ConnectionPool.getInstance();

    public List<Post> byTime(Timestamp time) {
        List<Post> sortedByTimePosts = new ArrayList<>();

        try(PooledConnection conn = PooledConnection.wrap(pool.takeConnection(),
                pool.getFreeConnections(), pool.getReservedConnections())) {
            String sql = "BEGIN " +
                    "SELECT  * FROM post WHERE  CURRENT_DATE tStamp=(?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setLong(1, time);
            ResultSet rs = ps.executeQuery();
            if (!rs.next()) throw new SQLException();

            return new Post(rs.getLong("id"), rs.getLong("socialId"), rs.getString("postId"), rs.getString("hashtags"),
                    rs.getTimestamp("tStamp"));

        } catch (SQLException e) {
            e.printStackTrace();
            return new Post(0L, 0L, "", "", new Timestamp(0));
        }

    }

    public List<Post> byPlace() {
        List<Post> sortedByPlacePosts = new ArrayList<>();
    }

    public List<Post> byTimeAndPlace() {
        List<Post> sortedByTimeAndPlacePosts = new ArrayList<>();
    }


}
