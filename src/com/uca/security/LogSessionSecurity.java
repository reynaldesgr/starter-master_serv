package com.uca.security;

import spark.Request;

public class LogSessionSecurity {
    /** Return the session user -- if this user is connected -- **/
    public static String getSessionUser(Request req){
        if(req.session().attribute("username") != null){
            return req.session().attribute("username");
        }
        return null;
    }
}
