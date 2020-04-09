package com.example.rythmik;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;

public class RockInstrument extends AppCompatActivity {

    public static Principal p;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /*
          Fait le lien entre la classe et le Layout.
         */
        setContentView(R.layout.activity_rock_instrument);


        /*
          Modification de la taille de l'activité
         */
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        int width = dm.widthPixels;
        int height = dm.heightPixels;
        getWindow().setLayout((int)(width*.8),(int)(height*.6));


        Button retour;
        retour = findViewById(R.id.buttonRockRetour);


        final Button buttonRock[] = new Button[6]; //Tableau de Button représentant les instruments de style Rock

        /*
          Création d'une string pour obtenir l'id des Button pour les instruments de style Rock.
          Initialisation du tableau en fonction des ID obtenues.
         */
        int i;
        for (i = 0; i < 4; i++) {

            String buttonID = "Rock" + (i + 1);
            int resID = getResources().getIdentifier(buttonID, "id", getPackageName());
            buttonRock[i] = findViewById(resID);
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

        buttonRock[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                p.sqr.setSample(p.irow,R.raw.rock1);
                p.instruButton[p.irow].setBackgroundResource(R.drawable.bass);
                finish();
            }
        });

        buttonRock[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                p.sqr.setSample(p.irow,R.raw.rock2);
                p.instruButton[p.irow].setBackgroundResource(R.drawable.clap);
                finish();
            }
        });

        buttonRock[2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                p.sqr.setSample(p.irow,R.raw.rock3);
                p.instruButton[p.irow].setBackgroundResource(R.drawable.cymbale);
                finish();
            }
        });

        buttonRock[3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                p.sqr.setSample(p.irow,R.raw.rock4);
                p.instruButton[p.irow].setBackgroundResource(R.drawable.drum);
                finish();
            }
        });

    }
}
