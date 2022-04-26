package com.uca.gui;

import com.uca.core.StudentCore;
import com.uca.core.StudentStickerCore;
import com.uca.entity.StudentEntity;
import com.uca.entity.StudentStickerEntity;
import com.uca.entity.TeacherEntity;
import com.uca.entity.StickerEntity;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import spark.Request;

public class HistoryStudentStickerGUI {
    public static String getAllHistoryStudentsStickers(Request req) throws IOException, TemplateException {
        Configuration configuration = _FreeMarkerInitializer.getContext();

        Map<String, Object> input = new HashMap<>();
        if(!req.session().attributes().isEmpty()){
            input.put("user_log", req.session().attribute("username").toString());
        }
        input.put("student_stickers", StudentStickerCore.getAllStudentsStickers());

        Writer output = new StringWriter();
        Template template = configuration.getTemplate("model/history_student_stickers.ftl");
        template.setOutputEncoding("UTF-8");
        template.process(input, output);

        return output.toString();
    }

    public static String getAllStickersStudents(int id, Request req) throws IOException, TemplateException{
        Configuration configuration = _FreeMarkerInitializer.getContext();

        Map<String, Object> input = new HashMap<>();
        if(!req.session().attributes().isEmpty()){
            input.put("userlog", req.session().attribute("username").toString());
        }
        input.put("student", StudentCore.getStudentById(id));
        input.put("consult_stickers", StudentStickerCore.getStudentStickers(id));


        Writer output = new StringWriter();
        Template template = configuration.getTemplate("model/consult_student_stickers.ftl");
        template.setOutputEncoding("UTF-8");
        template.process(input, output);
        return output.toString();
    }
}
