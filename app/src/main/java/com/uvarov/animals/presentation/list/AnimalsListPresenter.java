package com.uvarov.animals.presentation.list;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.uvarov.domain.models.Animal;
import com.uvarov.domain.models.AnimalType;
import com.uvarov.domain.models.AnimalsInteractor;

import java.util.ArrayList;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

@InjectViewState
public class AnimalsListPresenter extends MvpPresenter<AnimalsListView> {

    @Inject
    AnimalsInteractor animalsInteractor;

    private CompositeDisposable disposable = new CompositeDisposable();

    private AnimalType animalType;

    @Inject
    public AnimalsListPresenter() {
    }

    protected void loadAnimals() {
        disposable.add(animalsInteractor.requestAnimals(animalType)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<ArrayList<Animal>>() {
                    @Override
                    public void accept(ArrayList<Animal> animals) throws Exception {
                        getViewState().showAnimalsList(animals);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        getViewState().showAnimalsLoadingError();
                    }
                })
        );
    }

    public void setAnimalType(AnimalType animalType) {
        this.animalType = animalType;
    }

    @Override
    public void onDestroy() {
        disposable.dispose();
    }
}
