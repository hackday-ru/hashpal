package com.epam;

import org.glassfish.jersey.server.ResourceConfig;

import javax.ws.rs.ApplicationPath;

/**
 * Created on 16/04/16.
 *
 * @author Vladislav Boboshko
 */

@ApplicationPath("api")
public class Init extends ResourceConfig {
    public Init() {
        packages("com.epam.REST");
    }
}
