package com.example.backendreactive.model;

public class Team {
    private String name;
    private int pj;
    private int pg;
    private int pe;
    private int pp;
    private int gf;
    private int gc;
    private int dg;
    private int points;

    public Team() {
    }

    public Team(String team) {
        this.name = team;
        this.pj = 0;
        this.pg = 0;
        this.pe = 0;
        this.pp = 0;
        this.gf = 0;
        this.gc = 0;
        this.dg = 0;
        this.points = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String team) {
        this.name = team;
    }

    public int getPj() {
        return pj;
    }

    public void setPj(int pj) {
        this.pj = pj;
    }

    public int getPg() {
        return pg;
    }

    public void setPg() {
        this.pg = this.pg+1;
    }

    public int getPe() {
        return pe;
    }

    public void setPe() {
        this.pe = this.pe+1;
    }

    public int getPp() {
        return pp;
    }

    public void setPp() {
        this.pp = this.pp+1;
    }

    public int getGf() {
        return gf;
    }

    public void setGf() {
        this.gf = this.gf+1;
    }

    public int getGc() {
        return gc;
    }

    public void setGc() {
        this.gc = this.gc+1;
    }

    public int getDg() {
        return dg;
    }

    public void setDg() {
        this.dg = this.gf-this.gc;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = this.points+points;
    }

    @Override
    public String toString() {
        return "Team{" +
                "name='" + name + '\'' +
                ", pj=" + pj +
                ", pg=" + pg +
                ", pe=" + pe +
                ", pp=" + pp +
                ", gf=" + gf +
                ", gc=" + gc +
                ", dg=" + dg +
                ", points=" + points +
                '}';
    }
}
