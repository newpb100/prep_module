package com.ams.test.sandbox;


import com.ams.test.extensions.LoggingExtension;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;


@ExtendWith(LoggingExtension.class)
//@ExtendWith(EnvironmentExtension.class)
public class JUnit5FooTests {
    private Logger logger;

    @Test
    public void simpleTest1(){
        System.out.println("просто текст");

        //как быстро зафейлить тест
        assert false;
        //int a = 1/0;
        //throw new NullPointerException();
    }

    @Test
    @DisplayName("Проверка TestInstancePostProcessor extension: Простой тест с логированием")
    public void simpleTest2(){

        System.out.println("пока ничего тут не делаем");
        logger.info("пока ничего тут не делаем");


    }

    @Test
    @DisplayName("Проверка ExecutionCondition extension: Запуск этого теста только в тестовой среде")
    public void testWithRunCondition(){


    }


    public void setLogger(Logger logger) {
        this.logger = logger;
    }
}
