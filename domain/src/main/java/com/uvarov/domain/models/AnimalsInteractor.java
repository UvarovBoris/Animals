package com.uvarov.domain.models;

import com.uvarov.domain.WebService;

import java.util.List;

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

    public Observable<List<Animal>> requestAnimals(AnimalType animalType) {
        return service.getAnimals(animalType.getApiKey())
                .flatMap(new Function<ApiResponse, ObservableSource<List<Animal>>>() {
                    @Override
                    public ObservableSource<List<Animal>> apply(@NonNull ApiResponse apiResponse) throws Exception {
                        return Observable.just(apiResponse.getData());
                    }
                });
    }
}
