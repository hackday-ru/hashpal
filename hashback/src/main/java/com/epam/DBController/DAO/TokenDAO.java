package com.epam.DBController.DAO;

import com.epam.DBController.ConnectionFactory;

/**
 * Created by vrama on 16.04.2016.
 */
public class TokenDAO {
    private TokenDAO() {}
    private static TokenDAO instance;
    public static TokenDAO getInstance() {
        return (instance==null)?(instance = new TokenDAO()):instance;
    }

    public boolean addToken(Long userId, Long socialId, String token) {
        try(ConnectionFactory.)

    }
}
