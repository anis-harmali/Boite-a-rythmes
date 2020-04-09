package com.example.rythmik;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;

public class StylePopup extends AppCompatActivity {




    public static Principal p;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /*
          Fait le lien entre la classe et le Layout.
         */
        setContentView(R.layout.activity_style_popup);


        /*
          Modification de la taille de l'activité
         */
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        int width = dm.widthPixels;
        int height = dm.heightPixels;
        getWindow().setLayout((int)(width*.8),(int)(height*.6));

        Button retour;
        Button normalStyle;
        Button jazzStyle;
        Button rockStyle;
        Button salsaStyle;
        Button technoStyle;

        /*
         Initialisation des variables avec les boutons du Layout en fonction des id.
         */
        retour = findViewById(R.id.buttonRetour);
        normalStyle = findViewById(R.id.buttonNormal);
        jazzStyle = findViewById(R.id.buttonJazz);
        rockStyle = findViewById(R.id.buttonRock);
        salsaStyle = findViewById(R.id.buttonSalsa);
        technoStyle = findViewById(R.id.buttonTech);


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
          Méthode pour changer le style en Normal (melange des instruments) lors du clic sur le bouton Normal
          Modification de chaque instrument par rapport au style choisi.
         */
        normalStyle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                p.sqr.setSample(0, R.raw.jazz6);
                p.instruButton[0].setBackgroundResource(R.drawable.maracas);
                p.sqr.setSample(1, R.raw.rock4);
                p.instruButton[1].setBackgroundResource(R.drawable.drum);
                p.sqr.setSample(2, R.raw.jazz1);
                p.instruButton[2].setBackgroundResource(R.drawable.clap);
                p.sqr.setSample(3, R.raw.salsa3);
                p.instruButton[3].setBackgroundResource(R.drawable.cymbale);
                p.sqr.setSample(4,R.raw.salsa4);
                p.instruButton[4].setBackgroundResource(R.drawable.drum);
                p.sqr.setSample(5,R.raw.jazz2);
                p.instruButton[5].setBackgroundResource(R.drawable.clap);
                finish();
            }
        });

        /*
          Méthode pour changer le style en Jazz (melange des instruments) lors du clic sur le bouton Jazz
          Modification de chaque instrument par rapport au style choisi.
         */
        jazzStyle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                p.sqr.setSample(0, R.raw.jazz4);
                p.instruButton[0].setBackgroundResource(R.drawable.drum);
                p.sqr.setSample(1, R.raw.jazz6);
                p.instruButton[1].setBackgroundResource(R.drawable.maracas);
                p.sqr.setSample(2, R.raw.jazz2);
                p.instruButton[2].setBackgroundResource(R.drawable.clap);
                p.sqr.setSample(3, R.raw.jazz3);
                p.instruButton[3].setBackgroundResource(R.drawable.cymbale);
                p.sqr.setSample(4,R.raw.jazz1);
                p.instruButton[4].setBackgroundResource(R.drawable.clap);
                p.sqr.setSample(5,R.raw.jazz5);
                p.instruButton[5].setBackgroundResource(R.drawable.drum);
                finish();
            }
        });

        /*
          Méthode pour changer le style en Rock (melange des instruments) lors du clic sur le bouton Rock
          Modification de chaque instrument par rapport au style choisi.
         */
        rockStyle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                p.sqr.setSample(0, R.raw.rock1);
                p.instruButton[0].setBackgroundResource(R.drawable.bass);
                p.sqr.setSample(1, R.raw.rock4);
                p.instruButton[1].setBackgroundResource(R.drawable.drum);
                p.sqr.setSample(2, R.raw.rock2);
                p.instruButton[2].setBackgroundResource(R.drawable.clap);
                p.sqr.setSample(3, R.raw.rock3);
                p.instruButton[3].setBackgroundResource(R.drawable.cymbale);
                p.sqr.setSample(4,R.raw.jazz4);
                p.instruButton[4].setBackgroundResource(R.drawable.drum);
                p.sqr.setSample(5,R.raw.salsa3);
                p.instruButton[5].setBackgroundResource(R.drawable.cymbale);
                finish();
            }
        });

        /*
          Méthode pour changer le style en Salsa (melange des instruments) lors du clic sur le bouton Salsa
          Modification de chaque instrument par rapport au style choisi.
         */
        salsaStyle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                p.sqr.setSample(0, R.raw.salsa5);
                p.instruButton[0].setBackgroundResource(R.drawable.maracas);
                p.sqr.setSample(1, R.raw.salsa4);
                p.instruButton[1].setBackgroundResource(R.drawable.drum);
                p.sqr.setSample(2, R.raw.salsa2);
                p.instruButton[2].setBackgroundResource(R.drawable.clap);
                p.sqr.setSample(3, R.raw.salsa3);
                p.instruButton[3].setBackgroundResource(R.drawable.cymbale);
                p.sqr.setSample(4,R.raw.salsa1);
                p.instruButton[4].setBackgroundResource(R.drawable.clap);
                p.sqr.setSample(5,R.raw.jazz4);
                p.instruButton[5].setBackgroundResource(R.drawable.drum);
                finish();
            }
        });

        /*
          Méthode pour changer le style en Techno (melange des instruments) lors du clic sur le bouton Techno
          Modification de chaque instrument par rapport au style choisi.
         */
        technoStyle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                p.sqr.setSample(0, R.raw.tech1);
                p.instruButton[0].setBackgroundResource(R.drawable.son);
                p.sqr.setSample(1, R.raw.tech5);
                p.instruButton[1].setBackgroundResource(R.drawable.drum);
                p.sqr.setSample(2, R.raw.tech3);
                p.instruButton[2].setBackgroundResource(R.drawable.clap);
                p.sqr.setSample(3, R.raw.tech4);
                p.instruButton[3].setBackgroundResource(R.drawable.cymbale);
                p.sqr.setSample(4,R.raw.tech6);
                p.instruButton[4].setBackgroundResource(R.drawable.son);
                p.sqr.setSample(5,R.raw.tech2);
                p.instruButton[5].setBackgroundResource(R.drawable.son);
                finish();
            }
        });

    }
}