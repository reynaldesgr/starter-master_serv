package com.uca.dao;

import com.uca.security.HashPasswordSecurity;

import java.sql.*;

public class _Initializer {

  public static void Init(){
    Connection connection = _Connector.getInstance();

    try {
      PreparedStatement statement;

      //Init articles table
      /** Drop table, uncomment to use / comment to desactivate **/
      statement = connection.prepareStatement("DROP TABLE IF EXISTS studentsStickers");
      statement.executeUpdate();
      statement = connection.prepareStatement("DROP TABLE IF EXISTS students");
      statement.executeUpdate();
      statement = connection.prepareStatement("DROP TABLE IF EXISTS stickers");
      statement.executeUpdate();
      statement = connection.prepareStatement("DROP TABLE IF EXISTS classroom");
      statement.executeUpdate();
      statement = connection.prepareStatement("DROP TABLE IF EXISTS teachers");
      statement.executeUpdate();
      /**                                                     **/


      // Teachers table //
      statement = connection.prepareStatement("CREATE TABLE IF NOT EXISTS teachers (id_teacher int primary key auto_increment, firstname varchar(100), lastname varchar(100), username varchar(100), password varchar(100))");
      statement.executeUpdate();

      // Class table //
      statement = connection.prepareStatement("CREATE TABLE IF NOT EXISTS classroom (id_classroom int primary key auto_increment, classname varchar(100), id_teacher int, foreign key(id_teacher) references teachers(id_teacher)); ");
      statement.executeUpdate();

      // Students table //
      statement = connection.prepareStatement("CREATE TABLE IF NOT EXISTS students (id_student int primary key auto_increment, firstname varchar(100), lastname varchar(100), id_classroom int, foreign key(id_classroom) references classroom(id_classroom)); ");
      statement.executeUpdate();

      // Stickers table //
      statement = connection.prepareStatement("CREATE TABLE IF NOT EXISTS stickers (id_sticker int primary key auto_increment, description varchar(100), color varchar(10));");
      statement.executeUpdate();

      // StudentsStickers table //

      statement = connection.prepareStatement("CREATE TABLE IF NOT EXISTS studentsStickers (id int primary key auto_increment, id_student int, id_sticker int, id_teacher int, reason varchar(500), date_sticker date, foreign key(id_sticker) references stickers(id_sticker), foreign key(id_teacher) references teachers(id_teacher), foreign key(id_student) references students(id_student)); ");
      statement.executeUpdate();


      /** Insert into, uncomment to use / comment to desactivate **/

      /** Teachers **/
      statement = connection.prepareStatement("DELETE FROM teachers WHERE id_teacher = 0");
      statement.executeUpdate();
      statement = connection.prepareStatement("INSERT INTO teachers(id_teacher, firstname, lastname, username, password) VALUES (0, 'Aucun', 'Aucun', 'Aucun', 'Aucun');");
      statement.executeUpdate();

      statement = connection.prepareStatement("INSERT INTO teachers(id_teacher, firstname, lastname, username, password) VALUES(?, ?, ?, ?, ?);");
      statement.setInt(1, 1);
      statement.setString(3, "Myrtille");
      statement.setString(2, "Mireille");
      statement.setString(4, "myrmirei");
      statement.setString(5, HashPasswordSecurity.getHash("myr15"));
      statement.executeUpdate();
      statement = connection.prepareStatement("INSERT INTO teachers(firstname, lastname, username, password) VALUES(?, ?, ?, ?);");
      statement.setString(2, "Framboise");
      statement.setString(1, "Julien");
      statement.setString(3, "julframb");
      statement.setString(4, HashPasswordSecurity.getHash("jufram15"));
      statement.executeUpdate();

      statement = connection.prepareStatement("INSERT INTO teachers(firstname, lastname, username, password) VALUES(?, ?, ?, ?);");
      statement.setString(2, "Jouveneau");
      statement.setString(1, "Bruno");
      statement.setString(3, "brunojouv");
      statement.setString(4, HashPasswordSecurity.getHash("bbj15"));
      statement.executeUpdate();

      /** Classroom **/
      statement = connection.prepareStatement("DELETE  FROM classroom WHERE id_classroom = 0");
      statement.executeUpdate();
      statement = connection.prepareStatement("INSERT INTO classroom(id_classroom, classname, id_teacher) VALUES (0, 'Aucun', 0);");
      statement.executeUpdate();
      statement = connection.prepareStatement("INSERT INTO classroom(id_classroom, classname, id_teacher) VALUES(?, ?, ?);");
      statement.setInt(1, 1);
      statement.setString(2, "C1");
      statement.setInt(3, 1);
      statement.executeUpdate();
      statement.setInt(1, 2);
      statement.setString(2, "C2");
      statement.setInt(3, 1);
      statement.executeUpdate();

      /** Students **/
      statement = connection.prepareStatement("INSERT INTO students(firstname, lastname, id_classroom) VALUES(?, ?, ?);");
      statement.setString(1, "Theodore");
      statement.setString(2, "Muillerez");
      statement.setInt(3, 1);
      statement.executeUpdate();

      statement = connection.prepareStatement("INSERT INTO students(firstname, lastname, id_classroom) VALUES(?, ?, ?);");
      statement.setString(1, "Mathilde");
      statement.setString(2, "Richard");
      statement.setInt(3, 1);
      statement.executeUpdate();

      statement = connection.prepareStatement("INSERT INTO students(firstname, lastname, id_classroom) VALUES(?, ?, ?);");
      statement.setString(1, "Louis");
      statement.setString(2, "Raymond");
      statement.setInt(3, 1);
      statement.executeUpdate();

      statement = connection.prepareStatement("INSERT INTO students(firstname, lastname, id_classroom) VALUES(?, ?, ?);");
      statement.setString(1, "Mathias");
      statement.setString(2, "Bernard");
      statement.setInt(3, 2);
      statement.executeUpdate();

      statement = connection.prepareStatement("INSERT INTO students(firstname, lastname, id_classroom) VALUES(?, ?, ?);");
      statement.setString(1, "Julie");
      statement.setString(2, "Roberts");
      statement.setInt(3, 2);
      statement.executeUpdate();

      /** Stickers **/
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
      statement.executeUpdate();
      /**                                     **/


    } catch (Exception e){
      System.out.println(e.toString());
      throw new RuntimeException("could not create database !");
    }
  }
}