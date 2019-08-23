package com.fireworks.fireworks_chat.util;

/**
 * Created on : August 15, 2019
 * Author     : alifhaikal
 * Name       : Alif Haikal
 */
public final class AvatarUtil {
    public static String generateAvatar(String s) {
        s = s.replaceAll(" ", "");
        return "https://robohash.org/" + s + "/bgset_bg2/3.14160?set=set4";
    }
}
