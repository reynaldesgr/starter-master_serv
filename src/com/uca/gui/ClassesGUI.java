package com.uca.gui;

import com.uca.core.ClassCore;
import com.uca.core.TeacherCore;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import spark.Request;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

public class ClassesGUI {

    public static String getAllClasses(Request req) throws IOException, TemplateException {
        Configuration configuration = _FreeMarkerInitializer.getContext();

        Map<String, Object> input = new HashMap<>();
        if(!req.session().attributes().isEmpty()){
            input.put("userlog", req.session().attribute("username").toString());
        }
        input.put("classes", ClassCore.getAllClasses());

        if(ClassCore.getAllClasses().isEmpty()){
            input.put("empty", ClassCore.getAllClasses());
        }

        input.put("teachers", TeacherCore.getAllTeachers());

        if(TeacherCore.getAllTeachers().isEmpty()){
            input.put("empty_teachers", TeacherCore.getAllTeachers());
        }

        Writer output = new StringWriter();
        Template template = configuration.getTemplate("model/classes.ftl");
        template.setOutputEncoding("UTF-8");
        template.process(input, output);

        return output.toString();
    }

}
