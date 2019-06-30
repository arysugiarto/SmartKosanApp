package com.mppl.smartkosanapp.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.mppl.smartkosanapp.R;
import com.mppl.smartkosanapp.model.Register;
import com.mppl.smartkosanapp.rest.ApiInterface;
import com.mppl.smartkosanapp.rest.Constant;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterActivity extends AppCompatActivity  {

    private Button buttonSignUp;
    private EditText editTextName,editTextEmail,editTextPassword,editTextNohp,editTextAlamat;
    private RadioGroup radioGender;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        buttonSignUp = findViewById(R.id.buttonSigUp);
        editTextName = findViewById(R.id.edt_nama);
        editTextEmail = findViewById(R.id.edt_email);
        editTextNohp = findViewById(R.id.edt_password);
        editTextPassword = findViewById(R.id.edt_nama);
        editTextAlamat = findViewById(R.id.edt_alamat);
        radioGender = findViewById(R.id.radioGender);

        buttonSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nama = editTextName.getText().toString();
                String email = editTextEmail.getText().toString();
                String password = editTextPassword.getText().toString();
//                String jk = editTextNohp.getText().toString();
                String alamat = editTextAlamat.getText().toString();
                String no_hp = editTextNohp.getText().toString();

                ApiInterface api = Constant.getClient().create(ApiInterface.class);
                Call<Register> postItem = api.createUser(nama, password,email,alamat,no_hp);
                postItem.enqueue(new Callback<Register>() {
                    @Override
                    public void onResponse(Call<Register> call, Response<Register> response) {
                        String status = response.body().getStatus();

                        if (status.equals("Sukses")) {
                            Toast.makeText(RegisterActivity.this, "Data berhasil disimpan", Toast.LENGTH_SHORT).show();
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



//    @Override
//    public void onClick(View v) {
//        if (v == buttonSignUp){
//            userSignUp();
//        }
//    }
}
