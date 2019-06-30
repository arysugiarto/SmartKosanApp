package com.mppl.smartkosanapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mppl.smartkosanapp.Activity.KamarActivity;
import com.mppl.smartkosanapp.R;
import com.mppl.smartkosanapp.model.Tagihan;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TagihanAdapter extends RecyclerView.Adapter<TagihanAdapter.ListViewHolder> {

    private TagihanAdapter mContext;
    private List<Tagihan> tagihanList;
    private FragmentActivity activity;

    public List<Tagihan> getTagihanList() {
        return tagihanList;
    }

    public void setTagihanList(List<Tagihan> tagihanList) {
        this.tagihanList = tagihanList;
    }


    public void setActivity(Context activity) {
        this.activity = (FragmentActivity) activity;
    }

    public TagihanAdapter(FragmentActivity activity) {
        this.activity = activity;
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
        final Tagihan tagihan = tagihanList.get(position);
        holder.jenisTagihan.setText(""+(tagihan.getJenis()));
        holder.tanggal.setText(""+(tagihan.getTglBayar()));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(mContext.getActivity(), KamarActivity.class);
                i.putExtra("jenis",tagihan.getJenis());
                i.putExtra("tgl",tagihan.getTglBayar());
//                i.putExtra("gambar1",p.getGambar());
                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                mContext.getActivity().startActivity(i);

            }
        });
    }


    @Override
    public int getItemCount() {
        return tagihanList.size();
    }

    public Context getActivity() {
        return activity;
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
