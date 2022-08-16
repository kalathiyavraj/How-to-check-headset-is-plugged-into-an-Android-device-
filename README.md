# How-to-check-headset-is-plugged-into-an-Android-device-
How to check headset is plugged into an Android device?
![headphones-audio-listen](https://user-images.githubusercontent.com/84270801/184952949-52e519c3-5448-4334-b6e4-e6a47946a7a4.jpg)

>That was simple logic for checking headphone or earphone plug was connected android device or not using BroadcastReceiver .

>>Put this code in your activity on create.

```gradle
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
```
>>Add this code in XML
```gradle
 <TextView
        android:id="@+id/status_text"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:textSize="25sp"
        android:fontFamily="@font/poppins"
        android:text="Detecting headphones plug In" />
```
