package com.ams.test.sandbox;

import org.junit.experimental.theories.DataPoint;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

@RunWith(Theories.class)
public class JUnit4TheoriesTests {

    @DataPoint
    public static String java = "Java";
    @DataPoint
    public static String node = "node";
    @DataPoint
    public static String python = "python";

//    @DataPoints
//    public static String[] oss = new String[] {"Linux", "macOS", "Windows"};


//   Запуски выдают одинаковые результаты независимо от того, заданы ли датапоинты отдельно или в виде массива


//    @Theory
//    public void test_theory(String a) {
//        System.out.println(a);
//    }
//    //Java
//    //node
//    //python


//    @Theory
//    public void test_theory_combos(String a, String b) {
//        System.out.println(a + " - " + b);
//    }
//    //.. 9 комбинаций (т.е. 3 объявленных датапоинта комбинируются по 2)


    @Theory
    public void test_theory_combos(String a, String b, String c) {
        System.out.println(a + " - " + b + " - " + c);
    }
    //..27 комбинаций  (т.е. 3 объявленных датапоинта комбинируются по 3)


//    @Theory
//    public void test_theory_one(String a, String b) {
//        System.out.println(a + " - " + b);
//    }
//    //.. 9 комбинаций (т.е. 3 значения комбинируем по 2)

}
