package com.thinknear.attribution.web.service;

import java.util.concurrent.Future;

import org.springframework.util.concurrent.ListenableFuture;

import com.thinknear.attribution.web.model.UserLocation;

/**
 * Created by kennethr on 4/9/15.
 */
public interface UserLocationService {
    UserLocation getUserLocation(String id);
    ListenableFuture<UserLocation> getUserLocationAsync(String id) throws InterruptedException;
    UserLocation createUserLocation(UserLocation userLocation);
    void updateUserLocation(UserLocation userLocation);
    void deleteUserLocation(String id);
}
