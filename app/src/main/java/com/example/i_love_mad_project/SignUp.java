package com.example.i_love_mad_project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.scwang.wave.MultiWaveHeader;

public class SignUp extends AppCompatActivity {
    MultiWaveHeader wave_header;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        wave_header=findViewById(R.id.wave);
        wave_header.setVelocity(10);
        wave_header.setProgress(1);
        wave_header.isRunning();
        wave_header.setGradientAngle(45);
        wave_header.setWaveHeight(40);
    }
}