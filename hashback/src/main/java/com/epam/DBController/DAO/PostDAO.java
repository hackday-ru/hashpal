package com.epam.DBController.DAO;

import com.epam.DBController.ConnectionPool.ConnectionPool;
import com.epam.DBController.ConnectionPool.PooledConnection;
import com.epam.DBController.Entities.Post;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by vrama on 16.04.2016.
 */
public class PostDAO {
    private static PostDAO instance;

    public static PostDAO getInstance() {
        return (instance==null)?(instance = new PostDAO()):instance;
    }

    private ConnectionPool pool = ConnectionPool.getInstance();

    public boolean addPost(Post post) {
        try(PooledConnection conn = PooledConnection.wrap(pool.takeConnection(),
                pool.getFreeConnections(), pool.getReservedConnections())) {
            String sql = "INSERT INTO post (social_id, post_id, hashtags) VALUES (?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setLong(1, post.getSocialId());
            ps.setString(2, post.getPostId());
            ps.setString(3, post.getHashtags());
            if (ps.executeUpdate() == 0) throw new SQLException("Nothing was added");
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
    




    private PostDAO() {
    }
}
