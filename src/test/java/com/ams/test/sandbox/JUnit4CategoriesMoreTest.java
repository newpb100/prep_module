package com.ams.test.sandbox;

import com.ams.test.supply.markerinterfaceCatA;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class JUnit4CategoriesMoreTest {

    @Category(markerinterfaceCatA.class)
    @Test
    public void test4() {
        System.out.println("Runs when category A is selected.");
        assert true;
    }
}
