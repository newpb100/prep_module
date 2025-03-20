package com.ams.test.extensions;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestInstancePostProcessor;

//https://www.baeldung.com/junit-5-extensions
public class LoggingExtension implements TestInstancePostProcessor {

    @Override
    public void postProcessTestInstance(Object o, ExtensionContext extensionContext) throws Exception {

        Logger logger = LogManager.getLogger(o.getClass());

        o.getClass()
                .getMethod("setLogger", Logger.class)
                .invoke(o,logger);
    }
}
