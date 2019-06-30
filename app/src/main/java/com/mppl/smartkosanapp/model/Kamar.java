package com.mppl.smartkosanapp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Kamar {

    @SerializedName("id_kamar")
    @Expose
    private String idKamar;

    @SerializedName("kode_kamar")
    @Expose
    private String kodeKamar;

    @SerializedName("harga")
    @Expose
    private String harga;

    @SerializedName("status")
    @Expose
    private String status;

    @SerializedName("ket")
    @Expose
    private String ket;

    @SerializedName("id_user")
    @Expose
    private String isUser;

    @SerializedName("gambar1")
    @Expose
    private String gambar;


    public Kamar(){

    }


    public Kamar(String idKamar, String kodeKamar, String harga, String status, String isUser, String gambar, String ket) {
        this.idKamar = idKamar;
        this.kodeKamar = kodeKamar;
        this.harga = harga;
        this.status = status;
        this.isUser = isUser;
        this.ket = ket;
        this.gambar = gambar;

    }

    public String getIdKamar() {
        return idKamar;
    }

    public void setIdKamar(String idKamar) {
        this.idKamar = idKamar;
    }

    public String getKodeKamar() {
        return kodeKamar;
    }

    public void setKodeKamar(String kodeKamar) {
        this.kodeKamar = kodeKamar;
    }

    public String getHarga() {
        return harga;
    }

    public void setHarga(String harga) {
        this.harga = harga;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getIsUser() {
        return isUser;
    }

    public void setIsUser(String isUser) {
        this.isUser = isUser;
    }

    public String getGambar() {
        return gambar;
    }

    public void setGambar(String gambar) {
        this.gambar = gambar;
    }

    public String getKet() {
        return ket;
    }

    public void setKet(String ket) {
        this.ket = ket;
    }
}
