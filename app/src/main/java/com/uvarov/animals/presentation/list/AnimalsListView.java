package com.uvarov.animals.presentation.list;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;
import com.uvarov.domain.models.Animal;

import java.util.List;

public interface AnimalsListView extends MvpView {

    @StateStrategyType(AddToEndSingleStrategy.class)
    void showAnimalsList(List<Animal> animals);

}