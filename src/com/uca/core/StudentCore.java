package com.uca.core;

import com.uca.dao.StudentDAO;
import com.uca.entity.StudentEntity;

import java.util.ArrayList;

public class StudentCore {

    public static ArrayList<StudentEntity> getAllStudents() {
        return new StudentDAO().getAllStudents();
    }

    /** Create a student in the databse **/
    public static StudentEntity createStudent(String firstname, String lastname, String student_class){
        StudentEntity s = new StudentEntity();
        s.setFirstName(firstname);
        s.setLastName(lastname);
        s.setStudent_class(student_class);
        return new StudentDAO().create(s);
    }

    public static StudentEntity getStudentById(int id_student){
        return new StudentDAO().getById(id_student);
    }

    public static void deleteStudent(StudentEntity student){
        new StudentDAO().delete(student);
    }

    public static void updateStudent(int id, String student_class){
        new StudentDAO().updateStudent(id, student_class);
    }
}
