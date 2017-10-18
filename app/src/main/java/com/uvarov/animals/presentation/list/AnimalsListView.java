package com.uvarov.animals.presentation.list;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.SkipStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;
import com.uvarov.domain.models.Animal;

import java.util.ArrayList;

@StateStrategyType(SkipStrategy.class)
public interface AnimalsListView extends MvpView {

    //@StateStrategyType(AddToEndSingleStrategy.class)
    void showAnimalsList(ArrayList<Animal> animals);

    //@StateStrategyType(SkipStrategy.class)
    void showAnimalsLoadingError();
}