package com.entities;

import java.util.Date;

public class CoachTime {
    String time;
    int am=0;
    int pm=0;
    public CoachTime(){}
    public CoachTime(String t)
    {this.time=t;}

    public String getTime() {
        return time;
    }

    public int getAm() {
        return am;
    }

    public int getPm() {
        return pm;
    }

    public void setAm(int am) {
        this.am = am;
    }

    public void setPm(int pm) {
        this.pm = pm;
    }
}
