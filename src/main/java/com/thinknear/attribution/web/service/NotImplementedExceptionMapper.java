package com.thinknear.attribution.web.service;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import com.thinknear.attribution.web.model.ApiFault;

@Provider
public class NotImplementedExceptionMapper implements ExceptionMapper<NotImplementedException> {

    public Response toResponse(NotImplementedException ire) {
        ApiFault error = new ApiFault("501", "notImplemented", ire.getMessage());
        return Response.status(Status.NOT_IMPLEMENTED).entity(error).build();
    }

}
