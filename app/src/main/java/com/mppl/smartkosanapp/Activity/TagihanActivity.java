package com.mppl.smartkosanapp.Activity;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.mppl.smartkosanapp.R;

import butterknife.ButterKnife;

public class TagihanActivity extends AppCompatActivity {

    TextView tvtagihan,tvtgl;
    String id,sjenis,stgl;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tagihan);

        id = getIntent().getStringExtra("id_pembayaran");

        tvtagihan = findViewById(R.id.tv_jenis_pembayaran);
        tvtgl = findViewById(R.id.tv_tgl);
        ButterKnife.bind(this);



        getData();
    }

    private void getData() {

        sjenis = getIntent().getStringExtra("jenis");
        stgl = getIntent().getStringExtra("tgl");

        tvtagihan.setText(sjenis);
        tvtgl.setText(stgl);
    }


}
