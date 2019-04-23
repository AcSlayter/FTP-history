package com.exc.util;

public class CmdHelper {
    public static String getArg(String[] cmdArgs, String key){
        for (String tmp : cmdArgs){
            if(tmp.contains(key)) {
                return tmp.split("=")[1];
            }
        }
        return null;
    }
}
