package com.uca.gui;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import spark.Request;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

public class LoginGUI {
    /** Return the model view of /login **/
    public static String getModelLogin(Request req) throws IOException, TemplateException {
        Configuration configuration = _FreeMarkerInitializer.getContext();

        Map<String, Object> input = new HashMap<>();
        String dest = req.queryParams("ref");
        input.put("ref", dest);

        input.put("login_title", "Se connecter");
        Writer output = new StringWriter();
        Template template = configuration.getTemplate("model/login.ftl");
        template.setOutputEncoding("UTF-8");
        template.process(input, output);

        return output.toString();
    }
}
