package com.mppl.smartkosanapp.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.mppl.smartkosanapp.R;
import com.mppl.smartkosanapp.SessionManager;
import com.mppl.smartkosanapp.model.Login;
import com.mppl.smartkosanapp.rest.Api;
import com.mppl.smartkosanapp.rest.ApiInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity   {

     Button btnSigIn;
     EditText editTextEmail,editTextPassword;
     SessionManager sessionManager;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editTextEmail = findViewById(R.id.email);
        editTextPassword = findViewById(R.id.password);
        btnSigIn = findViewById(R.id.buttonsignin);
        sessionManager = new SessionManager(getApplicationContext());

        sessionManager = new SessionManager(getApplicationContext());


        editTextPassword.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    login();
                    return true;
                }
                return false;
            }
        });
        btnSigIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();

            }
        });

    }

    private void login(){
        ApiInterface apiInterface = Api.getUrl().create(ApiInterface.class);

//        Call<Login>
        retrofit2.Call<Login> call = apiInterface.userLogin(editTextEmail.getText().toString(), editTextPassword.getText().toString());

        call.enqueue(new Callback<Login>() {
            @Override
            public void onResponse(Call<Login> call, Response<Login> response) {

                String nama = response.body().getResponse();

                //simpan data ke preference

                String username = response.body().getDataUser().getNama();
                String email = response.body().getDataUser().getEmail();
                String alamat = response.body().getDataUser().getAlamat();
                String nohp = response.body().getDataUser().getNohp();

                Log.e("Respone",nama);

                if (nama.equals("sukses")){

                    sessionManager.createSession(nama);
                    sessionManager.createAlamat(alamat);
                    sessionManager.createNohp(nohp);
                    sessionManager.createEmail(email);
                    sessionManager.createUsername(username);

                    Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                    startActivity(intent);
                }
            }

            @Override
            public void onFailure(retrofit2.Call<Login> call, Throwable t) {

            }
        });

    }

    public void regis(View view) {
        Intent intent = new Intent(LoginActivity.this,RegisterActivity.class);
        startActivity(intent);
    }
}
