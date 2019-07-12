package com.mppl.smartkosanapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import com.mppl.smartkosanapp.Activity.LoginActivity;
import com.mppl.smartkosanapp.Activity.MainActivity;
import com.mppl.smartkosanapp.model.User;
import com.mppl.smartkosanapp.rest.ApiInterface;

import java.util.HashMap;
import java.util.List;

public class SessionManager {

    SharedPreferences pref;
    SharedPreferences.Editor editor;
    Context _context;
    //    Context context;
    int mode = 0;
    ApiInterface mApiInterface;
    List<User> mUserList;

    private static final String PREF_NAME = "SessionPref";
    private static final String IS_LOGIN = "is_login";
    public static final String USERNAME = "username";
    public static final String NAMA = "nama";
    public static final String EMAIL = "email";
    public static final String ID_USER = "id_user";
    public static final String ALAMAT = "alamat";
    public static final String PASSWORD = "password";
    public static final String JK = "jk";
    public static final String NO_HP = "no_hp";


    public static final String LOGIN_TYPE = "login_type";

    public SessionManager(Context _context) {
        this._context = _context;
        pref = _context.getSharedPreferences(PREF_NAME,mode);
        editor = pref.edit();
    }



    public void checkLogin(){
        if(!this.is_login()){
            Intent i = new Intent(_context,MainActivity.class);
            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            _context.startActivity(i);
        }else{
            Intent i = new Intent(_context, LoginActivity.class);
            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            _context.startActivity(i);
        }
    }

    private boolean is_login(){
        return pref.getBoolean(IS_LOGIN,false);
    }

    public void logout(){
        editor.clear();
        editor.commit();
        Intent intent = new Intent(_context, LoginActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        _context.startActivity(intent);
    }
//    public String getUsername(){
//
//    }

    public HashMap<String, String> getUserDetils(){
        HashMap<String, String> user = new HashMap<String, String>();
        user.put(USERNAME, pref.getString(USERNAME, null));

//        this.getUser();
        user.put(LOGIN_TYPE,pref.getString(LOGIN_TYPE,null));
        user.put(ID_USER,pref.getString(ID_USER, null));
        user.put(EMAIL,pref.getString(EMAIL, null));
        user.put(ALAMAT,pref.getString(ALAMAT, null));
        user.put(NO_HP,pref.getString(NO_HP, null));
        return user;

    }

    public void createSession(String nama) {
        editor.putBoolean(IS_LOGIN,true);
        editor.putString(NAMA,nama);

        editor.commit();
    }

    public void createEmail(String email){
        editor.putString(EMAIL, email);
        editor.commit();

    }

    public void createAlamat(String alamat){
        editor.putString(ALAMAT, alamat);
        editor.commit();

    }

    public void createNohp(String no_hp){
        editor.putString(NO_HP, no_hp);
        editor.commit();

    }

    public void createUsername(String username){
        editor.putString(USERNAME, username);
        editor.commit();

    }


}
