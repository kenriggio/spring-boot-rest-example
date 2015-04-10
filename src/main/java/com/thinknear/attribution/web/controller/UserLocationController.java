package com.thinknear.attribution.web.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;

import com.thinknear.attribution.annotation.Profile;
import com.thinknear.attribution.web.service.UserLocationService;
import com.thinknear.attribution.web.model.UserLocation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

@Controller
@RequestMapping("/attribution/userlocation")
public class UserLocationController {
    private UserLocationService userLocationService;

    @Autowired
    public UserLocationController(UserLocationService userLocationService) {
        this.userLocationService = userLocationService;
    }

    public UserLocationService getUserLocationService() {
        return userLocationService;
    }

    public void setUserLocationService(UserLocationService userLocationService) {
        this.userLocationService = userLocationService;
    }

    /**
     * Generates the Location and ETag headers for the <code>UserLocation</code> object.
     * @param userLocation
     * @return
     */
    protected HttpHeaders getResponseHeadersForUserLocation(UserLocation userLocation) {
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.add("Location", linkTo(methodOn(UserLocationController.class).getUserLocationById(userLocation.getUserLocationId())).withSelfRel().getHref());
        responseHeaders.add("ETag", String.valueOf(userLocation.hashCode())); // Should do MD5 of content, but this is just an example
        return responseHeaders;
    }

    @Profile("UserLocationController#getUserLocationById")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public HttpEntity<UserLocation> getUserLocationById(@PathVariable(value = "id") String id) {
        UserLocation userLocation = userLocationService.getUserLocation(id);
        userLocation.add(linkTo(methodOn(UserLocationController.class).getUserLocationById(id)).withSelfRel());
        return new ResponseEntity<UserLocation>(userLocation, getResponseHeadersForUserLocation(userLocation), HttpStatus.OK);
    }

    @Profile("UserLocationController#createUserLocation")
    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public HttpEntity<UserLocation> createUserLocation(@RequestBody UserLocation userLocation) {
        userLocation = userLocationService.createUserLocation(userLocation);
        userLocation.add(linkTo(methodOn(UserLocationController.class).getUserLocationById(userLocation.getUserLocationId())).withSelfRel());
        return new ResponseEntity<UserLocation>(userLocation, getResponseHeadersForUserLocation(userLocation), HttpStatus.CREATED);
    }

    @Profile("UserLocationController#updateUserLocation")
    @RequestMapping(method = RequestMethod.PUT)
    @ResponseBody
    public HttpEntity<Void> updateUserLocation(@RequestBody UserLocation userLocation) {
        try {
            userLocationService.updateUserLocation(userLocation);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (NotImplementedException nie) {
            return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).build();
            // TODO: Only done as an example to return a response that tests the ThrowableAspect
        } catch (Throwable t) {
            // This is a basic catch all since we don't want to blast the users with our stack traces
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @Profile("UserLocationController#deleteUserLocation")
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public HttpEntity<Void> deleteUserLocation(@PathVariable(value = "id") String id) {
        try {
            userLocationService.deleteUserLocation(id);
            return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
        } catch (NotImplementedException nie) {
            return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).build();
            // TODO: Only done as an example to return a response that tests the ThrowableAspect
        } catch (Throwable t) {
            // This is a basic catch all since we don't want to blast the users with our stack traces
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }




}