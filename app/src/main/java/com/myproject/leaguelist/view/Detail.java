package com.myproject.leaguelist.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.myproject.leaguelist.R;

public class Detail extends AppCompatActivity {

    private TextView textView_league,textView_sport, textView_alternate;
    private Button button_save_fav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        textView_league = findViewById(R.id.tv_league_sqlite);
        textView_sport = findViewById(R.id.tv_sport_sqlite);
        textView_alternate = findViewById(R.id.tv_alternate_sqlite);
        button_save_fav = findViewById(R.id.add_to_fav);

        if (getIntent().getExtras() != null) {
            /**
             * Jika Bundle ada, ambil data dari Bundle
             */
            Bundle bundle = getIntent().getExtras();
            textView_league.setText(bundle.getString("league"));
            textView_sport.setText(bundle.getString("sport"));
            textView_alternate.setText(bundle.getString("alternate"));


        }
    }
}