package com.uca.core;

import com.uca.dao.StickerDAO;
import com.uca.dao.StudentDAO;
import com.uca.dao.StudentStickerDAO;
import com.uca.entity.StickerEntity;
import com.uca.entity.StudentEntity;
import com.uca.entity.StudentStickerEntity;
import com.uca.entity.TeacherEntity;

import java.time.LocalDate;
import java.util.ArrayList;

public class StudentStickerCore {
    public static ArrayList<StudentStickerEntity> getAllStudentsStickers() {
        return new StudentStickerDAO().getAllStudentStickers();
    }

    public static StudentStickerEntity createStudentSticker(int id_student, int id_teacher, int id_sticker, String reason){
        StudentEntity student = StudentCore.getStudentById(id_student);

        /* Création du sticker associé */
        StickerEntity sticker = StickerCore.getStickerById(id_sticker);

        /* Création du professeur associé */
        TeacherEntity teacher = TeacherCore.getTeacherById(id_teacher);

        StudentStickerEntity sticker_student = new StudentStickerEntity();

        sticker_student.setReason(reason);
        sticker_student.setStudent(student);
        sticker_student.setTeacher(teacher);
        sticker_student.setSticker(sticker);
        sticker_student.setDate_sticker(java.sql.Date.valueOf(LocalDate.now()));
        return new StudentStickerDAO().create(sticker_student);
    }

    public static StudentStickerEntity getStudentStickersById(int id){
        return new StudentStickerDAO().getById(id);
    }

    public static ArrayList<StudentStickerEntity> getStudentStickers(int id){
        return new StudentStickerDAO().getStudentStickersById(id);
    }

    /** Return the list of teachers presents in stickersStudents table. **/
    public static ArrayList<TeacherEntity> getAllTeachersStickers(){
        ArrayList<StudentStickerEntity> students_stickers = getAllStudentsStickers();
        ArrayList<TeacherEntity> teachers_stickers = new ArrayList<>();
        for(StudentStickerEntity s : students_stickers){
            teachers_stickers.add(s.getTeacher());
        }   return teachers_stickers;
    }

    /** Return the list of students presents in stickersStudents table. **/
    public static ArrayList<StudentEntity> getAllStudents(){
        ArrayList<StudentStickerEntity> students_stickers = getAllStudentsStickers();
        ArrayList<StudentEntity> students = new ArrayList<>();
        for(StudentStickerEntity s : students_stickers){
            students.add(s.getStudent());
        }   return students;
    }

    /** Return the list of stickers presents in stickersStudents table. **/
    public static ArrayList<StickerEntity> getAllStickers(){
        ArrayList<StudentStickerEntity> students_stickers = getAllStudentsStickers();
        ArrayList<StickerEntity> stickers = new ArrayList<>();
        for(StudentStickerEntity s : students_stickers){
            stickers.add(s.getSticker());
        }   return stickers;
    }

    public static void delete(StudentStickerEntity student_sticker){
         new StudentStickerDAO().delete(student_sticker);
    }
}
