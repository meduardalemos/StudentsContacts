package com.example.studentscontacts.ui.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.studentscontacts.DAO.StudentDAO;
import com.example.studentscontacts.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;


public class ActivityStudentsList extends AppCompatActivity {

    private final StudentDAO dao = new StudentDAO();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_students_list);
        configFabAddNewStudent();
    }

    private void configFabAddNewStudent() {
        FloatingActionButton btAddNewStudent = findViewById(R.id.students_list_fab);
        btAddNewStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                opensActivityStudentForm();
            }
        });
    }

    private void opensActivityStudentForm() {
        startActivity(new Intent(this, ActivityStudentsForm.class));
    }

    @Override
    protected void onResume() {
        super.onResume();
        configStudentsList();
    }

    private void configStudentsList() {
        ListView studentsList = findViewById(R.id.students_list_listview);
        studentsList.setAdapter(new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                dao.allStudents()));
    }
}