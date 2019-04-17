package com.isigk;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MenuEtudiant extends AppCompatActivity {
Button btnListeEncadreur,btnReponseEncadreur,btnConsulterJurys,btnRempliFiche;
String id_etudiant;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_etudiant);
        btnConsulterJurys=findViewById(R.id.btnJurys);
        btnListeEncadreur=findViewById(R.id.btnListEncadreur);
        btnReponseEncadreur=findViewById(R.id.btnReponse);
        btnRempliFiche=findViewById(R.id.btnRempli);



        Bundle data = getIntent().getExtras();

        if (data != null) {
            id_etudiant = data.getString("idEtudiant");

        }

        btnRempliFiche.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(MenuEtudiant.this,FicheEncadrement.class);
                i.putExtra("id_etudiant",id_etudiant);
                startActivity(i);
            }
        });

        btnConsulterJurys.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(MenuEtudiant.this,Soutenance.class);
                i.putExtra("id_etudiant",id_etudiant);
                startActivity(i);
            }
        });
        btnListeEncadreur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(MenuEtudiant.this,ListEncadreur.class);
                i.putExtra("id_etudiant",id_etudiant);
                startActivity(i);
            }
        });
        btnReponseEncadreur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(MenuEtudiant.this,ListReponse.class);
                i.putExtra("id_etudiant",id_etudiant);
                startActivity(i);
            }
        });
    }
}
