package com.uca.core;

import com.uca.dao.StudentDAO;
import com.uca.entity.StudentEntity;

import java.util.ArrayList;

public class StudentCore {

    public static ArrayList<StudentEntity> getAllStudents() {
        return new StudentDAO().getAllStudents();
    }

    /** Create a student in the databse **/
    public static StudentEntity createStudent(String firstname, String lastname, int id_classroom){
        StudentEntity s = new StudentEntity();
        s.setFirstName(firstname);
        s.setLastName(lastname);
        s.setId_classroom(id_classroom);
        s.setClassEntity(ClassCore.getClassById(id_classroom));
        return new StudentDAO().create(s);
    }

    public static StudentEntity getStudentById(int id_student){
        return new StudentDAO().getById(id_student);
    }

    public static void deleteStudent(StudentEntity student){
        new StudentDAO().delete(student);
    }

    public static void updateStudent(int id, int id_classroom){
        new StudentDAO().updateStudent(id, id_classroom);
    }
}
