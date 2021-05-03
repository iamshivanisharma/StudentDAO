package com.example.project;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class taskAdapter extends RecyclerView.Adapter<taskAdapter.TasksViewHolder> {

    private Context mCtx;
    private List<Data> taskList;

    public taskAdapter(Context mCtx, List<Data> taskList) {
        this.mCtx = mCtx;
        this.taskList = taskList;
    }

    @Override
    public TasksViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mCtx).inflate(R.layout.activity_recyclerview, parent, false);
        return new TasksViewHolder(view);
    }

    @Override
    public void onBindViewHolder(TasksViewHolder holder, int position) {
        Data t = taskList.get(position);
        holder.textViewTask.setText(t.getName());
        holder.textViewDesc.setText(t.getMarks());
        holder.textViewFinishBy.setText(t.getSection());

        if (t.isFinished())
            holder.textViewStatus.setText("Student");
        else
            holder.textViewStatus.setText("Student");
            }

    @Override
    public int getItemCount() {
        return taskList.size();
    }

    class TasksViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView textViewStatus, textViewTask, textViewDesc, textViewFinishBy;

        public TasksViewHolder(View itemView) {
            super(itemView);

         textViewStatus = itemView.findViewById(R.id.textViewStatus);
            textViewTask = itemView.findViewById(R.id.textViewTask);
            textViewDesc = itemView.findViewById(R.id.textViewDesc);
            textViewFinishBy = itemView.findViewById(R.id.textViewFinishBy);


            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            Data  task = taskList.get(getAdapterPosition());

            Intent intent = new Intent(mCtx, UpdateData.class);
            intent.putExtra("task", task);

            mCtx.startActivity(intent);
        }
    }
}