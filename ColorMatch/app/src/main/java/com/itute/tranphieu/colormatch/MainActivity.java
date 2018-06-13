package com.itute.tranphieu.colormatch;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ImageButton btnInfo,btnPlay,btnExit;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AnhXa();
        intent = new Intent(MainActivity.this,PlayActivity.class);
        setButtonOnClick();
    }

    private void setButtonOnClick() {
        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               startActivity(intent);
            }
        });
        btnInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Play game and traning your brain!", Toast.LENGTH_SHORT).show();
            }
        });
        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finishAffinity();
            }
        });
    }

    private void AnhXa() {
        btnInfo = (ImageButton) findViewById(R.id.ImageButtonInfo);
        btnPlay = (ImageButton) findViewById(R.id.ImageButtonPlay);
        btnExit = (ImageButton) findViewById(R.id.ImageButtonExit);
    }


}
