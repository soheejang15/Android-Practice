package com.example.dsm2018.hello;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void clickMethod(View v){
        Toast.makeText(getApplicationContext(),"시작 버튼이 눌렸어요.",Toast.LENGTH_LONG).show();
    }

    public void onNbuttonClicked(View v){
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://m.naver.com"));
        startActivity(myIntent);
    }

    public void onCbuttonClicked(View v){
        Intent myIntent = new Intent(Intent.ACTION_VIEW,Uri.parse("tel:010-6375-5851"));
        startActivity(myIntent);
    }

    public void onNewActivityClicked(View v){
        Intent intent = new Intent(getApplicationContext(),NewActivity.class);
        startActivity(intent);
    }
}
