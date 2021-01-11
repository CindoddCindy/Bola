package com.myproject.leaguelist.retrofit;

import com.myproject.leaguelist.pojo.LeagueRespon;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RetrofitMethod {

    @GET("all_leagues.php")
    Call<LeagueRespon> getDataLeague();


}
