package com.ams.train;

import com.ams.train.supply.CounterSingleton;
import com.ams.train.supply.SimpleProtocolsEnum;

import java.util.Arrays;
import java.util.stream.Stream;

public class Step35EnumAndLambdas {


    public static void main(String[] args) {


        // SimpleProtocolsEnum spe2 = new SimpleProtocolsEnum("SMB","Server Message Block");
        // несмотря на то, что конструктор объявлен с <none> модификатором - такой вызов фейлится
        // Enum types cannot be instantiated

        SimpleProtocolsEnum spe = SimpleProtocolsEnum.DHCP;

        // могут иметь публичные поля
        spe.pubField = "1111";

        System.out.println("spe.name() : " + spe.name());
        // spe.name() : DHCP

        // форматированные вывод через переопределенный метод toString()
        System.out.println(spe);
        // Proto: Dynamic Host Configuration Protocol ; Desc: Dynamic Host Configuration Protocol ; secure?: true

        Arrays.asList(SimpleProtocolsEnum.getSecureProtocols()).stream().forEach(System.out::println);
        // [Proto: Dynamic Host Configuration Protocol ; Desc: Dynamic Host Configuration Protocol ; secure?: true, Proto: Network File System ; Desc: Network File System ; secure?: true]

        Stream.of(SimpleProtocolsEnum.getSecureProtocols()).forEach(System.out::println);
        // [Proto: Dynamic Host Configuration Protocol ; Desc: Dynamic Host Configuration Protocol ; secure?: true, Proto: Network File System ; Desc: Network File System ; secure?: true]


        // Сравнение enums
        System.out.println();

        SimpleProtocolsEnum spe2 = SimpleProtocolsEnum.DHCP;
        SimpleProtocolsEnum spe3 = SimpleProtocolsEnum.NFS;

        if (spe == spe2) {
            System.out.println("spe == spe2                         - it is true");
        }
        if (spe == SimpleProtocolsEnum.DHCP) {
            System.out.println("spe == SimpleProtocolsEnum.DHCP     - it is true");
        }
        if (spe.equals(spe2)){
            System.out.println("spe.equals(spe2)                    - it is true");
        }
        if (! spe.equals(spe3)){
            System.out.println("spe.equals(spe3)                    - it is NOT true");
        }

        // Реализация паттерна Singleton на Enum
        System.out.println();
        System.out.println("Реализация паттерна Singleton на Enum");
        CounterSingleton cs = CounterSingleton.INSTANCE;
        cs.setValue(1);

        CounterSingleton cs2 = CounterSingleton.INSTANCE;
        cs2.setValue(2);

        System.out.println("Печать значений из cs и cs2");
        cs.printValue();
        cs2.printValue();
        // value = 2
        // value = 2
    }
}
