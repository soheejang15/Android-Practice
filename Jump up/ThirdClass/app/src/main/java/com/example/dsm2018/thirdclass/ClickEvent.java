package com.example.dsm2018.thirdclass;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ClickEvent extends AppCompatActivity {
    private TextView clickResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_click_event);

        clickResult = (TextView)findViewById(R.id.text_click_description);

        Button clickBtn = (Button)findViewById(R.id.btn_click_btn);
        clickBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                printResult("클릭");
            }
        });

        clickBtn.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                printResult("롱클릭");
                return false;
            }
        });

        clickBtn.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                switch (event.getAction()){
                    case MotionEvent.ACTION_DOWN :clickResult.setText(null); printResult("터치(다운)"); break;
                    case MotionEvent.ACTION_MOVE: printResult("터치(무브)"); break;
                    case MotionEvent.ACTION_UP: printResult("터치(업)"); break;
                }
                return false;
            }
        });
    }

    void printResult(String result){
        clickResult.setText(result+"\n"+clickResult.getText().toString());
    }
}
