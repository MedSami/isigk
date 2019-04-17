package com.isigk.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.isigk.Model.DataModel;
import com.isigk.R;

import java.util.List;



public class ReponseAdapter extends RecyclerView.Adapter<ReponseAdapter.ActorViewHolder> {

    List<DataModel> items;
    private Context ctx;

    public ReponseAdapter(List<DataModel> items, Context ctx) {
        this.items = items;
        this.ctx=ctx;


    }

    @Override
    public ReponseAdapter.ActorViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_rows_reponse,viewGroup,false);

        ReponseAdapter.ActorViewHolder Actionview = new ReponseAdapter.ActorViewHolder(v);
        return Actionview;
    }

    @Override
    public void onBindViewHolder(ReponseAdapter.ActorViewHolder holder, int position) {
        DataModel dm = items.get(position);
        holder.txtEncadreur.setText(dm.getNomencadreur());
        holder.txtResponse.setText(dm.getNomdemande());
        holder.dm=dm;

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public  class ActorViewHolder extends RecyclerView.ViewHolder{
        TextView txtEncadreur,txtResponse;
        DataModel dm;
        public ActorViewHolder(View itemView) {
            super(itemView);

            txtEncadreur =  itemView.findViewById(R.id.txtEncadreur);
            txtResponse =  itemView.findViewById(R.id.txtReponse);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });

        }
    }

}
