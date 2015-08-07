package com.thinknear.attribution.web.service;


import java.net.URI;

import javax.jws.WebService;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

import org.springframework.hateoas.Link;

import com.thinknear.attribution.web.controller.UserLocationController;
import com.thinknear.attribution.web.model.UserLocation;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

@WebService(endpointInterface = "com.thinknear.attribution.web.service.HelloWorld")
@Produces("application/json")
@Path("/hello")
public class HelloWorldImpl implements HelloWorld {

    @GET
    @Path("hi/{name}")
    @Produces("application/json") 
    public Response sayHi(@Context UriInfo ui, @PathParam("name") String text) {
        System.out.println("sayHi called");
        UserLocation location = new UserLocation();
        location.setUserId(text);
        UriBuilder ub = ui.getRequestUriBuilder();
        URI uri = ub.build("");
        Link link = new Link(uri.toString());
        return Response.ok(location, MediaType.APPLICATION_JSON).build();
    }
    
    @GET
    @Path("bye/{name}")
    @Produces("application/json") 
    public Response sayBye(@PathParam("name") String text) {
        System.out.println("sayBye called");
        throw new NotImplementedException();
    }
}