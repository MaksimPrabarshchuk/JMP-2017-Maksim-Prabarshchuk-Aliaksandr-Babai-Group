package com.github.alebabai.jmp2k17.mvc.util;


import org.apache.commons.lang3.StringUtils;

import static org.springframework.beans.propertyeditors.ResourceBundleEditor.BASE_NAME_SEPARATOR;

public final class CommentUtils {
    private CommentUtils() {
    }

    public static String getValidUsername(String username) {
        return StringUtils.replacePattern(username, "[^\\p{L}\\d]+", BASE_NAME_SEPARATOR);
    }
}
