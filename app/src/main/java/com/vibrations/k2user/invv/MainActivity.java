package com.vibrations.k2user.invv;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.firebase.iid.FirebaseInstanceId;

public class MainActivity extends AppCompatActivity {

    private Button accoutic, vibration, video;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Context context = this;
        accoutic = (Button) findViewById(R.id.button);
        vibration = (Button) findViewById(R.id.button2);
        video = (Button) findViewById(R.id.button3);

        //String refreshedToken = FirebaseInstanceId.getInstance().getToken();
        //Log.d("Anand", "Refreshed token: " + refreshedToken);


        accoutic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, Accoutic.class);
                startActivity(intent);
            }
        });

        vibration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, Vibration.class);
                startActivity(intent);
            }
        });

        video.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, Video.class);
                startActivity(intent);
            }
        });

    }
}
