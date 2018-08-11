package com.example.dsm2018.hello;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class NewActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);
    }

    public void onBackButtonClicked(View v){
        Toast.makeText(getApplicationContext(),"돌아가기 버튼이 눌렸어요.",Toast.LENGTH_LONG).show();
        finish();
    }
}
