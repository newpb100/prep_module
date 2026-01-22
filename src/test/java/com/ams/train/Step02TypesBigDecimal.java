package com.ams.train;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.text.DecimalFormat;

import static org.junit.jupiter.api.Assertions.assertTrue;


public class Step02TypesBigDecimal {

    public static void doStep02TypesBigDecimal() {

        // BigDecimal
        System.out.println();
        System.out.println("BigDecimal");
        System.out.println();
        System.out.println("------------ BD as String --------------------------------");
        BigDecimal bdthirdValue = new BigDecimal("3445.5545");
        System.out.println("3445.5545 as String = " + bdthirdValue);
        // 3445.5545 as String = 3445.5545

        System.out.println("round it with MathContext.DECIMAL32");
        // A MathContext object with a precision setting matching the precision of the IEEE 754-2019 decimal32 format,
        // 7 digits, and a rounding mode of HALF_EVEN.
        // Если цифра слева ЧЕТНАЯ округление НЕ происходит
        System.out.println(new BigDecimal("3445.5545", MathContext.DECIMAL32));
        // 3445.554

        System.out.println();
        bdthirdValue = new BigDecimal("3445.5445");
        System.out.println("3445.5445 as String = " + bdthirdValue);
        // 3445.5445 as String = 3445.5445

        System.out.println();
        System.out.println("round it with MathContext.DECIMAL32");
        System.out.println(new BigDecimal("3445.5445", MathContext.DECIMAL32));
        // 3445.544
        // тут округление ПРОИСХОДИТ
        System.out.println("round 3445.5555 as String = " + new BigDecimal("3445.5555", MathContext.DECIMAL32));
        // round 3445.5555 as String = 3445.556

        System.out.println("------------ BD as String end  ---------------------------");

        System.out.println();
        System.out.println("------------ BD as valueOf --------------------------------");

        bdthirdValue = BigDecimal.valueOf(3445.5545);
        System.out.println("3445.5545 as valueOf = " + bdthirdValue);
        // 3445.5545 as valueOf = 3445.5545

        bdthirdValue = BigDecimal.valueOf(3445.5445);
        System.out.println("3445.5445 as valueOf = " + bdthirdValue);
        // 3445.5445 as valueOf = 3445.5445

        System.out.println("------------ BD as valueOf end ---------------------------");


        System.out.println();
        System.out.println("------------ BD as float ---------------------------------");
        System.out.println("-- Rounding with MathContext.DECIMAL32 ---");
        bdthirdValue = new BigDecimal(3445.5545);
        System.out.println("3445.5545 as float = " + bdthirdValue);
        // 3445.5545 as float = 3445.554500000000189174897968769073486328125
        // получается эта часть 500000000189174897968769073486328125 округляется до 6
        // ?? объяснение почему она округляется тут по правилу Ceil?
        // и так как слева в 7-й позиции стоит 4, то округление ПРОИСХОДИТ, результат 3445.555
        System.out.println("round 3445.5545 as float = " + new BigDecimal(3445.5545, MathContext.DECIMAL32));
        // round 3445.5545 as float = 3445.555

        System.out.println();
        bdthirdValue = new BigDecimal(3445.5445);
        System.out.println("3445.5445 as float = " + bdthirdValue);
        // 3445.5445 as float = 3445.54449999999997089616954326629638671875
        // эта часть 49999999997089616954326629638671875 округляется до 5
        // и так как слева в 7-й позиции стоит 4, то округления не происходит, результат 3445.544
        System.out.println("round 3445.5445 as float = " + new BigDecimal(3445.5445, MathContext.DECIMAL32));
        // round 3445.5445 as float = 3445.544

        System.out.println();
        System.out.println("-- Rounding with RoundingMode.HALF_EVEN ---");
        bdthirdValue = new BigDecimal(3445.5545);
        System.out.println("3445.5545 as float = " + bdthirdValue);
        // 3445.5545 as float = 3445.554500000000189174897968769073486328125
        System.out.println("round 3445.5545 as float = " + new BigDecimal(3445.5545).setScale(3, RoundingMode.HALF_EVEN));
        // round 3445.5545 as float = 3445.555

        bdthirdValue = new BigDecimal(3445.5445);
        System.out.println("3445.5445 as float = " + bdthirdValue);
        // 3445.5445 as float = 3445.54449999999997089616954326629638671875
        System.out.println("round 3445.5445 as float = " + new BigDecimal(3445.5445).setScale(3, RoundingMode.HALF_EVEN));
        // round 3445.5445 as float = 3445.544

        System.out.println();
        System.out.println("-- Rounding with RoundingMode.HALF_EVEN and transit value as float var.1 ---");
        float fvalue = 3445.5545f;
        bdthirdValue = new BigDecimal(fvalue);
        System.out.println("3445.5545f as float = " + bdthirdValue);
        // 3445.5545 as float = 3445.5545
        System.out.println("round 3445.5545f as transitted through variable = " + new BigDecimal(fvalue).setScale(3, RoundingMode.HALF_EVEN));
        // round 3445.5545f as transitted through variable = 3445.554

        System.out.println();
        System.out.println("-- Rounding with RoundingMode.HALF_EVEN and transit value as float var.2 ---");
        bdthirdValue = new BigDecimal(3445.5545f);
        System.out.println("3445.5545f as float = " + bdthirdValue);
        // 3445.5545f as float = 3445.554443359375
        System.out.println("round 3445.5545f as float directly = " + new BigDecimal(3445.5545f).setScale(3, RoundingMode.HALF_EVEN));
        // round 3445.5545f as float directly = 3445.554

        System.out.println();
        System.out.println("------------ BD as float end  ---------------------------");

        // Еще попытки решить проблему

/*        DecimalFormat decimalFormat = new DecimalFormat("####.###");
        String result = decimalFormat.format(3445.5545);
        System.out.println((result));
        // 3445,555

        decimalFormat = new DecimalFormat("####.###");
        result = decimalFormat.format(3445.5445);
        System.out.println((result));
        // 3445,544*/


        bdthirdValue = new BigDecimal(3445.5545);
        System.out.println(bdthirdValue);
        DecimalFormat decimalFormat = new DecimalFormat("####.###");
        System.out.println(decimalFormat.format(bdthirdValue.setScale(3, RoundingMode.HALF_EVEN)));
        // 3445.554


        decimalFormat = new DecimalFormat("####.###");
        String result = decimalFormat.format(3445.5545);
        System.out.println((result));
        // 3445,555
        double ddd1 = 3445.5545;
        decimalFormat = new DecimalFormat("####.###");
        result = decimalFormat.format(ddd1);
        System.out.println((result));
        // 3445,555

        ddd1 = 3445.5545;
        decimalFormat = new DecimalFormat("####.###");
        // Если предыдущее число чётное, округление производится:
        result = decimalFormat.format(ddd1);
        System.out.println(result);
        // 3445,555 - верно
        ddd1 = 3445.5545;


        // Пример использования, https://www.baeldung.com/java-bigdecimal-biginteger
        System.out.println();
        System.out.println("-- check calculateTotalAmount func --");
        System.out.println("calculateTotalAmount = " +
                calculateTotalAmount(
                    new BigDecimal("4.5"),        // все значения передает как строки.. это, конечно, легко
                    new BigDecimal("2.69"),
                    new BigDecimal("0.10"),
                    new BigDecimal("0.0725"))
        );

        // Еще примеры
        // https://sky.pro/wiki/java/big-decimal-v-java-otlichiya-metodov-set-scale-i-round/
        System.out.println();
        System.out.println("-- Использование точности и метода round() для округления --");
        MathContext mc = new MathContext(7, RoundingMode.HALF_UP);
        BigDecimal number = new BigDecimal("3445.5545");
        System.out.println("number.round(mc) = " + number.round(mc));
        // 3445.555, вопросов нет, передали стрингу, 7 знаков для Precision и если в 8-м стоит 5 то округляем вверх
        // такой подход, с отдельным заданием MathContext и применением метода round()
        // кстати, тоже не поможет по проблеме описанной выше с прямой передачей дабл значения, и методом HALF_EVEN
        // тоже будет 3445.555

        System.out.println("-- Использование масштаба для округления --");
        number = new BigDecimal("3445.5545");
        System.out.println("number.setScale(3) = " + number.setScale(3, RoundingMode.HALF_UP));
        // 3445.555, вопросов нет


        // Неожиданные ошибки
        // https://lemnik.wordpress.com/2011/03/25/bigdecimal-and-your-money/
        System.out.println( );
        BigDecimal value = new BigDecimal(1);
        // value = value.divide(new BigDecimal(3));
        // Exception in thread "main" java.lang.ArithmeticException: Non-terminating decimal expansion; no exact representable decimal result.
        //
        // Примитивные числовые типы просто проигнорируют это и представят 0,3* так, как смогут,
        // в то время как BigDecimal выдаст исключение ArithmeticException вместо того, чтобы пытаться представить повторяющееся число. В некоторых случаях получение ошибки будет желательным,
        // но я видел, как кто-то решал проблему с ArithmaticException следующим образом:
        //
        // try {
        //       return decimal1.divide(decimal2);
        // } catch(ArithmaticException ae) {
        //    return new BigDecimal(decimal1.doubleValue() / decimal2.doubleValue());
        // }
        // Да, ребята, к сожалению, я вполне серьёзно. Это ошибка, возникающая из-за сбоя в вычислениях,
        // когда они перестают выполняться, и кто-то добавляет «хак», чтобы просто «быстро заставить их работать,
        // а потом мы их исправим». Это настоящая катастрофа, но я вижу это слишком часто.
        //
        // Проблема этого примера в том
        // что тут попытка разделить BigDecimal на BigDecimal и получить результат с Неограниченной точностью
        // поэтому нужно всегда(?) ограничивать точность

        System.out.println("1 / 3 = " + (new BigDecimal(1, MathContext.DECIMAL32).divide
                                        (new BigDecimal(3, MathContext.DECIMAL32), MathContext.DECIMAL32))
                          );

    }

    public static BigDecimal calculateTotalAmount(BigDecimal quantity,
                                                  BigDecimal unitPrice, BigDecimal discountRate, BigDecimal taxRate) {
        BigDecimal amount = quantity.multiply(unitPrice);
        // 4.5 * 2.69 = 12,105

        BigDecimal discountedAmount = amount.multiply(BigDecimal.ONE.subtract(discountRate));
        // вот это интересная конструкция, с помощью нее он вычисляет скидку и вычитает скидку из исходного amount
        //
        // discountedAmount = 12,105 - (12,105 * 0.10) = 12,105 - 1,2105 = 10,8945

        BigDecimal total = discountedAmount.multiply(BigDecimal.ONE.add(taxRate));
        // вот это интересная конструкция, с помощью нее он вычисляет размер налога и прибавляет его к исходному discountedAmount
        //
        // total = 10,8945 + (10,8945 * 0.0725) = 10,8945 + 0,78985125 = 11,68435125

        // round to 2 decimal places using HALF_EVEN
        return total.setScale(2, RoundingMode.HALF_EVEN);
        // 11,68
        // не очень показательно, показательно было бы если бы получалось 11,68535125 !
    }


}
