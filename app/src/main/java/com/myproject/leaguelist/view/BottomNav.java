package com.myproject.leaguelist.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.myproject.leaguelist.R;
import com.myproject.leaguelist.view.frgament.Favorite;
import com.myproject.leaguelist.view.frgament.LeagueListFragment;

public class BottomNav extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_nav);

        getFragmentPage(new LeagueListFragment());

        BottomNavigationView bottomNavigation = findViewById(R.id.bottomNavigationViewSoccer);
        bottomNavigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                Fragment fragment = null;

                //Menantukan halaman Fragment yang akan tampil
                switch (item.getItemId()){
                    case R.id.league:
                        fragment = new LeagueListFragment();
                        break;

                    case R.id.league_fav:
                        fragment = new Favorite();
                        break;


                }
                return getFragmentPage(fragment);
            }
        });

    }

    private boolean getFragmentPage(Fragment fragment){
        if (fragment != null){
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.page_container_league, fragment)
                    .commit();
            return true;
        }
        return false;
    }
}