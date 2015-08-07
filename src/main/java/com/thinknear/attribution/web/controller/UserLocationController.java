package com.thinknear.attribution.web.controller;



import io.swagger.annotations.Api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.jsonschema.JsonSchema;
import com.thinknear.attribution.annotation.Profile;
import com.thinknear.attribution.web.service.UserLocationService;
import com.thinknear.attribution.web.model.ApiFault;
import com.thinknear.attribution.web.model.UserLocation;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@Api(value = "userlocation", produces = "application/json")
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
     * Generates the Location headers for the <code>UserLocation</code> object.
     * TODO: Consider putting this logic in a Filter so that it is done for every relevant response.
     * @param userLocation
     * @return
     */
    protected HttpHeaders getResponseHeadersForUserLocation(UserLocation userLocation) {
        HttpHeaders responseHeaders = new HttpHeaders();
        return responseHeaders;
    }

    @ApiOperation(value = "Gets an existing UserLocation by Id", notes = "Returns a UserLocation for given id", response = UserLocation.class)
    @ApiResponses(value = {
            @ApiResponse(code = 404, message = "UserLocation was not found", response = ApiFault.class),  // TODO: Not implemented
            @ApiResponse(code = 200, message = "UserLocation was found and returned", response = UserLocation.class) })
    @Profile("UserLocationController#getUserLocationById")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces="application/json")
    @ResponseBody
    public HttpEntity<UserLocation> getUserLocationById(@ApiParam(name = "id", value = "Unique Indentifier", required = true) @PathVariable(value = "id") String id) {
        UserLocation userLocation = userLocationService.getUserLocation(id);
        return new ResponseEntity<UserLocation>(userLocation, getResponseHeadersForUserLocation(userLocation), HttpStatus.OK);
    }
    


    @ApiOperation(value = "Create new UserLocation", notes = "Creates new UserLocation")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Fields are with validation errors", response = ApiFault.class),  // TODO: Not implemented
            @ApiResponse(code = 201, message = "UserLocation was created") })
    @Profile("UserLocationController#createUserLocation")
    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public HttpEntity<UserLocation> createUserLocation(@ApiParam(name = "userLocation", value = "User Location to Update", required = true) @RequestBody UserLocation userLocation) {
        userLocation = userLocationService.createUserLocation(userLocation);
        return new ResponseEntity<UserLocation>(userLocation, getResponseHeadersForUserLocation(userLocation), HttpStatus.CREATED);
    }

    @ApiOperation(value = "Updates an existing UserLocation", notes = "Updates UserLocation")
    @ApiResponses(value = {
            @ApiResponse(code = 404, message = "UserLocation to update was not found", response = ApiFault.class),  // TODO: Not implemented
            @ApiResponse(code = 400, message = "Fields are with validation errors", response = ApiFault.class),  // TODO: Not implemented
            @ApiResponse(code = 501, message = "Not implemented yet", response = ApiFault.class),  // TODO: Not implemented
            @ApiResponse(code = 204, message = "UserLocation was updated") })
    @Profile("UserLocationController#updateUserLocation")
    @RequestMapping(method = RequestMethod.PUT)
    @ResponseBody
    public HttpEntity<Void> updateUserLocation(@ApiParam(name = "userLocation", value = "Updated User Location", required = true) @RequestBody UserLocation userLocation) {
        userLocationService.updateUserLocation(userLocation);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @ApiOperation(value = "Deletes an existing UserLocation", notes = "Deletes UserLocation")
    @ApiResponses(value = {
            @ApiResponse(code = 404, message = "UserLocation to delete was not found", response = ApiFault.class),  // TODO: Not implemented
            @ApiResponse(code = 501, message = "Not implemented yet", response = ApiFault.class),  // TODO: Not implemented
            @ApiResponse(code = 204, message = "UserLocation was deleted") })
    @Profile("UserLocationController#deleteUserLocation")
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public HttpEntity<Void> deleteUserLocation(@ApiParam(name = "id", value = "Unique Indentifier", required = true) @PathVariable(value = "id") String id) {
        userLocationService.deleteUserLocation(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

    
    @RequestMapping(value = "/schema", method = RequestMethod.GET, produces="application/json")
    @ResponseBody
    public HttpEntity<String> getUserLocationSchema() {
        ObjectMapper mapper = new ObjectMapper();
        JsonSchema schema;
        String result= "";
        try {
            schema = mapper.generateJsonSchema(UserLocation.class);
            result = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(schema);
        } catch (JsonMappingException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
        } catch (JsonProcessingException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        } 
        
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.add("Content-Type", "application/json;charset=UTF-8");
       
        ResponseEntity<String> responseEntity = 
                new ResponseEntity<String>(result, responseHeaders, HttpStatus.OK);
        return responseEntity;
    }



}