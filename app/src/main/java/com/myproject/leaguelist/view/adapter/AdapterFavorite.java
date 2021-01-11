package com.myproject.leaguelist.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.myproject.leaguelist.R;
import com.myproject.leaguelist.pojo.LeaguePojo;

import java.util.List;

public class AdapterFavorite extends RecyclerView.Adapter<AdapterFavorite.AdapterFavoriteChild> {

    public Context context;
    public List<LeaguePojo> leaguePojoList;

    public AdapterFavorite(Context context, List<LeaguePojo>leaguePojos){
        this.context=context;
        this.leaguePojoList=leaguePojos;
    }

    @NonNull
    @Override
    public AdapterFavoriteChild onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.leaguesqlite, parent, false);
        AdapterFavoriteChild adapterFavoriteChild = new AdapterFavoriteChild(mView);

        return adapterFavoriteChild;

    }

    @Override
    public void onBindViewHolder(@NonNull AdapterFavoriteChild holder, int position) {
        final LeaguePojo leaguePojo=leaguePojoList.get(position);


        holder.textView_league.setText(leaguePojo.getLeague());
        holder.textView_sport.setText(leaguePojo.getSport());
        holder.textView_alternate.setText(leaguePojo.getAlternate());


    }

    @Override
    public int getItemCount() {
        return leaguePojoList.size();
    }

    public  class  AdapterFavoriteChild extends RecyclerView.ViewHolder{

        private TextView textView_league,textView_sport, textView_alternate;

        public AdapterFavoriteChild(@NonNull View itemView) {
            super(itemView);
            textView_league = itemView.findViewById(R.id.tv_league_sqlite_adapter);
            textView_sport = itemView.findViewById(R.id.tv_sport_sqlite_adapter);
            textView_alternate = itemView.findViewById(R.id.tv_alternate_sqlite_adapter);

        }
    }
}
