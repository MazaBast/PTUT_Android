package com.example.mazan.projet5;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Message;
import android.os.ParcelUuid;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ImageButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.util.UUID;

import static java.lang.Thread.sleep;


/**
 * Created by mazan on 22/11/2017.
 */

public class principalactivity extends AppCompatActivity {

    Chronometer simpleChronometer;
    Button start, stop, restart, setFormat, clearFormat;
    int Tempsecoule;
    private Thread t;
    private boolean running = true;
    private TextView mTextMessage;
    //private UUID iud = UUID.fromString("A9 02 07 43 LD 75 46 AB B8 FC D6 E7 C1 50 ED 07");
    private BluetoothDevice mmDevice;
    private BluetoothSocket mmSocket;
    boolean penible;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.principalactivity);

        // SWITCH GEOFENCING
        Switch Geofencing = (Switch) findViewById(R.id.switch1);
        final boolean switchstatus = (false);
        Geofencing.setChecked(true);

        ImageButton aproposicon = (ImageButton) findViewById(R.id.aproposicon);
         aproposicon.setOnClickListener(new View.OnClickListener() {
         public void onClick(View view) {
         Intent intent3 = new Intent(principalactivity.this, apropos.class);
         startActivity(intent3);
         }});

         ImageButton eodresize = (ImageButton) findViewById(R.id.eodresized);
         eodresize.setOnClickListener(new View.OnClickListener() {
         public void onClick(View view) {
         Intent intent4 = new Intent(principalactivity.this, avisTravailleur.class);
         startActivity(intent4);}}); //On devra renvoyer la valeur du chrono une fois qu'on aura cliqué ici.

        t = new Thread(
                new Runnable() {
                    public void run() {
                        int i = 0;
                        while (running) {
                            if(recupBluetooth()) {
                                //Mettre les commandes
                                i = i + 1;
                                Log.i("1", "" + i);
                                TextView ShowTempsEcoule = (TextView) findViewById(R.id.ShowTempsEcoule);
                                ShowTempsEcoule.setText(String.valueOf(i + 's'));

                                // traitement
                                try {
                                    sleep(1000);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                    }
                }
        );
        t.start();




        Geofencing.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
        if (switchstatus==(true))
            simpleChronometer.start();
        else
            simpleChronometer.stop();

        }
    });



    }

    public boolean recupBluetooth() {
        penible = false;

        // Reperer si la device possède ou non le bluetooth
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        /*if (bluetoothAdapter == null)
            Toast.makeText(principalactivity.this, "Pas de Bluetooth",
                    Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(principalactivity.this, "Avec Bluetooth",
                    Toast.LENGTH_SHORT).show();*/

        // Activer le bluetooth de force
        if (!bluetoothAdapter.isEnabled()) {
            bluetoothAdapter.enable();
        }

        if(bluetoothAdapter.startDiscovery()){
            // Register for broadcasts when a device is discovered.
            IntentFilter filter = new IntentFilter(BluetoothDevice.ACTION_FOUND);
            registerReceiver(mReceiver, filter);
        }

        return penible;

    }

    // Create a BroadcastReceiver for ACTION_FOUND.
    private final BroadcastReceiver mReceiver = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (BluetoothDevice.ACTION_FOUND.equals(action)) {
                // Discovery has found a device. Get the BluetoothDevice
                // object and its info from the Intent.
                BluetoothDevice device = intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);
                // A TESTER POUR LE GET UUID
                Log.i("1",""+device.getName());
                Log.i("2",""+device.getAddress());
                try {
                    Log.i("3", "" + device.getUuids());
                }catch (Exception e){

                }
                // MAC : 00:15:83:EA:74:36
                    /*if(device.getUuids(). == (iud)) {
                    penible = true;
                }*/
            }
        }
    };

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // Don't forget to unregister the ACTION_FOUND receiver.
        unregisterReceiver(mReceiver);
    }
}










        /* Chronometer simpleChronometer = (Chronometer) findViewById(R.id.simpleChronometer); // initiate a chronometer
             simpleChronometer.start(); // start a chronometer
             simpleChronometer.stop(); // stop a chronometer

                 // initiate views
                 simpleChronometer = (Chronometer) findViewById(R.id.simpleChronometer);
                 start = (Button) findViewById(R.id.startchro);
                 stop = (Button) findViewById(R.id.stopchro);
                 //restart = (Button) findViewById(R.id.restartchro);
                 //setFormat = (Button) findViewById(R.id.setFormat);
                 //clearFormat = (Button) findViewById(R.id.clearFormat);

                 // perform click  event on start button to start a chronometer
                 start.setOnClickListener(new View.OnClickListener() {

                     @Override
                     public void onClick(View v) {
                         // TODO Auto-generated method stub

                         simpleChronometer.start();
                     }
                 });

                 // perform click  event on stop button to stop the chronometer
                 stop.setOnClickListener(new View.OnClickListener() {

                     @Override
                     public void onClick(View v) {
                         // TODO Auto-generated method stub

                         simpleChronometer.stop();
                     }
                 });

            /*     // perform click  event on restart button to set the base time on chronometer
                 restart.setOnClickListener(new View.OnClickListener() {

                     @Override
                     public void onClick(View v) {
                         // TODO Auto-generated method stub

                         simpleChronometer.setBase(SystemClock.elapsedRealtime());
                     }
                 }); */
// String formatType=simpleChronometer.getFormat(); servira lorsque je saurais quoi renvoyer

/** final Intent intent3 = new Intent().setClass(this, apropos.class);
 // Then add the action to the button:
 ImageButton btnOtherActivity3 = (ImageButton) findViewById(R.id.aproposicon);
 btnOtherActivity3.setOnClickListener(new View.OnClickListener() {
 public void onClick(View v) {
 // Launch the activity
 startActivity(intent3);
 }
 });

 final Intent intent4 = new Intent().setClass(this, MainActivity.class);
 // Then add the action to the button:
 ImageButton btnOtherActivity4 = (ImageButton) findViewById(R.id.fintravail);
 btnOtherActivity4.setOnClickListener(new View.OnClickListener() {
 public void onClick(View v) {
 // Launch the activity
 startActivity(intent4); */