package com.mppl.smartkosanapp.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.mppl.smartkosanapp.R;
import com.mppl.smartkosanapp.model.Kamar;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class KamarAdapter extends RecyclerView.Adapter<KamarAdapter.ListViewHolder> {


    private Context mContext;
    private List<Kamar> kamarList;

    public List<Kamar> getKamarList() {
        return kamarList;
    }

    public void setKamarList(List<Kamar> kamarList) {
        this.kamarList = kamarList;
    }

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

    public KamarAdapter (List<Kamar> kamarList){
        this.kamarList = kamarList;
    }
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_kamar, parent, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull KamarAdapter.ListViewHolder holder, int position) {
        final Kamar p = getKamarList().get(position);
        holder.tvId.setText(p.getIdKamar());
        holder.tvKode.setText(p.getKodeKamar());
        holder.tvStatus.setText(p.getStatus());
    }

    @Override
    public int getItemCount() {
        return getKamarList().size();
    }

    class ListViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_kode_kamar)
        TextView tvKode;
        @BindView(R.id.tv_nama_kamar)
        TextView tvId;
        @BindView(R.id.status)
        TextView tvStatus;


        public ListViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}

