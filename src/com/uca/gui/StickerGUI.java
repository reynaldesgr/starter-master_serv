package com.uca.gui;

import com.uca.core.StickerCore;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

import spark.Request;

public class StickerGUI {
    public static String getAllStickers(Request req) throws IOException, TemplateException {
        Configuration configuration = _FreeMarkerInitializer.getContext();

        Map<String, Object> input = new HashMap<>();
        if(!req.session().attributes().isEmpty()){
            input.put("userlog", req.session().attribute("username").toString());
        }
        if(!StickerCore.getAllStickers().isEmpty()){
            input.put("stickers", StickerCore.getAllStickers());
        }
        Writer output = new StringWriter();
        Template template = configuration.getTemplate("model/stickers.ftl");
        template.setOutputEncoding("UTF-8");
        template.process(input, output);

        return output.toString();
    }
}
