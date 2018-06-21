package com.rice.util;

public class Validation {
    public static boolean isEmpty(Object object) {
        if (object instanceof String) {
            String str = (String) object;
            if (str == null || str.isEmpty()) {
                return true;
            }
            return false;
        }
        if (object == null) {
            return true;
        }
        return false;
    }
}
