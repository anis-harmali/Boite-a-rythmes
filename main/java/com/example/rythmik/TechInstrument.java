package com.example.rythmik;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;

import com.example.rythmik.R;

public class TechInstrument extends AppCompatActivity {

    public static Principal p;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /*
          Fait le lien entre la classe et le Layout.
         */
        setContentView(R.layout.activity_tech_instrument);


        /*
          Modification de la taille de l'activité
         */
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        int width = dm.widthPixels;
        int height = dm.heightPixels;
        getWindow().setLayout((int)(width*.8),(int)(height*.6));


        Button retour;
        retour = findViewById(R.id.buttonTechRetour);


        final Button buttonTech[] = new Button[6]; //Tableau de Button représentant les instruments de style Techno

        /*
          Création d'une string pour obtenir l'id des Button pour les instruments de style Techno
          Initialisation du tableau en fonction des ID obtenues.
         */
        int i;
        for (i = 0; i < 6; i++) {

            String buttonID = "Tech" + (i + 1);
            int resID = getResources().getIdentifier(buttonID, "id", getPackageName());
            buttonTech[i] = findViewById(resID);
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

        buttonTech[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                p.sqr.setSample(p.irow,R.raw.tech1);
                p.instruButton[p.irow].setBackgroundResource(R.drawable.son);
                finish();
            }
        });

        buttonTech[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                p.sqr.setSample(p.irow,R.raw.tech2);
                p.instruButton[p.irow].setBackgroundResource(R.drawable.son);
                finish();
            }
        });

        buttonTech[2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                p.sqr.setSample(p.irow,R.raw.tech3);
                p.instruButton[p.irow].setBackgroundResource(R.drawable.clap);
                finish();
            }
        });

        buttonTech[3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                p.sqr.setSample(p.irow,R.raw.tech4);
                p.instruButton[p.irow].setBackgroundResource(R.drawable.cymbale);
                finish();
            }
        });

        buttonTech[4].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                p.sqr.setSample(p.irow,R.raw.tech5);
                p.instruButton[p.irow].setBackgroundResource(R.drawable.drum);
                finish();
            }
        });

        buttonTech[5].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                p.sqr.setSample(p.irow,R.raw.tech6);
                p.instruButton[p.irow].setBackgroundResource(R.drawable.son);
                finish();
            }
        });

    }
}