package com.github.hekonsek.simpleconfig;

import org.apache.commons.configuration2.*;

public class SimpleConfig {

    private static final SimpleConfig INSTANCE = new SimpleConfig();

    private final CompositeConfiguration configuration;

    public SimpleConfig() {
        configuration = new CompositeConfiguration(){

            @Override
            protected boolean containsKeyInternal(String key) {
                return super.containsKeyInternal(key) || super.containsKeyInternal(normalizedKey(key));
            }

            @Override
            protected Object getPropertyInternal(String key) {
                Object result = super.getPropertyInternal(key);
                if(result == null) {
                    result = super.getPropertyInternal(normalizedKey(key));
                }
                return result;
            }

            private String normalizedKey(String key) {
                return key.toUpperCase().replaceAll("\\.", "_");
            }

        };
        configuration.setThrowExceptionOnMissing(true);
        configuration.addConfiguration(new SystemConfiguration());
        configuration.addConfiguration(new EnvironmentConfiguration());
    }

    public static SimpleConfig simple() {
        return INSTANCE;
    }

    public SimpleConfig clearProperty(String key) {
        configuration.getInMemoryConfiguration().clearProperty(key);
        return this;
    }

    public Configuration config() {
        return configuration;
    }

}