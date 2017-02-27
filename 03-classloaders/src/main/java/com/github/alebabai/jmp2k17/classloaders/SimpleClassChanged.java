package com.github.alebabai.jmp2k17.classloaders;

import org.apache.commons.lang3.StringUtils;

public final class SimpleClassChanged {

    private SimpleClassChanged() {
    }

    public static String processText(String text) {
        return StringUtils.repeat(text, 10);
    }
}
