package com.example.dsm2018.constraintlayout;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    TextView textMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        Intent intent = getIntent();
        String msg = intent.getStringExtra("message");

        textMessage = findViewById(R.id.result_text_show);
        textMessage.setText(msg);

        Button resultBtn = findViewById(R.id.result_btn_result);
        resultBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Intent는 액티비티 간의 데이터 상호작용을 위해 객체를 생성하는 것
                Intent intent = new Intent();
                intent.putExtra("result",textMessage.getText().toString());

                //결과 전달
                setResult(RESULT_OK,intent);

                //액티비티 화면 종료
                finish();
            }
        });
    }

}
