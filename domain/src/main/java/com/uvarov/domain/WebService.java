package com.uvarov.domain;

import com.uvarov.domain.models.ApiResponse;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

public interface WebService {

    @GET("api.php")
    Observable<ApiResponse> getAnimals(@QueryMap String query);
}
