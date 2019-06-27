package com.mppl.smartkosanapp.model;

import android.widget.TextView;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Histori {

    @SerializedName("id_pembayaran")
    @Expose
    private String idPembayaran;
    @SerializedName("id_user")
    @Expose
    private String idUser;
    @SerializedName("jenis")
    @Expose
    private String jenis;
    @SerializedName("bukti")
    @Expose
    private String bukti;
    @SerializedName("tgl_bayar")
    @Expose
    private String tglBayar;
    @SerializedName("status")
    @Expose
    private String status;


    public Histori() {
    }

    public Histori(String idPembayaran, String idUser, String jenis, String bukti, String tglBayar, String status) {
        this.idPembayaran = idPembayaran;
        this.idUser = idUser;
        this.jenis = jenis;
        this.bukti = bukti;
        this.tglBayar = tglBayar;
        this.status = status;
    }

    public String getIdPembayaran() {
        return idPembayaran;
    }

    public void setIdPembayaran(String idPembayaran) {
        this.idPembayaran = idPembayaran;
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public String getJenis() {
        return jenis;
    }

    public void setJenis(String jenis) {
        this.jenis = jenis;
    }

    public String getBukti() {
        return bukti;
    }

    public void setBukti(String bukti) {
        this.bukti = bukti;
    }

    public String getTglBayar() {
        return tglBayar;
    }

    public void setTglBayar(String tglBayar) {
        this.tglBayar = tglBayar;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
