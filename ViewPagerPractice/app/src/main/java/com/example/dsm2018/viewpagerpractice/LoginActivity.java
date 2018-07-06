package com.example.dsm2018.viewpagerpractice;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private Button loginLoginButton;
    private EditText loginIdEdit, loginPwEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginLoginButton = (Button) findViewById(R.id.button_login_login);
        loginIdEdit = (EditText) findViewById(R.id.edit_login_id);
        loginPwEdit = (EditText) findViewById(R.id.edit_login_pw);

        loginLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ( loginIdEdit.getText().toString().isEmpty() || loginPwEdit.getText().toString().isEmpty()) {
                    Toast.makeText(LoginActivity.this,"아이디 또는 비밀번호를 입력해주세요.",Toast.LENGTH_SHORT).show();


                } else {
                    Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                    startActivity(intent);
                }

            }
        });

    }


}
