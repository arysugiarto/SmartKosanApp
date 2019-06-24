package com.mppl.smartkosanapp.model;

import android.widget.TextView;

public class Tagihan {

    private TextView jenisTagihan, tanggal, totalTagihan;

    public Tagihan() {
    }

    public Tagihan(TextView jenisTagihan, TextView tanggal, TextView totalTagihan) {
        this.jenisTagihan = jenisTagihan;
        this.tanggal = tanggal;
        this.totalTagihan = totalTagihan;
    }

    public TextView getJenisTagihan() {
        return jenisTagihan;
    }

    public TextView getTanggal() {
        return tanggal;
    }

    public TextView getTotalTagihan() {
        return totalTagihan;
    }
}
