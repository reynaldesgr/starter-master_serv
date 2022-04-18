package com.uca.core;

import com.uca.dao.ClassDAO;
import com.uca.entity.*;

import java.util.ArrayList;

public class ClassCore {
    public static ArrayList<ClassEntity> getAllClasses() {
        return new ClassDAO().getAllClasses();
    }

    public static ClassEntity createClass(int id_classroom, String classname, int id_teacher){
        ClassEntity classroom = new ClassEntity();
        classroom.setIdClass(id_classroom);
        classroom.setClassname(classname);
        classroom.setIdTeacher(id_teacher);
        return new ClassDAO().create(classroom  );
    }

    public static ClassEntity getClassById(int id){
        return new ClassDAO().getById(id);
    }

    public static void delete(ClassEntity classroom){
         new ClassDAO().delete(classroom);
    }
}
