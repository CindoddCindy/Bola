package com.myproject.leaguelist.pojo;

public class LeaguePojo {

    private int idleague;
    private String league;
    private String sport;
    private String alternate;

    public LeaguePojo() {
    }

    public LeaguePojo(int idleague, String league, String sport, String alternate) {
        this.idleague = idleague;
        this.league = league;
        this.sport = sport;
        this.alternate = alternate;
    }

    public int getIdleague() {
        return idleague;
    }

    public void setIdleague(int idleague) {
        this.idleague = idleague;
    }

    public String getLeague() {
        return league;
    }

    public void setLeague(String league) {
        this.league = league;
    }

    public String getSport() {
        return sport;
    }

    public void setSport(String sport) {
        this.sport = sport;
    }

    public String getAlternate() {
        return alternate;
    }

    public void setAlternate(String alternate) {
        this.alternate = alternate;
    }
}
