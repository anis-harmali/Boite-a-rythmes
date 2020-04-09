package com.example.rythmik;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;

public class JazzInstrument extends AppCompatActivity {

    public static Principal p;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /*
          Fait le lien entre la classe et le Layout.
         */
        setContentView(R.layout.activity_jazz_instrument);


        /*
          Modification de la taille de l'activité
         */
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        int width = dm.widthPixels;
        int height = dm.heightPixels;
        getWindow().setLayout((int)(width*.8),(int)(height*.6));


        Button retour;
        retour = findViewById(R.id.buttonJazzRetour);

        final Button buttonJazz[] = new Button[6]; //Tableau de Button représentant les instruments de style Jazz

        /*
          Création d'une string pour obtenir l'id des Button pour les instruments de style Jazz.
          Initialisation du tableau en fonction des ID obtenues.
         */
        int i;
        for (i = 0; i < 6; i++) {

            String buttonID = "Jazz" + (i + 1);
            int resID = getResources().getIdentifier(buttonID, "id", getPackageName());
            buttonJazz[i] = findViewById(resID);
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

        buttonJazz[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                p.sqr.setSample(p.irow,R.raw.jazz1);
                p.instruButton[p.irow].setBackgroundResource(R.drawable.clap);
                finish();
            }
        });

        buttonJazz[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                p.sqr.setSample(p.irow,R.raw.jazz2);
                p.instruButton[p.irow].setBackgroundResource(R.drawable.clap);
                finish();
            }
        });

        buttonJazz[2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                p.sqr.setSample(p.irow,R.raw.jazz3);
                p.instruButton[p.irow].setBackgroundResource(R.drawable.cymbale);
                finish();
            }
        });

        buttonJazz[3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                p.sqr.setSample(p.irow,R.raw.jazz4);
                p.instruButton[p.irow].setBackgroundResource(R.drawable.drum);
                finish();
            }
        });

        buttonJazz[4].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                p.sqr.setSample(p.irow,R.raw.jazz5);
                p.instruButton[p.irow].setBackgroundResource(R.drawable.drum);
                finish();
            }
        });

        buttonJazz[5].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                p.sqr.setSample(p.irow,R.raw.jazz6);
                p.instruButton[p.irow].setBackgroundResource(R.drawable.maracas);
                finish();
            }
        });

    }
}
