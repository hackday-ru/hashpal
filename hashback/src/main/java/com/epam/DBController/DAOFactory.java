package com.epam.DBController;

import com.epam.DBController.DAO.*;

/**
 * Created on 16/04/16.
 *
 * @author Vladislav Boboshko
 */
public class DAOFactory {
    public static TokenDAO getTokenDAO() {
        return TokenDAO.getInstance();
    }

    public static UserDAO getUserDAO() {
        return UserDAO.getInstance();
    }

    public static PostDAO getPostDAO() {
        return PostDAO.getInstance();
    }

    public static SearchHashDAO getSearchHashDAO() {
        return SearchHashDAO.getInstance();
    }

    public static FavoriteHashDAO getFavoriteHashDAO() {
        return FavoriteHashDAO.getInstance();
    }
}
