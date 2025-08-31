package com.example.bookman.config;

import java.util.ResourceBundle;

public final class AppConfig {
    private static final ResourceBundle BUNDLE = ResourceBundle.getBundle("application");

    // Exposed constants
    public static final String APP_VERSION = BUNDLE.getString("app.version");
    public static final String EXPORT_DEFAULT_FILE_NAME   = BUNDLE.getString("export.defaultFileName");

    // Prevent instantiation
    private AppConfig() {}
}

