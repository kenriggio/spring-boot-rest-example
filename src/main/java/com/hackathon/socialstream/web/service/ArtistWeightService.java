package com.hackathon.socialstream.web.service;

import java.util.concurrent.Future;

import org.springframework.util.concurrent.ListenableFuture;

import com.hackathon.socialstream.web.model.ArtistWeight;

/**
 * Created by kennethr on 4/9/15.
 */
public interface ArtistWeightService {
    ArtistWeight getArtistWeight(String id);
    ListenableFuture<ArtistWeight> getArtistWeightAsync(String id) throws InterruptedException;
    ArtistWeight createArtistWeight(ArtistWeight artistWeight);
    void updateArtistWeight(ArtistWeight artistWeight);
    void deleteArtistWeight(String id);
}
