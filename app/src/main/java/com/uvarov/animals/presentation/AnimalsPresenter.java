package com.uvarov.animals.presentation;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.uvarov.domain.models.AnimalType;
import com.uvarov.domain.models.AnimalsInteractor;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

@InjectViewState
public class AnimalsPresenter extends MvpPresenter<AnimalsView> {

    @Inject
    AnimalsInteractor animalsInteractor;

    private AnimalType animalType;

    @Inject
    public AnimalsPresenter() {
    }

    @Override
    protected void onFirstViewAttach() {
        animalsInteractor.requestAnimals(animalType)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe();

    }

    public void setAnimalType(AnimalType animalType) {
        this.animalType = animalType;
    }
}
