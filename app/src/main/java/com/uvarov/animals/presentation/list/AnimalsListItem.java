package com.uvarov.animals.presentation.list;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.uvarov.animals.R;
import com.uvarov.animals.presentation.detail.AnimalsDetailActivity;
import com.uvarov.domain.models.Animal;

import butterknife.BindView;
import butterknife.ButterKnife;

class AnimalListItem extends RecyclerView.ViewHolder {

    @BindView(R.id.avatar)
    ImageView avatarImageView;

    @BindView(R.id.id_text_view)
    TextView idTextView;

    @BindView(R.id.title_text_view)
    TextView titleTextView;

    private Context context;

    public AnimalListItem(Context context, View root) {
        super(root);
        this.context = context;

        ButterKnife.bind(this, itemView);
    }

    public void onBindViewHolder(final Animal animal) {

        idTextView.setText(String.valueOf(animal.getId()));
        titleTextView.setText(animal.getTitle());

        Picasso.with(context)
                .load(animal.getUrl())
                .into(avatarImageView);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                context.startActivity(AnimalsDetailActivity.newIntent(context, animal));
            }
        });
    }

}