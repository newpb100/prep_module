package com.ams.test.extensions;

import com.ams.train.ServerConfig;
import org.junit.jupiter.api.extension.ConditionEvaluationResult;
import org.junit.jupiter.api.extension.ExecutionCondition;
import org.junit.jupiter.api.extension.ExtensionContext;

import java.io.IOException;
import java.util.Properties;

public class EnvironmentExtension implements ExecutionCondition {

    @Override
    public ConditionEvaluationResult evaluateExecutionCondition(ExtensionContext extensionContext) {

        Properties props = new Properties();
        try {
            System.out.println("221212");
            props.load(EnvironmentExtension.class.getResourceAsStream("serverconfig.properties"));
            //props.load(EnvironmentExtension.class.getResourceAsStream("12312"));

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (Exception e){
            System.out.println("---------------------!!!");
            throw new RuntimeException(e);
        }
        System.out.println("-121212--------------------!!!");

        if ("prod".equalsIgnoreCase(props.getProperty("port"))){
            return ConditionEvaluationResult.disabled("Test disabled on PROD environment");
        }else{
            return ConditionEvaluationResult.enabled("Test enabled, no PROD environment found");
        }
    }
}
