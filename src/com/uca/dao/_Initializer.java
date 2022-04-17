package com.uca.dao;

import java.sql.*;

public class _Initializer {

    public static void Init(){
        Connection connection = _Connector.getInstance();

        try {
            PreparedStatement statement;

            //Init articles table

            // Students table //
            statement = connection.prepareStatement("CREATE TABLE IF NOT EXISTS students (id_student int primary key auto_increment, firstname varchar(100), lastname varchar(100), student_class varchar(50)); ");
            statement.executeUpdate();

            statement.executeUpdate();

            // Teachers table //
            statement = connection.prepareStatement("CREATE TABLE IF NOT EXISTS teachers (id_teacher int primary key auto_increment, firstname varchar(100), lastname varchar(100), username varchar(100), password varchar(10))");
            statement.executeUpdate();

            // Stickers table //
            statement = connection.prepareStatement("CREATE TABLE IF NOT EXISTS stickers (id_sticker int primary key auto_increment, description varchar(100), color varchar(10));");
            statement.executeUpdate();

            // StudentsStickers table //
            statement = connection.prepareStatement("CREATE TABLE IF NOT EXISTS studentsStickers (id int primary key auto_increment, id_student int, id_sticker int, id_teacher int, reason varchar(500), date_sticker date, foreign key(id_sticker) references stickers(id_sticker), foreign key(id_teacher) references teachers(id_teacher), foreign key(id_student) references students(id_student)); ");
            statement.executeUpdate();




        } catch (Exception e){
            System.out.println(e.toString());
            throw new RuntimeException("could not create database !");
        }
    }
}
