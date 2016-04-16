package com.epam.REST.Resources.Posts;

import com.epam.Common.RequestReader;
import com.epam.DBController.DAOFactory;
import com.epam.DBController.Entities.Post;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.Timestamp;

/**
 * Created on 16/04/16.
 *
 * @author Vladislav Boboshko
 */

@Path("post")
public class AddPost {

    @POST
    @Path("add")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addPost(@Context HttpServletRequest requestContext) {
        HttpSession session = requestContext.getSession();
        JSONObject jsonResponse = new JSONObject();
        Post post;
        if (requestContext.getSession().getAttribute("user") == null) {
            jsonResponse.put("result", "unauthorized");
            return Response.status(401).entity(jsonResponse.toJSONString()).build();
        }
        try {
            JSONObject jsonRequest = (JSONObject) new JSONParser().parse(RequestReader.readRequestBody(requestContext));
            post = new Post(
                    (Long) jsonRequest.get("socialId"),
                    (String) jsonRequest.get("postId"),
                    (String) jsonRequest.get("hashtags"),
                    new Timestamp((Long) jsonRequest.get("timestamp")),
                    (Float) jsonRequest.get("lat"),
                    (Float) jsonRequest.get("lon"));
        } catch (ParseException e) {
            jsonResponse.put("result", "bad request");
            return Response.status(400).entity(jsonResponse.toJSONString()).build();
        }
        return Response.ok().entity(jsonResponse.toJSONString()).build();
    }
}