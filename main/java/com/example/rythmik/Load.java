package com.example.rythmik;

import android.content.DialogInterface;
import android.graphics.Color;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Load extends AppCompatActivity {

    public static Principal p;
    Button retour;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load);

        /*
          Modification de la taille de l'activité
         */
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        int width = dm.widthPixels;
        int height = dm.heightPixels;
        getWindow().setLayout((int)(width*.8),(int)(height*.6));


        retour = findViewById(R.id.buttonRetourLoad);

        /*
          Méthode permetant de fermer l'activité lors du clic sur le bouton Retour.
         */
        retour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });



        Button btn1;
        TableLayout tableLayout = findViewById(R.id.loadTL);
        TableRow tr;


        File file = new File("/data/user/0/com.example.rythmik/files");

        boolean testCreation;
        if(!file.exists()) {
            testCreation = file.mkdir();
            if(testCreation) {
                Toast.makeText(this, "Repertoire cree", Toast.LENGTH_SHORT).show();
            }
            else {
                Toast.makeText(this, "Probleme lors de la creation du répertoire", Toast.LENGTH_SHORT).show();
            }
        }



        final File[] list = file.listFiles();
        int count = 0;
        for (File f: list){
            String name = f.getName();
            if (name.endsWith(".txt"))
                count++;
        }


        for (int i = 0; i < count; i++) {


            tr = new TableRow(this);

            Button btn = new Button(this);
            btn.setId(i);
            final int id_ = btn.getId();
            String nom = list[i].getName();
            nom = nom.replace(".txt", "");
            btn.setText(nom);


            tr.addView(btn);
            tableLayout.addView(tr);


            btn1 = findViewById(id_);
            final String finalNom = nom;
            final int finalI = i;
            btn1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    Load(v, finalI, list);
                    Toast.makeText(v.getContext(), "Fichier chargé : " + finalNom, Toast.LENGTH_SHORT).show();
                    finish();
                }
            });

            final int finalI1 = i;
            final TableRow finalTr = tr;
            btn1.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(final View v) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(Load.this);
                    builder.setMessage("Supprimer le fichier ?").setCancelable(false)
                            .setPositiveButton("Oui", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    list[finalI1].delete();
                                    finalTr.removeView(v);
                                    Toast.makeText(v.getContext(), "Fichier supprimé", Toast.LENGTH_SHORT).show();
                                }
                            })
                            .setNegativeButton("Non", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.cancel();
                                }
                            }).show();



                    return true;
                }
            });
        }

    }

    public void Load(View v, int i, File[] list) {
        FileInputStream fis;
        int nbBeats;
        int nbBpm;

        try {
            fis = openFileInput(list[i].getName());
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);
            StringBuilder sb = new StringBuilder();
            String fileText;

            while( (fileText = br.readLine()) != null) {
                sb.append(fileText);
            }

            StringTokenizer st = new StringTokenizer(sb.toString(), ",");


            nbBeats = Integer.parseInt(st.nextToken());
            nbBpm = Integer.parseInt(st.nextToken());




            if(nbBeats >= p.sqr.getBeats()) {
                for(int x = 0; x < p.sqr.getRows(); x++) {
                    for(int y = p.sqr.getBeats(); y <= nbBeats; y++) {
                        p.b[x][y-1].setVisibility(View.VISIBLE);
                    }
                }
            }
            else {
                for(int x = 0; x < p.sqr.getRows(); x++) {
                    for(int y = p.sqr.getBeats(); y > (nbBeats); y--) {
                        p.b[x][y-1].setVisibility(View.GONE);
                    }
                }
            }



            while (st.hasMoreTokens()) {
                p.sqr.setBeats(nbBeats);
                p.mesureNumber.setText("" + (p.sqr.getBeats()) / 4);

                p.bpmNumber.setText("" + nbBpm);
                p.sqr.setBpm(nbBpm);
                p.bpm = nbBpm;

                for(int x = 0; x<p.sqr.getRows();x++) {
                  for(int y = 0;y<p.sqr.getBeats();y++) {
                      if (Integer.parseInt(st.nextToken()) == 0) {
                        p.sqr.disableCell(x,y);
                        p.b[x][y].setChecked(false);
                        if( (y<2) || (y>3 && y<6) || (y>7 && y<10) || (y>11 && y<14) || (y>15 && y<18)) {
                            p.b[x][y].setBackgroundColor(0x8000FF00);
                        }
                        else p.b[x][y].setBackgroundColor(0x80FF0000);
                      }
                     else {
                         p.sqr.enableCell(x,y);
                         p.b[x][y].setChecked(true);
                         if( (y<2) || (y>3 && y<6) || (y>7 && y<10) || (y>11 && y<14) || (y>15 && y<18)) {
                             p.b[x][y].setBackgroundColor(Color.GREEN);
                         }
                         else p.b[x][y].setBackgroundColor(Color.RED);
                     }
                  }
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
