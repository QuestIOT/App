package com.dan.myapp;
import com.firebase.client.Firebase;
/**
 * Created by dan_1 on 17-Mar-16.
 */
public class CrowdWeather extends android.app.Application {

    @Override
    public void onCreate(){
        super.onCreate();
        Firebase.setAndroidContext(this);
    }
}
