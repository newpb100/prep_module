package com.ams.test.sandbox;

import org.junit.*;
import org.junit.rules.ExpectedException;
import org.junit.rules.Timeout;

import java.util.concurrent.TimeUnit;

public class JUnit4CheckTimeoutTest {

    @Rule
    public Timeout globalTimeout = new Timeout(7000, TimeUnit.MILLISECONDS);
    // общее время на выполнение всех методов, включая фикстуры


    @Before
    public void someBeforeMethod() throws InterruptedException {
        System.out.println("someBeforeMethod() started");

        Thread.sleep(5500);
    }
    // успевает пройти и не фейлится

    @Test(timeout = 2000)
    public void checkTimer() throws InterruptedException {
        System.out.println("checkTimer() started");

        Thread.sleep(3000);
        // err! org.junit.runners.model.TestTimedOutException: test timed out after 7000 milliseconds...
        // если в таймауте этого метода стоит 2000мс (он не успевает сработать), срабатывает глобальный таймер, т.к. по нему прошло 5500 + 1500 = 7000мс

        // но если таймаут у этого метода поставить в 1000, например
        // то сработает таймер именно на методе, а не глобальный т.к. в методе пройдет 1000мс, суммарно будет еще только 5500 + 1000 = 6500мс
        // err! org.junit.runners.model.TestTimedOutException: test timed out after 1000 milliseconds...
    }

}
