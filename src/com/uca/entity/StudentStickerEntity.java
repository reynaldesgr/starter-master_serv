package com.uca.entity;

import java.sql.Date;

public class StudentStickerEntity {
    private int id;
    private String reason;

    private StudentEntity student;
    private TeacherEntity teacher;
    private StickerEntity sticker;

    private Date date_sticker;

    private int id_student;
    private String student_firstname;
    private String student_lastname;
    private int id_teacher;
    private String teacher_firstname;
    private String teacher_lastname;
    private int id_sticker;
    private StickerEntity.COLOR color_sticker;

    public void setId(int id){ this.id = id; }
    public int getId(){ return this.id; }

    public void setReason(String reason){ this.reason = reason; }
    public String getReason(){ return this.reason; }

    public void setDate_sticker(Date d){ this.date_sticker = d; }
    public String getDate_sticker(){ return this.date_sticker.toString(); }

    public void setStudent(StudentEntity s){ this.student = s;}
    public StudentEntity getStudent(){ return this.student; }

    public void setTeacher(TeacherEntity t){ this.teacher = t; }
    public TeacherEntity getTeacher(){ return this.teacher; }

    public void setSticker(StickerEntity st){ this.sticker = st; }
    public StickerEntity getSticker(){ return this.sticker; }

    public int getId_student(){ return this.id_student; }
    public int getId_teacher(){ return this.id_teacher; }

    public int getId_sticker(){ return this.id_sticker; }

    public String getStudent_firstname(){ return this.student_firstname; }
    public String getTeacher_firstname(){ return this.teacher_firstname; }

    public String getStudent_lastname(){ return this.student_lastname; }
    public String getTeacher_lastname(){ return this.teacher_lastname; }

    public String getColor_sticker(){ return String.valueOf(this.color_sticker); }


    public void setId_student(int id){ this.id_student = id; }
    public void setId_sticker(int id){ this.id_sticker = id; }
    public void setId_teacher(int id){ this.id_teacher = id; }

    public void setStudent_firstname(String name){ this.student_firstname = name; }
    public void setTeacher_firstname(String name){ this.teacher_firstname = name; }

    public void setStudent_lastname(String name){ this.student_lastname = name; }
    public void setTeacher_lastname(String name){ this.teacher_lastname = name; }

    public void setColor_sticker(StickerEntity.COLOR c){ this.color_sticker = c; }
}
