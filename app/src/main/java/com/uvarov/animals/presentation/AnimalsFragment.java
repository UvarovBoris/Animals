package com.uvarov.animals.presentation;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.uvarov.animals.AnimalsApplication;
import com.uvarov.animals.R;
import com.uvarov.domain.models.Animal;
import com.uvarov.domain.models.AnimalType;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AnimalsFragment extends MvpAppCompatFragment implements AnimalsView {

    @Inject
    @InjectPresenter
    AnimalsPresenter animalsPresenter;

    @BindView(R.id.animalsRecyclerView)
    protected RecyclerView animalsRecyclerView;

    private AnimalsAdapter animalsAdapter;

    @ProvidePresenter
    AnimalsPresenter provideAnimalsPresenter() {
        animalsPresenter.setAnimalType(AnimalType.CAT);
        return animalsPresenter;
    }

    @Override
    public void onCreate(Bundle saveState) {
        ((AnimalsApplication) getActivity().getApplication()).getAppDaggerComponent().inject(this);
        super.onCreate(saveState);
        animalsAdapter = new AnimalsAdapter(getContext(), new ArrayList<Animal>());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_animals, container, false);

        ButterKnife.bind(this, view);

        animalsRecyclerView.setHasFixedSize(true);
        animalsRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        animalsRecyclerView.setAdapter(animalsAdapter);

        return view;
    }

    @Override
    public void showAnimalsList(List<Animal> animals) {
        animalsAdapter.setAnimals(animals);
        animalsAdapter.notifyDataSetChanged();
    }
}
