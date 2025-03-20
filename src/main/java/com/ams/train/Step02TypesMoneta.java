package com.ams.train;

import org.javamoney.moneta.FastMoney;
import org.javamoney.moneta.Money;
import org.javamoney.moneta.format.CurrencyStyle;
import org.opentest4j.AssertionFailedError;

import javax.money.*;
import javax.money.convert.*;
import javax.money.format.AmountFormatQueryBuilder;
import javax.money.format.MonetaryAmountFormat;
import javax.money.format.MonetaryFormats;
import java.math.RoundingMode;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.*;

public class Step02TypesMoneta {

    // https://alta-systems.ru/java-best-practices/от-float-до-jsr-354-как-правильно-работать-с-дене/?ysclid=m2xj5wk7g7175639981
    public static void doStep02TypesMoneta() {

        CurrencyUnit ruble = Monetary.getCurrency("RUB");

        System.out.println("currencyCode:          " + ruble.getCurrencyCode());
        System.out.println("numericCode:           " + ruble.getNumericCode());
        System.out.println("defaultFractionDigits: " + ruble.getDefaultFractionDigits());
        // currencyCode:          RUB
        // numericCode:           643
        // defaultFractionDigits: 2

        // MonetaryAmount
        // MonetaryAmount – это числовое представление денежной величины.
        // Он всегда связан с CurrencyUnit и определяет денежное представление валюты.
        // Классы Money и FastMoney реализуют интерфейс MonetaryAmount.
        // Разница между ними в том, что они используют разные типы данных для числового представления денежных величин.
        // FastMoney использует long, а Money – BigDecimal.
        // Если нам важна производительность, то лучше воспользоваться классом FastMoney.

        // MonetaryAmount monetaryAmount = Monetary.getDefaultAmountFactory()
        //        .setCurrency(ruble).setNumber(100).create();
        // см. ниже как используется

        System.out.println();
        Money money = Money.of(50, ruble);
        FastMoney fastMoney = FastMoney.of(50, ruble);

        System.out.println("money:     " + money.toString());
        System.out.println("fastMoney: " + fastMoney.toString());
        // нояб. 03, 2024 1:38:02 AM org.javamoney.moneta.DefaultMonetaryContextFactory createMonetaryContextNonNullConfig
        // INFO: Using custom MathContext: precision=256, roundingMode=HALF_EVEN
        // money:     RUB 50
        // fastMoney: RUB 50


        // Сравнение одной и тойже денежной величина, созданной разными способами
        System.out.println();
        System.out.println("-- Сравнение одной и той же денежной величины, созданной разными способами -- ");
        MonetaryAmount oneDolar = Monetary.getDefaultAmountFactory()
                                          .setCurrency("USD").setNumber(1).create();
        Money oneUSDMoney = Money.of(1, "USD");
        FastMoney oneUSDFastMoney = FastMoney.of(1, "USD");

        // MonetaryAmount = Money
        assertTrue(oneDolar.equals(oneUSDMoney), "oneDolar.equals(oneUSDMoney)");
        System.out.println("oneDolar(MonetaryAmount) equals oneUSDMoney(Money)");
        System.out.println();

        // MonetaryAmount != FastMoney
        // Внимание! В таком виде можно распечатать в консоль ошибку, но поток выполнения не останавливается, а зависает
        try {
            assertTrue(oneDolar.equals(oneUSDFastMoney), "oneDolar(MonetaryAmount) NOT equals oneUSDFastMoney(FastMoney)");
        } catch (AssertionFailedError e){
            e.printStackTrace(System.out);
            // oneUSDMoney(Money) NOT equals oneUSDFastMoney(FastMoney) ==> expected: <true> but was: <false>
        }

        // Money != FastMoney
        try {
            assertTrue(oneUSDMoney.equals(oneUSDFastMoney), "oneUSDMoney(Money) NOT equals oneUSDFastMoney(FastMoney)");
        } catch (AssertionFailedError e){
            e.printStackTrace(System.out);
            // oneUSDMoney(Money) NOT equals oneUSDFastMoney(FastMoney) ==> expected: <true> but was: <false>
        }


        // Арифметика
        System.out.println();
        System.out.println("-- Арифметика --");
        Money money1 = Money.of(5.133, ruble);
        Money money2 = Money.of(10.611, ruble);
        Money money3 = Money.of(0.701, ruble);
        Money sumAmount = Money.of(0, ruble);

        sumAmount = sumAmount.add(money1).add(money2).add(money3);

        System.out.println("Общая сумма: " + sumAmount.toString());
        // Общая сумма: RUB 16.445

        System.out.println("-- Округление по дефолту (HALF_EVEN) --");
        System.out.println("Округленная сумма: " + sumAmount.with(Monetary.getDefaultRounding()));
        // Округленная сумма: RUB 16.44
        System.out.println("-- Округление по другому методу (HALF_UP) --");
        // но как изменить метод округления??? например на HALF_UP .. это оказалось ни разу не просто! не смог найти примера
        // например, приводится такой пример, но он уже нерабочий (поменял в нем usd на ruble)
        // MonetaryAmount amount = Money.of(10.99, ruble);
        // MonetaryAmount roundedUp = amount.with(Monetary.getRounding().up(2));          // roundedUp = $11.00
        // MonetaryAmount roundedDown = amount.with(Monetary.getRounding().down(2));      // roundedDown = $10.99
        // MonetaryAmount roundedHalfUp = amount.with(Monetary.getRounding().halfUp(2));  // roundedHalfUp = $11.00
            // java: no suitable method found for getRounding(no arguments)
            // method javax.money.Monetary.getRounding(javax.money.CurrencyUnit,java.lang.String...) is not applicable
            // (actual and formal argument lists differ in length)

        // через Яндекс нейро смог найти
        // запрос: Monetary get rounding example
        // на основе пример с
        // https://stackoverflow.com/questions/45501524/more-than-2-precision-rounding-with-formatted-using-monetary-api-java
        MonetaryAmount monetaryAmount = Monetary.getDefaultAmountFactory()
                .setCurrency(ruble).setNumber(16.445).create();
        monetaryAmount = monetaryAmount.with(
                Monetary.getRounding(RoundingQueryBuilder.of().set(RoundingMode.HALF_UP).setScale(2).build()));
        System.out.println("Округленная сумма: " + monetaryAmount.getNumber());
        // Округленная сумма: 16.45

        // Еще арифметический пример
        System.out.println("-- Еще арифметический пример --");
        MonetaryAmount[] monetaryAmounts = new MonetaryAmount[] {
                    Money.of(100, "CHF"),
                    Money.of(10.20, "CHF"),
                    Money.of(1.15, "CHF")
        };
        // странно все-таки, что создается массив именно MonetaryAmount, а не Money
        // приводится весьма пространное утверждение
        // "При сложении или вычитании сумм лучше использовать параметры, которые являются экземплярами MonetaryAmount,
        // так как для выполнения операций с суммами необходимо убедиться, что обе суммы выражены в одной валюте."
        // > И каким образом в примере ниже проводится это "убеждение" ? В конце в ассерте? Так, тоже самое можно и для Money
        // или FastMoney сделать, там строки тоже содержат валюту см. пример выше
        // money:     RUB 50
        // fastMoney: RUB 50

        Money sumAmtCHF = Money.of(0, "CHF");

        for (MonetaryAmount monetaryAmountIterator : monetaryAmounts) {
            sumAmtCHF = sumAmtCHF.add(monetaryAmountIterator);
        }

        assertEquals("CHF 111.35", sumAmtCHF.toString());


        // Конвертация валют
        System.out.println();
        System.out.println("-- Конвертация валют --");
        Money dollar = Money.of(1,"USD");

        CurrencyConversion conversionRuble = MonetaryConversions.getConversion(ruble);

        Money rublesForDollar = dollar.with(conversionRuble);

        System.out.println(dollar.getCurrency().getCurrencyCode() +           ": " + dollar.getNumber());
        System.out.println(rublesForDollar.getCurrency().getCurrencyCode()  + ": " + rublesForDollar.getNumber());
        // USD: 1
        // RUB: 97.048429
        // Проверяем через https://cbr.ru/currency_base/daily/
        // 97,5499

        // Форматирование денежных сумм
        // Позволяет получить доступ к форматам денежных единиц на основе региональных представлений с помощью java.util.Locale
        System.out.println();
        System.out.println("-- Форматирование валют --");
        MonetaryAmountFormat formatRu = MonetaryFormats.getAmountFormat(new Locale("ru"));
        String ruFormatted = formatRu.format(rublesForDollar);

        System.out.println("Начальное значение         : " + rublesForDollar.toString());
        System.out.println("Отформатированное значение : " + ruFormatted);
        // Начальное значение        : RUB 35.5
        // Отформатированное значение: 35,50 RUB

        // Формат можно кастомизировать
        MonetaryAmountFormat customFormat = MonetaryFormats.getAmountFormat(AmountFormatQueryBuilder.
                of(new Locale("ru")).set(CurrencyStyle.NAME).set("pattern", "00000.00 \u20BD").build());
        String customFormatted = customFormat.format(rublesForDollar);

        System.out.println("Кастомный формат значения  : " + customFormatted);

    }
}
