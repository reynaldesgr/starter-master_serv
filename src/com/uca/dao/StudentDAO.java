package com.uca.dao;

import com.uca.core.ClassCore;
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
                entity.setId_classroom(resultSet.getInt("id_classroom"));
                entity.setClassEntity(ClassCore.getClassById(entity.getId_classroom()));

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
            PreparedStatement statement = this.connect.prepareStatement("INSERT INTO students(firstname, lastname, id_classroom) VALUES(?, ?, ?);");
            statement.setString(1, obj.getFirstName());
            statement.setString(2, obj.getLastName());
            statement.setInt(3, obj.getId_classroom());
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
            PreparedStatement statement_bis = this.connect.prepareStatement("SELECT id_student FROM studentsStickers WHERE id_student = ?");
            statement_bis.setInt(1,obj.getId_student());
            ResultSet resultSet = statement_bis.executeQuery();

            /* If there is a student who received a sticker */
            while(resultSet.next()){
                PreparedStatement statement_del = this.connect.prepareStatement("DELETE FROM studentsStickers WHERE id_student = ?");
                statement_del.setInt(1, resultSet.getInt("id_student"));
                statement_del.executeUpdate();
            }
            PreparedStatement statement = this.connect.prepareStatement("DELETE FROM students WHERE id_student = ?;");
            statement.setInt(1, obj.getId_student());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateStudent(int id, int id_classroom){
        try{
            PreparedStatement statement = this.connect.prepareStatement("UPDATE students SET id_classroom = ?  WHERE id_student = ?");
            statement.setInt(1, id_classroom);
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
            PreparedStatement statement = this.connect.prepareStatement("SELECT * FROM students WHERE id_student = ?");
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()){
                StudentEntity s = new StudentEntity();

                s.setId_student(resultSet.getInt("id_student"));
                s.setFirstName(resultSet.getString("firstname"));
                s.setLastName(resultSet.getString("lastname"));
                s.setId_classroom(resultSet.getInt("id_classroom"));
                s.setClassEntity(ClassCore.getClassById(s.getId_classroom()));

                return s;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }


}
