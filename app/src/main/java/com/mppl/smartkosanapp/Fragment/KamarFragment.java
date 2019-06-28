package com.mppl.smartkosanapp.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mppl.smartkosanapp.Activity.KamarActivity;
import com.mppl.smartkosanapp.R;
import com.mppl.smartkosanapp.adapter.KamarAdapter;
import com.mppl.smartkosanapp.getmodel.GetKamar;
import com.mppl.smartkosanapp.model.Kamar;
import com.mppl.smartkosanapp.rest.Api;
import com.mppl.smartkosanapp.rest.ApiInterface;
import com.mppl.smartkosanapp.rest.ItemClickSupport;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class KamarFragment extends Fragment {

    private RecyclerView rvKamar;
    private KamarAdapter adapter;
    private List<Kamar> kamarList;


    public KamarFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_kamar, container, false);

        rvKamar = rootView.findViewById(R.id.rv_kamar);
        rvKamar.setHasFixedSize(true);
        rvKamar.setLayoutManager(new LinearLayoutManager(this.getActivity()));

        getData();

        return rootView;
    }

    private void clickItemDetail(Kamar kamar) {
        Intent kamarActivity = new Intent(getActivity(), KamarActivity.class);
        kamarActivity.putExtra("id_kamar", kamar.getIdKamar());
        startActivity(kamarActivity);
        getActivity().overridePendingTransition(0, 0);
    }

    private void getData() {
        final KamarAdapter kamarAdapter = new KamarAdapter(this.getActivity());
//        sessionManager = new SessionManager(getActivity().getApplicationContext());
        ApiInterface apiInterface = Api.getUrl().create(ApiInterface.class);
        Call<GetKamar> call = apiInterface.getKamar();

        call.enqueue(new Callback<GetKamar>() {
            @Override
            public void onResponse(Call<GetKamar> call, Response<GetKamar> response) {
//                progressBar.setVisibility(View.GONE);
                List<Kamar> listKamar = response.body().getResult();
                kamarAdapter.setKamarList(listKamar);
                rvKamar.setAdapter(kamarAdapter);
                kamarAdapter.setKamarList(listKamar);
                reloadView(kamarAdapter,listKamar);
            }

            @Override
            public void onFailure(Call<GetKamar> call, Throwable t) {

            }
        });
    }


    public void reloadView(RecyclerView.Adapter adapter, final List<Kamar> list) {
        rvKamar.setAdapter(adapter);
        ItemClickSupport.addTo(rvKamar).setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
            @Override
            public void onItemClicked(RecyclerView recyclerView, final int position, View v) {
                Kamar listKamar = list.get(position);
                String id_kamar = listKamar.getIdKamar();
                clickItemDetail(list.get(position));
            }
        });

    }
}

