package com.epam.Common;

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
