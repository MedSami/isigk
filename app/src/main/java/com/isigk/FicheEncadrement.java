package com.isigk;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.isigk.Api.ApiRequest;
import com.isigk.Api.RetrofitService;
import com.isigk.Model.ResponseDataModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FicheEncadrement extends AppCompatActivity {
EditText edtNomProjet,edtNomEntreprise;
Button btnEnregistrer;
int index;
String id_etudiant;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fiche_encadrement);
        edtNomEntreprise=findViewById(R.id.edtNomEntreprise);
        edtNomProjet=findViewById(R.id.edtNomProjet);
        btnEnregistrer=findViewById(R.id.btnEnregistrer);

        Bundle data = getIntent().getExtras();

        if (data != null) {
            id_etudiant = data.getString("id_etudiant");

        }

        // Spinner element
        Spinner spinner =  findViewById(R.id.spinner);


        // Spinner Drop down elements
        List<String> jurys = new ArrayList<String>();
        jurys.add("Choisir Encadreur");
        jurys.add("Karoui Jalel");
        jurys.add("Gafsi Chadlia");


        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, jurys);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        spinner.setAdapter(dataAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                //item = adapterView.getItemAtPosition(position).toString();
                index= position;
                Toast.makeText(FicheEncadrement.this, index+"-"+id_etudiant, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });



        btnEnregistrer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 if (edtNomEntreprise.getText().toString().equals("")){
                    Toast.makeText(FicheEncadrement.this, "Saisir Nom Entreprise", Toast.LENGTH_SHORT).show();
                }else if (edtNomProjet.getText().toString().equals("")){
                    Toast.makeText(FicheEncadrement.this, "Saisir Nom Projet", Toast.LENGTH_SHORT).show();
                }else if(index==0){
                     Toast.makeText(FicheEncadrement.this, "Choisir Encadreur", Toast.LENGTH_SHORT).show();
                 }else {
                     ApiRequest api = RetrofitService.getClient().create(ApiRequest.class);
                     Call<ResponseDataModel> ficheEncadrement=api.FicheEncadrement(index,edtNomEntreprise.getText().toString(),edtNomProjet.getText().toString(),id_etudiant);
    ficheEncadrement.enqueue(new Callback<ResponseDataModel>() {
    @Override
    public void onResponse(Call<ResponseDataModel> call, Response<ResponseDataModel> response) {
        Toast.makeText(FicheEncadrement.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onFailure(Call<ResponseDataModel> call, Throwable t) {
        Toast.makeText(FicheEncadrement.this, "Problem Connexion", Toast.LENGTH_SHORT).show();
    }
});
                 }
            }
        });

    }
}
