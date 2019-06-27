package com.mppl.smartkosanapp.adapter;

import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.bumptech.glide.Glide;
import com.mppl.smartkosanapp.Fragment.KamarFragment;
import com.mppl.smartkosanapp.R;
import com.mppl.smartkosanapp.model.Kamar;

import java.util.List;

public class KamarAdapter extends RecyclerView.Adapter<KamarAdapter.MyViewHolder> {


    private KamarFragment mContext;
    private List<Kamar> kamarList;

    public KamarAdapter(FragmentActivity activity) {
    }


    public class MyViewHolder extends RecyclerView.ViewHolder{
            public TextView kode,status;
            public ImageView gambar;

        public MyViewHolder(View view) {
            super(view);
            kode = view.findViewById(R.id.tv_kode_kamar);
            status = view.findViewById(R.id.status);
            gambar = view.findViewById(R.id.im_kamar);

        }
    }

    public KamarAdapter (KamarFragment mContext,List<Kamar> kamarList){
        this.mContext = mContext;
        this.kamarList = kamarList;
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_kamar,parent,false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        Kamar kamar = kamarList.get(position);
        holder.kode.setText(""+(kamar.getKodeKamar()));
        holder.status.setText(kamar.getStatus());

        Glide.with(mContext).load(kamar.getGambar()).into(holder.gambar);
    }

    @Override
    public int getItemCount() {
        return kamarList.size();
    }
}
