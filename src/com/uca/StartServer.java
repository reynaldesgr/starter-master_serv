package com.uca;

import com.uca.core.*;
import com.uca.dao._Initializer;
import com.uca.entity.StickerEntity;
import com.uca.entity.StudentEntity;
import com.uca.entity.StudentStickerEntity;
import com.uca.gui.*;
import com.uca.security.LogSessionSecurity;
import spark.Session;

import static spark.Spark.*;

public class StartServer {

    public static void main(String[] args) {
        //Configure Spark
        staticFiles.location("/static/");
        port(8081);

        _Initializer.Init();

        //Defining our routes
        /** -- GET -- **/

        get("/", (req, res) -> {
            res.redirect("/index");
            return null;
        });

        /* Students */
        get("/students", (req, res) -> {
            return StudentGUI.getAllStudents(req);
        });

        /* Teachers */
        get("/teachers", (req, res) ->{
            return TeacherGUI.getAllTeachers();
        });

        /* Stickers */
        get("/stickers", (req, res) ->{
            return StickerGUI.getAllStickers(req);
        });

        /* Students that received stickers */
        get("/students-stickers", (req, res) ->{
            return HistoryStudentStickerGUI.getAllHistoryStudentsStickers();
        });

        /* Index */
        get("/index", (req, res) ->{
            return IndexGUI.getModelIndex(req);
        });

        /* Login */
        get("/login", (req, res) ->{
            return LoginGUI.getModelLogin();
        });

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
        get("delete-student-sticker/:id", (req, res) ->{
            if(LogSessionSecurity.getSessionUser(req) != null){
                StudentStickerEntity stickers_student_to_remove = StudentStickerCore.getStudentStickersById(Integer.parseInt(req.params(":id")));
                StudentStickerCore.delete(stickers_student_to_remove);
                res.redirect("/consult-student-stickers/" + stickers_student_to_remove.getStudent().getId_student());
            }else{
                res.redirect("/index");
            }
            return null;
        });

        /* Delete a sticker */
        get("delete-sticker/:id", (req, res) ->{
            if(LogSessionSecurity.getSessionUser(req) != null){
                StickerEntity sticker_to_remove = StickerCore.getStickerById(Integer.parseInt(req.params(":id")));
                StickerCore.deleteSticker(sticker_to_remove);
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
                StudentCore.deleteStudent(student_to_remove);
                res.redirect("/students");
            }else{
                res.redirect("/index");
            }
            return null;
        });


        /** -- POST -- **/

        /* Login */
        post("/login", (req, res) ->{
            String username = req.queryParams("username");
            String password = req.queryParams("password");
            if(TeacherCore.checkLogin(username, password)){
                Session session = req.session(true);
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
                        TeacherCore.getTeacherByUsername(LogSessionSecurity.getSessionUser(req).toString()).getId_teacher(),
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
                return HistoryStudentStickerGUI.getAllStickersStudents(id_student, req);
            }else{
                res.redirect("/index");
            }
            return null;
        });

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
               StickerEntity s = StickerCore.createSticker(color, description);
               res.redirect("/stickers");
           }else{
               res.redirect("/index");
           }
           return null;
        });

    }
}