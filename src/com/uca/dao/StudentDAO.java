package com.uca.dao;

import com.uca.entity.StudentEntity;

import java.sql.*;
import java.util.ArrayList;

public class StudentDAO extends _Generic<StudentEntity> {

    /** Return all Students present in the BDD **/
    public ArrayList<StudentEntity> getAllStudents() {
        ArrayList<StudentEntity> entities = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = this.connect.prepareStatement("SELECT * FROM students ORDER BY id_student ASC;");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                StudentEntity entity = new StudentEntity();
                entity.setId_student(resultSet.getInt("id_student"));
                entity.setFirstName(resultSet.getString("firstname"));
                entity.setLastName(resultSet.getString("lastname"));
                entity.setStudent_class(resultSet.getString("student_class"));

                entities.add(entity);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return entities;
    }

    /** Insert / Create a Sticker in the BDD **/
    @Override
    public StudentEntity create(StudentEntity obj) {
        try {
            PreparedStatement statement = this.connect.prepareStatement("INSERT INTO students(firstname, lastname, student_class) VALUES(?, ?, ?);");
            statement.setString(1, obj.getFirstName());
            statement.setString(2, obj.getLastName());
            statement.setString(3, obj.getStudent_class());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /** Delete a Sticker from the BDD **/
    @Override
    public void delete(StudentEntity obj){
        try {
            /** If a student is assigned to a sticker (student received a sticker) and
                this student is about to be deleted,
                we have to delete the student in the table studentsStickers too
                (because of foreign keys in the table studentsStickers) **/
            PreparedStatement statement_bis = this.connect.prepareStatement("SELECT student FROM studentsStickers WHERE student = ?");
            statement_bis.setInt(1,obj.getId_student());
            ResultSet resultSet = statement_bis.executeQuery();

            /* If there is a student who received a sticker */
            while(resultSet.next()){
                PreparedStatement statement_del = this.connect.prepareStatement("DELETE FROM studentsStickers WHERE student = ?");
                statement_del.setInt(1, resultSet.getInt("student"));
                statement_del.executeUpdate();
            }
            PreparedStatement statement = this.connect.prepareStatement("DELETE FROM students WHERE id_student = ?;");
            statement.setInt(1, obj.getId_student());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateStudent(int id, String student_class){
        try{
            PreparedStatement statement = this.connect.prepareStatement("UPDATE students SET student_class = ?  WHERE id_student = ?");
            statement.setString(1, student_class);
            statement.setInt(2, id);
            statement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    /** Return a Sticker object by giving its id **/
    @Override
    public StudentEntity getById(int id){
        try{
            StudentEntity s = new StudentEntity();
            PreparedStatement statement = this.connect.prepareStatement("SELECT * FROM students WHERE id_student = ?");
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()){
                s.setId_student(resultSet.getInt("id_student"));
                s.setFirstName(resultSet.getString("firstname"));
                s.setLastName(resultSet.getString("lastname"));
            }
            return s;
        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }


}
