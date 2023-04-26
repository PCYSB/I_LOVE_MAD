package com.example.i_love_mad_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.scwang.wave.MultiWaveHeader;

public class loginActivity extends AppCompatActivity {
    MultiWaveHeader wave_header;
    /////
    TextView tv_sign_up;
    TextView tv_find_id;
    TextView tv_find_password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        wave_header=findViewById(R.id.wave);
        wave_header.setVelocity(10);
        wave_header.setProgress(1);
        wave_header.isRunning();
        wave_header.setGradientAngle(45);
        wave_header.setWaveHeight(40);

        tv_sign_up=findViewById(R.id.tv_sign_up);
        tv_find_id=findViewById(R.id.tv_find_id);
        tv_find_password=findViewById(R.id.tv_find_password);

        tv_sign_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(loginActivity.this, SignUp.class);
                startActivity(intent);
            }
        });

        tv_find_id.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(loginActivity.this, FindID.class);
                startActivity(intent);
            }
        });

        tv_find_password.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(loginActivity.this, FindPassword.class);
                startActivity(intent);
            }
        });


    }
}