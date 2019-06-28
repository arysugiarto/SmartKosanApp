package com.mppl.smartkosanapp.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mppl.smartkosanapp.R;
import com.mppl.smartkosanapp.adapter.KamarAdapter;
import com.mppl.smartkosanapp.adapter.TagihanAdapter;
import com.mppl.smartkosanapp.getmodel.GetKamar;
import com.mppl.smartkosanapp.getmodel.GetTagihan;
import com.mppl.smartkosanapp.model.Kamar;
import com.mppl.smartkosanapp.model.Tagihan;
import com.mppl.smartkosanapp.rest.Api;
import com.mppl.smartkosanapp.rest.ApiInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class TagihanFragment extends Fragment {

    private RecyclerView rvTagihan;
    private TagihanAdapter adapter;
    private List<Tagihan> tagihanList;


    public TagihanFragment() {
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
        View rootView = inflater.inflate(R.layout.fragment_tagihan, container, false);

        rvTagihan = rootView.findViewById(R.id.rv_tagihan);
        rvTagihan.setHasFixedSize(true);

        rvTagihan.setLayoutManager(new LinearLayoutManager(this.getActivity()));

        getData();
        return rootView;
    }

    private void getData() {
        final TagihanAdapter tagihanAdapter = new TagihanAdapter(this.getActivity());
//        sessionManager = new SessionManager(getActivity().getApplicationContext());
        ApiInterface apiInterface = Api.getUrl().create(ApiInterface.class);
        Call<GetTagihan> call = apiInterface.getTagihan();

        call.enqueue(new Callback<GetTagihan>() {
            @Override
            public void onResponse(Call<GetTagihan> call, Response<GetTagihan> response) {
//                progressBar.setVisibility(View.GONE);
                List<Tagihan> listTagihan = response.body().getResult();
                tagihanAdapter.setTagihanList(listTagihan);
                rvTagihan.setAdapter(tagihanAdapter);
            }

            @Override
            public void onFailure(Call<GetTagihan> call, Throwable t) {

            }
        });
    }


}
