package com.example.rythmik;


import android.content.Intent;
import android.graphics.Color;
import android.graphics.pdf.PdfDocument;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.ToggleButton;


public class Principal extends AppCompatActivity {

    public int bpm;

    /*
      Création du Sequencer
     */
    Sequencer sqr = new Sequencer(this,6,20);


    private ToggleButton play;
    public TextView mesureNumber;
    public TextView bpmNumber;
    private Button bpmPlus;
    private Button bpmMinus;
    private Button reset;
    private Button style;
    private Button save;
    private Button load;
    private Button mesurePlus;
    private Button mesureMinus;
    public int i;


    public int irow; //Ligne de l'instrument
    public ImageButton instruButton[] = new ImageButton[6]; //Bouton pour les instruments
    public ToggleButton b[][] = new ToggleButton[sqr.getRows()][sqr.getBeats()]; //Tableau de ToggleButton pour la grille




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        /*
          Fait le lien entre la classe et le Layout.
         */
        setContentView(R.layout.activity_principal);


        /*
         Initialisation des variables avec les boutons du Layout en fonction des id.
         */
        play = findViewById(R.id.playButton);
        mesureNumber = findViewById(R.id.MesureNumber);
        bpmNumber = findViewById(R.id.bpmNumber);
        bpmPlus = findViewById(R.id.buttonBpmPlus);
        bpmMinus = findViewById(R.id.buttonBpmMinus);
        reset = findViewById(R.id.buttonReset);
        style = findViewById(R.id.buttonStyle);
        save = findViewById(R.id.buttonSauv_principal);
        load = findViewById(R.id.buttonCharg_principal);
        mesurePlus = findViewById(R.id.buttonMesurePlus);
        mesureMinus = findViewById(R.id.buttonMesureMinus);


        /*
         Variable de type Principal se trouvant dans les autres classes
         */
        StylePopup.p = this;
        ModifInstru.p = this;
        JazzInstrument.p = this;
        RockInstrument.p = this;
        SalsaInstrument.p = this;
        TechInstrument.p = this;
        Save.p = this;
        Load.p = this;
        PageAccueil.p = this;


        /*
          Création d'une string pour obtenir l'id des ImageButton pour les instruments.
          Initialisation du tableau en fonction des ID obtenues.
         */
        for (i = 0; i < sqr.getRows(); i++) {

            String buttonID = "Button" + (i + 1) + "0";
            int resID = getResources().getIdentifier(buttonID, "id", getPackageName());
            instruButton[i] = findViewById(resID);
        }



        /*
          Modification de l'affichage pour le nombre du BPM
          Utilisation de la méthode getBpm de la classe Sequencer
         */
        bpmNumber.setText("" + sqr.getBpm());
        bpm = Integer.parseInt(bpmNumber.getText().toString());


        /*
          Initialisation des instruments avec la méthode setSample de la classe Sequencer
         */
        sqr.setSample(0, R.raw.jazz6);
        sqr.setSample(1, R.raw.rock4);
        sqr.setSample(2, R.raw.jazz1);
        sqr.setSample(3, R.raw.salsa3);
        sqr.setSample(4, R.raw.salsa4);
        sqr.setSample(5, R.raw.jazz2);


