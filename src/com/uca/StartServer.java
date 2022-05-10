package com.uca;

import com.uca.core.*;
import com.uca.dao._Initializer;
import com.uca.entity.ClassEntity;
import com.uca.entity.StickerEntity;
import com.uca.entity.StudentEntity;
import com.uca.entity.StudentStickerEntity;
import com.uca.gui.*;
import com.uca.security.LogSessionSecurity;

import static spark.Spark.*;

public class StartServer {

    public static void main(String[] args) {
        //Configure Spark
        staticFiles.location("/static/");
        port(8081);

        _Initializer.Init();

        //Defining our routes

        get("/", (req, res) -> {
            res.redirect("/index");
            return null;
        });

        /* Students */
        get("/students", (req, res) -> StudentGUI.getAllStudents(req));

        /* Classes */
        get("/classes", (req, res) -> ClassesGUI.getAllClasses(req));

        /* Teachers */
        get("/teachers", (req, res) -> TeacherGUI.getAllTeachers(req));

        /* Stickers */
        get("/stickers", (req, res) -> StickerGUI.getAllStickers(req));

        /* Students that received stickers */
        get("/students-stickers", (req, res) -> HistoryStudentStickerGUI.getAllHistoryStudentsStickers(req));

        /* Index */
        get("/index", (req, res) -> IndexGUI.getModelIndex(req));

        /* Login */
        get("/login", (req, res) -> LoginGUI.getModelLogin());

        /* Add/Remove/Modify stickers from students */
        get("/put-stickers", (req, res) ->{
            if(LogSessionSecurity.getSessionUser(req) != null) {
                return StudentStickerGUI.getAllStudentsStickers(req);
            }else{
                res.redirect("/index");
            }
            return null;
        });

        /* Add/Remove/Modify student(s) */
        get("/put-students", (req, res) ->{
            if(LogSessionSecurity.getSessionUser(req) != null){
                return StudentGUI.getAllStudents(req);
            }else{
                res.redirect("/index");
            }
            return null;
        });

        /* Add/Remove/Modify class(es) */
        get("/put-classes", (req, res) ->{
            if(LogSessionSecurity.getSessionUser(req) != null){
                return ClassesGUI.getAllClasses(req);
            }else{
                res.redirect("/index");
            }
            return null;
        });

        /* Disconnect */
        get("/disconnect", (req, res) ->{
            if(LogSessionSecurity.getSessionUser(req) != null){
                req.session().removeAttribute("username");
            }
            res.redirect("/index");
            return null;
        });

        /* Consult the sticker of a student */
        get("/consult-student-stickers/:idstudent", (req, res) ->{
            if(LogSessionSecurity.getSessionUser(req) != null){
                int id_student = Integer.parseInt(req.params(":idstudent"));
                return HistoryStudentStickerGUI.getAllStickersStudents(id_student, req);
            }else{
                res.redirect("/index");
            }
            return null;
        });

        /* Delete a sticker  */
        get("delete-student-sticker/:id_student/:id", (req, res) ->{
            if(LogSessionSecurity.getSessionUser(req) != null){
                int id = Integer.parseInt(req.params(":id"));
                int id_student = Integer.parseInt(req.params(":id_student"));
                StudentStickerEntity stickers_student_to_remove = StudentStickerCore.getStudentStickersById(id);
                if(stickers_student_to_remove != null){
                    StudentStickerCore.delete(stickers_student_to_remove);
                }
                return HistoryStudentStickerGUI.getAllStickersStudents(id_student, req);
            }else{
                res.redirect("/index");
            }
            return null;
        });

        /* Delete a sticker */
        get("delete-sticker/:id", (req, res) ->{
            if(LogSessionSecurity.getSessionUser(req) != null){
                StickerEntity sticker_to_remove = StickerCore.getStickerById(Integer.parseInt(req.params(":id")));
                if(sticker_to_remove != null){
                    StickerCore.deleteSticker(sticker_to_remove);
                }
                res.redirect("/stickers");
            }else{
                res.redirect("/index");
            }
            return null;
        });

        /* Delete a student  */
        get("delete-student/:id", (req, res) ->{
            if(LogSessionSecurity.getSessionUser(req) != null){
                StudentEntity student_to_remove = StudentCore.getStudentById(Integer.parseInt(req.params(":id")));
                if(student_to_remove != null){
                    StudentCore.deleteStudent(student_to_remove);
                }
                res.redirect("/students");
            }else{
                res.redirect("/index");
            }
            return null;
        });

        /* Delete a class  */
        get("delete-class/:id", (req, res) ->{
            if(LogSessionSecurity.getSessionUser(req) != null){
                ClassEntity class_to_remove = ClassCore.getClassById(Integer.parseInt(req.params(":id")));
                if(class_to_remove != null){
                    ClassCore.delete(class_to_remove);
                }
                res.redirect("/classes");
            }else{
                res.redirect("/index");
            }
            return null;
        });


        /* Login */
        post("/login", (req, res) ->{
            String username = req.queryParams("username");
            String password = req.queryParams("password");
            if(TeacherCore.checkLogin(username, password)){
                req.session(true);
                req.session().attribute("username", username);
                res.redirect("/index");
            }else{
                res.redirect("/login");
            }
            return null;
        });

        /* Put an existing sticker on a student + adding a reason to this sticker */
        post("/put-stickers", (req, res) ->{
            if(LogSessionSecurity.getSessionUser(req) != null){
                StudentStickerCore.createStudentSticker(
                        Integer.parseInt(req.queryParams("name").split(" ")[0]) ,
                        TeacherCore.getTeacherByUsername(LogSessionSecurity.getSessionUser(req)).getId_teacher(),
                        Integer.parseInt(req.queryParams("color").split(" ")[0]) ,
                        req.queryParams("reason") );

                res.redirect("/students-stickers");
            }else{
                res.redirect("/index");
            }
            return null;
        });

        /* Stickers of a particular student */
        post("/consult-student-stickers", (req, res) ->{
            if(LogSessionSecurity.getSessionUser(req) != null){
                int id_student = Integer.parseInt(req.queryParams("student_name").split(" ")[0]);
                // res.redirect("consult-student-stickers/" + id_student);
                return HistoryStudentStickerGUI.getAllStickersStudents(id_student, req);
            }else{
                res.redirect("/index");
            }
            return null;
        });

        /* Update a student */
        post("/update-student", (req, res) ->{
            if(LogSessionSecurity.getSessionUser(req) != null){
                int id_student = Integer.parseInt(req.queryParams("name"));
                int new_student_class = Integer.parseInt(req.queryParams("studentclass"));
                StudentCore.updateStudent(id_student, new_student_class);
                res.redirect("/students");
            }else{
                res.redirect("/index");
            }
            return null;
        });

        /* Update a classroom */
        post("/update-classes", (req, res) ->{
            if(LogSessionSecurity.getSessionUser(req) != null){
                int id_class = Integer.parseInt(req.queryParams("classId"));
                String newName = req.queryParams("classname");
                int id_teacher = Integer.parseInt(req.queryParams("classTeacher"));
                ClassCore.updateClass(id_class, newName, id_teacher);
                res.redirect("/put-classes");
            }else{
                res.redirect("/index");
            }
            return null;
        });

        /* Adding a student */
        post("/add-student", (req, res) ->{
            if(LogSessionSecurity.getSessionUser(req) != null){
                String firstname = req.queryParams("firstname");
                String lastname = req.queryParams("lastname");
                int student_class = Integer.parseInt(req.queryParams("studentclass"));
                StudentCore.createStudent(firstname, lastname, student_class);
                res.redirect("/students");
            }else{
                res.redirect("/index");
            }
            return null;
        });

        /* Adding a classroom */
        post("/add-classroom", (req, res) ->{
            if(LogSessionSecurity.getSessionUser(req) != null){
                String classname = req.queryParams("classname");
                int teacherId = Integer.parseInt(req.queryParams("classTeacher"));
                ClassCore.createClass(classname, teacherId);
                res.redirect("/put-classes");
            }else{
                res.redirect("/index");
            }
            return null;
        });

        /* Modify an existing sticker */
        post("/modify-sticker", (req, res) -> {
            if(LogSessionSecurity.getSessionUser(req) != null){
                int id_sticker = Integer.parseInt(req.queryParams("id"));
                StickerEntity.COLOR new_color_sticker = StickerEntity.COLOR.valueOf(req.queryParams("color"));
                String new_description = req.queryParams("description");
                StickerCore.updateSticker(id_sticker, new_color_sticker, new_description);
                res.redirect("/stickers");
            }else{
                res.redirect("/index");
            }
            return null;
        });

        /* Add a sticker -- in the database -- */
        post("/add-sticker", (req, res) ->{
           if(LogSessionSecurity.getSessionUser(req) != null){
               String color = String.valueOf(StickerEntity.COLOR.valueOf(req.queryParams("color")));
               String description = req.queryParams("description");
               StickerCore.createSticker(color, description);
               res.redirect("/stickers");
           }else{
               res.redirect("/index");
           }
           return null;
        });

    }
}
