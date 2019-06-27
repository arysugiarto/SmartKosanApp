package com.mppl.smartkosanapp.Fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mppl.smartkosanapp.R;
import com.mppl.smartkosanapp.adapter.KamarAdapter;
import com.mppl.smartkosanapp.model.Kamar;

import java.util.ArrayList;
import java.util.List;


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
        View view = inflater.inflate(R.layout.fragment_kamar, container, false);

        rvKamar = view.findViewById(R.id.rv_kamar);

        preparekamarDumyumy();
        return view;
    }

    private void preparekamarDumyumy() {
        final KamarAdapter kamarAdapter = new KamarAdapter(this.getActivity());



    }


    }

