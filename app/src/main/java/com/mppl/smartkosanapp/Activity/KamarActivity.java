package com.mppl.smartkosanapp.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.mppl.smartkosanapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class KamarActivity extends AppCompatActivity {

    @BindView(R.id.kodenya)
    TextView tvkodenya;
    @BindView(R.id.statusKamar)
    TextView tvstatuskamar;
//    @BindView(R.id.statusKamar)
//    TextView tvstatuskamar;

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


        kode =  findViewById(R.id.kodenya);
        status =  findViewById(R.id.status);
        tvImg = findViewById(R.id.image);
      getData();


    }


    private void getData(){

        img = getIntent().getStringExtra("foto");
        skode = getIntent().getStringExtra("kode");
        sstatus = getIntent().getStringExtra("ket");

        tvkodenya.setText(skode);
        tvstatuskamar.setText(sstatus);
        Glide.with(getApplicationContext())
                .load("http://kosan.haptic.id/foto_kamar/"+img)
                .into(tvImg);
    }


}
