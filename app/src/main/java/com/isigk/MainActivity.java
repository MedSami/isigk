package com.isigk;

import android.content.Intent;
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

public class MainActivity extends AppCompatActivity {
EditText edtCin,edtPassword;
Button btnEntrer,btnInscrire;
int index;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    edtCin=findViewById(R.id.edtCin);
    edtPassword=findViewById(R.id.edtMotDePasse);
    btnEntrer=findViewById(R.id.btnEntrer);
    btnInscrire=findViewById(R.id.btnInscrire);

        // Spinner element
        Spinner spinner =  findViewById(R.id.spinner);


        // Spinner Drop down elements
        List<String> utilisateurs = new ArrayList<String>();
        utilisateurs.add("Encadreur");
        utilisateurs.add("Etudiant");


        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, utilisateurs);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        spinner.setAdapter(dataAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                index= position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });



    btnEntrer.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if(edtCin.getText().toString().equals("") || edtCin.getText().toString().length()!=8){
                Toast.makeText(MainActivity.this, "Verifier votre CIN SVP", Toast.LENGTH_SHORT).show();
            }else if(edtPassword.getText().toString().equals("")){
                Toast.makeText(MainActivity.this, "Saisir Mot De Passe SVP", Toast.LENGTH_SHORT).show();
            }else {
                ApiRequest api= RetrofitService.getClient().create(ApiRequest.class);
                //Instance Call Methode
                Call<ResponseDataModel> Login=api.Login(edtCin.getText().toString(),""+index);
Login.enqueue(new Callback<ResponseDataModel>() {
    @Override
    public void onResponse(Call<ResponseDataModel> call, Response<ResponseDataModel> response) {
        if(response.isSuccessful()){
            if(!response.body().getResult().isEmpty()) {
                if (response.body().getResult().get(0).getnCin().equals(edtCin.getText().toString())) {
                    if (response.body().getResult().get(0).getMotDePasse().equals(edtPassword.getText().toString())) {

                        if (index == 0) {

                            Intent intent = new Intent(MainActivity.this, MenuEncadreur.class);
                            intent.putExtra("idEncadreur", "" + response.body().getResult().get(0).getId());
                            startActivity(intent);
                        }
                        if (index == 1) {

                            Intent intent = new Intent(MainActivity.this, MenuEtudiant.class);
                            intent.putExtra("idEtudiant", "" + response.body().getResult().get(0).getId());
                            startActivity(intent);
                        }


                    } else {
                        Toast.makeText(MainActivity.this, "Mot De Passe Incorrect", Toast.LENGTH_SHORT).show();
                    }
                } else {

                    Toast.makeText(MainActivity.this, "CIN Incorrect", Toast.LENGTH_SHORT).show();

                }
            }else {
                Toast.makeText(MainActivity.this, "CIN Incorrect", Toast.LENGTH_SHORT).show();

            }
        }else {
            Toast.makeText(MainActivity.this, "CIN Incorrect3", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onFailure(Call<ResponseDataModel> call, Throwable t) {
        Toast.makeText(MainActivity.this, "Problem Connexion", Toast.LENGTH_SHORT).show();
    }
});
            }
        }
    });

    btnInscrire.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {

        }
    });

    }
}
