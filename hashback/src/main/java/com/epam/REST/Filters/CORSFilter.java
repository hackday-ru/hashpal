package com.epam.REST.Filters;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.core.MultivaluedMap;
import java.io.IOException;

/**
 * Created on 16/04/16.
 *
 * @author Vladislav Boboshko
 */
public class CORSFilter implements ContainerResponseFilter {
    @Override
    public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext) throws IOException {
        MultivaluedMap<String, Object> headers = responseContext.getHeaders();
        headers.add("Access-Control-Allow-Origin", "http://localhost:3000");
        headers.add("Access-Control-Allow-Headers",
                "origin, content-type, accept, authorization");
        headers.add("Access-Control-Allow-Credentials", "true");
        headers.add("Access-Control-Allow-Methods",
                "GET, POST, PUT, DELETE, OPTIONS, HEAD");
    }
}
