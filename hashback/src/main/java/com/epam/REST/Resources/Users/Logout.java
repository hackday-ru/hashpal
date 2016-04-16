package com.epam.REST.Resources.Users;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created on 16/04/16.
 *
 * @author Vladislav Boboshko
 */
@Path("logout")
public class Logout {

    @GET
    public Response logout(@Context HttpServletRequest requestContext) {
        requestContext.getSession().invalidate();
        return Response.ok().build();
    }
}
