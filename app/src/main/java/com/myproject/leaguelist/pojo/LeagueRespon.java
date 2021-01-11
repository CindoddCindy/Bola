
package com.myproject.leaguelist.pojo;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LeagueRespon {

    @SerializedName("leagues")
    @Expose
    private List<League> leagues = new ArrayList<League>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public LeagueRespon() {
    }

    /**
     * 
     * @param leagues
     */
    public LeagueRespon(List<League> leagues) {
        super();
        this.leagues = leagues;
    }

    public List<League> getLeagues() {
        return leagues;
    }

    public void setLeagues(List<League> leagues) {
        this.leagues = leagues;
    }

}
