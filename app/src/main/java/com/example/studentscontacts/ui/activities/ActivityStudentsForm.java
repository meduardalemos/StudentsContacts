package com.example.studentscontacts.ui.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.studentscontacts.DAO.StudentDAO;
import com.example.studentscontacts.R;
import com.example.studentscontacts.model.Student;

public class ActivityStudentsForm extends AppCompatActivity {

    private EditText fieldName;
    private EditText fieldEmail;
    private EditText fieldPhone;
    private final StudentDAO dao = new StudentDAO();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_students_form);
        initializeFields();
        configSaveButton();
    }

    private void configSaveButton() {
        Button btSaveNewStudent = findViewById(R.id.students_form_button_save);
        btSaveNewStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Student savedStudent = createsStudent();
                save(savedStudent);
            }
        });
    }

    private void initializeFields() {
        fieldName = findViewById(R.id.students_form_name);
        fieldEmail = findViewById(R.id.students_form_email);
        fieldPhone = findViewById(R.id.students_form_phone);
    }

    private void save(Student savedStudent) {
        dao.save(savedStudent);
        finish();
    }

    @NonNull
    private Student createsStudent() {
        String name = fieldName.getText().toString();
        String email = fieldEmail.getText().toString();
        String phone = fieldPhone.getText().toString();
        Student savedStudent = new Student(name, email, phone);
        return savedStudent;
    }
}