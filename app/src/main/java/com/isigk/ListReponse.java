package com.isigk;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.isigk.Adapter.EncadreurAdapter;
import com.isigk.Adapter.ReponseAdapter;
import com.isigk.Api.ApiRequest;
import com.isigk.Api.RetrofitService;
import com.isigk.Model.DataModel;
import com.isigk.Model.ResponseDataModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListReponse extends AppCompatActivity {
    private RecyclerView RecycleLayout;
    private RecyclerView.LayoutManager RecycleManager;
    private RecyclerView.Adapter reponseAdapter;
    String id_etudiant;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_reponse);
        RecycleLayout = findViewById(R.id.recyclerview);

        Bundle data = getIntent().getExtras();

        if (data != null) {
            id_etudiant = data.getString("id_etudiant");
            Toast.makeText(this, id_etudiant, Toast.LENGTH_SHORT).show();
        }

        ApiRequest api = RetrofitService.getClient().create(ApiRequest.class);
        Call<ResponseDataModel> encadreurs=api.ReponseEncadrement(id_etudiant);

        encadreurs.enqueue(new Callback<ResponseDataModel>() {
            @Override
            public void onResponse(Call<ResponseDataModel> call, Response<ResponseDataModel> response) {
                String code = response.body().getCode();
                List<DataModel> item = response.body().getResult();

                if (code.equals("1")) {
                    RecycleManager = new LinearLayoutManager(ListReponse.this, LinearLayoutManager.VERTICAL, false);

                    RecycleLayout.setLayoutManager(RecycleManager);

                    reponseAdapter = new ReponseAdapter(item, ListReponse.this);

                    RecycleLayout.setAdapter(reponseAdapter);
                }
            }

            @Override
            public void onFailure(Call<ResponseDataModel> call, Throwable t) {
                Toast.makeText(ListReponse.this, "Problem Connexion", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
