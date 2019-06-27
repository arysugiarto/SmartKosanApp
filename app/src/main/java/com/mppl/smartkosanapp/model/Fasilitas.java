package com.mppl.smartkosanapp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Fasilitas {
    @SerializedName("id_fasilitas")
    @Expose
    private String idfasilitas;

    @SerializedName("nama")
    @Expose
    private String nama;

    public String getIdfasilitas() {
        return idfasilitas;
    }

    public void setIdfasilitas(String idfasilitas) {
        this.idfasilitas = idfasilitas;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }
}
