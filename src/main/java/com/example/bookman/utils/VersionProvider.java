package com.example.bookman.utils;
import picocli.CommandLine.IVersionProvider;

import java.io.InputStream;
import java.util.Properties;

public class VersionProvider implements IVersionProvider {
    @Override
    public String[] getVersion() throws Exception {
        Properties props = new Properties();
        try (InputStream is = getClass().getClassLoader().getResourceAsStream("application.properties")) {
            props.load(is);
        }
        return new String[] { props.getProperty("app.version", "unknown") };
    }
}
