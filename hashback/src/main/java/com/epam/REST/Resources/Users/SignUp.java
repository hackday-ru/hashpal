package com.epam.REST.Resources.Users;

import com.epam.Common.LoginDispatcher;
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

@Path("register")
public class SignUp {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response signUp(@Context HttpServletRequest request) {
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
        // TODO: 16/04/16 check user creation
        if (false) {
            jsonResponse.put("result", "user exists or something wrong");
            return Response.ok().entity(jsonResponse.toJSONString()).build();
        }
        jsonResponse.put("result", "Success");
        return Response.ok().entity(jsonResponse.toJSONString()).build();
    }
}
