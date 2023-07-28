package com.ams.train;

public class Step26BitOperations {

    public static void main(String[] args) {
        //Побитовые логические операции

        System.out.println();
        System.out.println("Bit operations");
        int ab1 = 0b0011;
        int ab2 = 0b0001;
        byte bb = 0b01111111; // максимальное положительное байт-число

        System.out.println(Integer.toBinaryString((ab1 | ab2))); //or
        //11
        System.out.println(Integer.toBinaryString((ab1 ^ ab2))); //xor
        //10
        System.out.println(Integer.toBinaryString((~ab1)));      //not
        //11111111 11111111 11111111 11111100
        System.out.println(Integer.toBinaryString((ab1 & ab2))); //and
        //1

        // Подитовые операции сдвиги влево, Беззнаковый сдвиг влево "<<"

        System.out.println(ab1 << 1); // x2 = 6
        System.out.println(ab1 << 7); // 3 x 128 = 384

        System.out.println("Сделаем из положительного отрицательное число");
        System.out.println(bb);                                 //127
        System.out.println(Integer.toBinaryString(bb));         //01111111  (0 не печатает)
        System.out.println(bb << 1);                            //254   тут результат автоматом привелся к int
        System.out.println(Integer.toBinaryString((bb << 1)));  //11111110    тут на самом деле распечатывается int
        System.out.println(((byte)(bb << 1)));                  //-2    заставим результат быть все еще byte
                                                                //возможно, сама операция сначал приводит bb к инту, а потом мы ее обрезаем приведением к byte - Так и есть!

                                                                //подтверждение того, что сдвиги оперируются интом
                                                                //https://www.examclouds.com/ru/java/java-core-russian/pobitovie-operacii
                                                                //Типы byte и short продвигаются к типу int при вычислении выражения.

        // отрицательные числа и Знаковый сдвиг вправо ">>"
        System.out.println("Сдвиг вправо для отрицательного числа -4");
        byte bbb = (byte)0b1111_1100;    //-4
        System.out.println(bbb >> 1);    //-2
                                         //1111_1111_1111_1100  - приводит сначала к int
                                         //1111_1111_1111_1110  - потом сдвигает, сохраняя знак, так как сдвиг Знаковый


        // отрицательные числа и сдвиг вправо для отрицательного числа
        System.out.println("Сдвиг вправо для положительного числа 4");
        bbb = (byte)0b0000_0100;         //4
        System.out.println(bbb >> 1);    //2    слева дополнение идет 0-м т.к. тут изначально число положительное

        // отрицательные числа и Беззнаковый сдвиг вправо ">>>" для отрицательного числа
        System.out.println("Сдвиг вправо >>> для отрицательного числа -4");
        bbb = (byte)0b11111100;                 //-4
        System.out.println(bbb >>> 1);          //2147483646  получается этот оператор сначала преобразует число к int потом сдвигает биты
        System.out.println(bbb >> 1);           //-2          привел сначала -4 к инту, не просто нулей докинул, а именно нулей со знаком, чтобы тоже было -4 и сделал сдвиг
        System.out.println((byte)(bbb >>> 1));  //-2          получается преобразование к byte работает уже после того, как он сделал преобразование к инт и на результат это никак не повлияло
                                                //            а в итоге хотелось бы получить : 0b0111 1110 = 126


        // сдвиг более на более чем разрядов в самом типе данных
        int i1 = 16;
        System.out.println();
        System.out.println("i1 >> 33");
        System.out.println(i1 >> 33);           //8
                                                // расчет по формуле 33 % 32 = 1, т.е. на 1 бит
                                                //https://javapd.blogspot.com/2008/05/24-7.html



        // XOR-шифрование
        int secret = 0b101011;
        int key = 0b011100;

        System.out.println();
        System.out.println("secret = " + secret);
        System.out.println("encrypted  = "  + (secret ^ key));
        System.out.println("decrypted = "  + ((secret ^ key) ^ key));
    }
}
