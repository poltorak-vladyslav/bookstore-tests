package com.bookstore.configuration;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.aeonbits.owner.ConfigCache;
import org.aeonbits.owner.ConfigFactory;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class ConfigurationManager {

    private static final Configuration CONFIGURATION;

    static {
        ConfigFactory.setProperty("env", Environment.getEnvironment().name().toLowerCase());
        CONFIGURATION = ConfigCache.getOrCreate(Configuration.class);
    }

    public static Configuration getConfiguration() {
        return CONFIGURATION;
    }
}
