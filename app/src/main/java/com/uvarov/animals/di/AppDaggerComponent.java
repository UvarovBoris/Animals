package com.uvarov.animals.di;

import com.uvarov.animals.AnimalsFragment;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {WebServiceDaggerModule.class})
public interface AppDaggerComponent {

    void inject(AnimalsFragment fragment);
}
