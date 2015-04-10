package com.thinknear.attribution.web.service;

import com.thinknear.attribution.web.model.UserLocation;

/**
 * Created by kennethr on 4/9/15.
 */
public interface UserLocationService {
    UserLocation getUserLocation(String id);
    UserLocation createUserLocation(UserLocation userLocation);
    void updateUserLocation(UserLocation userLocation);
    void deleteUserLocation(String id);
}
