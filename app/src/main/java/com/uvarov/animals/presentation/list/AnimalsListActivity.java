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

        Fragment currentFragment = getSupportFragmentManager().findFragmentById(animalsContentFragmentId);
        if (currentFragment == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(animalsContentFragmentId, AnimalsListFragment.newInstance(CAT), CAT.getName())
                    .commit();
        }

        animalsTabs.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if (tab.getText().equals(getString(R.string.cats))) {
                    changeAnimalFragment(CAT);
                } else if (tab.getText().equals(getString(R.string.dogs))) {
                    changeAnimalFragment(DOG);
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

    private void changeAnimalFragment(AnimalType animalType) {
        Fragment currentFragment = getSupportFragmentManager().findFragmentById(animalsContentFragmentId);
        Fragment newFragment = getSupportFragmentManager().findFragmentByTag(animalType.getName());
//        if (currentFragment == null) {
//            getSupportFragmentManager()
//                    .beginTransaction()
//                    .add(animalsContentFragmentId, AnimalsListFragment.newInstance(animalType), animalType.getName())
//                    .commit();
//        } else
        if (newFragment == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .detach(currentFragment)
                    .replace(animalsContentFragmentId, AnimalsListFragment.newInstance(animalType), animalType.getName())
                    .commit();
        } else {
            getSupportFragmentManager()
                    .beginTransaction()
                    .detach(currentFragment)
                    .attach(newFragment)
                    .commit();
        }

    }

}
