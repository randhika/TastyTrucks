package com.kirussell.tastytrucks.location;

import android.location.Location;

import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.model.LatLng;

/**
 * Created by russellkim on 06/04/16.
 * Google api location provider
 */
public class GoogleLocationProvider implements LocationProvider {

    private final GoogleApiClientHost googleApiClientHost;
    private LatLng lastLocation;

    GoogleLocationProvider(GoogleApiClientHost googleApiClientHost) {
        this.googleApiClientHost = googleApiClientHost;
    }

    @Override
    public void onStart() {
        googleApiClientHost.onStart();
    }

    @Override
    public void onStop() {
        googleApiClientHost.onStop();
    }

    @Override
    public LatLng getLastLocation() {
        //noinspection ResourceType
        Location location = LocationServices.FusedLocationApi.getLastLocation(googleApiClientHost.getGoogleApiClient());
        if (location != null) {
            lastLocation = new LatLng(location.getLatitude(), location.getLongitude());
        }
        return lastLocation;
    }
}
