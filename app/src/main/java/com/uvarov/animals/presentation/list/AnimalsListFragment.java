package com.uvarov.animals.presentation.list;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

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

public class AnimalsListFragment extends MvpAppCompatFragment implements AnimalsListView {

    private static final String ANIMAL_TYPE_KEY = "animalType";

    @Inject
    @InjectPresenter
    AnimalsListPresenter animalsListPresenter;

    @BindView(R.id.animalsRecyclerView)
    protected RecyclerView animalsRecyclerView;

    private AnimalsListAdapter animalsListAdapter;

    @ProvidePresenter
    AnimalsListPresenter provideAnimalsPresenter() {
        animalsListPresenter.setAnimalType((AnimalType) getArguments().getSerializable(ANIMAL_TYPE_KEY));
        return animalsListPresenter;
    }

    public static AnimalsListFragment newInstance(AnimalType animalType) {
        AnimalsListFragment fragment = new AnimalsListFragment();

        Bundle args = new Bundle();
        args.putSerializable(ANIMAL_TYPE_KEY, animalType);
        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public void onCreate(Bundle saveState) {
        ((AnimalsApplication) getActivity().getApplication()).getAppDaggerComponent().inject(this);
        super.onCreate(saveState);
        animalsListAdapter = new AnimalsListAdapter(getContext(), new ArrayList<Animal>());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_animals, container, false);

        ButterKnife.bind(this, view);

        animalsRecyclerView.setHasFixedSize(true);
        animalsRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        animalsRecyclerView.setAdapter(animalsListAdapter);

        return view;
    }

    @Override
    public void showAnimalsList(List<Animal> animals) {
        animalsListAdapter.setAnimals(animals);
        animalsListAdapter.notifyDataSetChanged();
    }

    @Override
    public void showAnimalsLoadingError() {
        Toast.makeText(getActivity(), getString(R.string.animalsLoadingError), Toast.LENGTH_LONG).show();
    }
}
