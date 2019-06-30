package com.mppl.smartkosanapp.Activity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.mppl.smartkosanapp.R;
import com.mppl.smartkosanapp.model.Register;
import com.mppl.smartkosanapp.rest.ApiInterface;
import com.mppl.smartkosanapp.rest.Constant;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterActivity extends AppCompatActivity   {

    private Button buttonSignUp;
    private EditText editTextId,editTextName,editTextEmail,editTextPassword,editTextNohp,editTextAlamat,editTextJk;
    private RadioGroup radioGender;
    private Spinner spinner;
    ProgressDialog progressDialog;
    private String refreshFlag = "0";

    Context mContext;
    ApiInterface mApiService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        editTextId = findViewById(R.id.edt_id);
        editTextName = (EditText) findViewById(R.id.edt_nama);
        editTextEmail = (EditText) findViewById(R.id.edt_email);
        editTextPassword = (EditText) findViewById(R.id.edt_password);
        editTextNohp = (EditText) findViewById(R.id.edt_no);
        editTextJk = (EditText) findViewById(R.id.edt_jk);
        editTextAlamat = (EditText) findViewById(R.id.edt_alamat);

        buttonSignUp = (Button) findViewById(R.id.buttonSigUp);

        progressDialog = new ProgressDialog(this);
        buttonSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressDialog.setMessage("Loading ...");
                progressDialog.setCancelable(false);
                progressDialog.show();

                refreshFlag = "1";

                String id_user = editTextId.getText().toString();
                String name = editTextName.getText().toString();
                String email = editTextEmail.getText().toString();
                String password = editTextPassword.getText().toString();
                String no_hp = editTextNohp.getText().toString();
                String jk = editTextJk.getText().toString();
                String alamat = editTextAlamat.getText().toString();

                ApiInterface api = Constant.getClient().create(ApiInterface.class);
                Call<Register> postItem = api.registerRequest(id_user,name,email,password,no_hp,jk,alamat);
                postItem.enqueue(new Callback<Register>() {
                    @Override
                    public void onResponse(Call<Register> call, Response<Register> response) {
                        progressDialog.hide();
                        String status = response.body().getResponse();

                        if (status.equals("Sukses")) {
                            Toast.makeText(RegisterActivity.this, "Data berhasil disimpan", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(RegisterActivity.this,LoginActivity.class);
                            startActivity(intent);
                            finish();
                        } else {
                            Toast.makeText(RegisterActivity.this, "Data gagal disimpan", Toast
                                    .LENGTH_SHORT).show();
                        }

                    }

                    @Override
                    public void onFailure(Call<Register> call, Throwable t) {

                    }
                });
            }
        });


    }


    }
