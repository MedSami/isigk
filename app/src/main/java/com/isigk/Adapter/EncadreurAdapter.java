package com.isigk.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.isigk.Api.ApiRequest;
import com.isigk.Api.RetrofitService;
import com.isigk.Model.DataModel;
import com.isigk.Model.ResponseDataModel;
import com.isigk.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EncadreurAdapter extends RecyclerView.Adapter<EncadreurAdapter.ActorViewHolder> {

    List<DataModel> items;
    private Context ctx;
    String idEtudiant;
    public EncadreurAdapter(List<DataModel> items, Context ctx,String idEtudiant) {
        this.items = items;
        this.ctx=ctx;
        this.idEtudiant=idEtudiant;


    }

    @Override
    public EncadreurAdapter.ActorViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_rows_encadreur,viewGroup,false);

        EncadreurAdapter.ActorViewHolder Actionview = new EncadreurAdapter.ActorViewHolder(v);
        return Actionview;
    }

    @Override
    public void onBindViewHolder(EncadreurAdapter.ActorViewHolder holder, int position) {
        DataModel dm = items.get(position);
        holder.txtEncadreur.setText(dm.getNomencadreur());
        holder.txtDomaine.setText(dm.getDomaine());
        holder.dm=dm;

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public  class ActorViewHolder extends RecyclerView.ViewHolder{
        TextView txtEncadreur,txtDomaine;
        DataModel dm;
        public ActorViewHolder(View itemView) {
            super(itemView);

            txtEncadreur =  itemView.findViewById(R.id.txtEncadreur);
            txtDomaine =  itemView.findViewById(R.id.txtDomaine);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ApiRequest api= RetrofitService.getClient().create(ApiRequest.class);
                    //Instance Call Methode
                    Call<ResponseDataModel> demande=api.DemandeEncadrement(dm.getId(),idEtudiant);
                    demande.enqueue(new Callback<ResponseDataModel>() {
                        @Override
                        public void onResponse(Call<ResponseDataModel> call, Response<ResponseDataModel> response) {
                            Toast.makeText(ctx, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                        }

                        @Override
                        public void onFailure(Call<ResponseDataModel> call, Throwable t) {
                            Toast.makeText(ctx, "Problem Connexion", Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            });

        }
    }

}
