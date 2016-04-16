package com.epam.Common;

import com.epam.DBController.DAOFactory;
import com.epam.DBController.Entities.User;
import org.json.simple.JSONObject;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Created on 16/04/16.
 *
 * @author Vladislav Boboshko
 */
public class LoginDispatcher {
    private LoginDispatcher() {
        socials = new HashMap<>();
        socials.put(1L, "vk");
        socials.put(2L, "twitter");
        socials.put(3L, "instagram");
        socials.put(4L, "facebook");
    }
    private static LoginDispatcher instance;
    public static LoginDispatcher getInstance() {
        return (instance==null)?(instance = new LoginDispatcher()):instance;
    }

    private HashMap<Long, String> socials;

    public boolean authorize(HttpSession session, String login, String password) {
        User user = DAOFactory.getUserDAO().getUserById(login);
        if (user.getId() == 0) {
            return false;
        }

        if (!(password.equals(user.getPassword()) && login.equals(user.getLogin()))) {
            return false;
        }
        user.setPassword("");
        session.setAttribute("user", user);
        session.setMaxInactiveInterval(0);
        return true;
    }

    public String getSocialName(Long id) {
        return socials.getOrDefault(id, "unknown");
    }

    public Long getSocialId(String name) {
        return socials.entrySet()
                .stream()
                .filter(entry -> entry.getValue().equals(name))
                .map(Map.Entry::getKey)
                .collect(Collectors.toList()).get(1);
    }
}
