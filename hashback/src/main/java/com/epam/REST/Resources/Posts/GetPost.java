package com.epam.REST.Resources.Posts;

import com.epam.Common.LoginDispatcher;
import com.epam.DBController.DAOFactory;
import com.epam.DBController.Entities.Post;
import org.json.simple.JSONObject;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created on 16/04/16.
 *
 * @author Vladislav Boboshko
 */

@Path("post")
public class GetPost {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{social}/{id}")
    public Response getPost(@Context HttpServletRequest requestContext, @PathParam("social") String social,
                            @PathParam("id") String postId) {
        if (!LoginDispatcher.getInstance().isAuthorized(requestContext.getSession(false))) {
            return Response.status(401).build();
        }
        Post post = DAOFactory.getPostDAO().getPostById(LoginDispatcher.getInstance().getSocialId(social), postId);
        if (post.getId() == 0) {
            return Response.status(404).build();
        }
        JSONObject response = new JSONObject();
        response.put("social", LoginDispatcher.getInstance().getSocialName(post.getSocialId()));
        response.put("postId", post.getPostId());
        return Response.ok().entity(response.toJSONString()).build();
    }

}
