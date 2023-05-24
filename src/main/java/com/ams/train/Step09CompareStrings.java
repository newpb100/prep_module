package com.ams.train;

import java.util.Scanner;

public class Step09CompareStrings {
    public static void main(String[] args) {

        // 3. Compare of Strings (links)
        String txt = "gdsagdfsgdsfgfsdg";
        String txt1 = txt;
        String txt2 = txt.toUpperCase(); // gen new string object

        if (txt == txt1){
            System.out.println("String links are equal");
        }
        if (txt != txt2){
            System.out.println("String links for txt and txt.toUpperCase() are NOT equal");
        }
        // if (txt >= txt2){        not compile
        // if (txt <= txt2){        not compile

        // 4. Compare of Strings (by content)
        String inputStr = "Привет работникам ИТ";
        //var sc1 = new Scanner(System.in);
        var sc1 = new Scanner(inputStr);
        String str = sc1.nextLine();

        inputStr = "привет работникам ит";
        var sc2 = new Scanner(inputStr);
        String str2 = sc2.nextLine();

        if (str.equals(str2)){
            System.out.println("str and str2 are equal by content");
        }else if (str.equalsIgnoreCase(str2)){
            System.out.println("str and str2 are equal by content IGNORE CASE");
        }
        // by ternar
        System.out.println(str.equalsIgnoreCase(str2) ? "str and str2 are equal by content IGNORE CASE" : "not equal");

        // 5. Important moment
        String str5  = "новая строка";
        String str6 = "новая строка";
        System.out.println(str5 == str6 ? "внезапно указатели равны" : "не равны");   // равны, компилятор это понял еще на этапе компиляции

        // 5.1. Compare with expression
        String s12 = "abc 2.0";
        String s13 = "abc " + Math.sqrt(4.0);

        if (s12 == s13){
            System.out.println("abc 2.0 == abc + Math.sqrt(4.0)");
        } else{
            System.out.println("abc 2.0 != abc + Math.sqrt(4.0)"); // <- потому что на этапе компиляции компилятор не вычисляет выражение
        }

        // 5.2.
        String str7 = new String("новая строка");
        String str8 = new String("новая строка");
        String str9 = new String(str5);
        System.out.println(str5 == str7 ? "str5 == str7 : равны" : "str5 == str7 : НЕ равны");
        // НЕ равны
        System.out.println(str7 == str8 ? "str7 == str8 : равны" : "str7 == str8 : НЕ равны");
        // НЕ равны
        System.out.println(str8 == str9 ? "str8 == str9 : равны" : "str8 == str9 : НЕ равны");
        // НЕ равны

        // 6. Compare with intern
        String some = "Просто строка something of текста ";
        String some2 = new String("Просто строка something of текста ");

        System.out.println(some == some2 ? "some == some2 : равны" : "some == some2 : НЕ равны");
        System.out.println(some == some2.intern() ? "some == some2.intern() : равны" : "some == some2.intern() : НЕ равны");

        // 7. Repeat string
        System.out.println("This is repeatable string".repeat(5));

    }
}
