package com.lc.wj.utils;

import java.util.UUID;

public class UploadUtils {

    public static String uuidStringName(){
        String uuid = UUID.randomUUID().toString();
        String all = uuid.replaceAll("-", "");
        return all;
    }
}
