package com.mppl.smartkosanapp.Fragment;


import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.mppl.smartkosanapp.R;
import com.mppl.smartkosanapp.model.User;
import com.mppl.smartkosanapp.rest.Api;
import com.mppl.smartkosanapp.rest.ApiInterface;

import butterknife.BindView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.POST;
import retrofit2.http.Query;


public class ProfileFragment extends Fragment {
    @BindView(R.id.tvNama)
    TextView txt_nama;
    @BindView(R.id.tvEmail)
    TextView txt_email;
    @BindView(R.id.tvHp)
    TextView txt_hp;
    @BindView(R.id.tvAlamat)
    TextView txt_alamat;


    public ProfileFragment() {
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
         View view = inflater.inflate(R.layout.fragment_profile, container, false);
        ImageView editProfile = (ImageView) view.findViewById(R.id.edit_profile);



        editProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                assert getFragmentManager() != null;
                FragmentTransaction fr = getFragmentManager().beginTransaction();
                fr.replace(R.id.fl_container, new EditProfileFragment());
                fr.addToBackStack(null);
                fr.commit();
            }
        });

        getProfile();

        return view;


    }

    private void getProfile() {
        ApiInterface apiInterface = Api.getUrl().create(ApiInterface.class);
        Call<User> call = apiInterface.profile();
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                txt_nama.setText(response.body().getNama());
                txt_email.setText(response.body().getEmail());
                txt_hp.setText(response.body().getNohp());
                txt_alamat.setText(response.body().getAlamat());
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {

            }
        });

    }






}
