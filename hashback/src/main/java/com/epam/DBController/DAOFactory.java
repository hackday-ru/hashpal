package com.epam.DBController;

import com.epam.DBController.DAO.TokenDAO;
import com.epam.DBController.DAO.UserDAO;

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
}
