package com.uvarov.animals.presentation;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.uvarov.animals.AnimalsApplication;
import com.uvarov.animals.R;
import com.uvarov.domain.models.AnimalType;

import javax.inject.Inject;

import butterknife.ButterKnife;

public class AnimalsFragment extends MvpAppCompatFragment implements AnimalsView {

    @Inject
    @InjectPresenter
    AnimalsPresenter animalsPresenter;

    @ProvidePresenter
    AnimalsPresenter provideAnimalsPresenter() {
        animalsPresenter.setAnimalType(AnimalType.CAT);
        return animalsPresenter;
    }

    @Override
    public void onCreate(Bundle saveState) {
        ((AnimalsApplication) getActivity().getApplication()).getAppDaggerComponent().inject(this);
        super.onCreate(saveState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_animals, container, false);

        ButterKnife.bind(this, view);

        return view;
    }
}
