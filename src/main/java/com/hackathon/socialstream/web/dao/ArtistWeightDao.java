package com.hackathon.socialstream.web.dao;

import java.util.List;

import com.hackathon.socialstream.web.model.ArtistWeight;

/**
 * Created by kennethr on 4/9/15.
 */
public interface ArtistWeightDao {
    //ArtistWeight createArtistWeight(ArtistWeight artistWeight);
    public List<ArtistWeight> getTopTenArtists();
    /*boolean updateArtistWeight(ArtistWeight artistWeight);
    boolean deleteArtistWeight(String id);
    ArtistWeight findArtistWeightById(String id);
    List<ArtistWeight> findArtistWeightsByUserId(String userId);*/
}
