package com.uvarov.animals;

import android.app.Application;

import com.uvarov.animals.di.AppDaggerComponent;
import com.uvarov.animals.di.DaggerAppDaggerComponent;

public class AnimalsApplication extends Application {

    private AppDaggerComponent appDaggerComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        appDaggerComponent = DaggerAppDaggerComponent.builder().build();
    }

    public AppDaggerComponent getAppDaggerComponent() {
        return appDaggerComponent;
    }
}
