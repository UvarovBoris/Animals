package com.uvarov.animals.presentation;

import com.arellomobile.mvp.MvpView;
import com.uvarov.domain.models.Animal;

import java.util.List;

public interface AnimalsView extends MvpView {

    void showAnimalsList(List<Animal> animals);

}