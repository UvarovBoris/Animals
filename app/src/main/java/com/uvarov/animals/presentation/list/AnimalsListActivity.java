package com.uvarov.animals.presentation.list;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import com.uvarov.animals.R;
import com.uvarov.domain.models.AnimalType;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.uvarov.domain.models.AnimalType.CAT;
import static com.uvarov.domain.models.AnimalType.DOG;

public class AnimalsListActivity extends AppCompatActivity {

    @BindView(R.id.animals_tabs)
    TabLayout animalsTabs;

    private int animalsContentFragmentId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animals);

        ButterKnife.bind(this);

        animalsContentFragmentId = R.id.animals_content;

        Fragment fragment = getSupportFragmentManager().findFragmentById(animalsContentFragmentId);
        if (fragment == null) {
            fragment = AnimalsListFragment.newInstance(CAT);
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(animalsContentFragmentId, fragment, CAT.getName())
                    .commit();
        }

        animalsTabs.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if (tab.getText().equals(getString(R.string.cats))) {
                    showAnimalFragment(CAT);
                } else if (tab.getText().equals(getString(R.string.dogs))) {
                    showAnimalFragment(DOG);
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });
    }

    private void showAnimalFragment(AnimalType animalType) {
        AnimalsListFragment fragment = AnimalsListFragment.newInstance(animalType);
        getSupportFragmentManager()
                .beginTransaction()
                .replace(animalsContentFragmentId, fragment, animalType.getName())
                .commit();
    }

}
