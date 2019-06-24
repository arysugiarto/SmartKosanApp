package com.mppl.smartkosanapp.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.mppl.smartkosanapp.Fragment.TagihanFragment;
import com.mppl.smartkosanapp.R;
import com.mppl.smartkosanapp.model.Tagihan;

import java.util.List;

public class TagihanAdapter extends RecyclerView.Adapter<TagihanAdapter.MyViewHolder> {

    private TagihanAdapter mContext;
    private List<Tagihan> tagihanList;

    public class MyViewHolder extends RecyclerView.ViewHolder{

        public TextView jenisTagihan, totalTagihan, tanggal;

        public MyViewHolder(@NonNull View view) {
            super(view);

            jenisTagihan = view.findViewById(R.id.tv_jenis_tagihan);
            totalTagihan = view.findViewById(R.id.tv_harga_klinik);
            tanggal = view.findViewById(R.id.tv_nama_klinik);
        }

    }

    public TagihanAdapter(TagihanAdapter mContext, List<Tagihan> tagihanList) {
        this.mContext = mContext;
        this.tagihanList = tagihanList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_tagihan,parent,false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        Tagihan tagihan = tagihanList.get(position);
        holder.jenisTagihan.setText(""+(tagihan.getJenisTagihan()));
        holder.tanggal.setText(""+(tagihan.getTanggal()));
        holder.totalTagihan.setText(""+(tagihan.getTotalTagihan()));

    }

    @Override
    public int getItemCount() {
        return tagihanList.size();
    }
}