        /*
          Méthode pour l'augmentation du BPM lors d'un clic sur "+".
          Incrémentation de 10 en 10, BPM maximum = 1000.
          Utilisation de la méthode getBpm et setBpm de la classe Sequencer
          Et modification de l'affichage.
         */
        bpmPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(sqr.getBpm() < 1000) {
                    bpmNumber.setText("" + (bpm = bpm + 10));
                    sqr.setBpm(bpm);
                }
            }
        });


        /*
          Méthode pour la diminution du BPM lors d'un clic sur "-".
          Décrémentation de 10 en 10, BPM minimum = 10.
          Utilisation de la méthode setBpm dans la classe Sequencer
          Et modification de l'affichage.
         */
        bpmMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(sqr.getBpm() > 10) {
                    bpmNumber.setText("" + (bpm=bpm-10));
                    sqr.setBpm(bpm);
                }
            }
        });


        /*
          Méthode pour la lecture du motif lors d'un clic sur play/pause.
          Utilisation de la méthode toggle() de la classe Sequencer
         */
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sqr.toggle();
            }
        });



        /*
          Méthode pour la modification d'un instrument lors d'un clic sur une icone d'instrument.
          Ouverture de l'activité correspondante et mise en pause de la musique.
          Utilisation de la méthode stop() de la classe Sequencer
         */
        for (int j = 0; j < sqr.getRows(); j++) {
            final int finalJ = j;
            instruButton[j].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(Principal.this, ModifInstru.class));
                    sqr.stop();
                    play.setChecked(false);
                    irow = finalJ;
                }
            });
        }


        /*
          Méthode pour la modification du style lors d'un clic sur le bouton Style.
          Ouverture de l'activité correspondante et mise en pause de la musique.
          Utilisation de la méthode stop() de la classe Sequencer
         */
        style.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Principal.this,StylePopup.class));
                sqr.stop();
                play.setChecked(false);
            }
        });


        /*
          Création d'une string pour obtenir l'id des ToggleButton.
          Initialisation du tableau en fonction des ID obtenues.
          Activation/Désactivation de la case pour le Sequencer avec les méthodes enableCell/disableCell
          Changement de la couleur des cases lorsqu'elles sont activées ou non en fonction de leur placement
         */
        for(int i = 0; i<sqr.getRows();i++) {
            for(int j = 0;j<sqr.getBeats();j++) {

                String buttonID = "toggleButton" + (i+1) + (j+1);
                int resID = getResources().getIdentifier(buttonID, "id", getPackageName());
                b[i][j] = findViewById(resID);

                final int finalI = i;
                final int finalJ = j;
                b[i][j].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (b[finalI][finalJ].isChecked()) {
                            sqr.enableCell(finalI, finalJ);

                            if( (finalJ <2) || (finalJ >3 && finalJ <6) || (finalJ >7 && finalJ <10) || (finalJ >11 && finalJ <14) || (finalJ >15 && finalJ <18))
                                b[finalI][finalJ].setBackgroundColor(Color.GREEN);

                            else b[finalI][finalJ].setBackgroundColor(Color.RED);


                        } else {
                            sqr.disableCell(finalI, finalJ);

                            if( (finalJ <2) || (finalJ >3 && finalJ <6) || (finalJ >7 && finalJ <10) || (finalJ >11 && finalJ <14) || (finalJ >15 && finalJ <18))
                                b[finalI][finalJ].setBackgroundColor(0x8000FF00);

                            else b[finalI][finalJ].setBackgroundColor(0x80FF0000);

                        }
                    }
                });


            }
        }


        /*
          Méthode pour la remise à zero du motif lors d'un clic sur le bouton Reset.
          Désactivation des cases, change la couleur des cases et mise en pause de la musique.
         */
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for(int i = 0; i<sqr.getRows();i++) {
                    for(int j = 0;j<sqr.getMaxBeats() ;j++) {
                        sqr.disableCell(i, j);
                        b[i][j].setChecked(false);
                        if( (j<2) || (j>3 && j<6) || (j>7 && j<10) || (j>11 && j<14) || (j>15 && j<18)) {
                            b[i][j].setBackgroundColor(0x8000FF00);
                        }
                        else b[i][j].setBackgroundColor(0x80FF0000);
                        sqr.stop();
                    }
                    play.setChecked(false);
                }
            }
        });


        /*
         La grille commence avec 2 mesures (8 temps/cases)
         */
        for(int i = 0; i < sqr.getRows(); i++) {
            for(int j = sqr.getBeats(); j > (sqr.getBeats()) - 12; j--) {
                b[i][j-1].setVisibility(View.GONE);
            }
        }
        sqr.deleteColumns(12);
        mesureNumber.setText("" + (sqr.getBeats()) / 4);


        /*
          Méthode pour l'ajout de mesure lors d'un clic sur le bouton "+".
          Mesure maximum = 5 (20 cases)
          Mise en pause de la musique.
          Affichage des 4 cases supplémentaires
          Ajoutes 4 cases (une mesure) dans le Sequencer avec addColumns.
          Et modification de l'affichage.
         */
        mesurePlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!(sqr.getBeats() == sqr.getMaxBeats())) {
                    sqr.stop();
                    for(int i = 0; i < sqr.getRows(); i++) {
                        for(int j = sqr.getBeats(); j <= (sqr.getBeats()) + 4; j++) {
                            b[i][j-1].setVisibility(View.VISIBLE);
                        }
                    }
                    sqr.addColumns(4);
                    mesureNumber.setText("" + (sqr.getBeats()) / 4);
                    play.setChecked(false);
                }
            }
        });

        /*
          Méthode pour la diminution de mesure lors d'un clic sur le bouton "-".
          Mesure minimum = 1 (4 cases)
          Mise en pause de la musique.
          Suppression des 4 cases.
          Enleves 4 cases (une mesure) dans le Sequencer avec deleteColumns.
          Et modification de l'affichage.
         */
        mesureMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!(sqr.getBeats() == 4)) {
                    sqr.stop();
                    for(int i = 0; i < sqr.getRows(); i++) {
                        for(int j = sqr.getBeats(); j > (sqr.getBeats()) - 4; j--) {
                            b[i][j-1].setVisibility(View.GONE);
                        }
                    }
                    sqr.deleteColumns(4);
                    mesureNumber.setText("" + (sqr.getBeats()) / 4);
                    play.setChecked(false);
                }
            }
        });

        /*
          Sauvegarde du motif lors d'un clic sur le bouton Sauv.
          Création d'un fichier dans le repertoire du smartphone
         */
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Principal.this,Save.class));
                sqr.stop();
                play.setChecked(false);
            }
        });

        load.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Principal.this,Load.class));
                sqr.stop();
                play.setChecked(false);
            }
        });

    }



    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    @Override
    public void onPause() {
        super.onPause();
        sqr.stop();
        play.setChecked(false);
    }
}
