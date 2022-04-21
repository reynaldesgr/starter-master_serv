package com.uca.core;

import com.uca.dao.ClassDAO;
import com.uca.dao.StudentDAO;
import com.uca.entity.*;

import java.util.ArrayList;

public class ClassCore {
    public static ArrayList<ClassEntity> getAllClasses() {
        return new ClassDAO().getAllClasses();
    }

    public static ClassEntity createClass(String classname, int id_teacher){
        ClassEntity classroom = new ClassEntity();
        classroom.setClassname(classname);
        classroom.setIdTeacher(id_teacher);
        return new ClassDAO().create(classroom);
    }

    public static ClassEntity getClassById(int id){
        return new ClassDAO().getById(id);
    }

    public static void delete(ClassEntity classroom){
        if (classroom.getIdClass() != 0) {
            new ClassDAO().delete(classroom);
        }
    }

    public static void updateClass(int id_class, String newName, int id_teacher) {
        new ClassDAO().updateClass(id_class, newName, id_teacher);
    }
}
