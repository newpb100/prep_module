package com.ams.test.sandbox;

import com.ams.train.Step03Scanner;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StepTests {

    @Test
    public void checkScanner(){
        Assertions.assertEquals(Step03Scanner.Step03Scanner(), 102.0);
    }
}
