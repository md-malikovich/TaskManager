package com.example.taskmanager;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    static final int CODE = 10;

    RecyclerView recyclerView;
    TaskAdapter adapter;
    Button addTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.task_list);
        adapter = new TaskAdapter();
        recyclerView.setAdapter(adapter);
        RecyclerView.LayoutManager manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);

        addTask = findViewById(R.id.add_btn);
        addTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, NewTaskActivity.class);
                startActivityForResult(intent, CODE);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == CODE) {
            if (resultCode == RESULT_OK) {
                //String text = data.getStringExtra(NewTaskActivity.NEW_KEY); //
                Task task = (Task) data.getSerializableExtra (NewTaskActivity.NEW_KEY);
                //Intent intent = new Intent(MainActivity.this, NewTaskActivity.class);
                //intent.putExtra(NewTaskActivity.NEW_KEY, task);
                adapter.addNewTask(task);
            }
        }
    }
}