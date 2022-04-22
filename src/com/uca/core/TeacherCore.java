package com.uca.core;

import com.uca.dao.TeacherDAO;
import com.uca.entity.TeacherEntity;
import com.uca.security.HashPasswordSecurity;

import java.util.ArrayList;

public class TeacherCore {
    public static ArrayList<TeacherEntity> getAllTeachers() {
        return new TeacherDAO().getAllTeachers();
    }

    public static TeacherEntity getTeacherByUsername(String username){
        return new TeacherDAO().getByUsername(username);
    }

    public static TeacherEntity getTeacherById(int id){
        return new TeacherDAO().getById(id);
    }


    /** Check if a username corresponds to a password in the database **/
    public static boolean checkLogin(String username, String password) throws Exception {
        TeacherEntity t = getTeacherByUsername(username);
        return HashPasswordSecurity.check(password, t.getPassword());
    }
}
