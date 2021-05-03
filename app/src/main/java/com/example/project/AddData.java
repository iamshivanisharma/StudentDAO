package com.example.project;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class AddData extends AppCompatActivity {
    private EditText editTextTask, editTextDesc, editTextFinishBy;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_data);
        editTextTask = findViewById(R.id.editTextTask);
        editTextDesc = findViewById(R.id.editTextDesc);
        editTextFinishBy = findViewById(R.id.editTextFinishBy);
        findViewById(R.id.button_save).setOnClickListener(view -> saveTask());
    }
    private void saveTask() {
        final String sTask = editTextTask.getText().toString().trim();
        final String  sDesc = editTextDesc.getText().toString().trim();
        final String sFinishBy = editTextFinishBy.getText().toString().trim();
        if (sTask.isEmpty()) {
            editTextTask.setError("Name required");
            editTextTask.requestFocus();
            return;
        }
        if (editTextDesc.getText().toString().trim().isEmpty()) {
            editTextDesc.setError("Marks required");
            editTextDesc.requestFocus();
            return;
        }
        if (sFinishBy.isEmpty()) {
            editTextFinishBy.setError("Section required");
            editTextFinishBy.requestFocus();
            return;
        }

        class SaveTask extends AsyncTask<Void, Void, Void> {

            @Override
            protected Void doInBackground(Void... voids) {

                //creating a task
                Data task = new Data();
                task.setName(sTask);
                task.setMarks(sDesc);
                task.setSection(sFinishBy);

                //adding to database
                DatabaseClient.getInstance(getApplicationContext()).getAppDatabase()
                        .dataDao()
                        .insert(task);
                return null;
            }
            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
                finish();
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                Toast.makeText(getApplicationContext(), "Added", Toast.LENGTH_LONG).show();
            }
        }

        SaveTask st = new SaveTask();
        st.execute();
    }

    }