package org.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");

        Logger LOGGER = LoggerFactory.getLogger(Main.class);

        LOGGER.info("Тестовая строка для проверки логгирования");
    }
}