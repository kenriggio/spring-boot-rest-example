package com.hackathon.socialstream.web.dao;

import com.hackathon.socialstream.web.model.ArtistWeight;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by lovebisaria on 11/24/15.
 */
public class ArtistWeightRowMapper  implements RowMapper {

    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
        ArtistWeight artistWeight = new ArtistWeight();
        artistWeight.setArtistWeightId(rs.getString("artist_weight_id"));
        artistWeight.setName(rs.getString("name"));
        artistWeight.setAttractionId(rs.getString("AGE"));
        artistWeight.setWeight(rs.getInt("attraction_id"));
        return artistWeight;
    }
}
