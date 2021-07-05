package com.example.moodmanager;

import java.time.Month;
import java.time.Year;

public class Humour {
    private Month month;
    private Year year;
    private int unknow;
    private int angry;
    private int frowning;
    private int neutral;
    private int sligthlysmiling;
    private int grinningsmiling;
    private boolean clicked;

    public Humour(Month month, Year year, int unknow, int angry, int frowning, int neutral, int sligthlysmiling, int grinningsmiling, boolean clicked) {
        this.month = month;
        this.year = year;
        this.unknow = unknow;
        this.angry = angry;
        this.frowning = frowning;
        this.neutral = neutral;
        this.sligthlysmiling = sligthlysmiling;
        this.grinningsmiling = grinningsmiling;
        this.clicked = clicked;
    }

    public Month getMonth() {
        return month;
    }

    public void setMonth(Month month) {
        this.month = month;
    }

    public Year getYear() {
        return year;
    }

    public void setYear(Year year) {
        this.year = year;
    }

    public int getUnknow() {
        return unknow;
    }

    public void setUnknow(int unknow) {
        this.unknow = unknow;
    }

    public int getAngry() {return angry; }

    public void setAngry(int angry) { this.angry = angry; }

    public int getFrowning() {
        return frowning;
    }

    public void setFrowning(int frowning) {
        this.frowning = frowning;
    }

    public int getNeutral() {
        return neutral;
    }

    public void setNeutral(int neutral) {
        this.neutral = neutral;
    }

    public int getSligthlysmiling() {
        return sligthlysmiling;
    }

    public void setSligthlysmiling(int sligthlysmiling) {
        this.sligthlysmiling = sligthlysmiling;
    }

    public int getGrinningsmiling() {
        return grinningsmiling;
    }

    public void setGrinningsmiling(int grinningsmiling) {
        this.grinningsmiling = grinningsmiling;
    }

    public boolean isClicked() {
        return clicked;
    }

    public void setClicked(boolean clicked) {
        this.clicked = clicked;
    }

    @Override
    public String toString() {
        return
                "   "+month+" "+ year +
                "\n\n ❔: " + unknow +
                "   \uD83D\uDE21: " + angry +
                "   ☹️: " + frowning +
                "   \uD83D\uDE10: " + neutral +
                "   \uD83D\uDE42: " + sligthlysmiling +
                "   \uD83D\uDE04: " + grinningsmiling;
    }
}
