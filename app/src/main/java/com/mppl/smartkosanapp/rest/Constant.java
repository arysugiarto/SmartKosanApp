package com.mppl.smartkosanapp.rest;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Constant {

//    public static String BASE_URL ="http://kosan.haptic.id/api/";

    public static String BASE_URL ="http://192.168.1.10/webservice/SmartKosanWebService/api/";

    private static Retrofit retrofit;

    public static Retrofit getClient() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return retrofit;
    }

}
