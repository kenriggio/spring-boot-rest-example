package com.thinknear.attribution.web.dao.logfile;

import com.thinknear.attribution.web.dao.UserLocationDao;
import com.thinknear.attribution.web.model.UserLocation;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.List;

/**
 * Created by kennethr on 4/9/15.
 */
public class UserLocationDaoImpl implements UserLocationDao {

    public UserLocationDaoImpl() {
    }

    @Override
    public UserLocation createUserLocation(UserLocation userLocation) {
        userLocation.setUserLocationId("postId");
        return userLocation;
    }

    @Override
    public boolean updateUserLocation(UserLocation userLocation) {
        throw new NotImplementedException();
    }

    @Override
    public boolean deleteUserLocation(String id) {
        throw new NotImplementedException();
    }

    @Override
    public UserLocation findUserLocationById(String id) {
        UserLocation userLocation = new UserLocation();
        userLocation.setUserLocationId(id);
        userLocation.setUserId("userId");
        userLocation.setLat("1");
        userLocation.setLon("2");
        return userLocation;
    }

    @Override
    public List<UserLocation> findUserLocationsByUserId(String userId) {
        throw new NotImplementedException();
    }
}
