package com.thinknear.attribution.web.service.impl;

import java.util.concurrent.Future;

import com.thinknear.attribution.annotation.Profile;
import com.thinknear.attribution.annotation.Throwit;
import com.thinknear.attribution.web.service.UserLocationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;

import com.thinknear.attribution.web.model.UserLocation;
import com.thinknear.attribution.web.dao.UserLocationDao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class UserLocationServiceImpl implements UserLocationService {

    static final Logger logger = LoggerFactory.getLogger(UserLocationServiceImpl.class);

    private UserLocationDao userLocationDao;

    @Autowired
    public UserLocationServiceImpl(UserLocationDao userLocationDao) {
        this.userLocationDao = userLocationDao;
    }

    @Override
    @Profile("UserLocationServiceImpl#getUserLocation")
    @Throwit
    public UserLocation getUserLocation(String id) {
    	//Thread.sleep(75);
        return userLocationDao.findUserLocationById(id);
    }

    @Override
    @Profile("UserLocationServiceImpl#createUserLocation")
    @Throwit
    public UserLocation createUserLocation(UserLocation userLocation) {
        return userLocationDao.createUserLocation(userLocation);
    }

    @Override
    @Profile("UserLocationServiceImpl#updateUserLocation")
    @Throwit
    public void updateUserLocation(UserLocation userLocation) {
        if (!userLocationDao.updateUserLocation(userLocation)) {
            // TODO: do something
        }

    }

    @Override
    @Profile("UserLocationServiceImpl#deleteUserLocation")
    @Throwit
    public void deleteUserLocation(String id) {
        if (!userLocationDao.deleteUserLocation(id)) {
            // TODO: do something
        }
    }

	@Override
	@Profile("UserLocationServiceImpl#getUserLocationAsync")
	public ListenableFuture<UserLocation> getUserLocationAsync(String id) throws InterruptedException {
		UserLocation userLocation = userLocationDao.findUserLocationById(id);
		return new AsyncResult<UserLocation>(userLocation);
	}
}