package com.mppl.smartkosanapp.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.mppl.smartkosanapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class KamarActivity extends AppCompatActivity {

    @BindView(R.id.kodenya)
    TextView tvkodenya;
    @BindView(R.id.statusKamar)
    TextView tvstatuskamar;

    private TextView kode, status;
    ImageView tvImg;
    private String skode, sstatus,img ;
    String id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kamar);
        id = getIntent().getStringExtra("id_kamar");
        ButterKnife.bind(this);


        Intent i = getIntent();

        kode =  findViewById(R.id.kodenya);
        status =  findViewById(R.id.status);
//        tvImg = findViewById(R.id.image);
      getData();

//        getData();

    }

//    private void getData(){
//        ApiInterface apiInterface = Api.getUrl().create(ApiInterface.class);
//
//        Call<Kamar> call = apiInterface.getDetailKamar(id);
//
//        call.enqueue(new Callback<Kamar>() {
//            @Override
//            public void onResponse(Call<Kamar> call, Response<Kamar> response) {
//                tvkodenya.setText(response.body().getKodeKamar());
//                tvstatuskamar.setText(response.body().getStatus());
//
//            }
//
//            @Override
//            public void onFailure(Call<Kamar> call, Throwable t) {
//
//            }
//        });
//    }

    private void getData(){

//        img = getIntent().getStringExtra("gambar1");
        skode = getIntent().getStringExtra("kode");
        sstatus = getIntent().getStringExtra("status");

        tvkodenya.setText(skode);
        tvstatuskamar.setText(sstatus);
//        Glide.with(getApplicationContext())
//                .load("http://192.168.1.10/webservice/SmartKosanWebService/foto_kamar/"+img)
//                .into(tvImg);
    }


}
