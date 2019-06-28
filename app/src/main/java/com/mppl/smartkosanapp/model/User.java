package com.mppl.smartkosanapp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class User {
    @SerializedName("id_user")
    @Expose
    private int idUser;
    @SerializedName("nama")
    @Expose
    private String nama;
    @SerializedName("password")
    @Expose
    private String password;
    @SerializedName("jk")
    @Expose
    private String jk;
    @SerializedName("no_hp")
    @Expose
    private String nohp;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("alamat")
    @Expose
    private String alamat;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("akses")
    @Expose
    private String akses;

    @SerializedName("data")
    private Boolean error;

    @SerializedName("message")
    private String message;

    @SerializedName("user")
    private User user;

    public User(Boolean error, String message, User user) {
        this.error = error;
        this.message = message;
        this.user = user;
    }

    public User(String name, String email, String password, String hp, String jk, String alamat) {
        this.nama = name;
        this.email = email;
        this.password = password;
        this.jk = jk;
        this.alamat = alamat;
        this.nohp = hp;

    }

    public Boolean getError() {
        return error;
    }

    public String getMessage() {
        return message;
    }

    public User getUser() {
        return user;
    }


    public User(int idUser, String nama, String password, String jk) {
        this.idUser = idUser;
        this.nama = nama;
        this.password = password;
        this.jk = jk;
        this.nohp = nohp;
        this.email = email;
        this.alamat = alamat;
        this.status = status;
        this.akses = akses;
    }

    public String getAkses() {
        return akses;
    }

    public void setAkses(String akses) {
        this.akses = akses;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getJk() {
        return jk;
    }

    public void setJk(String jk) {
        this.jk = jk;
    }

    public String getNohp() {
        return nohp;
    }

    public void setNohp(String nohp) {
        this.nohp = nohp;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
