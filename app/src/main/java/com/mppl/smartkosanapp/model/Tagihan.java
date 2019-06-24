package com.mppl.smartkosanapp.model;

import android.widget.TextView;

public class Tagihan {

    private String jenisTagihan, tanggal;
    private int totalTagihan;

    public Tagihan() {
    }

    public Tagihan(String jenisTagihan, String tanggal, int totalTagihan) {
        this.jenisTagihan = jenisTagihan;
        this.tanggal = tanggal;
        this.totalTagihan = totalTagihan;
    }

    public String getJenisTagihan() {
        return jenisTagihan;
    }

    public void setJenisTagihan(String jenisTagihan) {
        this.jenisTagihan = jenisTagihan;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public int getTotalTagihan() {
        return totalTagihan;
    }

    public void setTotalTagihan(int totalTagihan) {
        this.totalTagihan = totalTagihan;
    }
}
