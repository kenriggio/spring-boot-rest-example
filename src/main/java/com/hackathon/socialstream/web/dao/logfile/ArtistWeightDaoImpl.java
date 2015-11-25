package com.hackathon.socialstream.web.dao.logfile;

import com.hackathon.socialstream.web.dao.ArtistWeightDao;
import com.hackathon.socialstream.web.dao.ArtistWeightRowMapper;
import com.hackathon.socialstream.web.model.ArtistWeight;

import org.springframework.jdbc.core.JdbcTemplate;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by kennethr on 4/9/15.
 */
public class ArtistWeightDaoImpl implements ArtistWeightDao {

    @Inject
    private JdbcTemplate jdbcTemplate;
    public ArtistWeightDaoImpl() {
    }

    /*@Override
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
*/

    private static String TOP10ARTIST = "SELECT * FROM Artist_Weight ORDER BY weight DESC LIMIT 5";

    @Override
    public List<ArtistWeight> getTopTenArtists(){

    List<ArtistWeight> artistWeight = jdbcTemplate.query(ArtistWeightDaoImpl.TOP10ARTIST, new ArtistWeightRowMapper());

        return artistWeight;
    }

}
