package com.epam.REST.Resources.Users.Profile;

import com.epam.Common.LoginDispatcher;
import com.epam.DBController.Entities.Token;
import com.epam.DBController.Entities.User;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import java.util.Collections;
import java.util.List;

/**
 * Created on 16/04/16.
 *
 * @author Vladislav Boboshko
 */

@Path("user")
public class GetUserInfo {

    @GET
    public Response getUser(@Context HttpServletRequest requestContext) {
        User user = (User) requestContext.getSession().getAttribute("user");
        if (user == null) {
            return Response.status(401).build();
        }
        JSONObject jsonResponse = new JSONObject();
        jsonResponse.put("id", user.getId());
        jsonResponse.put("login", user.getLogin());
        JSONArray tokens = new JSONArray();
        List<Token> tokenList = Collections.emptyList();
        for (Token i:tokenList) {
            JSONObject token = new JSONObject();
            token.put("social", LoginDispatcher.getInstance().getSocialName(i.getSocID()));
            token.put("token", i.getToken());
            tokens.add(token);
        }
        jsonResponse.put("connections", tokens);
        return Response.ok().entity(jsonResponse.toJSONString()).build();
    }
}
