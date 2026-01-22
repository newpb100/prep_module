package com.ams.train;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Step41Regexp {

    public static void main(String[] args) {

        /// 1. Проверка номера телефона, {NUM} - это строгое соответствие количества цифр
        System.out.println();
        System.out.println("##### 1 #####");
        String input = "+12343454552";
        boolean result = input.matches("(\\+*)\\d{11}");
        if (result) {
            System.out.println("It is a phone number");
        } else {
            System.out.println("It is NOT a phone number!");
        }


        /// 2. Проверка Matcher: find, group, start, end, appendReplacement, appendTail
        System.out.println();
        System.out.println("##### 2 #####");
        input = "Hello Java! Hello JavaScript! JavaSE 8.";
        Pattern pattern = Pattern.compile("Java\\w*");
        Matcher matcher = pattern.matcher(input);
        StringBuffer sb = new StringBuffer();

        /// Т.к. первое вхождение "Java" начинается с 6-го индекса, то  find от 0 до 6 даст для него true,
        /// начиная с 7го индекса, ,будет возвращаться start и end уже для 2-го вхождения
        if (matcher.find(6)) {
            System.out.println("find(6) = true;  start = " + matcher.start() + " ; end = " + matcher.end());
            // find(6) = true;  start = 6 ; end = 10
        }

        /// Т.к группы не были объявлены в шаблоне РВ, то 0-вая группа = ее отсутствие и означает весь поисковый шаблон
        System.out.println();
        System.out.println(matcher.start(0));
        // 6
        // System.out.println(matcher.start(1));
        // Err: Exception in thread "main" java.lang.IndexOutOfBoundsException: No group 1


        System.out.println();
        /// Сбрасываем сначала индекс поиска в исходное состояние, чтобы внутри while снова найти все вхождения Java в тексте
        matcher.reset();
        while (matcher.find()) {
            String repl = matcher.group();
            System.out.println(repl + " ; start = " + matcher.start() + " ; end = " + matcher.end());
            matcher.appendReplacement(sb, "HTML");
        }
        System.out.println();

        matcher.appendTail(sb);

        System.out.println("Before            : " + input);
        System.out.println("After             : " + sb.toString());
        // Before: Hello Java! Hello JavaScript! JavaSE 8.
        // если НЕ использовать appendTail
        // After: Hello HTML! Hello HTML! HTML
        // если использовать appendTail
        // After: Hello HTML! Hello HTML! HTML 8.


        /// 3. Пример выше можно сделать проще через Replace ALL
        System.out.println();
        System.out.println("##### 3 #####");
        input = "Hello Java! Hello JavaScript! JavaSE 8.";
        pattern = Pattern.compile("Java\\w*");
        matcher = pattern.matcher(input);
        String newStr = matcher.replaceAll("HTML");

        System.out.println();
        System.out.println("Before ReplaceALL : " + input);
        System.out.println("After ReplaceALL  : " + newStr);


        /// 4. Replace First
        System.out.println();
        System.out.println("##### 4 #####");
        pattern = Pattern.compile("Java\\w*");
        matcher = pattern.matcher(input);
        newStr = matcher.replaceFirst("HTML");

        System.out.println();
        System.out.println("After replaceFirst: " + newStr);


        /// 5. Работа с группами и экранированием quoteReplacement()
        System.out.println();
        System.out.println("##### 5 #####");
        /// Как на уровне стринга пишется бэкслэш и как он выводится (хранится)
        String pat = "\\$";
        System.out.println(pat);
        //     \$
        /// Как меняет представление бэкслэша и доллара метод quoteReplacement()
        String escapedPat = Matcher.quoteReplacement(pat);
        System.out.println(escapedPat);
        //     \\\$ - проэкранировал отдельно бэкслэш и отдельно знак доллара

        /// Если целевая подстрока содержит знак доллара например, то в шаблоне РВ необходимо указать, что $ - это строковый литерал без к.-л. спец. значения
        input = "Hello $world, welcome to (Java) regex!";
        String searchTerm = "(\\$world)(,)";                                // Note the use of double backslash to escape $

        pattern = Pattern.compile(searchTerm);
        matcher = pattern.matcher(input);

        String replacement = "\\$99 $0 $1 $2";                              // Escape $ and refer to groups
        ///           Первый доллар, как знак валюты оставляем, остальные используем как спец. конструкции РВ
        ///           $0 - это подстрока полного совпадения с РВ (backreference to the entire match): $world,
        ///           $1 - первая группа: $world
        ///           $2 - вторая группа: ,
        /// Только первый доллар в matcher.replaceAll() будет интерпретироваться как символ, остальные будут обработаны со спец. смыслом движком РВ
        String res = matcher.replaceAll(replacement);

        System.out.println();
        System.out.println("Original: " + input);
        System.out.println("Replaced: " + res);
        // Original: Hello $world, welcome to (Java) regex!
        // Replaced: Hello $99 $world, $world , welcome to (Java) regex!

        /// После quoteReplacement() заэкранируются все $-ры , а также первый экранирующий бэкслэш также будет "нейтрализован" еще одним
        String escapedReplacement = Matcher.quoteReplacement(replacement);
        /// И теперь полученная последовательность в matcher.replaceAll() будет интерпретироваться как строка символов без доп. значений
        res = matcher.replaceAll(escapedReplacement);

        System.out.println();
        System.out.println("Original: " + input);
        System.out.println("Replaced: " + res);
        // Original: Hello $world, welcome to (Java) regex!
        // Replaced: Hello \$99 $0 $1 $2 welcome to (Java) regex!


        /// 6. Шаблоны РВ - границы слова
        System.out.println();
        System.out.println("##### 6 #####");
        String REGEX =
                "\\bdog\\b";
        String INPUT =
                "dog dog dog doggie dogg";

        Pattern p = Pattern.compile(REGEX);
        Matcher m = p.matcher(INPUT);

        int count = 0;
        while (m.find()) {
            count++;
            System.out.println("Match number " + count);
            System.out.println("start(): " + m.start() + " ; end(): "+ m.end());
        }

    }
}
