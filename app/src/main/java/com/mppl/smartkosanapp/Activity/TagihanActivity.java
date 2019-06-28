package com.mppl.smartkosanapp.Activity;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.mppl.smartkosanapp.R;
import com.mppl.smartkosanapp.model.Tagihan;
import com.mppl.smartkosanapp.rest.Api;
import com.mppl.smartkosanapp.rest.ApiInterface;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TagihanActivity extends AppCompatActivity {

    @BindView(R.id.tagihandetail)
    TextView tvtagihan;
    String id;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tagihan);

        id = getIntent().getStringExtra("id_pembayaran");
        ButterKnife.bind(this);

        getData();
    }

    private void getData() {

        ApiInterface apiInterface = Api.getUrl().create(ApiInterface.class);
        Call<Tagihan> call = apiInterface.getDetailTagihan(id);
        call.enqueue(new Callback<Tagihan>() {
            @Override
            public void onResponse(Call<Tagihan> call, Response<Tagihan> response) {

                tvtagihan.setText(response.body().getJenis());
            }

            @Override
            public void onFailure(Call<Tagihan> call, Throwable t) {

            }
        });
    }


}
