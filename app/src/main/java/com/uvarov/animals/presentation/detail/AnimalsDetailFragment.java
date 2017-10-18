package com.uvarov.animals.presentation.detail;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.uvarov.animals.R;
import com.uvarov.domain.models.Animal;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AnimalsDetailFragment extends Fragment {

    private static final String ANIMAL_KEY = "animal";

    @BindView(R.id.avatar)
    ImageView avatar;
    @BindView(R.id.id_text_view)
    TextView idTextView;
    @BindView(R.id.title_text_view)
    TextView titleTextView;

    public static AnimalsDetailFragment newInstance(Animal animal) {
        AnimalsDetailFragment fragment = new AnimalsDetailFragment();
        Bundle args = new Bundle();
        args.putSerializable(ANIMAL_KEY, animal);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_animals_detail, container, false);

        ButterKnife.bind(this, view);

        Bundle args = getArguments();
        Animal animal = (Animal) args.getSerializable(ANIMAL_KEY);

        Picasso.with(getContext())
                .load(animal.getUrl())
                .into(avatar);

        idTextView.setText(String.valueOf(animal.getId()));

        titleTextView.setText(animal.getTitle());

        return view;
    }

}
