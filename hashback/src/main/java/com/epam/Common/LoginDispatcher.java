package com.epam.Common;

import javax.servlet.http.HttpSession;

/**
 * Created on 16/04/16.
 *
 * @author Vladislav Boboshko
 */
public class LoginDispatcher {
    private LoginDispatcher() {}
    private static LoginDispatcher instance;
    public static LoginDispatcher getInstance() {
        return (instance==null)?(instance = new LoginDispatcher()):instance;
    }

    public boolean authorize(HttpSession session, String login, String password) {
        // TODO: 16/04/16 get user entity from dao by login
        String def = "whynot";
        if (!(password.equals(def) && login.equals(def))) {
            return false;
        }
        // TODO: 16/04/16 before setting entity into session remove passwd
        session.setAttribute("user", new Object()); //set entity here
        session.setMaxInactiveInterval(0);
        return true;
    }
}
