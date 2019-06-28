package com.mppl.smartkosanapp.adapter;

import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mppl.smartkosanapp.R;
import com.mppl.smartkosanapp.model.Tagihan;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TagihanAdapter extends RecyclerView.Adapter<TagihanAdapter.ListViewHolder> {

    private TagihanAdapter mContext;
    private List<Tagihan> tagihanList;

    public List<Tagihan> getTagihanList() {
        return tagihanList;
    }

    public void setTagihanList(List<Tagihan> tagihanList) {
        this.tagihanList = tagihanList;
    }

    public TagihanAdapter(FragmentActivity activity) {
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        public TextView jenisTagihan, totalTagihan, tanggal;

        public MyViewHolder(@NonNull View view) {
            super(view);

            jenisTagihan = view.findViewById(R.id.tv_jenis_tagihan);
            totalTagihan = view.findViewById(R.id.tv_harga);
            tanggal = view.findViewById(R.id.tv_nama_klinik);
        }

    }

    public TagihanAdapter(TagihanAdapter mContext, List<Tagihan> tagihanList) {
        this.mContext = mContext;
        this.tagihanList = tagihanList;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_tagihan,parent,false);
        return new ListViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, int position) {
        Tagihan tagihan = tagihanList.get(position);
        holder.jenisTagihan.setText(""+(tagihan.getJenis()));
        holder.tanggal.setText(""+(tagihan.getTglBayar()));
//        holder.harga.setText(""+(tagihan.get()));
    }


    @Override
    public int getItemCount() {
        return tagihanList.size();
    }

    class ListViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_jenis_tagihan)
        TextView jenisTagihan;
        @BindView(R.id.tv_date_tagihan)
        TextView tanggal;
//        @BindView(R.id.tv_harga)
//        TextView harga;
//        @BindView(R.id.tv_harga)
//        TextView tvStatus;


        public ListViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
