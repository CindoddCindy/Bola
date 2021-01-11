package com.myproject.leaguelist.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.myproject.leaguelist.R;
import com.myproject.leaguelist.sqlite.AddFavorite;

public class Detail extends AppCompatActivity {

    private AddFavorite addFavorite;

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

        addFavorite=new AddFavorite(getApplicationContext());


        if (getIntent().getExtras() != null) {
            /**
             * Jika Bundle ada, ambil data dari Bundle
             */
            Bundle bundle = getIntent().getExtras();
            textView_league.setText(bundle.getString("league"));
            textView_sport.setText(bundle.getString("sport"));
            textView_alternate.setText(bundle.getString("alternate"));


        }

        button_save_fav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveFav();
            }
        });
    }

    public  void saveFav(){

            addFavorite.insertDataLeague(textView_league.getText().toString(), textView_sport.getText().toString(), textView_alternate.getText().toString());
            Toast.makeText(getApplicationContext(), "Saved", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(Detail.this, BottomNav.class);
            startActivity(intent);
            finish();





    }



}