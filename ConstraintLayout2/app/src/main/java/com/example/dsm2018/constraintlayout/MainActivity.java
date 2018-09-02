package com.example.dsm2018.constraintlayout;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    public final static int REQUEST_CODE = 1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button firstBtn = findViewById(R.id.main_btn_firstlayout);
        Button resultBtn = findViewById(R.id.main_btn_result);

        firstBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,DisplayMessageActivity.class);
                startActivity(intent);
            }
        });

        resultBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,ResultActivity.class);
                EditText editText = findViewById(R.id.main_edit_message);

                String msg = editText.getText().toString();

                intent.putExtra("message",msg);

                startActivityForResult(intent, REQUEST_CODE);
                // 결과를 리턴받기 위해 다른 액티비티 실행시 사용.
            }
        });
    }

    /*public void onButtonClick (View view){
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        EditText editText = (EditText) findViewById(R.id.main_edit_message);

        String msg = editText.getText().toString();
        intent.putExtra("message",msg);
        startActivity(intent);
    }*/

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, requestCode, data);

        if(requestCode == REQUEST_CODE && resultCode == RESULT_OK && data != null){
            String result = data.getStringExtra("result");

            Toast.makeText(MainActivity.this, result, Toast.LENGTH_SHORT).show();
        }
    }

    public void callIntent(View view){
        //어떤 액티비티를 시작할 것인지가 아닌 어떤 동작을 할 것인지를 지정
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:"+"01063752109"));

        //ACTION_DIAL을 샐행할 앱이 있는지 체크
        if (intent.resolveActivity(getPackageManager()) != null){
            startActivity(intent);
        }else{
            Toast.makeText(this,"수행할 앱이 없습니다.",Toast.LENGTH_SHORT).show();
        }
    }

    public void sendKakao(View view){
        EditText messageEditText = findViewById(R.id.main_edit_message);

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT,messageEditText.getText().toString());

        if(intent.resolveActivity(getPackageManager())!=null){
            startActivity(intent);
        }
    }

    @Override
    public void onClick(View v) {
        Intent intent = null;

        switch (v.getId()){
            case R.id.main_btn_firstlayout:
                intent = new Intent(this, FirstActivity.class);
                break;

        }
    }
}
