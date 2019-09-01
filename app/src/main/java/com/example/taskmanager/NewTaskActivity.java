package com.example.taskmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class NewTaskActivity extends AppCompatActivity {

    static final String NEW_KEY = "new_key";

    EditText newTaskTitle;
    CheckBox newTaskIsDone;
    EditText newStartDate;
    Button btnSaveTask;

    String newTask;
    String newDate;
    String newStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_task);

        newTaskTitle = findViewById(R.id.new_task_title);
        newTaskIsDone = findViewById(R.id.new_task_isDone);
        newStartDate = findViewById(R.id.new_start_date);
        btnSaveTask = findViewById(R.id.btn_save_task);

        btnSaveTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                newTask = newTaskTitle.getText().toString();
                newStatus = newTaskIsDone.getText().toString();
                newDate = newStartDate.getText().toString();
                String fullTask = newTask + " " + newDate + " " + newStatus;
                Intent intent = new Intent();
                intent.putExtra(NEW_KEY, fullTask);
                setResult(RESULT_OK);
                Log.d("ololo", "addTask");
                finish();
            }
        });
    }
}
