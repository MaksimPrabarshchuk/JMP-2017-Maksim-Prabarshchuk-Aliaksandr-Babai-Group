package com.github.alebabai.ws;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class JerseyApplication {
    private static final URI BASE_URI = URI.create("http://localhost:8080/");
    private static final String APP_NAME = "Jersey Simple REST";
    private static final String BASE_PACKAGE = "com.github.alebabai.ws";

    public static void main(String[] args) throws IOException, URISyntaxException {
        final HttpServer server = GrizzlyHttpServerFactory.createHttpServer(BASE_URI, createConfig());
        server.start();
    }

    private static ResourceConfig createConfig() {
        final ResourceConfig config = new ResourceConfig();
        config.setApplicationName(APP_NAME);
        config.packages(BASE_PACKAGE);
        return config;
    }
}
