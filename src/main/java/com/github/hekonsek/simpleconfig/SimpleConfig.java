package com.github.hekonsek.simpleconfig;

import org.apache.commons.configuration2.*;

import java.util.HashMap;
import java.util.Map;

public class SimpleConfig {

    private static final SimpleConfig INSTANCE = new SimpleConfig();

    private final CompositeConfiguration configuration;

    private final Map<String, Object> inMemoryProperties = new HashMap<>();

    public SimpleConfig() {
        configuration = new CompositeConfiguration();
        configuration.addConfiguration(new MapConfiguration(inMemoryProperties), true);
        configuration.addConfiguration(new SystemConfiguration());
        configuration.addConfiguration(new EnvironmentConfiguration());
    }

    public static SimpleConfig simple() {
        return INSTANCE;
    }

    synchronized public SimpleConfig property(String key, Object value) {
        inMemoryProperties.put(key, value);
        return this;
    }

    synchronized public SimpleConfig reset() {
        inMemoryProperties.clear();
        return this;
    }

    public Configuration config() {
        return configuration;
    }

}