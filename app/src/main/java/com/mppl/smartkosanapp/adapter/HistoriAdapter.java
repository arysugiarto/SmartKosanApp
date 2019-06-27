package com.mppl.smartkosanapp.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mppl.smartkosanapp.R;
import com.mppl.smartkosanapp.model.Histori;

import java.util.List;

public class HistoriAdapter extends RecyclerView.Adapter<HistoriAdapter.MyViewHolder> {

    private TagihanAdapter mContext;
    private List<Histori> historiList;

    public class MyViewHolder extends RecyclerView.ViewHolder{

        public TextView jenisPembayaran, totalPembayaran, tanggalPembayaran, status;

        public MyViewHolder(@NonNull View view) {
            super(view);

            jenisPembayaran = view.findViewById(R.id.tv_jenis_pembayaran);
            totalPembayaran = view.findViewById(R.id.tv_total_pembayaran);
            tanggalPembayaran = view.findViewById(R.id.tv_nama_klinik);
            status = view.findViewById(R.id.tv_status);
        }

    }

    public HistoriAdapter(TagihanAdapter mContext, List<Histori> historiList) {
        this.mContext = mContext;
        this.historiList = historiList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_histori,parent,false);
        return new HistoriAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Histori histori = historiList.get(position);
        holder.jenisPembayaran.setText(""+(histori.getJenis()));
        holder.tanggalPembayaran.setText(""+(histori.getTglBayar()));
//        holder.totalPembayaran.setText(""+(histori.getTotalPembayaran()));
        holder.totalPembayaran.setText(""+(histori.getStatus()));
    }

    @Override
    public int getItemCount() {
        return historiList.size();
    }
}
