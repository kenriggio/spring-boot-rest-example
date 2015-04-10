package com.thinknear.attribution.web.dao;

import com.thinknear.attribution.web.model.UserLocation;
import java.util.List;

/**
 * Created by kennethr on 4/9/15.
 */
public interface UserLocationDao {
    UserLocation createUserLocation(UserLocation userLocation);
    boolean updateUserLocation(UserLocation userLocation);
    boolean deleteUserLocation(String id);
    UserLocation findUserLocationById(String id);
    List<UserLocation> findUserLocationsByUserId(String userId);
}
