package com.ams.train;

import com.ams.train.supply.Bird;
import com.ams.train.supply.ClassWithFinalMembers;
import com.ams.train.supply.ClassWithFinalNonNullMembers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Step42LombokTest {

    @Test
    void whenClassHasFinalMembers_thenGeneratedConstructorHasParameters() {
        ClassWithFinalMembers classWithFinalMembers = new ClassWithFinalMembers("dummyString");
        Assertions.assertNotNull(classWithFinalMembers);
        Assertions.assertEquals("dummyString", classWithFinalMembers.getStringObject());
    }

    @Test
    void whenClassHasFinalAndNonNullMembers_thenGeneratedConstructorHasParameters() {
        ClassWithFinalNonNullMembers classWithFinalNonNullMembers = new ClassWithFinalNonNullMembers("finalString", "nonNullString");
        Assertions.assertNotNull(classWithFinalNonNullMembers);
        Assertions.assertEquals("finalString", classWithFinalNonNullMembers.getFinalStringObject());
        Assertions.assertEquals("nonNullString", classWithFinalNonNullMembers.getNonNullStringObject());
        Assertions.assertNull(classWithFinalNonNullMembers.getNonFinalStringObject());
    }

    @Test
    void whenClassHasFinalAndNonNullMembers_thenGeneratedConstructorHasNoParameters() {
        ///Конструктор без параметров вызвать не получится
        ///ClassWithFinalNonNullMembers classWithFinalNonNullMembers = new ClassWithFinalNonNullMembers();  Err: Expected 2 arguments but found 0

        /// В таком виде, уже здесь будет ошибка
        ClassWithFinalNonNullMembers classWithFinalNonNullMembers = new ClassWithFinalNonNullMembers(null, null);
        /// Err: java.lang.NullPointerException: nonNullStringObject is marked non-null but is null..

        /// Final-значение можно проверить на null
        ///Assertions.assertNull(classWithFinalNonNullMembers.getFinalStringObject());

        /// Non-null значение в таком виде нет смысла проверять
        /// Assertions.assertNull(classWithFinalNonNullMembers.getNonNullStringObject());
        /// Message: assertNull always fails according its method contract

        /// сюда не дойдет т.к. свалится выше на этапе присвоения null-значения
        /// Assertions.assertEquals(null, classWithFinalNonNullMembers.getNonNullStringObject());
    }

    @Test
    void checkDataAnnot(){
        Bird bird = new Bird("Gray Pigeon");
    }
}
