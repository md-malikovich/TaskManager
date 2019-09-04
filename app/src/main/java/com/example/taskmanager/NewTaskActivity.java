package com.example.taskmanager;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import java.util.Date;

public class NewTaskActivity extends AppCompatActivity {

    static final String NEW_KEY = "new_key";

    EditText newTaskTitle;
    EditText newTaskDescription;
    CheckBox newTaskIsDone;
    EditText newStartDate;
    EditText newEndDate;
    Button btnSaveTask;

    String newTask;
    String newDescription;
    String startDate;
    String endDate;
    String newStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_task);

        newTaskTitle = findViewById(R.id.new_task_title);
        newTaskDescription = findViewById(R.id.new_task_description);
        newStartDate = findViewById(R.id.new_start_date);
        newEndDate = findViewById(R.id.new_end_date);
        newTaskIsDone = findViewById(R.id.new_task_isDone);
        btnSaveTask = findViewById(R.id.btn_save_task);

        btnSaveTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                newTask = newTaskTitle.getText().toString();
                newDescription = newTaskDescription.getText().toString();
                startDate = newStartDate.getText().toString();
                endDate = newStartDate.getText().toString();
                newStatus = newTaskIsDone.getText().toString();
                Task task = new Task(newTask, newDescription, new Date(), new Date(), false);
                //String fullTask = newTask + " " + newDescription + " " + startDate + " " + endDate + " " + newStatus;
                Intent intent = new Intent();
                intent.putExtra(NEW_KEY, task);
                setResult(RESULT_OK, intent);
                Log.d("ololo", "addTask");
                finish();
            }
        });
    }
}





/*
import java.util.Calendar;
import android.app.DatePickerDialog; //
import android.app.TimePickerDialog; //
import android.text.format.DateUtils; //
import android.view.View; //
import android.widget.DatePicker; //
import android.widget.TextView;
import android.widget.TimePicker; //

    //TextView currentDateTime;
    //Calendar dateAndTime = Calendar.getInstance();
 */

//currentDateTime = findViewById(R.id.currentDateTime);
//setInitialDateTime();

/*    public void setDate(View v) {
        new DatePickerDialog(NewTaskActivity.this, d, dateAndTime.get(Calendar.YEAR), dateAndTime.get(Calendar.MONTH),
                dateAndTime.get(Calendar.DAY_OF_MONTH)).show();
    }

    private void setInitialDateTime() {
        newStartDate.setText(DateUtils.formatDateTime(this,
                dateAndTime.getTimeInMillis(),
                DateUtils.FORMAT_SHOW_DATE | DateUtils.FORMAT_SHOW_YEAR
                        | DateUtils.FORMAT_SHOW_TIME));
    }

    DatePickerDialog.OnDateSetListener d = new DatePickerDialog.OnDateSetListener() {
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            dateAndTime.set(Calendar.YEAR, year);
            dateAndTime.set(Calendar.MONTH, monthOfYear);
            dateAndTime.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            setInitialDateTime();
        }
    };*/

/*
    <TextView android:id="@+id/currentDateTime"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"/>
 */

/*
    <EditText
        android:id="@+id/new_start_date"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:onClick="setDate"
        android:inputType="date"
        android:clickable="true"
        android:focusable="false"
        android:hint="@string/start_date"/>
 */