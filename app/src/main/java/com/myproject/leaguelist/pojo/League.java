
package com.myproject.leaguelist.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class League {

    @SerializedName("idLeague")
    @Expose
    private String idLeague;
    @SerializedName("strLeague")
    @Expose
    private String strLeague;
    @SerializedName("strSport")
    @Expose
    private String strSport;
    @SerializedName("strLeagueAlternate")
    @Expose
    private String strLeagueAlternate;

    /**
     * No args constructor for use in serialization
     * 
     */
    public League() {
    }

    /**
     * 
     * @param strLeagueAlternate
     * @param strLeague
     * @param strSport
     * @param idLeague
     */
    public League(String idLeague, String strLeague, String strSport, String strLeagueAlternate) {
        super();
        this.idLeague = idLeague;
        this.strLeague = strLeague;
        this.strSport = strSport;
        this.strLeagueAlternate = strLeagueAlternate;
    }

    public String getIdLeague() {
        return idLeague;
    }

    public void setIdLeague(String idLeague) {
        this.idLeague = idLeague;
    }

    public String getStrLeague() {
        return strLeague;
    }

    public void setStrLeague(String strLeague) {
        this.strLeague = strLeague;
    }

    public String getStrSport() {
        return strSport;
    }

    public void setStrSport(String strSport) {
        this.strSport = strSport;
    }

    public String getStrLeagueAlternate() {
        return strLeagueAlternate;
    }

    public void setStrLeagueAlternate(String strLeagueAlternate) {
        this.strLeagueAlternate = strLeagueAlternate;
    }

}
