package com.example.sportsapp;

public class sports {
    private String sportName;
    private int sportimage;

    public sports(String sportName, int sportimage) {
        this.sportName = sportName;
        this.sportimage = sportimage;
    }

    public String getSportName() {
        return sportName;
    }

    public void setSportName(String sportName) {
        this.sportName = sportName;
    }

    public int getSportimage() {
        return sportimage;
    }

    public void setSportimage(int sportimage) {
        this.sportimage = sportimage;
    }
}
