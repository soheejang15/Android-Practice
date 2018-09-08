package com.example.dsm2018.thirdclass;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class CustomAdapterViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_adapter_view);

        ArrayList<Contact> data = new ArrayList<>();
        data.add(new Contact("제니", "010-1234-5678"));
        data.add(new Contact("리사", "010-1234-5678"));
        data.add(new Contact("로제", "010-1234-5678"));
        data.add(new Contact("소미", "010-1234-5678"));
        data.add(new Contact("유정", "010-1234-5678"));
        data.add(new Contact("세정", "010-1234-5678"));
        data.add(new Contact("결경", "010-1234-5678"));
        data.add(new Contact("재환", "010-1234-5678"));
        data.add(new Contact("진영", "010-1234-5678"));;
        data.add(new Contact("지훈", "010-1234-5678"));
        data.add(new Contact("아이린", "010-1234-5678"));
        data.add(new Contact("수지", "010-1234-5678"));

        CustomAdapter adapter = new CustomAdapter(data);
        ListView listView = findViewById(R.id.list_view_number);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(CustomAdapterViewActivity.this,position + "번째 아이템 선택",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
