package com.epam.Analysis;

import com.epam.DBController.ConnectionPool.ConnectionPool;
import com.epam.DBController.ConnectionPool.PooledConnection;
import com.epam.DBController.Entities.Post;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
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
            String sql = "SELECT  * FROM post WHERE CURRENT_DATE>=(?) AND CURRENT_DATE<=(?)+ interval '1 day'" +
                    "ORDER BY social_Id DESC limit 10";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setTimestamp(1, time);
            ps.setTimestamp(2, time);
            ResultSet rs = ps.executeQuery();

            while(rs.next()) {
                sortedByTimePosts.add(new Post(
                        rs.getLong("id"),
                        rs.getLong("social_Id"),
                        rs.getString("post_Id"),
                        rs.getString("hashtags"),
                        rs.getTimestamp("tStamp")));
            }


            if (!rs.next()) throw new SQLException();

        } catch (SQLException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }

        return sortedByTimePosts;
    }

    public List<Post> byPlace() {
        List<Post> sortedByPlacePosts = new ArrayList<>();
    }

    public List<Post> byTimeAndPlace() {
        List<Post> sortedByTimeAndPlacePosts = new ArrayList<>();
    }


}
