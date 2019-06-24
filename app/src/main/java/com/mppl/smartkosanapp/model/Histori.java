package com.mppl.smartkosanapp.model;

import android.widget.TextView;

public class Histori {

    private String jenisPembayaran, tanggalPembayaran, status;
    private int totalPembayaran;

    public Histori() {
    }

    public Histori(String jenisPembayaran, String tanggalPembayaran, String status, int totalPembayaran) {
        this.jenisPembayaran = jenisPembayaran;
        this.tanggalPembayaran = tanggalPembayaran;
        this.status = status;
        this.totalPembayaran = totalPembayaran;
    }

    public String getJenisPembayaran() {
        return jenisPembayaran;
    }

    public void setJenisPembayaran(String jenisPembayaran) {
        this.jenisPembayaran = jenisPembayaran;
    }

    public int getTotalPembayaran() {
        return totalPembayaran;
    }

    public void setTotalPembayaran(int totalPembayaran) {
        this.totalPembayaran = totalPembayaran;
    }

    public String getTanggalPembayaran() {
        return tanggalPembayaran;
    }

    public void setTanggalPembayaran(String tanggalPembayaran) {
        this.tanggalPembayaran = tanggalPembayaran;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
