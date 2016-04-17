/*package com.epam.Analysis;

import com.epam.Common.StringToHashtags;
import com.epam.DBController.ConnectionPool.ConnectionPool;
import com.epam.DBController.ConnectionPool.PooledConnection;
import com.epam.DBController.Entities.Post;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.*;


public class Analysis {
    private static Analysis ourInstance = new Analysis();

    public static Analysis getInstance() {
        return ourInstance;
    }

    private Analysis() {
    }

    private ConnectionPool pool = ConnectionPool.getInstance();

    public List<String> byTime(Timestamp time, int days) {
        List<String> sortedByTimeHash = new ArrayList<>();
        Map<String, Integer> hashCCounter = new HashMap<>();


        try(PooledConnection conn = PooledConnection.wrap(pool.takeConnection(),
                pool.getFreeConnections(), pool.getReservedConnections())) {
            String sql = "SELECT * FROM post " +
                    "WHERE tstamp BETWEEN ((?) - INTERVAL '0.5 day' *(?)) AND ((?) + INTERVAL '0.5 day' * (?));";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setTimestamp(1, time);
            ps.setInt(2, days);
            ps.setTimestamp(3, time);
            ps.setInt(4, days);
            ResultSet rs = ps.executeQuery();

            while(rs.next()) {
                StringToHashtags.proceed(rs.getString("hashtags"));

                sortedByTimeHash.add(StringToHashtags.proceed(rs.getString("hashtags")));

            }


        } catch (SQLException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }

        for (String tempHash:sortedByTimeHash) {
            if (!hashCCounter.containsKey(tempHash)) {
                hashCCounter.put(tempHash, 1);
            } else {
                hashCCounter.put(tempHash, hashCCounter.get(tempHash)+1);
            }
        }

        for (Map.Entry<String, Integer> entry : hashCCounter.entrySet()) {

            System.out.println("Hash = " + entry.getKey() + ", Повторений = " + entry.getValue());
        }


        return sortedByTimeHash;
    }

    public List<Post> byPlace() {
        List<Post> sortedByPlacePosts = new ArrayList<>();
    }

    public List<Post> byTimeAndPlace() {
        List<Post> sortedByTimeAndPlacePosts = new ArrayList<>();
    }


}
*/