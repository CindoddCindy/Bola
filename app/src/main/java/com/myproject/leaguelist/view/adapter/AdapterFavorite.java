package com.myproject.leaguelist.view.adapter;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class AdapterFavorite extends RecyclerView.Adapter<AdapterFavorite.AdapterFavoriteChild> {

    @NonNull
    @Override
    public AdapterFavoriteChild onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterFavoriteChild holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public  class  AdapterFavoriteChild extends RecyclerView.ViewHolder{

        public AdapterFavoriteChild(@NonNull View itemView) {
            super(itemView);
        }
    }
}
