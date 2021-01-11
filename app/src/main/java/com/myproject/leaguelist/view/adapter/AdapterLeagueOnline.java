package com.myproject.leaguelist.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.myproject.leaguelist.R;
import com.myproject.leaguelist.pojo.League;

import java.util.List;

public class AdapterLeagueOnline extends RecyclerView.Adapter<AdapterLeagueOnline.OnlineAdapterChild> {

    Context context;
    List<League> leagueList;

    public AdapterLeagueOnline(Context context, List<League> leagueList){
        this.context=context;
        this.leagueList=leagueList;
    }

    @NonNull
    @Override
    public OnlineAdapterChild onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.league_api, parent, false);
        OnlineAdapterChild mViewHolder = new OnlineAdapterChild(mView);


        return mViewHolder;


    }

    @Override
    public void onBindViewHolder(@NonNull OnlineAdapterChild holder, int position) {
        holder.textView_league.setText(String.valueOf(leagueList.get(position).getStrLeague()));
        holder.textView_sport.setText(String.valueOf(leagueList.get(position).getStrSport()));
        holder.textView_alternate.setText(String.valueOf(leagueList.get(position).getStrLeagueAlternate()));

        holder.cardView_list_league.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });



    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class OnlineAdapterChild extends RecyclerView.ViewHolder{

        private TextView textView_league, textView_sport, textView_alternate;

        private CardView cardView_list_league;


        public OnlineAdapterChild(@NonNull View itemView) {
            super(itemView);

            textView_league=itemView.findViewById(R.id.tv_league_api);
            textView_sport=itemView.findViewById(R.id.tv_sport_api);
            textView_alternate=itemView.findViewById(R.id.tv_alternate_api);
            cardView_list_league=itemView.findViewById(R.id.cv_league);
        }
    }
}
