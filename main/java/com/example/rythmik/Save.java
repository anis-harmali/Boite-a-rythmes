package com.example.rythmik;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.StringTokenizer;

public class Save extends AppCompatActivity {


    public static Principal p;
    Button retour;
    Button annuler;
    Button valider;
    EditText nomFichier;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_save);

        /*
          Modification de la taille de l'activité
         */
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        int width = dm.widthPixels;
        int height = dm.heightPixels;
        getWindow().setLayout((int)(width*.8),(int)(height*.6));


        retour = findViewById(R.id.buttonRetourSave);
        annuler = findViewById(R.id.buttonSaveA);
        valider = findViewById(R.id.buttonSaveV);
        nomFichier = findViewById(R.id.fileName);



        Calendar calendar = Calendar.getInstance();
        String currentDate = DateFormat.getDateTimeInstance(DateFormat.MEDIUM, DateFormat.MEDIUM).format(calendar.getTime());

        currentDate = currentDate.replace("AM", "");
        currentDate = currentDate.replace("PM", "");
        StringTokenizer st = new StringTokenizer(currentDate.toString(), "/ ,:");

        String date = "";
        date = date + st.nextToken();
        while(st.hasMoreTokens()) {
            date = date + "-" + st.nextToken();
        }

        nomFichier.setText(date);


        /*
          Méthode permetant de fermer l'activité lors du clic sur le bouton Retour.
         */
        retour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        annuler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


        valider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Save(v);
               finish();
            }
        });

    }


    public void Save(View v) {
        String grille = "" + p.sqr.getBeats() + "," + p.sqr.getBpm() + ",";
        for(int i = 0; i<p.sqr.getRows();i++) {
            for(int j = 0;j<p.sqr.getBeats();j++) {
                if (p.b[i][j].isChecked()) {
                    grille = grille + "1,";
                }
                else {
                    grille = grille + "0,";
                }
            }
        }

        FileOutputStream fos = null;
        String text = nomFichier.getText().toString() + ".txt";

        try {
            fos = openFileOutput(text, MODE_PRIVATE);
            fos.write(grille.getBytes());
            Toast.makeText(this, "Saved to " + getFilesDir() + "/" + text, Toast.LENGTH_LONG).show();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
