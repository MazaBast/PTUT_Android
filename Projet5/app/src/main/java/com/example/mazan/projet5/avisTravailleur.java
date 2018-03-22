package com.example.mazan.projet5;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import java.io.FileOutputStream;

/**
 * Created by mazan on 30/01/2018.
 */

public class avisTravailleur extends Activity {



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.avistravailleur);
        Button findejournee = (Button) findViewById(R.id.findejournee);




       /* Button findejournee = (Button) findViewById(R.id.findejournee);
        findejournee.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

            }
            // EditText commentaire = (EditText) findViewById(R.id.commentaire);
            // commentaire.getText().toString();
        }); */

        findejournee.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                EditText et = (EditText)(findViewById(R.id.commentaire));
                String data = et.getText().toString();
                Log.i("1",data);
            }
        });
    }

    /*public void save(View view){
        //data = et.getText().toString();
        try {
            @SuppressWarnings("deprecation")
            FileOutputStream fOut = openFileOutput("recuperationcommentaire",MODE_WORLD_READABLE);
            fOut.write(data.getBytes());
            fOut.close();
            Toast.makeText(getBaseContext(),"Stockage fichier",
                    Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    } */

    }

