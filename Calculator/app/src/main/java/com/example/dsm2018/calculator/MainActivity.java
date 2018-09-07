package com.example.dsm2018.calculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView result;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void add(View view){

        Log.d("add","call add");

        EditText num1 = findViewById(R.id.main_edit_num1);
        EditText num2 = findViewById(R.id.main_edit_num2);

        String first = num1.getText().toString();
        String second = num2.getText().toString();

        int firstNum = Integer.parseInt(first);
        int secondNum = Integer.parseInt(second);

        result = findViewById(R.id.main_text_result);

        int addResult = firstNum+secondNum;
        result.setText(addResult+"");

    }

    public void sub(View view){

        EditText num1 = findViewById(R.id.main_edit_num1);
        EditText num2 = findViewById(R.id.main_edit_num2);

        String first = num1.getText().toString();
        String second = num2.getText().toString();

        int firstNum = Integer.parseInt(first);
        int secondNum = Integer.parseInt(second);

        result = findViewById(R.id.main_text_result);

        int subResult = firstNum-secondNum;
        result.setText(subResult+"");

    }

    public void mul(View view){

        EditText num1 = findViewById(R.id.main_edit_num1);
        EditText num2 = findViewById(R.id.main_edit_num2);

        String first = num1.getText().toString();
        String second = num2.getText().toString();

        int firstNum = Integer.parseInt(first);
        int secondNum = Integer.parseInt(second);

        result = findViewById(R.id.main_text_result);

        int mulResult = firstNum*secondNum;
        result.setText(mulResult+"");

    }

    public void div(View view){

        EditText num1 = findViewById(R.id.main_edit_num1);
        EditText num2 = findViewById(R.id.main_edit_num2);

        String first = num1.getText().toString();
        String second = num2.getText().toString();

        int firstNum = Integer.parseInt(first);
        int secondNum = Integer.parseInt(second);

        result = findViewById(R.id.main_text_result);

        int divResult = firstNum/secondNum;
        result.setText(divResult+"");

    }


}
