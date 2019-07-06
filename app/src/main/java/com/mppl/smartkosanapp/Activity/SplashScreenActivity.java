package com.mppl.smartkosanapp.Activity;

import android.content.Context;
import android.content.DialogInterface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.mppl.smartkosanapp.R;
import com.mppl.smartkosanapp.SessionManager;

public class SplashScreenActivity extends AppCompatActivity {
    SessionManager sessionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(!isConnected(SplashScreenActivity.this)) buildDialog(SplashScreenActivity.this).show();
        else {
            Toast.makeText(SplashScreenActivity.this,"Welcome", Toast.LENGTH_SHORT).show();
            setContentView(R.layout.activity_splash_screen);
            sessionManager = new SessionManager(getApplicationContext());
//          sessionManager.getUser();
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    sessionManager.checkLogin();
                    finish();
                }
            }, 5000);
        }


    }

    public boolean isConnected(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo mNetInfo = cm.getActiveNetworkInfo();

        if (mNetInfo != null && mNetInfo.isConnectedOrConnecting()) {
            android.net.NetworkInfo wifi = cm.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
            android.net.NetworkInfo mobile = cm.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
            if ((mobile != null && mobile.isConnectedOrConnecting()) || (wifi != null && wifi.isConnectedOrConnecting()))
                return true;
            else return false;
        } else
            return false;
    }

    public AlertDialog.Builder buildDialog(Context c) {

        AlertDialog.Builder builder = new AlertDialog.Builder(c);
        builder.setTitle("Tidak Ada Koneksi Internet");
        builder.setMessage("Anda perlu cek kembali jaringan internet anda . Tekan ok untuk keluar");

        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {

                finish();
            }
        });

        return builder;
    }
}
