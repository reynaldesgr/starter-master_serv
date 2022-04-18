package com.uca.dao;

import java.sql.*;

public class _Initializer {

    public static void Init(){
        Connection connection = _Connector.getInstance();

        try {
            PreparedStatement statement;

            //Init articles table
            /** Drop table, uncomment to use / comment to desactivate **/
            /*
            statement = connection.prepareStatement("DROP TABLE studentsStickers");
            statement.executeUpdate();
            statement = connection.prepareStatement("DROP TABLE teachers");
            statement.executeUpdate();
            statement = connection.prepareStatement("DROP TABLE students");
            statement.executeUpdate();
            statement = connection.prepareStatement("DROP TABLE stickers");
            statement.executeUpdate();*/
            /**                                                     **/

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


            /** Insert into, uncomment to use / comment to desactivate **/

            /** Students **/
            /*
            statement = connection.prepareStatement("INSERT INTO students(firstname, lastname, student_class) VALUES(?, ?, ?);");
            statement.setString(1, "Theodore");
            statement.setString(2, "Muillerez");
            statement.setString(3, "C1");
            statement.executeUpdate();
            statement = connection.prepareStatement("INSERT INTO students(firstname, lastname, student_class) VALUES(?, ?, ?);");
            statement.setString(1, "Mathilde");
            statement.setString(2, "Richard");
            statement.setString(3, "C1");
            statement.executeUpdate();
            statement = connection.prepareStatement("INSERT INTO students(firstname, lastname, student_class) VALUES(?, ?, ?);");
            statement.setString(1, "Louis");
            statement.setString(2, "Raymond");
            statement.setString(3, "C4");
            statement.executeUpdate();
            statement = connection.prepareStatement("INSERT INTO students(firstname, lastname, student_class) VALUES(?, ?, ?);");
            statement.setString(1, "Mathias");
            statement.setString(2, "Bernard");
            statement.setString(3, "C2");
            statement.executeUpdate();
            statement = connection.prepareStatement("INSERT INTO students(firstname, lastname, student_class) VALUES(?, ?, ?);");
            statement.setString(1, "Julie");
            statement.setString(2, "Roberts");
            statement.setString(3, "C2");
            statement.executeUpdate();*/

            /** Stickers **/
            /*
            statement = connection.prepareStatement("INSERT INTO stickers(description, color) VALUES(?, ?);");
            statement.setString(1, "Mauvais comportement");
            statement.setString(2, "ROUGE");
            statement.executeUpdate();
            statement = connection.prepareStatement("INSERT INTO stickers(description, color) VALUES(?, ?);");
            statement.setString(1, "Bon travail");
            statement.setString(2, "VERT");
            statement.executeUpdate();
            statement = connection.prepareStatement("INSERT INTO stickers(description, color) VALUES(?, ?);");
            statement.setString(1, "Bonne participation");
            statement.setString(2, "BLEU");
            statement.executeUpdate();*/
            
            /** Teachers **/
            /*
            statement = connection.prepareStatement("INSERT INTO teachers(firstname, lastname, username, password) VALUES(?, ?, ?, ?);");
            statement.setString(2, "Myrtille");
            statement.setString(1, "Mireille");
            statement.setString(3, "myrmirei");
            statement.setString(4, "myr15");
            statement.executeUpdate();

            statement = connection.prepareStatement("INSERT INTO teachers(firstname, lastname, username, password) VALUES(?, ?, ?, ?);");
            statement.setString(2, "Framboise");
            statement.setString(1, "Julien");
            statement.setString(3, "julframb");
            statement.setString(4, "jufram15");
            statement.executeUpdate();

            statement = connection.prepareStatement("INSERT INTO teachers(firstname, lastname, username, password) VALUES(?, ?, ?, ?);");
            statement.setString(2, "Jouveneau");
            statement.setString(1, "Bruno");
            statement.setString(3, "brunojouv");
            statement.setString(4, "bbj15");
            statement.executeUpdate();*/
            /**                                     **/


        } catch (Exception e){
            System.out.println(e.toString());
            throw new RuntimeException("could not create database !");
        }
    }
}
