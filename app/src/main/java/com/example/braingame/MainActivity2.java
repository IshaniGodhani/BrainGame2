package com.example.braingame;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class MainActivity2 extends AppCompatActivity {
    String[] level={"Level 1","Level 2","Level 3","Level 4","Level 5",
            "Level 6","Level 7","Level 8","Level 9","Level 10"};
    RecyclerView recyclerView;
    RecyclerAdapter recyclerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        String str=getIntent().getStringExtra("label");
        if(str.equals("nolimit"))
        {
            recyclerAdapter = new RecyclerAdapter(this, level);
            recyclerView = findViewById(R.id.level_list);
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MainActivity2.this);
            linearLayoutManager.setOrientation(recyclerView.VERTICAL);
            recyclerView.setLayoutManager(linearLayoutManager);
            recyclerView.setAdapter(recyclerAdapter);
            Config.outerLevel=1;
        }
        else if(str.equals("normal"))
        {
            recyclerAdapter = new RecyclerAdapter(this, level);
            recyclerView = findViewById(R.id.level_list);
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MainActivity2.this);
            linearLayoutManager.setOrientation(recyclerView.VERTICAL);
            recyclerView.setLayoutManager(linearLayoutManager);
            recyclerView.setAdapter(recyclerAdapter);
            Config.outerLevel=2;
        }
        else
        {
            recyclerAdapter = new RecyclerAdapter(this, level);
            recyclerView = findViewById(R.id.level_list);
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MainActivity2.this);
            linearLayoutManager.setOrientation(recyclerView.VERTICAL);
            recyclerView.setLayoutManager(linearLayoutManager);
            recyclerView.setAdapter(recyclerAdapter);
            Config.outerLevel=3;
        }

    }
}