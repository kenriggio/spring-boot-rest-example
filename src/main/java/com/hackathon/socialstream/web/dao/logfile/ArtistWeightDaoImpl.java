package com.hackathon.socialstream.web.dao.logfile;

import com.hackathon.socialstream.web.dao.ArtistWeightDao;
import com.hackathon.socialstream.web.model.ArtistWeight;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.List;

/**
 * Created by kennethr on 4/9/15.
 */
public class ArtistWeightDaoImpl implements ArtistWeightDao {

    public ArtistWeightDaoImpl() {
    }

    @Override
    public ArtistWeight createArtistWeight(ArtistWeight ArtistWeight) {
        ArtistWeight.setArtistWeightId("postId");
        return ArtistWeight;
    }

    @Override
    public boolean updateArtistWeight(ArtistWeight ArtistWeight) {
        throw new NotImplementedException();
    }

    @Override
    public boolean deleteArtistWeight(String id) {
        throw new NotImplementedException();
    }

    @Override
    public ArtistWeight findArtistWeightById(String id) {
        ArtistWeight ArtistWeight = new ArtistWeight();
        ArtistWeight.setArtistWeightId(id);
        ArtistWeight.setAttractionId("attractionId");
        ArtistWeight.setName("name");
        ArtistWeight.setWeight("2");
        return ArtistWeight;
    }

    @Override
    public List<ArtistWeight> findArtistWeightsByUserId(String userId) {
        throw new NotImplementedException();
    }


}
