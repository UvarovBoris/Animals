package com.uvarov.animals.presentation.detail;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.uvarov.animals.R;
import com.uvarov.domain.models.Animal;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AnimalsDetailActivity extends AppCompatActivity {

    private static final String ANIMAL_KEY = "animal";

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    public static Intent newIntent(Context context, Animal animal) {
        Intent intent = new Intent(context, AnimalsDetailActivity.class);
        intent.putExtra(ANIMAL_KEY, animal);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animals_detail);
        ButterKnife.bind(this);

        Animal animal = (Animal) getIntent().getSerializableExtra(ANIMAL_KEY);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(animal.getTitle());

        int animalsDetailContentId = R.id.animals_detail_content;
        Fragment fragment = getSupportFragmentManager().findFragmentById(animalsDetailContentId);
        if (fragment == null) {
            fragment = AnimalsDetailFragment.newInstance(animal);
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(animalsDetailContentId, fragment)
                    .commit();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
