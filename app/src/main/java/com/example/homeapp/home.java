package com.example.homeapp;

public class home {
    private int light1;
    private  int light2 ;
    private int fan;

    public home() {
        this.light1 = 0;
        this.light2 = 0;
        this.fan = 0;

    }

    public int getLight1() {
        return light1;
    }

    public void setLight1(int light1) {
        this.light1 = light1;
    }

    public int getLight2() {
        return light2;
    }

    public void setLight2(int light2) {
        this.light2 = light2;
    }

    public int getFan() {
        return fan;
    }

    public void setFan(int fan) {
        this.fan = fan;
    }
}
