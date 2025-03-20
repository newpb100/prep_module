package com.ams.test.sandbox;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

// отсюда
// https://habr.com/ru/articles/120101/
@RunWith(Parameterized.class)
public class JUnit4ParameterizeTest{

    private final CharSequence testData;
    private final boolean expectedResult;

    public JUnit4ParameterizeTest(final CharSequence testData, final boolean expectedResult){
        this.expectedResult = expectedResult;
        this.testData = testData;
    }

    // Must be static and return collection
    @Parameterized.Parameters(name = "Result true if only null or empty string")
    public static Collection<Object[]> testData() {
        return Arrays.asList(new Object[][] {
                {null, true},
                {"", true},
                {"    ", false},
                {"some string", true}  // will fail
        });
    }

    @Test
    public void checkStringForEmpty() {

        boolean actual = StringUtils.isEmpty(testData);
        org.junit.Assert.assertEquals(actual, expectedResult);

        // Будет 4 результата
        // 3 запуска (тут, думаю, правильнее говорить "тест-кейса") как PASSED
        // 1 запуск - FAILED

    }
}
