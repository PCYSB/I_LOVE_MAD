package com.example.i_love_mad_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import com.example.i_love_mad_project.main_view.loginActivity;
import com.scwang.wave.MultiWaveHeader;

public class MainActivity extends AppCompatActivity {
    private static int SPLASH_TIME_OUT = 1500;

    //Animation
    Animation ceterAnimation;
    //View
    View main_logo1;
    TextView i_mad;

    MultiWaveHeader wave_header;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ///Wave
        wave_header=findViewById(R.id.wave_header);
        wave_header.setVelocity(10);
        wave_header.setProgress(1);
        wave_header.isRunning();
        wave_header.setGradientAngle(45);
        wave_header.setWaveHeight(40);

        //Animation
        ceterAnimation= AnimationUtils.loadAnimation(this, R.anim.center_animation);
        //View
        main_logo1=findViewById(R.id.main_logo1);
        i_mad=findViewById(R.id.i_mad);

        i_mad.setAnimation(ceterAnimation);
        main_logo1.setAnimation(ceterAnimation);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this, loginActivity.class);
                startActivity(intent);
                finish();
            }
        },SPLASH_TIME_OUT);


    }
}