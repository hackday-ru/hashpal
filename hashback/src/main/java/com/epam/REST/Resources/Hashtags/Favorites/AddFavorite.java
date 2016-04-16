package com.epam.REST.Resources.Hashtags.Favorites;

import com.epam.Common.LoginDispatcher;
import com.epam.Common.RequestReader;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created on 16/04/16.
 *
 * @author Vladislav Boboshko
 */

@Path("favorites")
public class AddFavorite {

    @POST
    @Path("add")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addHashtag(@Context HttpServletRequest requestContext) {
        if (!LoginDispatcher.getInstance().isAuthorized(requestContext.getSession())) {
            return Response.status(401).build();
        }
        JSONObject jsonResponse = new JSONObject();
        String hashtag = "";
        Long user = 0L;
        try {
            JSONObject jsonRequest = (JSONObject) new JSONParser().parse(RequestReader.readRequestBody(requestContext));
            user = (Long) jsonRequest.get("user");
            hashtag = (String) jsonRequest.get("hashtag");
            if (user == null || hashtag == null) throw new ParseException(0);
        } catch (ParseException e) {
            return Response.status(401).build();
        }
        // TODO: 16/04/16 add hashtag to db
        return Response.ok().build();
    }
}
