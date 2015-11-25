package com.hackathon.socialstream.web.controller;



import com.fasterxml.jackson.databind.ObjectMapper;
import com.hackathon.socialstream.HTTPConnection;
import com.hackathon.socialstream.model.FbArtists;
import io.swagger.annotations.Api;


import com.hackathon.socialstream.annotation.Profile;
import com.hackathon.socialstream.web.model.ApiFault;
import com.hackathon.socialstream.web.model.ArtistWeight;
import com.hackathon.socialstream.web.service.ArtistWeightService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import net.minidev.json.parser.JSONParser;
import net.minidev.json.parser.ParseException;
import org.apache.cxf.ws.addressing.MAPAggregator;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.QueryParam;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@RestController
@Api(value = "socialstream", produces = "application/json", consumes = "application/json")
@RequestMapping("/socialstream/weight")
public class ArtistWeightController {
    private ArtistWeightService artistWeightService;

    @Autowired
    public ArtistWeightController(ArtistWeightService artistWeightService) {
        this.artistWeightService = artistWeightService;
    }

    public ArtistWeightService getArtistWeightService() {
        return artistWeightService;
    }

    public void setArtistWeightService(ArtistWeightService artistWeightService) {
        this.artistWeightService = artistWeightService;
    }

    /**
     * Generates the Location headers for the <code>ArtistWeight</code> object.
     * TODO: Consider putting this logic in a Filter so that it is done for every relevant response.
     * @param artistWeight
     * @return
     */
    protected HttpHeaders getResponseHeadersForArtistWeight(ArtistWeight artistWeight) {
        HttpHeaders responseHeaders = new HttpHeaders();
        return responseHeaders;
    }

    @ApiOperation(value = "Get Top Artists", response = ArtistWeight.class)
    @ApiResponses(value = {
            @ApiResponse(code = 404, message = "No Artists found", response = ApiFault.class),  // TODO: Not implemented
            @ApiResponse(code = 200, message = "Top artists found and returned", response = ArtistWeight.class) })
    @RequestMapping(value = "/top/artists", method = RequestMethod.GET, produces="application/json")
    @ResponseBody
    public Object getArtistsForConsumer(){

        List<ArtistWeight> artistWeight =  artistWeightService.getTopArtists();

        return artistWeight;
    }

    @ApiOperation(value = "Get Top 3 Liked Artists", response = ArtistWeight.class)
    @ApiResponses(value = {
            @ApiResponse(code = 404, message = "No Artists found", response = ApiFault.class),  // TODO: Not implemented
            @ApiResponse(code = 200, message = "Top artists found and returned", response = ArtistWeight.class) })
    @RequestMapping(value = "/top/likedartists", method = RequestMethod.POST, produces="application/json")
    @ResponseBody
    public Object getLikedArtists(Model model, @RequestBody(required = true)String artists){
        FbArtists fbArtists;
        try {
             fbArtists = new ObjectMapper().readValue(artists, FbArtists.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
//        try {
//            JSONObject json = (JSONObject)new JSONParser() .parse(artists);
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
        System.out.println("Linked Artists: " + artists);
        /*List<String> liked_artists = new ArrayList<String>();

        liked_artists.add("Celtics");
        liked_artists.add("Cavaliers");
        liked_artists.add("Merphis");
        liked_artists.add("Lakers");
        liked_artists.add("Knicks");*/

        //List<ArtistWeight> artistWeight =  artistWeightService.getTopLikedArtists(liked_artist.getArtists());

        //return artistWeight;
        try {
            HTTPConnection.sendGet();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


   /* @ApiOperation(value = "Gets an existing ArtistWeight by Id", notes = "Returns a ArtistWeight for given id", response = ArtistWeight.class)
    @ApiResponses(value = {
            @ApiResponse(code = 404, message = "ArtistWeight was not found", response = ApiFault.class),  // TODO: Not implemented
            @ApiResponse(code = 200, message = "ArtistWeight was found and returned", response = ArtistWeight.class) })
    @Profile("ArtistWeightController#getArtistWeightById")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces="application/json")
    @ResponseBody
    public HttpEntity<ArtistWeight> getArtistWeightById(@ApiParam(name = "id", value = "Unique Indentifier", required = true) @PathVariable(value = "id") String id) {
        ArtistWeight artistWeight = artistWeightService.getArtistWeight(id);
        return new ResponseEntity<ArtistWeight>(artistWeight, getResponseHeadersForArtistWeight(artistWeight), HttpStatus.OK);
    }


    @ApiOperation(value = "Create new ArtistWeight", notes = "Creates new ArtistWeight")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Fields are with validation errors", response = ApiFault.class),  // TODO: Not implemented
            @ApiResponse(code = 201, message = "ArtistWeight was created") })
    @Profile("ArtistWeightController#createArtistWeight")
    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public HttpEntity<ArtistWeight> createArtistWeight(@ApiParam(name = "artistWeight", value = "User Location to Update", required = true) @RequestBody ArtistWeight artistWeight) {
        artistWeight = artistWeightService.createArtistWeight(artistWeight);
        return new ResponseEntity<ArtistWeight>(artistWeight, getResponseHeadersForArtistWeight(artistWeight), HttpStatus.CREATED);
    }

    @ApiOperation(value = "Updates an existing ArtistWeight", notes = "Updates ArtistWeight")
    @ApiResponses(value = {
            @ApiResponse(code = 404, message = "ArtistWeight to update was not found", response = ApiFault.class),  // TODO: Not implemented
            @ApiResponse(code = 400, message = "Fields are with validation errors", response = ApiFault.class),  // TODO: Not implemented
            @ApiResponse(code = 501, message = "Not implemented yet", response = ApiFault.class),  // TODO: Not implemented
            @ApiResponse(code = 204, message = "ArtistWeight was updated") })
    @Profile("ArtistWeightController#updateArtistWeight")
    @RequestMapping(method = RequestMethod.PUT)
    @ResponseBody
    public HttpEntity<Void> updateArtistWeight(@ApiParam(name = "artistWeight", value = "Updated User Location", required = true) @RequestBody ArtistWeight artistWeight) {
        artistWeightService.updateArtistWeight(artistWeight);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @ApiOperation(value = "Deletes an existing ArtistWeight", notes = "Deletes ArtistWeight")
    @ApiResponses(value = {
            @ApiResponse(code = 404, message = "ArtistWeight to delete was not found", response = ApiFault.class),  // TODO: Not implemented
            @ApiResponse(code = 501, message = "Not implemented yet", response = ApiFault.class),  // TODO: Not implemented
            @ApiResponse(code = 204, message = "ArtistWeight was deleted") })
    @Profile("ArtistWeightController#deleteArtistWeight")
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public HttpEntity<Void> deleteArtistWeight(@ApiParam(name = "id", value = "Unique Indentifier", required = true) @PathVariable(value = "id") String id) {
        artistWeightService.deleteArtistWeight(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
*/

}