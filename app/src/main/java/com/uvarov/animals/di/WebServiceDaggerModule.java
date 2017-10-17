package com.uvarov.animals.di;

import com.uvarov.domain.WebService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class WebServiceDaggerModule {

    @Provides
    @Singleton
    WebService provideWebService() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://kot3.com/xim/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        return retrofit.create(WebService.class);
    }
}
