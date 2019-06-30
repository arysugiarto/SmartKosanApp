package com.mppl.smartkosanapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.mppl.smartkosanapp.Activity.KamarActivity;
import com.mppl.smartkosanapp.Fragment.KamarFragment;
import com.mppl.smartkosanapp.R;
import com.mppl.smartkosanapp.model.Kamar;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class KamarAdapter extends RecyclerView.Adapter<KamarAdapter.ListViewHolder> {


    private KamarFragment mContext;
    private Context context;
    private List<Kamar> kamarList;

    public KamarAdapter(KamarFragment kamarFragment, List<Kamar> kamarList) {
        this.mContext = mContext;
        this.kamarList = kamarList;
    }

    public List<Kamar> getKamarList() {
        return kamarList;
    }

    public void setKamarList(List<Kamar> kamarList) {
        this.kamarList = kamarList;
    }

    public KamarAdapter(FragmentActivity activity) {
        this.context = activity;
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
        Glide.with(context)
                .load("http://kosan.haptic.id/foto_kamar/"+p.getGambar())
                .into(holder.tvImage);
        holder.tvId.setText(p.getIdKamar());
        holder.tvKode.setText(p.getKodeKamar());
        holder.tvStatus.setText(p.getKet());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(mContext.getActivity(), KamarActivity.class);
                i.putExtra("kode",p.getKodeKamar());
                i.putExtra("ket",p.getKet());
                i.putExtra("foto",p.getGambar());
                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                mContext.getActivity().startActivity(i);

            }
        });
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
        @BindView(R.id.im_kamar)
        ImageView tvImage;


        public ListViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}

