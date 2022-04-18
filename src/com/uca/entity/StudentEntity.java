package com.uca.entity;

public class StudentEntity {
    protected int id_student;
    private String firstName;
    private String lastName;

    private int id_classroom;
    private ClassEntity classEntity;

    public int getId_classroom() {
        return id_classroom;
    }

    public void setId_classroom(int id_classroom) {
        this.id_classroom = id_classroom;
    }

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

    public String getClassName () {
        if (classEntity == null) {
            return "Null";
        }
        return getClassEntity().getClassname();
    }

    public ClassEntity getClassEntity() {
        return this.classEntity;
    }

    public void setClassEntity(ClassEntity classEntity) {
        this.classEntity = classEntity;
    }
}
