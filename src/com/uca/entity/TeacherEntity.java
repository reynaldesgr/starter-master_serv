package com.uca.entity;

public class TeacherEntity {
    private int id_teacher;
    private String firstName;
    private String lastName;
    private String userName;
    private String password;

    public int getId_teacher(){
        return this.id_teacher;
    }
    public void setId_teacher(int id_teacher){
        this.id_teacher = id_teacher;
    }

    public void setFirstName(String firstname){
        this.firstName = firstname;
    }
    public String getFirstName(){
        return this.firstName;
    }

    public void setLastName(String lastname){
        this.lastName = lastname;
    }
    public String getLastName(){
        return this.lastName;
    }

    public void setUserName(String username){
        this.userName = username;
    }
    public String getUserName(){
        return this.userName;
    }

    public void setPassword(String password){ this.password = password; }
    public String getPassword(){ return this.password; }
}
