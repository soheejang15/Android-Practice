package com.example.dsm2018.thirdclass;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class DialogActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);

        final EditText editName = (EditText) findViewById(R.id.edit_name);
        final EditText editPhone = (EditText) findViewById(R.id.edit_phone);

        findViewById(R.id.btn_yes).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editName.getText().toString();
                String phone = editPhone.getText().toString();

                Intent intent = new Intent();
                intent.putExtra("name",name);
                intent.putExtra("phone",phone);
                setResult(RESULT_OK,intent);

                finish();
            }
        });

        findViewById(R.id.btn_cancel).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }



}
