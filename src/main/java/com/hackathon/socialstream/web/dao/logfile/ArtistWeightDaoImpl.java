package com.hackathon.socialstream.web.dao.logfile;

import com.google.common.collect.ImmutableMap;
import com.hackathon.socialstream.web.dao.ArtistWeightDao;
import com.hackathon.socialstream.web.dao.ArtistWeightRowMapper;
import com.hackathon.socialstream.web.model.ArtistWeight;


import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import javax.inject.Inject;
import javax.sql.DataSource;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by kennethr on 4/9/15.
 */
public class ArtistWeightDaoImpl implements ArtistWeightDao {

	@Inject
	private DataSource dataSource;

    
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

    private static String TOP10ARTIST = "SELECT * FROM Artist_Weight ORDER BY weight DESC LIMIT 10";
    private static String TOP3LIKEDARTISTS = "SELECT * FROM (SELECT *  FROM `Artist_Weight`where artist_name IN (";
    private static String TOP3LIKEDARTIST1 = ") )as res ORDER by res.weight DESC LIMIT 3";
    //private static String TOP3LIKEDARTISTS = "SELECT * FROM (SELECT *  FROM `Artist_Weight`where artist_name IN ( :artist_name ) )as res ORDER by res.weight DESC LIMIT 3";



    @Override
    public List<ArtistWeight> getTopTenArtists(){

    	jdbcTemplate = new JdbcTemplate(dataSource);
    	List<ArtistWeight> artistWeight = jdbcTemplate.query(ArtistWeightDaoImpl.TOP10ARTIST, new ArtistWeightRowMapper());

        return artistWeight;
    }

    @Override
    public List<ArtistWeight> getTopLikedArtists(List<String> artists){

        System.out.println("Artists at ArtistsWeightDaoImpl: " + artists.toString());
        String query = TOP3LIKEDARTISTS + getQueryString(artists) + TOP3LIKEDARTIST1;

        System.out.println("Query is: " + query);

        Map<String, Object> params = (new ImmutableMap.Builder<String, Object>())
                                       .put("artist_name", artists)
                                       .build();
        try {
            //List<ArtistWeight> artistWeight = (List<ArtistWeight>) jdbcTemplate.queryForObject(ArtistWeightDaoImpl.TOP3LIKEDARTISTS, new ArtistWeightRowMapper(), params);
            List<ArtistWeight> artistWeight = jdbcTemplate.query(query, new ArtistWeightRowMapper());

            //FSSClient.getFSSData();
            return artistWeight;
        }
        catch(Exception e){
            System.out.println("Error in query for Object!!");
            System.out.println(e.getMessage());
            return null;
        }

    }

    private String getQueryString(List<String> artists) {
        StringBuffer query = new StringBuffer();
        for(int i=0;i<artists.size();i++){
            if(i == artists.size()-1) {
                System.out.println("Last position" + artists.get(i));
                query.append("'" + artists.get(i) + "'");
            }else{
                System.out.println("Other postion: " + artists.get(i));
                query.append("'" + artists.get(i) + "',");
            }
        }
        System.out.println("Final Query: " + query.toString());
        return query.toString();
    }

}
