package com.ams.test.sandbox;

import com.ams.test.supply.markerinterfaceCatA;
import com.ams.test.supply.markerinterfaceCatB;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class JUnit4CategoriesTest {

    //@Ignore("Fix it")
    @Test
    public void test_categoryNone() {
        System.out.println("Test without any category");
    }

    @Category(markerinterfaceCatA.class)
    @Test
    public void test1() {
        System.out.println("Runs when category A is selected.");
        assert(true);
    }

    @Category(markerinterfaceCatB.class)
    @Test
    public void test2() {
        System.out.println("Runs when category B is included.");
        assert false;
    }

    @Category({markerinterfaceCatA.class, markerinterfaceCatB.class})
    @Test
    public void test3() {
        System.out.println("Runs when either of category is included. (Любая из категорий включена, НО! при условии, что для второй нет инструкции Excluded)");
        assert true;
    }
}
