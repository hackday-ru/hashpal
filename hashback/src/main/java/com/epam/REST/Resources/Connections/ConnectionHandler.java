package com.epam.REST.Resources.Connections;

import com.epam.Common.LoginDispatcher;
import com.epam.Common.RequestReader;
import com.epam.DBController.Entities.User;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created on 16/04/16.
 *
 * @author Vladislav Boboshko
 */
@Path("connections")
public class ConnectionHandler {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("add")
    public Response addConnection(@Context HttpServletRequest requestContext) {
        User user = (User) requestContext.getSession().getAttribute("user");
        JSONObject jsonResponse = new JSONObject();
        if (user == null) {
            jsonResponse.put("result", "unauthorized");
            return Response.status(401).entity(jsonResponse.toJSONString()).build();
        }
        try {
            JSONObject jsonRequest = (JSONObject) new JSONParser().parse(RequestReader.readRequestBody(requestContext));
            Long id = LoginDispatcher.getInstance().getSocialId((String)jsonRequest.get("social"));
            String token = (String) jsonRequest.get("token");
            // TODO: 16/04/16 add token
        } catch (ParseException e) {
            jsonResponse.put("result", "bad request");
            return Response.status(400).entity(jsonResponse.toJSONString()).build();
        }
        jsonResponse.put("result", "success");
        return Response.ok().entity(jsonResponse.toJSONString()).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("delete/{socialName}")
    public Response deleteConnection(@Context HttpServletRequest requestContext, @PathParam("socialName") String socialName) {
        User user = (User) requestContext.getSession().getAttribute("user");
        JSONObject jsonResponse = new JSONObject();
        if (user == null) {
            jsonResponse.put("result", "unauthorized");
            return Response.status(401).entity(jsonResponse.toJSONString()).build();
        }
        Long socialId = LoginDispatcher.getInstance().getSocialId(socialName);
        if (socialId == 0) {
            jsonResponse.put("result", "unauthorized");
            return Response.status(400).entity(jsonResponse.toJSONString()).build();
        }
        // TODO: 16/04/16 remove token
        jsonResponse.put("result", "success");
        return Response.ok().entity(jsonResponse.toJSONString()).build();
    }
}
