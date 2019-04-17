package com.isigk;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.isigk.Api.ApiRequest;
import com.isigk.Api.RetrofitService;
import com.isigk.Model.ResponseDataModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Soutenance extends AppCompatActivity {
TextView txtDate,txtNomJury,txtTemp;
String id_etudiant;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soutenance);

        txtDate=findViewById(R.id.txtDate);
        txtNomJury=findViewById(R.id.txtNomJury);
        txtTemp=findViewById(R.id.txtTemp);
        Bundle data = getIntent().getExtras();

        if (data != null) {
            id_etudiant = data.getString("id_etudiant");
        }

        ApiRequest api = RetrofitService.getClient().create(ApiRequest.class);
        Call<ResponseDataModel> soutenance=api.Soutenance(id_etudiant);
soutenance.enqueue(new Callback<ResponseDataModel>() {
    @Override
    public void onResponse(Call<ResponseDataModel> call, Response<ResponseDataModel> response) {
        if(response.isSuccessful()){
            if(!response.body().getResult().isEmpty()){
            txtDate.setText("Votre Soutenance sera Le : "+response.body().getResult().get(0).getDate());
            txtTemp.setText("a : "+response.body().getResult().get(0).getHoraire());
            txtNomJury.setText("Jury Mr/Mme/Mlle : "+response.body().getResult().get(0).getNom_jury());
        }else {
                txtDate.setText("Votre Soutenance sera Le : Pas Encore");
                txtTemp.setText("a : Pas Encore");
                txtNomJury.setText("Jury Mr/Mme/Mlle : Pas Encore");            }
        }
    }

    @Override
    public void onFailure(Call<ResponseDataModel> call, Throwable t) {
        Toast.makeText(Soutenance.this, "Problem Connexion", Toast.LENGTH_SHORT).show();
    }
});

    }
}
