package com.mppl.smartkosanapp.Activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.mppl.smartkosanapp.R;
import com.mppl.smartkosanapp.model.User;
import com.mppl.smartkosanapp.rest.ApiInterface;
import com.mppl.smartkosanapp.rest.Constant;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {

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


        buttonSignUp.setOnClickListener(this);
    }

    private void userSignUp(){
        //defining a progress dialog to show while signing up
        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Signing Up...");
        progressDialog.show();

        //getting the user values
        final RadioButton radioSex = (RadioButton) findViewById(radioGender.getCheckedRadioButtonId());


        String name = editTextName.getText().toString().trim();
        String email = editTextEmail.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();
        String hp = editTextPassword.getText().toString().trim();
        String alamat = editTextPassword.getText().toString().trim();
        String jk = radioSex.getText().toString();

        //building retrofit object
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constant.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        //Defining retrofit api service
        ApiInterface service = retrofit.create(ApiInterface.class);

        //Defining the user object as we need to pass it with the call
        User user = new User(name, email, password, jk,hp, alamat);


        //defining the call
        Call<User> call = service.createUser(
                user.getNama(),
                user.getEmail(),
                user.getPassword(),
                user.getNohp(),
                user.getJk(),
                user.getAlamat()
        );

        //calling the api
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                //hiding progress dialog
                progressDialog.dismiss();
                //displaying the message from the response as toast
                Toast.makeText(getApplicationContext(), response.body().getMessage(), Toast.LENGTH_LONG).show();
                if (!response.body().getError()){
                    //starting profile activity
                    finish();
//                    SharedPrefManager.getInstance(getApplicationContext()).userLogin(response.body().getUser());
                    startActivity(new Intent(getApplicationContext(), LoginActivity.class));
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                progressDialog.dismiss();
                Toast.makeText(getApplicationContext(),t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public void onClick(View v) {
        if (v == buttonSignUp){
            userSignUp();
        }
    }
}
