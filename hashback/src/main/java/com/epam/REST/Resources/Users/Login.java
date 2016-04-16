package com.epam.REST.Resources.Users;

import com.epam.Common.LoginDispatcher;
import com.epam.Common.RequestReader;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import static com.epam.Common.RequestReader.readRequestBody;

/**
 * Created on 16/04/16.
 *
 * @author Vladislav Boboshko
 */

@Path("login")
public class Login {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response login(@Context HttpServletRequest request) {
        HttpSession session = request.getSession();
        JSONObject jsonResponse = new JSONObject();
        String login;
        String password;
        int code = 200;
        try {
            JSONObject requestBody = ((JSONObject) new JSONParser().parse(readRequestBody(request)));
            login = ((String) requestBody.get("login"));
            password = (String) requestBody.get("password");
        } catch (ParseException e) {
            e.printStackTrace();
            jsonResponse.put("result", "Wrong request");
            return Response.status(400).entity(jsonResponse.toJSONString()).build();
        }
        if (!LoginDispatcher.getInstance().authorize(session, login, password)) {
            jsonResponse.put("result", "Wrong credentials");
            return Response.status(401).entity(jsonResponse.toJSONString()).build();
        }
        jsonResponse.put("result", "Success");
        return Response.ok().entity(jsonResponse.toJSONString()).build();
    }

}
