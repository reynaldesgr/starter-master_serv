package com.uca.entity;

import java.util.Date;

public class StudentEntity {
    protected int id_student;
    private String firstName;
    private String lastName;
    private String student_class;

    public StudentEntity() {
        // Ignored
    }

    public int getId_student() {
        return id_student;
    }
    public void setId_student(int id_student){
        this.id_student = id_student;
    }

    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getStudent_class() {
        return this.student_class;
    }
    public void setStudent_class(String studentClass) {
        this.student_class = studentClass;
    }
}
