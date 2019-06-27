package com.mppl.smartkosanapp.rest;

import com.mppl.smartkosanapp.model.Fasilitas;
import com.mppl.smartkosanapp.model.Kamar;
import com.mppl.smartkosanapp.model.Tagihan;
import com.mppl.smartkosanapp.model.User;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiInterface {

    @GET("Kamar/datakamar")
    Call<Kamar>getKamar();

    @GET("Tagihan/tagihan")
    Call<Tagihan>getTagihan();

    @GET("Fasilitas/fasilitas")
    Call<Fasilitas>getFasilitas();

    @POST("User/signup")
    Call<User>postsignup();

}
