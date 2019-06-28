package com.mppl.smartkosanapp.helper;

import android.content.Context;
import android.content.SharedPreferences;

import com.mppl.smartkosanapp.model.User;

public class SharedPref {
    private static SharedPref mInstance;
    private static Context mCtx;

    public static final String SHARED_PREF_NAME = "loginretrofit";

    public static final String KEY_USER_ID = "keyid";
    public static final String KEY_USER_NAME = "keyname";
    public static final String KEY_USER_EMAIL  = "keyemail";
    public static final String KEY_USER_GENDER = "keygender";

    private  SharedPref(Context context){
        mCtx = context;
    }

    public static synchronized SharedPref getInstance(Context context){
        if (mInstance == null){
            mInstance = new SharedPref(context);
        }
        return  mInstance;
    }

    public boolean userLogin(User user){
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(KEY_USER_ID, user.getIdUser());
        editor.putString(KEY_USER_NAME, user.getNama());
        editor.putString(KEY_USER_EMAIL, user.getEmail());
        editor.putString(KEY_USER_GENDER, user.getJk());
        editor.apply();
        return true;
    }

    public boolean isLoggedIn(){
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        if (sharedPreferences.getString(KEY_USER_EMAIL,null)!= null)
            return true;
        return false;
    }
    public User getUse(){
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return new User(
                sharedPreferences.getInt(KEY_USER_ID, 0),
                sharedPreferences.getString(KEY_USER_NAME, null),
                sharedPreferences.getString(KEY_USER_EMAIL, null),
                sharedPreferences.getString(KEY_USER_GENDER, null)
        );
    }

    public boolean logout(){
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();
        return true;
    }
}
