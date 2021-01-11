package com.myproject.leaguelist.view.frgament;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.myproject.leaguelist.R;
import com.myproject.leaguelist.pojo.League;
import com.myproject.leaguelist.pojo.LeagueRespon;
import com.myproject.leaguelist.retrofit.RetrofitMethod;
import com.myproject.leaguelist.retrofit.RetrofitUrl;
import com.myproject.leaguelist.view.adapter.AdapterLeagueOnline;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link LeagueListFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class LeagueListFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private RecyclerView recyclerView;
    private AdapterLeagueOnline adapterLeagueOnline;
    private List<League> leagueList = new ArrayList<>();
    private RetrofitMethod retrofitMethod;


    public LeagueListFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment List.
     */
    // TODO: Rename and change types and number of parameters
    public static LeagueListFragment newInstance(String param1, String param2) {
        LeagueListFragment fragment = new LeagueListFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_list, container, false);

        recyclerView = view.findViewById(R.id.rv_league_online);
        adapterLeagueOnline = new AdapterLeagueOnline( getContext(),leagueList);
        recyclerView.setAdapter(adapterLeagueOnline);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);


        getDataPropinsi();

        return view;

    }

    public void getDataPropinsi(){

        retrofitMethod = RetrofitUrl.getRetrofitLeagueList().create(RetrofitMethod.class);
        Call<LeagueRespon> orderListCall=retrofitMethod.getDataLeague();
        orderListCall.enqueue(new Callback<LeagueRespon>() {
            @Override
            public void onResponse(Call<LeagueRespon> call, Response<LeagueRespon> response) {

                if (response.isSuccessful()) {
                    // response.body().getData();
                    List<League> data = response.body().getLeagues();
                    adapterLeagueOnline = new AdapterLeagueOnline(getContext(),data);
                    recyclerView.setAdapter(adapterLeagueOnline);
                    //adapterIndonesia = new AdapterIndonesia(getContext(),propinsiAtributes);
                    //recyclerView.setAdapter(adapterIndonesia);
                    adapterLeagueOnline.notifyDataSetChanged();
                }
                else {
                    // error case
                    switch (response.code()) {
                        case 404:
                            Toast.makeText(getContext(), "404 not found", Toast.LENGTH_SHORT).show();
                            break;
                        case 500:
                            Toast.makeText(getContext(), "500 internal server error", Toast.LENGTH_SHORT).show();
                            break;
                        case 401:
                            Toast.makeText(getContext(), "401 unauthorized", Toast.LENGTH_SHORT).show();
                            break;

                        default:
                            Toast.makeText(getContext(), "unknown error", Toast.LENGTH_SHORT).show();
                            break;
                    }
                }
            }

            @Override
            public void onFailure(Call<LeagueRespon> call, Throwable t) {
                Toast.makeText(getContext(), "network failure :( inform the user and possibly retry ", Toast.LENGTH_SHORT).show();

            }
        });


    }

}