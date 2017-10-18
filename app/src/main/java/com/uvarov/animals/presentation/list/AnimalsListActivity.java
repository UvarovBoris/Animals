package com.uvarov.animals.presentation.list;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import com.uvarov.animals.R;

public class AnimalsListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animals);

        int animalsFragmentId = R.id.animalsContent;

        Fragment fragment = getSupportFragmentManager().findFragmentById(animalsFragmentId);
        if (fragment == null) {
            fragment = new AnimalsListFragment();
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(animalsFragmentId, fragment)
                    .commit();
        }

    }
}
