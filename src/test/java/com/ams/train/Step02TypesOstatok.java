package com.ams.train;

import java.math.BigDecimal;
import java.math.BigInteger;

public class Step02TypesOstatok {

    public static void doStep02TypesOstatok() {

        // % операция
        System.out.println();
        System.out.println("Остаток от деления, % операция");

        System.out.println("остаток через 10 % 4 = " + (10 % 4));
        System.out.println("остаток через BigInteger.reminder() = " + (new BigInteger("10").remainder(new BigInteger("4"))));
        // 2  , вопросов нет

        System.out.println("остаток через 7.6 % 2.9 = " + (7.6 % 2.9));
        System.out.println("остаток через BigDecimal.reminder() = " + (new BigDecimal("7.6").remainder(new BigDecimal("2.9"))));
        // 1.8  , вопросов нет


        // "Если хотя бы одно из a или b отрицательно, базовое (математическое) определение не работает, и языки программирования различаются в том, как определяются эти значения.
        System.out.println();
        System.out.println("остаток через -10 % 4 = " + (-10 % 4));
        // -2
        System.out.println("при этом частное равное = " + ((-10) / 4));
        // -2
        System.out.println("остаток через BigInteger.reminder() = " + (new BigInteger(String.valueOf("-10")).remainder(new BigInteger("4"))));
        // -2

        System.out.println();
        System.out.println("остаток через 10 % -4 = " + (10 % (-4)));
        // 2
        System.out.println("при этом частное равное = " + (10 / (-4)));
        // -2
        System.out.println("остаток через BigInteger.reminder() = " + (new BigInteger(String.valueOf("10")).remainder(new BigInteger("-4"))));
        // -2


        // В википедии, https://ru.wikipedia.org/wiki/Деление_с_остатком:
        // Приводится формула: a = b * q + r ;  a - делимое, b - делитель
        // результатами деления с остатком являются два целых числа: q - называется неполным частным от деления,
        // r — остатком от деления. На остаток налагается дополнительное условие:
        // 0 <= r < |b|
        // то есть остаток от деления должен быть неотрицательным числом и по абсолютной величине меньше делителя.

        // То есть как только или делимое или делитель имеют знак базовое определение НЕ работает, каждый язык там по своему

        // https://en.wikipedia.org/wiki/Modulo
        // В теории чисел всегда выбирается положительный остаток, но в программировании выбор зависит от языка и знаков a или b.
        // Например, в стандартных Pascal и ALGOL 68 положительный остаток (или 0) получается даже при отрицательных делителях, а в некоторых языках программирования,
        // таких как C90, выбор зависит от реализации, если b или a отрицательные (подробнее см. таблицу в разделе § В языках программирования).

        // В джаве вычисление -10 % 4 = -2, видим знак запросто может быть в остатке, частное тоже имеет знак в зависимости от знак делимого или делителя
        // Джава реализует так называемое Усеченное деление (Truncated division) (есть еще Деление с округлением (Floored division), Евклидово деление (Euclidean division)):
        // q = trunc(a / b), когда дробная часть отбрасывается, то есть происходит усечение (округление) в меньшую сторону
        // и таким образом остаток будет иметь знак делителя, а частное может быть как положительным (если и делимое и делитель отрицательные)
        //
        // для Усеченного деления (Truncated division), r = a - b * trunc(a / b)
        // от меня: эта такая же же формула для остатка если проверять через "деление с остатком в столбик"
        // Примеры вычислений в джава:
        // -10 % 4 = -2, частное -2
        // Проверка: -2 = -10 - 4 * trunc( -10 / 4) = -10 - (4 * (-2)) = -10 + 8
        //
        // -10 % (-4) = -2, частное 2
        // Проверка: -2 = -10 - (-4) * trunc( -10 / -4) = -10 - (-4)*(2) = -10 + 8
        //
        // а вот в Руби, действует уже правило Floored division (в питоне тоже)
        // -10 % 4 = 2
        // Проверка, формула Floored division: r = -10 - 4 * [-10 / 4] = -10 - 4 * (-3) = -10 + 12 = 2 (где 10 / 4 = 2.5 )
        //
        // еще примеры:
        //  11 / -4 = -3, остаток -1    (где, 11 / 4 = 2.75)
        // -11 / 4  = -3, остаток 1
        //
        // из комментов к https://habr.com/ru/articles/421071/
        // При делении -13 на 4, например, T-деление (обычное для процессоров и стандартизованное в C) даёт частное -3 и остаток -1.
        // F-деление (например, операция "//" в Python3) даёт -4 и остаток 3.

        // Оператор remainder возвращает остаток от деления одного операнда на другой. Он всегда принимает знак ДЕЛИМОГО для Truncated division!
        // для Floored division - остаток всегда принимает знак ДЕЛИТЕЛЯ.
        // Внимание! Не путать с частным, частное подвержнего знаковым правилам: - на + = -, - на - = +


        // https://sky.pro/wiki/java/razlichiya-raboty-operatora-modulo-v-java-i-python/
        // Обратите внимание, что в Java оператор % возвращает остаток от деления, который может быть отрицательным.
        // Не стоит беспокоиться! В Java 8 появилась функция Math.floorMod(int x, int y), которая прекрасно решает эту проблему для отрицательных чисел.
        // В Java оператор % выполняет операцию вычисления остатка от деления, а не классического (математического) модуля.
        // от меня: то есть можно сказать так, когда говорим "вычисление остатка от деления", имеем в виду, что он может быть ОТРИЦАТЕЛЬНЫМ
        //          когда, говорим "ПО МОДУЛЮ" - то это мат. термин, надо иметь ввиду, что он должен быть всегда ПОЛОЖИТЕЛЬНЫМ
        //          в англ. терминологии также есть различие для % - оператор Remainder, mod - оператор Modulo
        // Возвращаемый оператором остаток может быть отрицательным, в то время как модуль всегда положителен.
        // от меня: Они пишут тут про ВСЕГДА положителен, при это для  Math.floorMod(int -x, int -y) "модуль" МОЖЕТ БЫТЬ ОТРИЦАТЕЛЬНЫМ см. ниже пример

        System.out.println();
        System.out.println("остаток через -10 % -4 = " + (-10 % -4));
        // -2  , тут частное = 2, тогда остаток = -10 - (-8) = -2
        System.out.println("при этом частное равно = " + ((-10) / (-4)));
        // 2   , проверяем частное
        System.out.println("остаток через BigInteger.reminder() = " + (new BigInteger(String.valueOf("-10")).remainder(new BigInteger("-4"))));
        // -2
        //
        // для случая с Руби значения остатка в этом случае тоже будет -2
        // p -10 % -4 = -2


        // Для вычисления модуля предлагается использовать
        // кем предлагается ? скай про?
        System.out.println();
        System.out.println("(a % b) < 0 ? (a % b) + b = " + (-10 % 4 + 4));                     // откуда такая формула? притягивание в джаву Floored division?
        // 2
        System.out.println("int result = Math.floorMod(-10, 4) = " + Math.floorMod(-10, 4));    // это НЕ вычисление модуля, это взятие остатка по алгоритму Floored division в Java!
        // 2

        // Коррекция результата модуля связана с тем, что возможны разные определения этой операции в разных математических контекстах.
        // В теории чисел модуль предполагает неотрицательное значение в диапазоне [0, b), формируя структуру последовательностей.

        System.out.println();
        System.out.println("int result = Math.floorMod(-10, -4) = " + Math.floorMod(-10, -4));
        // -2
        // пожалуйста, отрицательный "модуль".. ну и где тогда "которая прекрасно решает эту проблему для отрицательных чисел"

        // https://en.wikipedia.org/wiki/Modulo#Notes
        // В таблице для Java приводится
        //   Operation        Integer values      Floating point          Definition
        //  	%	            Yes	                   Yes	                Truncated
        //  Math.floorMod	    Yes	                   No	                Floored
        //
        //  т.е. для Math.floorMod вычисление идет по Floored-алгоритму, а это означает
        //  r = a - b * [a / b]
        //  где [] - floor function (rounding down)
        //  Thus according to equation, the remainder has the same sign as the divisor n
        //  r = -10 - (-4) * ( (-10)/(-4) ) = -10 - (-4) (2) = -10 + 8 = -2

        // результат такой же как и для %
        // от меня: в этом случае они совпали, но с учетом того как работает floor результаты, конечно, могут и не совпасть
        // Math.floor(2.9);  // Возвращает 2
        // Math.floor(-2.9); // Возвращает -3
        // Math.trunc(2.9);  // Возвращает 2
        // Math.trunc(-2.9); // Возвращает -2

        // Вычисление по модулю через BigInteger
        System.out.println();
        System.out.println("Вычисление по модулю через BigInteger");

        System.out.println();
        BigInteger firstValue = new BigInteger("10");                                  // 10 / 4 = 2.5
        BigInteger secondValue = new BigInteger("-4");
        System.out.println("остаток через 10 % -4         = " + (10 % -4));
        System.out.println("остаток Math.floorMod(10, -4) = " + Math.floorMod(10, -4));
        System.out.println("10 remainder -4               = " + firstValue.remainder(secondValue));
        // System.out.println("10 mod -4 = " + firstValue.mod(secondValue));
        //   2
        // - 2
        //   2
        //   Exception in thread "main" java.lang.ArithmeticException: BigInteger: modulus not positive;
        //       предполагал, что может он тут попробует по евклидовой математике вычислить, но нет, похоже считает также как Math.floorMod(10, -4)

        System.out.println();
        firstValue = new BigInteger("-10");
        secondValue = new BigInteger("4");
        System.out.println("остаток через -10 % 4         = " + (-10 % 4));
        System.out.println("остаток Math.floorMod(-10, 4) = " + Math.floorMod(-10, 4));
        System.out.println("-10 remainder 4               = " + firstValue.remainder(secondValue));
        System.out.println("-10 mod 4                     = " + firstValue.mod(secondValue));
        // -2
        //  2
        // -2
        //  2

        System.out.println();
        firstValue = new BigInteger("-10");
        secondValue = new BigInteger("-4");
        System.out.println("остаток через -10 % -4         = " + (-10 % -4));
        System.out.println("остаток Math.floorMod(-10, -4) = " + Math.floorMod(-10, -4));
        System.out.println("-10 remainder -4               = " + firstValue.remainder(secondValue));
        //System.out.println("-10 mod -4                     = " + firstValue.mod(secondValue));
        // -2
        // -2
        // -2
        // Exception in thread "main" java.lang.ArithmeticException: BigInteger: modulus not positive;


    }
}
