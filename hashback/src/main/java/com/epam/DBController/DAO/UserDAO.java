package com.epam.DBController.DAO;

import com.epam.DBController.ConnectionFabric;
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

    public List<Token> getTokensById(Long userID) {
        List<Token> tokens = new ArrayList<>();

        try(Connection con = ConnectionFabric.getDataSource().getConnection()) {
            String sql = "SELECT * FROM user_tokens WHERE users.id=(?)";
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

    public void deleteToken(Long userID, String token) {

        int status = 0;

        try(Connection con = ConnectionFabric.getDataSource().getConnection()) {
            String sql = "DELETE token FROM user_tokens WHERE users.id=(?) AND user_tokens.token=(?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setLong(1, userID);
            ps.setString(2, token);
            status  = ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
