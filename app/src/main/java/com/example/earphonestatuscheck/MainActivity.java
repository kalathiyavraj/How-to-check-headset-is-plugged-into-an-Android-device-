package com.example.earphonestatuscheck;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    BroadcastReceiver broadcastReceiver;
    boolean Microphone_Plugged_in = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        broadcastReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                final String action = intent.getAction();
                int iii;
                if (Intent.ACTION_HEADSET_PLUG.equals(action)) {
                    iii = intent.getIntExtra("state", -1);
                    if (iii == 0) {
                        Microphone_Plugged_in = false;
                        TextView tv1 = findViewById(R.id.status_text);
                        tv1.setText("Earphone not pluggen");
                    }
                    if (iii == 1) {
                        Microphone_Plugged_in = true;
                        TextView tv2 = findViewById(R.id.status_text);
                        tv2.setText("Earphone pluggen in");
                    }
                }
            }
        };
        IntentFilter receiverFilter = new IntentFilter(Intent.ACTION_HEADSET_PLUG);
        registerReceiver(broadcastReceiver, receiverFilter);
    }
}