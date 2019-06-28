package com.mppl.smartkosanapp.rest;

import com.mppl.smartkosanapp.getmodel.GetKamar;
import com.mppl.smartkosanapp.getmodel.GetTagihan;
import com.mppl.smartkosanapp.model.Fasilitas;
import com.mppl.smartkosanapp.model.User;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiInterface {

    @GET("Kamar/datakamar")
    Call<GetKamar>getKamar();

    @GET("Tagihan/tagihan")
    Call<GetTagihan> getTagihan();

    @GET("Fasilitas/fasilitas")
    Call<Fasilitas>getFasilitas();

    @FormUrlEncoded
    @POST("User/signup")
    Call<User> createUser(
            @Field("nama") String name,
            @Field("email") String email,
            @Field("password") String password,
            @Field("no_hp") String no_hp,
            @Field("jk") String jk,
            @Field("alamat") String alamat);
    @FormUrlEncoded
    @POST("login")
    Call<User> userLogin(
            @Field("email") String email,
            @Field("password") String password
    );

    Call<User>postsignup();

}
