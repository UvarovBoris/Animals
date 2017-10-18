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

    private static final String ANIMAL_TAB_KEY = "animalTab";

    @BindView(R.id.animals_tabs)
    TabLayout animalsTabs;

    private int animalsContentFragmentId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animals);

        ButterKnife.bind(this);

        animalsContentFragmentId = R.id.animals_content;

        if (getCurrentFragment() == null) {
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

    private Fragment getCurrentFragment() {
        return getSupportFragmentManager().findFragmentById(animalsContentFragmentId);
    }

    private void changeAnimalFragment(AnimalType animalType) {
        Fragment currentFragment = getCurrentFragment();
        Fragment newFragment = getSupportFragmentManager().findFragmentByTag(animalType.getName());
        if (newFragment == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .detach(currentFragment)
                    .replace(animalsContentFragmentId, AnimalsListFragment.newInstance(animalType), animalType.getName())
                    .commit();
        } else if (currentFragment != newFragment) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .detach(currentFragment)
                    .attach(newFragment)
                    .commit();
        }

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(ANIMAL_TAB_KEY, animalsTabs.getSelectedTabPosition());
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        animalsTabs.getTabAt(savedInstanceState.getInt(ANIMAL_TAB_KEY)).select();
    }
}
