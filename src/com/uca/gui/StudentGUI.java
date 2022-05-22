package com.uca.gui;

import com.uca.core.ClassCore;
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

public class StudentGUI {

    public static String getAllStudents(Request req) throws IOException, TemplateException {
        Configuration configuration = _FreeMarkerInitializer.getContext();

        Map<String, Object> input = new HashMap<>();
        if(!req.session().attributes().isEmpty()){
            input.put("userlog", req.session().attribute("username").toString());
        }
        input.put("stickers", StickerCore.getAllStickers());
        input.put("students", StudentCore.getAllStudents());

        if(StudentCore.getAllStudents().isEmpty()){
            input.put("empty", StudentCore.getAllStudents());
        }

        input.put("classes", ClassCore.getAllClasses());

        if(ClassCore.getAllClasses().isEmpty()){
            input.put("empty_classes", ClassCore.getAllClasses());
        }

        input.put("id_stickers", StickerCore.getAllStickers());

        Writer output = new StringWriter();
        Template template = configuration.getTemplate("model/students.ftl");
        template.setOutputEncoding("UTF-8");
        template.process(input, output);

        return output.toString();
    }

}
