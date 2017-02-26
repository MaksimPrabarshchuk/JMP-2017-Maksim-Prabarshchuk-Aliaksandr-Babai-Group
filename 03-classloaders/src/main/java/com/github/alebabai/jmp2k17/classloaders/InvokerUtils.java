package com.github.alebabai.jmp2k17.classloaders;

import java.net.MalformedURLException;
import java.net.URL;

public final class InvokerUtils {

    private InvokerUtils() {
        super();
    }

    public static URL getURL(String folderName, String fileName) throws MalformedURLException {
        final String fullPath = String.join("/", folderName, fileName);
        final String url = String.format("file://%s", fullPath);
        return new URL(url);
    }
}
