package com.uca.entity;

public class StudentEntity {
    protected int id_student;
    private String firstName;
    private String lastName;
    private String student_class;

    private ClassEntity classEntity;

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
        if (classEntity == null) {
            classEntity = new ClassEntity();
        }
        classEntity.add(this);
        this.classEntity = classEntity;
    }

    public void setStudent_class(String studentClass) {
        this.student_class = studentClass;
    }
}
