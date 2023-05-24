package com.example.i_love_mad_project.main_view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;
import com.example.i_love_mad_project.R;
import com.example.i_love_mad_project.login_class.RegisterRequest;
import com.scwang.wave.MultiWaveHeader;

import org.json.JSONException;
import org.json.JSONObject;

import java.nio.charset.StandardCharsets;

public class SignUpActivity extends AppCompatActivity {
    MultiWaveHeader wave_header;
    private EditText et_email;
    // private EditText et_nickname;
    private EditText et_password;
    // private EditText et_password_check;
    private Button btn_signUp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
/////wave
        wave_header = findViewById(R.id.wave);
        wave_header.setVelocity(10);
        wave_header.setProgress(1);
        wave_header.isRunning();
        wave_header.setGradientAngle(45);
        wave_header.setWaveHeight(40);

        et_email = findViewById(R.id.et_email);
        // et_nickname=findViewById(R.id.et_nickname);
        et_password = findViewById(R.id.et_password);
        // et_password_check=findViewById(R.id.et_password_check);
        btn_signUp = findViewById(R.id.btn_signUp);

        //회원가입 버튼
        btn_signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // TODO: 이메일, 비밀번호 정규식 적용해야 함
                String email = et_email.getText().toString();
                String password = et_password.getText().toString();
                // String nickname=et_nickname.getText().toString();
                String auth_provider = "IMAD";

                Response.Listener<JSONObject> responseLisner = response -> {
                    try {
                        //서버에서 해당 값인 경우 success인 경우 if문 부분 실행
                        boolean status = response.getInt("status") == 201;
                        if (status) {   //회원등록에 성공한 경우
                            Toast.makeText(getApplicationContext(), response.getString("message"), Toast.LENGTH_LONG).show();
                            Intent intent = new Intent(SignUpActivity.this, SignUp2Activity.class);
                            System.out.println("회원가입 성공");
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                };
                Response.ErrorListener errorListener = error -> {
                    try {
                        // 회원등록에 실패한경우
                        JSONObject jsonObject = new JSONObject(new String(error.networkResponse.data, StandardCharsets.UTF_8));
                        Toast.makeText(getApplicationContext(), jsonObject.getString("message"), Toast.LENGTH_LONG).show();
                        System.out.println("회원가입 실패");
                        System.out.println(jsonObject.getString("message"));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                };

                //서버에 요청 보내기
                RegisterRequest registerRequest = null;
                try {
                    JSONObject jsonParams = new JSONObject();
                    jsonParams.put("email", email);
                    jsonParams.put("password", password);
                    jsonParams.put("auth_provider", auth_provider);
                    registerRequest = new RegisterRequest(jsonParams, responseLisner, errorListener);
//                    new GetReqeust(IMAD_SIGNUP_API, jsonParams, responseLisner, errorListener);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                RequestQueue queue = Volley.newRequestQueue(SignUpActivity.this);
                queue.add(registerRequest);

            }
        });
    }

}
