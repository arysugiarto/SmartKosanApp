package com.mppl.smartkosanapp.rest;

import com.mppl.smartkosanapp.getmodel.GetKamar;
import com.mppl.smartkosanapp.getmodel.GetTagihan;
import com.mppl.smartkosanapp.model.Fasilitas;
import com.mppl.smartkosanapp.model.Kamar;
import com.mppl.smartkosanapp.model.Login;
import com.mppl.smartkosanapp.model.Register;
import com.mppl.smartkosanapp.model.Tagihan;
import com.mppl.smartkosanapp.model.User;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiInterface {

    @GET("Kamar/datakamar")
    Call<GetKamar> getKamar();

    @GET("Tagihan/tagihan")
    Call<GetTagihan> getTagihan();

    @GET("Fasilitas/fasilitas")
    Call<Fasilitas> getFasilitas();

    @GET("Kamar/datailkamar")
    Call<Kamar> getDetailKamar(@Query("id_kamar") String id_kamar);

    @GET("Tagihan/tagihan")
    Call<Tagihan> getDetailTagihan(@Query("id_pembayaran") String id_pembayaran);

    @FormUrlEncoded
    @POST("User/signup")
    Call<Register> createUser(
            @Field("nama") String name,
            @Field("email") String email,
            @Field("password") String password,
            @Field("no_hp") String no_hp,
            @Field("jk") String jk,
            @Field("alamat") String alamat);

    @FormUrlEncoded
    @POST("User/login")
    Call<Login> userLogin(
            @Field("email") String email,
            @Field("password") String password
    );

    Call<User> postsignup();

}
