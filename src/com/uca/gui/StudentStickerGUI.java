package com.uca.gui;

import com.uca.core.StickerCore;
import com.uca.core.StudentCore;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import spark.Request;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

public class StudentStickerGUI {

    public static String getAllStudentsStickers(Request req) throws IOException, TemplateException {
        Configuration configuration = _FreeMarkerInitializer.getContext();

        Map<String, Object> input = new HashMap<>();
        if(!req.session().attributes().isEmpty()){
            input.put("userlog", req.session().attribute("username").toString());
        }
        input.put("stickers", StickerCore.getAllStickers());

        if(StickerCore.getAllStickers().isEmpty()){
            input.put("empty_stickers", StickerCore.getAllStickers());
        }

        input.put("students", StudentCore.getAllStudents());

        if(StudentCore.getAllStudents().isEmpty()){
            input.put("empty_students", StudentCore.getAllStudents());
        }

        input.put("id_stickers", StickerCore.getAllStickers());

        Writer output = new StringWriter();
        Template template = configuration.getTemplate("model/student_stickers.ftl");
        template.setOutputEncoding("UTF-8");
        template.process(input, output);

        return output.toString();
    }

}