package com.example.backendreactive.model;

public class Game implements Comparable<Game>{

    private String home;
    private String visitor;
    private int goalsHome;
    private int goalsVisitor;
    private String fase;

    public Game() {
    }

    public Game(String home, String visitor, String fase) {
        this.home = home;
        this.visitor = visitor;
        this.fase = fase;
        this.goalsHome=0;
        this.goalsVisitor=0;
    }

    public String getHome() {
        return home;
    }

    public void setHome(String home) {
        this.home = home;
    }

    public String getVisitor() {
        return visitor;
    }

    public void setVisitor(String visitor) {
        this.visitor = visitor;
    }

    public int getGoalsHome() {
        return goalsHome;
    }

    public void setGoalsHome() {
        this.goalsHome = this.goalsHome+1;
    }

    public int getGoalsVisitor() {
        return goalsVisitor;
    }

    public void setGoalsVisitor() {
        this.goalsVisitor = this.goalsVisitor+1;
    }

    public String getFase() {
        return fase;
    }

    public void setFase(String fase) {
        this.fase = fase;
    }

    @Override
    public int compareTo(Game o) {
        if (getFase() == null || o.getFase() == null) {
            return 0;
        }
        return getFase().compareTo(o.getFase());
    }

    @Override
    public String toString() {
        return "Game{" +
                "home='" + home + '\'' +
                ", visitor='" + visitor + '\'' +
                ", goalsHome=" + goalsHome +
                ", goalsVisitor=" + goalsVisitor +
                ", fase='" + fase + '\'' +
                '}';
    }
}
