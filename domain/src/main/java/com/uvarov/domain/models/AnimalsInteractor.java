package com.uvarov.domain.models;

import com.uvarov.domain.WebService;

import java.util.ArrayList;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;

public class AnimalsInteractor {

    @Inject
    WebService service;

    @Inject
    public AnimalsInteractor() {
    }

    public Observable<ArrayList<Animal>> requestAnimals(AnimalType animalType) {
        return service.getAnimals(animalType.getName())
                .flatMap(new Function<ApiResponse, ObservableSource<ArrayList<Animal>>>() {
                    @Override
                    public ObservableSource<ArrayList<Animal>> apply(@NonNull ApiResponse apiResponse) throws Exception {
                        for(int i = 0; i < apiResponse.getData().size(); i++) {
                            apiResponse.getData().get(i).setId(i + 1);
                        }
                        return Observable.just(apiResponse.getData());
                    }
                });
    }
}
