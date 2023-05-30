package com.mustafa.diary;

/*
 * NIM  : 10120093
 *Nama  : Mustafa Nurkamal
 *Kelas : IF3
 * */

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.mustafa.diary.R;

public class ActivitySplashScreen extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashschreen);

        final Handler handler = new Handler();
        handler.postDelayed(() -> {
            startActivity(new Intent(getApplicationContext(), ActivityWelcomeDialog.class));
            finish();
        }, 2000L);
    }

}
