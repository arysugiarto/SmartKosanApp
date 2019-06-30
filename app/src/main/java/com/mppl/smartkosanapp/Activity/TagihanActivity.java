package com.mppl.smartkosanapp.Activity;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.mppl.smartkosanapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TagihanActivity extends AppCompatActivity {

    @BindView(R.id.tagihandetail)
    TextView jenis;
    @BindView(R.id.harga)
    TextView tgl;
    private String sjenis, stgl ;
    String id;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tagihan);

        id = getIntent().getStringExtra("id_pembayaran");
//
        jenis = findViewById(R.id.tv_jenis_pembayaran);
        tgl = findViewById(R.id.tv_tgl);
        ButterKnife.bind(this);



        getData();
    }

    private void getData() {

        sjenis = getIntent().getStringExtra("jenis");
        stgl = getIntent().getStringExtra("tgl");
//
        jenis.setText(sjenis);
        tgl.setText(stgl);
    }


}
