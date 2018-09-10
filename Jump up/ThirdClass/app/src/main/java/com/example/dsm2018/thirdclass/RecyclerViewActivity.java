package com.example.dsm2018.thirdclass;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerViewActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);

        RecyclerView recyclerView =  (RecyclerView)findViewById(R.id.recyclerView);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

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

        RecyclerAdapter adapter = new RecyclerAdapter(data);
        recyclerView.setAdapter(adapter);
    }
}
