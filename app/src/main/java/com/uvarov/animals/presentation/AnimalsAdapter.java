package com.uvarov.animals.presentation;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.uvarov.animals.R;
import com.uvarov.domain.models.Animal;

import java.util.List;

class AnimalsAdapter extends RecyclerView.Adapter<AnimalListItem> {

    private Context context;
    private List<Animal> animals;

    public AnimalsAdapter(Context context, List<Animal> animals) {
        this.context = context;
        this.animals = animals;
    }

    public void setAnimals(List<Animal> animals) {
        this.animals = animals;
    }

    @Override
    public int getItemCount() {
        return animals.size();
    }

    @Override
    public AnimalListItem onCreateViewHolder(ViewGroup parent, int viewType) {
        return new AnimalListItem(context, LayoutInflater.from(parent.getContext()).inflate(R.layout.animal_item, parent, false));
    }

    @Override
    public void onBindViewHolder(AnimalListItem holder, int position) {
        holder.onBindViewHolder(animals.get(position));
    }
}