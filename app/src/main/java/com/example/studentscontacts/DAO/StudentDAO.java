package com.example.studentscontacts.DAO;

import com.example.studentscontacts.model.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentDAO {

    private static List<Student> students = new ArrayList<>();
    public void save(Student student){
        students.add(student);
    }

    public List<Student> allStudents(){
        return new ArrayList<>(students);
    }
}
