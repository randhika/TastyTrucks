package com.kirussell.tastytrucks.location;

import android.location.Location;

/**
 * Created by russellkim on 08/04/16.
 */
public interface LocationProvider {

    void onStart();
    void onStop();
    Location getLastLocation();
}
