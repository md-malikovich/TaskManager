package com.example.taskmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.io.Serializable;
import java.nio.file.StandardWatchEventKinds;
import java.util.Date;

public class TaskDetailsActivity extends AppCompatActivity {

    static final String DETAILS_KEY = "details_key";

    TextView title;
    TextView description;
    TextView startDate;
    TextView endDate;
    CheckBox isDone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_details);
        setupView();
        Task task = getTask();
        showTask(task); // || showTask(getTask());
    }

    public void setupView() {
        title = findViewById(R.id.details_title);
        description = findViewById(R.id.details_description);
        startDate = findViewById(R.id.details_startDate);
        endDate = findViewById(R.id.details_endDate);
        isDone = findViewById(R.id.details_isDone);
    }

    public Task getTask() {
        Intent intent = getIntent();
        Task task = (Task) intent.getSerializableExtra(DETAILS_KEY);
        return task;
    }

    public void showTask(Task task) {
        title.setText(task.title);
        description.setText(task.description);
        startDate.setText(task.startDateStr());
        endDate.setText(task.endDateStr());
        isDone.setChecked(task.isDone);
    }
}
