package com.thinknear.attribution.web.service;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

public interface HelloWorld {
    Response sayHi(UriInfo ui, String text);
}
