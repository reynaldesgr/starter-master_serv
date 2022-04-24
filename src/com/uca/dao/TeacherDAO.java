package com.uca.dao;

import com.uca.entity.TeacherEntity;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class TeacherDAO extends _Generic<TeacherEntity> {

    /** Return all Teachers present in the BDD **/
    public ArrayList<TeacherEntity> getAllTeachers() {
        ArrayList<TeacherEntity> entities = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = this.connect.prepareStatement("SELECT * FROM teachers ORDER BY id_teacher ASC;");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                if (resultSet.getInt("id_teacher") != 0) {
                    TeacherEntity entity = new TeacherEntity();
                    entity.setId_teacher(resultSet.getInt("id_teacher"));
                    entity.setFirstName(resultSet.getString("firstname"));
                    entity.setLastName(resultSet.getString("lastname"));
                    entity.setUserName(resultSet.getString("username"));
                    entity.setPassword(resultSet.getString("password"));
                    entities.add(entity);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return entities;
    }

    /** Insert / Create a Teacher in BDD **/
    @Override
    public TeacherEntity create(TeacherEntity obj) {
        try {
            PreparedStatement statement = this.connect.prepareStatement("INSERT INTO teachers(firstname, lastname, username, password) VALUES(?, ?, ?, ?);", Statement.NO_GENERATED_KEYS);
            statement.setString(1, obj.getFirstName());
            statement.setString(2, obj.getLastName());
            statement.setString(3, obj.getUserName());
            statement.setString(4, obj.getPassword());
            statement.executeUpdate();
            ResultSet rs = statement.getGeneratedKeys();
            if(rs.next()){
                obj.setId_teacher(rs.getInt(1));
            }else{
                obj.setId_teacher(1);
            }
            return obj;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /** Delete a Teacher from the BDD **/
    @Override
    public void delete(TeacherEntity obj){
        try {
            PreparedStatement statement = this.connect.prepareStatement("DELETE FROM teachers WHERE id_teacher = ?;");
            statement.setInt(1, obj.getId_teacher());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /** Return a TeacherEntity object by giving its id **/
    @Override
    public TeacherEntity getById(int id){
        try{
            TeacherEntity t = new TeacherEntity();
            PreparedStatement statement = this.connect.prepareStatement("SELECT * FROM teachers WHERE id_teacher = ?");
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()){
                t.setId_teacher(resultSet.getInt("id_teacher"));
                t.setFirstName(resultSet.getString("firstname"));
                t.setLastName(resultSet.getString("lastname"));
                t.setUserName(resultSet.getString("username"));
                t.setPassword(resultSet.getString("password"));
                return t;
            }
        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }
        return null;
    }

    /** Return a TeacherEntity object by giving its username **/
    public TeacherEntity getByUsername(String username){
        try {
            TeacherEntity t = new TeacherEntity();
            PreparedStatement statement = this.connect.prepareStatement("SELECT * FROM teachers WHERE username = ?");
            statement.setString(1, username);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                t.setId_teacher(resultSet.getInt("id_teacher"));
                t.setFirstName(resultSet.getString("firstname"));
                t.setLastName(resultSet.getString("lastname"));
                t.setUserName(resultSet.getString("username"));
                t.setPassword(resultSet.getString("password"));
                return t;
            } else{
                return null;
            }
        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }
}
