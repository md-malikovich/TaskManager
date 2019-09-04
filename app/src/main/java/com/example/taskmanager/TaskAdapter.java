package com.example.taskmanager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Date;

public class TaskAdapter extends RecyclerView.Adapter<TaskViewHolder> {

    ArrayList<Task> task;

    public TaskAdapter() {
        task = new ArrayList<>();
        task.add(new Task("Some title1", "Some description", new Date(), new Date(), true));
        task.add(new Task("Some title2", "Some description", new Date(), new Date(), false));
        task.add(new Task("Some title3", "Some description", new Date(), new Date(), true));
    }

    @NonNull
    @Override
    public TaskViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.view_holder_task, parent, false);
        return new TaskViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TaskViewHolder holder, int position) {
        holder.onBind(task.get(position));
    }

    @Override
    public int getItemCount() {
        return task.size();
    }

    public void addNewTask(Task tasks) {
        task.add(tasks);
        //tasks.add(task);
        notifyDataSetChanged();
        Log.d("ololo", "addNewTask");
    }

/*    public void addNewTask(String text) {
        task.add(new Task("Some title1", "Some description", new Date(), new Date(), true));
        notifyDataSetChanged();
    }*/
}
