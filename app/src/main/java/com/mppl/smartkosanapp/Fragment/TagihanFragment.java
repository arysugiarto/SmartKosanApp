package com.mppl.smartkosanapp.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mppl.smartkosanapp.R;
import com.mppl.smartkosanapp.adapter.KamarAdapter;
import com.mppl.smartkosanapp.adapter.TagihanAdapter;
import com.mppl.smartkosanapp.model.Kamar;
import com.mppl.smartkosanapp.model.Tagihan;

import java.util.List;


public class TagihanFragment extends Fragment {

    private RecyclerView rvTagihan;
    private TagihanAdapter adapter;
    private List<Tagihan> tagihanListt;


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
        View view = inflater.inflate(R.layout.fragment_tagihan, container, false);

        return view;
    }

}
