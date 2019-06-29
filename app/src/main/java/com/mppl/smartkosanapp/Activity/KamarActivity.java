package com.mppl.smartkosanapp.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.mppl.smartkosanapp.R;
import com.mppl.smartkosanapp.model.Kamar;
import com.mppl.smartkosanapp.rest.Api;
import com.mppl.smartkosanapp.rest.ApiInterface;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class KamarActivity extends AppCompatActivity {

    @BindView(R.id.kodenya)
    TextView tvkodenya;
    @BindView(R.id.statusKamar)
    TextView tvstatuskamar;
    String id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kamar);
        id = getIntent().getStringExtra("id_kamar");
        ButterKnife.bind(this);

        getData();

    }

    private void getData(){
        ApiInterface apiInterface = Api.getUrl().create(ApiInterface.class);
//        sessionManager = new SessionManager(getApplicationContext());
//        HashMap<String,String> user = sessionManager.getUserDetils();
//        String id = user.get(SessionManager.ID_PRESTASI);

        Call<Kamar> call = apiInterface.getDetailKamar(id);

        call.enqueue(new Callback<Kamar>() {
            @Override
            public void onResponse(Call<Kamar> call, Response<Kamar> response) {
//                progressBar.setVisibility(View.GONE);

                tvkodenya.setText(response.body().getKodeKamar());
                tvstatuskamar.setText(response.body().getStatus());


////                tvTanggal.setText(response.body().getTanggal());
//                Glide.with(DetailPrestasiActivity.this)
//                        .load("http://sman14bdg.dscunikom.com/uploads/prestasi/".concat(response.body().getImage()))
//                        .into(imgDetail);

//                Log.e("Nama Prestasi ","OnRespone "+String.valueOf(response.body().getNamaPrestasi()));
            }

            @Override
            public void onFailure(Call<Kamar> call, Throwable t) {

            }
        });
    }


}
