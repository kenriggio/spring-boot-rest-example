package com.hackathon.socialstream.web.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;

import com.hackathon.socialstream.annotation.Profile;
import com.hackathon.socialstream.annotation.Throwit;
import com.hackathon.socialstream.web.dao.ArtistWeightDao;
import com.hackathon.socialstream.web.model.ArtistWeight;
import com.hackathon.socialstream.web.service.ArtistWeightService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@Service
public class ArtistWeightServiceImpl implements ArtistWeightService {

    static final Logger logger = LoggerFactory.getLogger(ArtistWeightServiceImpl.class);

    private ArtistWeightDao artistWeightDao;

    @Autowired
    public ArtistWeightServiceImpl(ArtistWeightDao artistWeightDao) {
        this.artistWeightDao = artistWeightDao;
    }

   /* @Override
    @Profile("ArtistWeightServiceImpl#getArtistWeight")
    @Throwit
    public ArtistWeight getArtistWeight(String id) {
    	//Thread.sleep(75);
        return artistWeightDao.findArtistWeightById(id);
    }

    @Override
    @Profile("ArtistWeightServiceImpl#createArtistWeight")
    @Throwit
    public ArtistWeight createArtistWeight(ArtistWeight artistWeight) {
        return artistWeightDao.createArtistWeight(artistWeight);
    }

    @Override
    @Profile("ArtistWeightServiceImpl#updateArtistWeight")
    @Throwit
    public void updateArtistWeight(ArtistWeight artistWeight) {
        if (!artistWeightDao.updateArtistWeight(artistWeight)) {
            // TODO: do something
        }

    }

    @Override
    @Profile("ArtistWeightServiceImpl#deleteArtistWeight")
    @Throwit
    public void deleteArtistWeight(String id) {
        if (!artistWeightDao.deleteArtistWeight(id)) {
            // TODO: do something
        }
    }

	@Override
	@Profile("ArtistWeightServiceImpl#getArtistWeightAsync")
	public ListenableFuture<ArtistWeight> getArtistWeightAsync(String id) throws InterruptedException {
		ArtistWeight artistWeight = artistWeightDao.findArtistWeightById(id);
		return new AsyncResult<ArtistWeight>(artistWeight);
	}*/

    @Override
    public List<ArtistWeight> getTopArtists(){
        List<ArtistWeight> artistWeight = artistWeightDao.getTopTenArtists();

        return artistWeight;
    }

}