package com.example.rythmik;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;

public class SalsaInstrument extends AppCompatActivity {

    public static Principal p;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /*
          Fait le lien entre la classe et le Layout.
         */
        setContentView(R.layout.activity_salsa_instrument);


        /*
          Modification de la taille de l'activité
         */
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        int width = dm.widthPixels;
        int height = dm.heightPixels;
        getWindow().setLayout((int)(width*.8),(int)(height*.6));


        Button retour;
        retour = findViewById(R.id.buttonSalsaRetour);


        final Button buttonSalsa[] = new Button[6]; //Tableau de Button représentant les instruments de style Salsa

        /*
          Création d'une string pour obtenir l'id des Button pour les instruments de style Salsa.
          Initialisation du tableau en fonction des ID obtenues.
         */
        int i;
        for (i = 0; i < 5; i++) {

            String buttonID = "Salsa" + (i + 1);
            int resID = getResources().getIdentifier(buttonID, "id", getPackageName());
            buttonSalsa[i] = findViewById(resID);
        }



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
          Méthodes permetant la modification de l'instrument lors du clic sur le bouton de l'instrument souhaité.
          Et modification dans le Sequencer de la classe Principal avec la methode setSample
         */

        buttonSalsa[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                p.sqr.setSample(p.irow,R.raw.salsa1);
                p.instruButton[p.irow].setBackgroundResource(R.drawable.clap);
                finish();
            }
        });


        buttonSalsa[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                p.sqr.setSample(p.irow,R.raw.salsa2);
                p.instruButton[p.irow].setBackgroundResource(R.drawable.clap);
                finish();
            }
        });

        buttonSalsa[2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                p.sqr.setSample(p.irow,R.raw.salsa3);
                p.instruButton[p.irow].setBackgroundResource(R.drawable.cymbale);
                finish();
            }
        });

        buttonSalsa[3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                p.sqr.setSample(p.irow,R.raw.salsa4);
                p.instruButton[p.irow].setBackgroundResource(R.drawable.drum);
                finish();
            }
        });

        buttonSalsa[4].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                p.sqr.setSample(p.irow,R.raw.salsa5);
                p.instruButton[p.irow].setBackgroundResource(R.drawable.maracas);
                finish();
            }
        });

    }
}
