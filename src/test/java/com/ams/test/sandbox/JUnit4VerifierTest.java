package com.ams.test.sandbox;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Verifier;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Thread.sleep;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class JUnit4VerifierTest {

    private List<String> alertLogMessage = new ArrayList<>();

    // Вносим доп. логику в тест, что если в alert лог что-то записалось - останавливаем тест!
    @Rule
    public Verifier verifier = new Verifier() {
        @Override
        protected void verify() throws Throwable {
            System.out.println(alertLogMessage.isEmpty());
            assertTrue("Message alert log is not empty!", alertLogMessage.isEmpty());
        }
    };

    @Test
    public void checkSmth() throws InterruptedException {
        System.out.println("checkSmth()");
        Thread.sleep(2000);

        // до этого момент тест выполняется без ошибок
        alertLogMessage.add("information about our test");
    }
    // Верификатор срабатывает после завершения тестового метода
    // java.lang.AssertionError: Message log is not empty..
    //      ..JUnit4VerifierTest$1.verify(JUnit4VerifierTest.java:23)...
}
