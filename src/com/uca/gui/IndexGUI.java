package com.uca.gui;
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

public class IndexGUI {
    /** Return the model view of /index **/
    public static String getModelIndex(Request req) throws IOException, TemplateException {
        Configuration configuration = _FreeMarkerInitializer.getContext();

        Map<String, Object> input = new HashMap<>();
        if(!req.session().attributes().isEmpty()){
            input.put("user_log", req.session().attribute("username").toString());
        }

        input.put("index_title", "Bienvenue");
        input.put("students", StudentCore.getAllStudents());

        if(StudentCore.getAllStudents().isEmpty()){
            input.put("empty_students", StudentCore.getAllStudents());
        }

        Writer output = new StringWriter();
        Template template = configuration.getTemplate("model/index.ftl");
        template.setOutputEncoding("UTF-8");
        template.process(input, output);

        return output.toString();
    }
}
