package com.example.mazan.projet5;

/**
 * Created by mazan on 17/11/2017.
 */


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class passwordcall extends Activity {
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.passwordcall);

        /** Button return_button1 = (Button) findViewById(R.id.return_button1);
         return_button1.setOnClickListener(new View.OnClickListener() {
         public void onClick(View view) {
         Intent intent1 = new Intent(passwordcall.this, MainActivity.class);
         startActivity(intent1);

         }});

         Button connect_button2 = (Button) findViewById(R.id.connect_button2);
         connect_button2.setOnClickListener(new View.OnClickListener() {
         public void onClick(View view) {
         Intent intent2 = new Intent(passwordcall.this, principal_activity.class);
         startActivity(intent2);}
         }); */

        final Intent intent1 = new Intent().setClass(this, MainActivity.class);
        // Then add the action to the button:
        Button btnOtherActivity1 = (Button) findViewById(R.id.return_button1);
        btnOtherActivity1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(intent1);}});



        final Intent intent2 = new Intent().setClass(passwordcall.this, principalactivity.class);
        // Then add the action to the button:
        Button btnOtherActivity2 = (Button) findViewById(R.id.connect_button2);
        btnOtherActivity2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Launch the activity

                String mdpvalide = "root";
                String uservalide = "root";
                String error1 = "connexion echouee";
                String Ok = "connexion reussie";

                EditText login = (EditText) (findViewById(R.id.Login));
                String username = login.getText().toString();
                Log.i("2", username);

                EditText password = (EditText) (findViewById(R.id.Password));
                String mdp = password.getText().toString();
                Log.i("3", mdp);

                if (username.equals(uservalide)&&mdp.equals(mdpvalide))
                { startActivity(intent2);
                    Log.i("5",Ok); }

                else
                {Log.i("4",error1);}


            }
        }); //on doit tester les valeurs fournies une fois cliqué ici.


   /* Button gettest1 = (Button) findViewById(R.id.gettest);
    gettest1.setOnClickListener(new View.OnClickListener() {
        public void onClick(View v) {
            r=requests.get(https://api.thingspeak.com/channels/440647/feeds/last.json?api_key=POIFRJN3JXL5KD1E)
        }
    }); */


    }}