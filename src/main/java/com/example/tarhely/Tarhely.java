package com.example.tarhely;

public class Tarhely {
    private int id;
    private String nev;
    private int meret;
    private int ar;

    public Tarhely(int id, String nev, int meret, int ar) {
        this.id = id;
        this.nev = nev;
        this.meret = meret;
        this.ar = ar;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNev() {
        return nev;
    }

    public void setNev(String nev) {
        this.nev = nev;
    }

    public int getMeret() {
        return meret;
    }

    public void setMeret(int meret) {
        this.meret = meret;
    }

    public int getAr() {
        return ar;
    }

    public void setAr(int ar) {
        this.ar = ar;
    }
}
