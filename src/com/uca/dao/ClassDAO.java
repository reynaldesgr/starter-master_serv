package com.uca.dao;


import com.uca.entity.ClassEntity;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ClassDAO extends _Generic<ClassEntity> {

    /** Return all StickerStudents present in the BDD
     * A sticker student is a student that receive a sticker from a teacher **/
    public ArrayList<ClassEntity> getAllClasses(){
        ArrayList<ClassEntity> entities = new ArrayList<>();
        try{
            PreparedStatement preparedStatement = this.connect.prepareStatement("SELECT * FROM classroom ORDER BY id_classroom ASC;");
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                ClassEntity entity = new ClassEntity();
                entity.setIdClass(resultSet.getInt("id_classroom"));
                entity.setClassname(resultSet.getString("classname"));
                entity.setIdTeacher(resultSet.getInt("id_teacher"));
                entities.add(entity);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return entities;
    }

    @Override
    public ClassEntity create(ClassEntity obj) {
        try {
            PreparedStatement statement = this.connect.prepareStatement("INSERT INTO classroom(id_classroom, classname, id_teacher) VALUES(?, ?, ?);");
            statement.setInt(1, obj.getIdClass());
            statement.setString(2, obj.getClassname());
            statement.setInt(3, obj.getIdTeacher());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void delete(ClassEntity obj) {
        try {

            PreparedStatement statement_update = this.connect.prepareStatement("UPDATE students SET id_classroom = null WHERE id_classroom = ?");
            statement_update.setInt(1, obj.getIdClass());
            statement_update.executeUpdate();

            PreparedStatement statement = this.connect.prepareStatement("DELETE FROM classroom WHERE id_classroom = ?;");
            statement.setInt(1, obj.getIdClass());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public ClassEntity getById(int id) {
        try{
            ClassEntity c = new ClassEntity();
            PreparedStatement statement = this.connect.prepareStatement("SELECT * FROM classroom WHERE id_classroom = ?");
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()){
                c.setIdClass(resultSet.getInt("id_classroom"));
                c.setClassname(resultSet.getString("classname"));
                c.setIdTeacher(resultSet.getInt("id_teacher"));
            }
            return c;
        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }
}
