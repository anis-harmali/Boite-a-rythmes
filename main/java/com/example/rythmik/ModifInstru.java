package com.example.rythmik;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class ModifInstru extends AppCompatActivity {


    public static Principal p;
    int instruRow;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /*
          Fait le lien entre la classe et le Layout.
         */
        setContentView(R.layout.activity_modif_instru);


        /*
          Modification de la taille de l'activité
         */
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        int width = dm.widthPixels;
        int height = dm.heightPixels;
        getWindow().setLayout((int)(width*.8),(int)(height*.6));



        Button retour;
        Button instruJazz;
        Button instruRock;
        Button instruSalsa;
        Button instruTech;


        /*
         Initialisation des variables avec les boutons du Layout en fonction des id.
         */
        retour = findViewById(R.id.buttonInstruRetour);
        instruJazz = findViewById(R.id.buttonInstruJazz);
        instruRock = findViewById(R.id.buttonInstruRock);
        instruSalsa = findViewById(R.id.buttonInstruSalsa);
        instruTech = findViewById(R.id.buttonInstruTech);


        /*
          Affichage du numero de la ligne de l'instrument que l'on souhaite modifié
         */
        TextView tirow = findViewById(R.id.irow);
        instruRow = p.irow;
        tirow.setText("" + (instruRow+1));



        /*
          Méthode permetant de fermer l'activité lors du clic sur le bouton Retour.
         */
        retour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


        /*
          Méthode permetant de choisir les instruments de style Jazz lors du clic sur le bouton Jazz.
          Ouverture de l'activité correspondante.
         */
        instruJazz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ModifInstru.this, JazzInstrument.class));
            }
        });


        /*
          Méthode permetant de choisir les instruments de style Rock lors du clic sur le bouton Rock.
          Ouverture de l'activité correspondante.
         */
        instruRock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ModifInstru.this, RockInstrument.class));
            }
        });


        /*
          Méthode permetant de choisir les instruments de style Salsa lors du clic sur le bouton Salsa.
          Ouverture de l'activité correspondante.
         */
        instruSalsa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ModifInstru.this, SalsaInstrument.class));
            }
        });


        /*
          Méthode permetant de choisir les instruments de style Techno lors du clic sur le bouton Techno.
          Ouverture de l'activité correspondante.
         */
        instruTech.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ModifInstru.this, TechInstrument.class));
            }
        });
    }
}
