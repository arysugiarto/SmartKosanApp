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
    public static final String ID_PENGADUAN = "id_pengaduan";
    public static final String ID_PMI = "id_pmi";


    public static final String LOGIN_TYPE = "login_type";

    public SessionManager(Context _context) {
        this._context = _context;
        pref = _context.getSharedPreferences(PREF_NAME,mode);
        editor = pref.edit();
    }

    public void createSession(String username, String role){
        editor.putBoolean(IS_LOGIN,true);
        editor.putString(USERNAME,username);
        editor.putString(LOGIN_TYPE,role);
//        editor.putString(ID_PENGADUAN,id_pengaduan);

        editor.commit();
    }
    public void createPengaduan(String id_pengaduan){
        editor.putString(ID_PENGADUAN,id_pengaduan);
        editor.commit();
    }
    public void createIdPMI(String id_pmi){
        editor.putString(ID_PMI,id_pmi);
        editor.commit();
    }

    public void checkLogin(){
        if(!this.is_login()){
            Intent i = new Intent(_context,LoginActivity.class);
            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            _context.startActivity(i);
        }else{
            Intent i = new Intent(_context, MainActivity.class);
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

    public HashMap<String, String> getUserDetils(){
        HashMap<String, String> user = new HashMap<String, String>();
        user.put(USERNAME, pref.getString(USERNAME, null));
//        this.getUser();
        user.put(LOGIN_TYPE,pref.getString(LOGIN_TYPE,null));
        user.put(ID_PENGADUAN,pref.getString(ID_PENGADUAN,null));
        user.put(ID_PMI,pref.getString(ID_PMI,null));


//        mUserList.get(0).getRole()
        return user;

    }

    public void createSession(String username) {
        editor.putBoolean(IS_LOGIN,true);
        editor.putString(USERNAME,username);

        editor.commit();
    }
}
