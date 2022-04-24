package com.uca.dao;

import com.uca.core.StickerCore;
import com.uca.core.StudentCore;
import com.uca.core.TeacherCore;
import com.uca.entity.StickerEntity;
import com.uca.entity.StudentStickerEntity;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class StudentStickerDAO extends _Generic<StudentStickerEntity> {

    /** Return all StickerStudents present in the BDD
     * A sticker student is a student that receive a sticker from a teacher **/
    public ArrayList<StudentStickerEntity> getAllStudentStickers(){
        ArrayList<StudentStickerEntity> entities = new ArrayList<>();
        try{
            PreparedStatement preparedStatement = this.connect.prepareStatement("SELECT * FROM studentsStickers ORDER BY id ASC;");
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                StudentStickerEntity entity = new StudentStickerEntity();
                entity.setId(resultSet.getInt("id"));
                entity.setId_student(resultSet.getInt("id_student"));
                entity.setId_teacher(resultSet.getInt("id_teacher"));
                entity.setId_sticker(resultSet.getInt("id_sticker"));
                entity.setReason(resultSet.getString("reason"));
                entity.setDate_sticker(resultSet.getDate("date_sticker"));

                entity.setStudent(StudentCore.getStudentById(resultSet.getInt("id_student")));
                entity.setTeacher(TeacherCore.getTeacherById(resultSet.getInt("id_teacher")));
                entity.setSticker(StickerCore.getStickerById(resultSet.getInt("id_sticker")));
                entity.setTeacher_firstname(entity.getTeacher().getFirstName());
                entity.setStudent_firstname(entity.getStudent().getFirstName());
                entity.setTeacher_lastname(entity.getTeacher().getLastName());
                entity.setStudent_lastname(entity.getStudent().getLastName());
                entity.setColor_sticker(StickerEntity.COLOR.valueOf(entity.getSticker().getColor()));
                entities.add(entity);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return entities;
    }


    /** Insert / Create a StudentSticker in the BDD **/
    @Override
    public StudentStickerEntity create(StudentStickerEntity obj) {
        try{
            PreparedStatement statement = this.connect.prepareStatement("INSERT INTO studentsStickers(id_student, id_sticker, id_teacher, reason, date_sticker) VALUES(?, ?, ?, ?, ?);");
            statement.setInt(1, obj.getStudent().getId_student());
            statement.setInt(2, obj.getSticker().getId_sticker());
            statement.setInt(3, obj.getTeacher().getId_teacher());
            statement.setString(4, obj.getReason());
            statement.setDate(5, Date.valueOf(obj.getDate_sticker()));
            statement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    /** Delete a StudentSticker from the BDD **/
    @Override
    public void delete(StudentStickerEntity obj) {
        try{
            PreparedStatement statement = this.connect.prepareStatement("DELETE FROM studentsStickers WHERE id = ?;");
            statement.setInt(1, obj.getId());
            statement.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    /** Return a StudentSticker object by giving its id **/
    @Override
    public StudentStickerEntity getById(int id){
        try{
            PreparedStatement statement = this.connect.prepareStatement("SELECT * FROM studentsStickers WHERE id = ?");
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()){
                StudentStickerEntity s = new StudentStickerEntity();

                s.setId(resultSet.getInt("id"));
                s.setId_student(resultSet.getInt("id_student"));
                s.setId_teacher(resultSet.getInt("id_teacher"));
                s.setId_sticker(resultSet.getInt("id_sticker"));
                s.setReason(resultSet.getString("reason"));
                s.setDate_sticker(resultSet.getDate("date_sticker"));

                s.setStudent(StudentCore.getStudentById(resultSet.getInt("id_student")));
                s.setTeacher(TeacherCore.getTeacherById(resultSet.getInt("id_teacher")));
                s.setSticker(StickerCore.getStickerById(resultSet.getInt("id_sticker")));
                s.setTeacher_firstname(s.getTeacher().getFirstName());
                s.setStudent_firstname(s.getStudent().getFirstName());
                s.setTeacher_lastname(s.getTeacher().getLastName());
                s.setStudent_lastname(s.getStudent().getLastName());
                s.setColor_sticker(StickerEntity.COLOR.valueOf(s.getSticker().getColor()));

                return s;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    /** Return the list of stickers of student (id) **/
    public ArrayList<StudentStickerEntity> getStudentStickersById(int id){
        ArrayList<StudentStickerEntity> student_stickers = new ArrayList<>();
        try{
            PreparedStatement statement = this.connect.prepareStatement("SELECT * FROM studentsStickers WHERE id_student = ?");
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()){
                StudentStickerEntity entity = new StudentStickerEntity();
                entity.setId(resultSet.getInt("id"));
                entity.setId_student(resultSet.getInt("id_student"));
                entity.setId_teacher(resultSet.getInt("id_teacher"));
                entity.setId_sticker(resultSet.getInt("id_sticker"));
                entity.setReason(resultSet.getString("reason"));
                entity.setDate_sticker(resultSet.getDate("date_sticker"));

                entity.setStudent(StudentCore.getStudentById(resultSet.getInt("id_student")));
                entity.setTeacher(TeacherCore.getTeacherById(resultSet.getInt("id_teacher")));
                entity.setSticker(StickerCore.getStickerById(resultSet.getInt("id_sticker")));
                entity.setTeacher_firstname(entity.getTeacher().getFirstName());
                entity.setStudent_firstname(entity.getStudent().getFirstName());
                entity.setTeacher_lastname(entity.getTeacher().getLastName());
                entity.setStudent_lastname(entity.getStudent().getLastName());
                entity.setColor_sticker(StickerEntity.COLOR.valueOf(entity.getSticker().getColor()));

                student_stickers.add(entity);
            }
            return student_stickers;
        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }

}
