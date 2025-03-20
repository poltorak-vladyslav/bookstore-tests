package com.bookstore.configuration;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.LoadPolicy;
import org.aeonbits.owner.Config.Sources;

@Sources({
        "system:properties",
        "classpath:common.properties",
        "classpath:environments/${env}.properties"
})
@LoadPolicy(Config.LoadType.MERGE)
public interface Configuration extends Config {

    @Key("base.uri")
    String baseUri();

    @Key("base.path")
    String basePath();
}
