package com.example.mazan.projet5;


import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.widget.Toast;

import java.io.IOException;
import java.util.Set;

import static java.lang.Thread.sleep;


public class MainActivity extends AppCompatActivity {
    private TextView mTextMessage;


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mTextMessage.setText(R.string.title_home);
                    return true;
                case R.id.navigation_dashboard:
                    mTextMessage.setText(R.string.title_dashboard);
                    return true;
                case R.id.navigation_notifications:
                    mTextMessage.setText(R.string.title_notifications);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        Button next = (Button) findViewById(R.id.connect_button);
        next.setOnClickListener(new View.OnClickListener() {
                                    public void onClick(View view) {
                                        Intent intent = new Intent(MainActivity.this, passwordcall.class);
                                        startActivity(intent);
                                        // Intent myIntent = new Intent(view.getContext(), passwordcall.class);
                                        // startActivityForResult(myIntent,passwordcall);

                                    }

                                }
        );

    }






}


/*
    // Lancer le scan grâce à la méthode Discovery
     // bluetoothAdapter.startDiscovery();
// Enregistrer le broadcast
        // IntentFilter filter = new IntentFilter(BluetoothDevice.ACTION_FOUND);
        // registerReceiver(bluetoothReceiver, filter);

        // Lancer le scan grâce à la méthode Discovery
        // bluetoothAdapter.startDiscovery();

        // Stocker les Devices auxquelles on s'est déjà connecté
        Set<BluetoothDevice> devices;
        devices = bluetoothAdapter.getBondedDevices();
        for (BluetoothDevice blueDevice : devices) {
            Toast.makeText(MainActivity.this, "Device = " + blueDevice.getName(), Toast.LENGTH_SHORT).show();
        }

        // Recherche de nouveaux périphériques
        final BroadcastReceiver bluetoothReceiver = new BroadcastReceiver() {
            public void onReceive(Context context, Intent intent) {
                String action = intent.getAction();
                if (BluetoothDevice.ACTION_FOUND.equals(action)) {
                    BluetoothDevice device = intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);
                    Toast.makeText(MainActivity.this, "New Device = " + device.getName(), Toast.LENGTH_SHORT).show();
                }
            }
        };

      */

// J'ENLEVERAIS PAS TOUT CES COMMENTAIRES QUENTIN
    // Le ONDESTROY sera à utiliser plus tard
       /* @Override
        protected void onDestroy() {
            super.onDestroy();
            bluetoothAdapter.cancelDiscovery();
            unregisterReceiver(bluetoothReceiver);
        } */

       /*     SE CONNECTER A UNE DEVICE APAIREE AUTOMATIQUEMENT
    private class ConnectThread extends Thread {
        private final BluetoothSocket mmSocket;
        private final BluetoothDevice mmDevice;

        public ConnectThread(BluetoothDevice device) {
            // Use a temporary object that is later assigned to mmSocket,
            // because mmSocket is final
            BluetoothSocket tmp = null;
            mmDevice = device;

            // Get a BluetoothSocket to connect with the given BluetoothDevice
            try {
                // MY_UUID is the app's UUID string, also used by the server code
                tmp = device.createRfcommSocketToServiceRecord(MY_UUID);
            } catch (IOException e) { }
            mmSocket = tmp;
        }

        public void run() {
            // Cancel discovery because it will slow down the connection
            mBtAdapter.cancelDiscovery();
            Log.w("ListDeviceBluetooth", "Initiation de la connexion");
            try {
                // Connect the device through the socket. This will block
                // until it succeeds or throws an exception

                mmSocket.connect();
                //Toast.makeText(getActivity().getApplicationContext(),"Appairage effectué",Toast.LENGTH_LONG).show();
                Log.w("ListDeviceBluetooth", "Appairage effectué");
            } catch (IOException connectException) {
                // Unable to connect; close the socket and get out
                //Toast.makeText(getActivity().getApplicationContext(),"Impossible de se connecter",Toast.LENGTH_LONG).show();
                try {
                    mmSocket.close();
                } catch (IOException closeException) { }
                return;
            }

            // Do work to manage the connection (in a separate thread)
            // manageConnectedSocket(mmSocket);
        }

        / Will cancel an in-progress connection, and close the socket
       public void cancel() {
           try {
               mmSocket.close();
           } catch (IOException e) { }
       }
} */




