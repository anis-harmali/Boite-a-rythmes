package com.example.rythmik;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;



public class PageAccueil extends AppCompatActivity {

    private Button nouv;
    private Button charg;

    static Principal p;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /*
          Fait le lien entre la classe et le Layout.
         */
        setContentView(R.layout.activity_page_accueil);


        /*
         Initialisation des variables avec les boutons du Layout en fonction des id.
         */
        nouv = findViewById(R.id.ButtonNouv);
        charg = findViewById(R.id.ButtonCharg);


        nouv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pActivity = new Intent(PageAccueil.this, Principal.class);
                startActivity(pActivity);
            }
        });

        charg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pActivity = new Intent(PageAccueil.this, Principal.class);
                startActivity(pActivity);
                startActivity(new Intent(PageAccueil.this,Load.class));

            }
        });

    }


}
