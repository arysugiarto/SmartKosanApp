package com.mppl.smartkosanapp.model;

import android.widget.TextView;

public class Histori {

    private TextView jenisPembayaran, totalPembayaran, tanggalPembayaran, status;

    public Histori() {
    }

    public Histori(TextView jenisPembayaran, TextView totalPembayaran, TextView tanggalPembayaran, TextView status) {
        this.jenisPembayaran = jenisPembayaran;
        this.totalPembayaran = totalPembayaran;
        this.tanggalPembayaran = tanggalPembayaran;
        this.status = status;
    }

    public TextView getJenisPembayaran() {
        return jenisPembayaran;
    }

    public TextView getTotalPembayaran() {
        return totalPembayaran;
    }

    public TextView getTanggalPembayaran() {
        return tanggalPembayaran;
    }

    public TextView getStatus() {
        return status;
    }
}
