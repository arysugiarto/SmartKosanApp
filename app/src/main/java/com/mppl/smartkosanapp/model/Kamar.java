package com.mppl.smartkosanapp.model;

public class Kamar {

    private int kode;
    private String status;
    private int gambar;

    public Kamar(){

    }


    public Kamar(int kode, String status,int gambar) {
        this.kode = kode;
        this.status = status;
        this.gambar = gambar;
    }

    public int getKode() {
        return kode;
    }

    public void setKode(int kode) {
        this.kode = kode;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getGambar() {
        return gambar;
    }

    public void setGambar(int gambar) {
        this.gambar = gambar;
    }
}
