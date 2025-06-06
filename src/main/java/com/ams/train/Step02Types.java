package com.ams.train;

import com.ams.train.supply.WideBoxed;
import com.ams.train.supply.WideVarArgs;

import java.util.ArrayList;
import java.util.StringTokenizer;

import static com.ams.train.supply.WideVarArgs.methodWideVar;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;

public class Step02Types {


    public static void main(String[] args){

        // Примитивы long Long boolean Boolean. Из обертки в примитив
        // Автоупаковка и Автораспаковка
        // Преобразование объектных типов. Parent и Child. Операции cast() и (Type)
        // Вывод на консоль литералов с плавающей точкой, классический и научный
        // CHAR
        // Экранирование
        // Escape последовательности
        // String и CharSequence
        // CASTs
        // расширение типов
        // сужение типов
        // char и short
        // Неявное преобразование к INT
        // int to String
        // operations from left to right
        // operations from right to left for =
        // increment/decrement , postfix and prefix
        // combine += /=
        // logic , has lower priority as compare ops
        // доп: интересные операции


        // Примитивы long Long boolean Boolean. Из обертки в примитив и из примитива в обертку
        System.out.println();
        System.out.println("Примитивы long Long boolean Boolean. Из обертки в примитив и из примитива в обертку");

        // long к Long
        long lg_prim = -9223372036854L;
        Long boxl1_wrap = Long.valueOf(lg_prim);
        Long boxl2_wrap = lg_prim;                        // неявно вызывается valueOf
        System.out.println("из примитива в обертку; boxl1_wrap = " + boxl1_wrap + "; boxl2_wrap = " + boxl2_wrap);

        // Long к long
        Long box3_wrap = 1234567L;
        long lg3_prim = box3_wrap.longValue();
        long lg4_prim = box3_wrap;               // неявно вызывается longValue
        System.out.println("из обертки в примитив;  lg3_prim = " + lg3_prim + "; lg4_prim = " + lg4_prim);

        // а с другими типами?
        Integer int_wrap = 12;
        int int_prim = int_wrap;
        System.out.println("int_prim = int_wrap;    int_prim = " + int_prim);

        // преобразование Object к boolean
        Boolean bl_wrap = true;
        Object obj = bl_wrap;
        //boolean bl_prim = (Boolean) obj;      // можно кастануть как через Boolean
        boolean bl_prim = (boolean) obj;        // так и напрямую в примитивный тип!!
        System.out.println("cast Object to boolean through Boolean,          bl_prim = " + bl_prim);

        // более продвинутый пример с использованием instanceof
        obj = "true";
        if (obj instanceof Boolean){
            bl_prim = (Boolean) obj;
        }else{
            System.out.println("obj НЕ содержит ссылку на тип Boolean, преобразование не делаем");
        }

        boolean bl_prim2 = false;
        bl_prim2 = bl_wrap;  // неявно вызывается bl_wrap.booleanValue()
        System.out.println("из обертки в примитив;  bl_prim2 = bl_wrap;      bl_prim2 = " + bl_prim);


        // Автоупаковка и Автораспаковка
        System.out.println();
        System.out.println("Автоупаковка в арифмических вывражениях");
        Integer iOb1 = 100;
        Integer iOb2 = 100;
        System.out.println(iOb1 == iOb2);
        // true

        Integer iOb3 = new Integer(120);
        Integer iOb4 = new Integer(120);
        System.out.println(iOb3 == iOb4);
        // false

        Integer iOb5 = 200;
        Integer iOb6 = 200;
        System.out.println(iOb5 == iOb6);
        // false

        // Расширение типа и Автоупаковка
        System.out.println("- Расширение типа имеет более высокий приоритет, чем Упаковка типа");
        short shVal = 25;
        WideBoxed.methodWide(shVal);

        System.out.println("- Расширение типа также имеет более высокий приоритет, чем Упаковка типа для перечня параметров");
        short shVal1 = 25;
        short shVal2 = 35;
        WideVarArgs.methodWideVar( shVal1, shVal2 );
        /**
        *  Хорошее замечание:
         *  Если закомментить метод static void methodWideVar(int i1, int i2)
         *  выдаст ошибку (java.lang.Integer...) cannot be applied to (short, short).
         *
         *  и тут, скорее вего как, срабатывает ограничение на передачу массива
         *
         *  когда компилятор встречает вызов метода со списком параметров переменной длины, то он упаковывает эти элементы в массив.
         *  Т.е. на входе должен быть массив Integer[]. Мы подаем short[]. При этом для массивов
         * autoboxing не работает:
         *
        * */

        System.out.println("- Если передали Объекты, то приоритет имеет метод в сигнатуре которого прописаны именно эти типы объектов");
        Integer shVal1Obj = 25;
        Integer shVal2Obj = 35;
        WideVarArgs.methodWideVar( shVal1Obj, shVal2Obj );

        System.out.println("Используем распаковку для удаления элемента по индексу (ожидается int, закидываем Integer)");
        ArrayList<Integer> alInt = new ArrayList<>();
        alInt.add(1);
        alInt.add(2);
        alInt.add(3);
        alInt.remove(0);
        Integer intObj = 1;
        alInt.remove(intObj);
        System.out.println("alInt = " + alInt);
        // alInt = [2, 3]

        // Несмотря на то, что входной параметр объявлен как Object в метод можно передать примитив int
        int app = 1;
        castIntToObject(app);
        // Преобразование int к Object:1


        // Преобразование объектных типов. Parent и Child. Операции cast() и (Type)
        // см. в практике
        // com/ams/train/Step39ClassCast.java	(prep_module)

        System.out.println();
        System.out.println(Boolean.TYPE);
        String aa111 = "true";
        System.out.println(aa111.getClass());
        //<T> T = "true".equals(aaa);


        // Вывод на консоль литералов с плавающей точкой, классический и научный
        System.out.println();
        System.out.println("Вывод на консоль литералов с плавающей точкой, классический и научный");
        double a12 = 2.718281828459045;
        double d12 = 4.05E-13;
        System.out.println("Тип double в классическом виде: " + a12);
        System.out.println("Тип double в научном виде     : " + d12);


        // CHAR
        System.out.println();
        System.out.println("CHAR");
        char symb1 = 1078;      //по индексу символа (его код в 10-м выражении) в таблице Unicode
        char symb2 = 'ж';       //по значению
        char symb3 = '\u0436';  //через шестнадцатеричную форму Unicode (это всё ещё «ж»), для 1078 в 16-ричной системе это 0436
        // 1 line
        char symb4 = 1079, symb5 = 'з';
        char symb6 = (char) 1079;

        System.out.println("symb1       = " + symb1);  // ж
        System.out.println("symb2       = " + symb2);  // ж
        System.out.println("symb3       = " + symb3);  // ж
        System.out.println("symb4       = " + symb4);  // з
        System.out.println("++symb3     = " + (++symb3)); // так как char - это и целочисленный тип в том числе, то можно так писать  // з

        System.out.println("(char) 1079 = " + symb6);  // з

        // Экранирование
        System.out.println();
        System.out.println("Экранирование");
        char a_doublq = '\"';
        char b_doublq = '"';
        System.out.println(" a_doublq = " + a_doublq); // будет выведена 1 двойная кавычка
        System.out.println(" b_doublq = " + b_doublq); // будет выведена 1 двойная кавычка

        // Escape последовательности
        System.out.println();
        System.out.println("Escape последовательности");
        System.out.println("\t\t100\t\t200\t\t300");
        System.out.println("\t\t10\t\t22\t\t33");
        System.out.println("\t\t1000\t\t2200\t\t3300");
        System.out.println("Добро пожаловать в \nв систему уважаемый анон");
        System.out.println("Добро пожаловать в систему уважаемый \b\b\b\b\b\b\b\b\bанон");  // Добро пожаловать в систему уанон
        System.out.println("Добро пожаловать в систему \rуважаемый анон");                  // уважаемый анон
        System.out.println("Рекомендуется к прочтению 'Углубленный курс JAVA', \\youtube\\ ");
        // комбинированная кодировка
        System.out.println("\uD83D\uDD0A");
        System.out.println("\uD83E\uDD73");
        System.out.println("\uD83C\uDF81");
        System.out.println("Улыбок тебе дед Макар \u263A \u263B");  // Улыбок тебе дед Макар ☺ ☻

        // некоторые символы просто так не интерпертируются в строке, например 0x1F600, если написать \u1F600 ничего не получится
        // надо использовать конструкцию Character.toChars(0x1F600)
        // источник:         https://javarush.com/groups/posts/literaly-v-java
        // также есть пояснение:
        // Casting valid int code points to char will work for code points in the basic multilingual plane just due to how UTF-16
        // was defined.
        // To convert anything above U+FFFF you should use Character.toChars(int) to convert to UTF-16 code units.
        int smile = 0x1F600;                         // Здесь шестнадцатеричный код эмоджи
        StringBuilder sb = new StringBuilder();
        sb.append(Character.toChars(smile));         // Собираем в StringBuilder
        System.out.println("Улыбающееся лицо              : " + sb.toString());

        // из комментов, то же самое без StringBuilder, действительно на фиг его городить тут
        String asmile = new String(Character.toChars(0x1F600));
        System.out.println("Улыбающееся лицо через String : " + asmile);


        // CASTS
        // расширение типов
        long lmax = Long.MAX_VALUE;
        long lmin = Long.MIN_VALUE;
        float f = lmax;
        System.out.println("");
        System.out.println("Long.MAX_VALUE     = " + Long.MAX_VALUE);    //Long.MAX_VALUE     = 9223372036854775807
        System.out.println("float f = lmax ; f = " + lmax);              //float f = lmax ; f = 9223372036854775807
        f = lmin;
        System.out.println("Long.MIN_VALUE     = " + Long.MIN_VALUE);    //Long.MIN_VALUE     = -9223372036854775808
        System.out.println("float f = lmin ; f = " + lmin);              //float f = lmin ; f = -9223372036854775808

        int intA = Integer.MAX_VALUE;
        System.out.println();
        System.out.println("int intA;                         intA  = " + intA);       //2147483647
        System.out.println("int intA + 1 ;                  intA+1  = " + (intA + 1)); //-2147483648
        long longRes = intA + 1;
        System.out.println("long longRes = intA + 1;       longRes  = " + longRes);    //-2147483648  !!!
        long longRes1 = (long)intA + 1;
        System.out.println("long longRes = (long)intA + 1; longRes1 = " + longRes1);   //2147483648



        // сужение типов
        //#1
        long lmil = 1000000L;               //
        int lMilInt = (int)lmil;            // 00000000 00001111 01000010 01000000 = 1 000 000 dec
        short lMilShort = (short )lMilInt;  //                   01000010 01000000 = 16980 dec
        byte lMilByte = (byte) lMilInt;     //                            01000000 = 64 dec

        System.out.println();
        System.out.println("short lMilShort = (short )lMilInt ; lMilShort = " + lMilShort);
        System.out.println("byte lMilByte = (byte) lMilInt    ; lMilByte  = " + lMilByte);

        //#2
        byte b128 = (byte)128;
        System.out.println();
        System.out.println("byte b128 = (byte)128;                   b128 = " + b128);
        // результат -128
        // Обоснование
        // 128 - 127 (максимальное в диапазоне) = 1; - это остаток, который нужно "проматывать" с другого конца
        // идем с другого конца
        // -128 + 1 - 1 = -128  , -1 делаем, потому что за 127 сразу идет -128, которое надо учитывать

        //#3
        long l123 = 1298390390L;               //01001101 01100011 11011101 01110110 = 1298390390 dec
        short sh123 = (short) l123;            //                  11011101 01110110 = 56694 dec ; 56694 - 32767 = 23927; -32768 + 23927 -1 = -8842
        //                                                  -1 потому что

        System.out.println("short sh123 = (short) 1298390390L;      sh123 = " + sh123);

        // char и short
        // несмотря на то, что они оба по 2 байта, преобразование обязательно, так как char-беззнаковый
        short shr = 75;
        char sym = (char) shr;
        System.out.println();
        System.out.println("char sym = (char) shr;   sym = " + sym);

        char sym2 = (char)-1;
        System.out.println("char sym2 = (char)-1; sym2           = " + sym2);
        System.out.println("char sym2 = (char)-1; (short)sym2    = " + (short)sym2);
        System.out.println("((short)65535)                       = " + ((short)65535)); //-1        диапазон:-32768    32767
        System.out.println("((short)32768)                       = " + ((short)32768)); //-32768    диапазон:-32768    32767
        System.out.println("char sym2 = (char)-1; (int)sym2      = " + (int)sym2);      //65535     диапазон:0         65535

        // Неявное преобразование к INT
        byte a = 120;
        byte b = 120;
        // byte c = a + b;              // err! result is INT
        int c = a + b;
        byte c1 = (byte)(a + b);        // операция возможна только с явным кастом

        //byte c2 = a + 1;              // err! result is INT, потому что 1 - это беззнаковый литерал типа INT
        byte c2 = (byte)(a + 1);
        //byte c2 = (byte)a + 1;        // Внимание! каст более приоритетный чем арифметическая операция

        byte c3 = 1 + 1;                // загадка! как так?  !!!!!!!!!!!!!!!
        System.out.println();
        System.out.println("byte c3 = 1 + 1; c3 = " + c3);

        short d = 100;
        // short e = d + a;             // err! result is INT
        int e = d + a;
        short e1 = (short)(d + a);      // операция возможна только с явным кастом


        // int to String
        int aaa1 = 1;
        //String str15 = 15;            // err!
        //String str16 = aaa;           // err!
        //String str15 = (String)15;    // err! Cannot cast int to String
        String str15 = "" + 15;
        String str16 = String.valueOf(aaa1);


        // String to int
        int a1 = Integer.parseInt(str15);
        System.out.println();
        System.out.println("print a1 = " + a1);


        // operations from left to right
        int a2 = 5;
        String str5 = a2 + a2 + "" + a2;
        System.out.println("print str5 = " + str5);   // 105 !

        // operations from right to left for =
        a2 = 5;
        int a3 = 6;
        int a4 = 7;
        int a5 = a2 = a3 = a4;
        System.out.println("a5 = " + a5 + " a4 = " + a4 +" a3 = " + a3 +" a2 = " + a2);   // 7 7 7 7

        // increment/decrement , postfix and prefix
        int a6 = 10;
        int y = a6++;
        System.out.println("postfix y = " + y + " ; a6  = " + a6);  // 10 11
        y = ++a6;
        System.out.println("prefix y = " + y + " ; a6  = " + a6);   // 12 12
        int aaa = 5;
        int bbb = ++aaa + ++aaa;
        System.out.println("bbb = ++aaa + ++aaa; bbb =  " + bbb); //13

        // combine
        y += a6;
        System.out.println("combine add y = " + y);      // 12 + 12 = 24
        y /= a6;
        System.out.println("combine division y = " + y); // 24 / 12 = 2

        // logic , has lower priority as compare ops
        System.out.println(" && : " + ( 100 > 2 && 100 < 100 )); // false
        System.out.println(" || : " + ( 100 > 2 || 100 < 100 )); // true

        // доп: интересные операции
        boolean ad = true;
        int addd = 2;
        System.out.println("! ad      = " + !ad);            // false
        System.out.println("~ addd    = " + ~addd);          // 1111 1101 , в десятичной = -3, т.к. это простая инверсия числа
        System.out.println(">>>= addd = " + (addd >>>= 1));  // 1

    }

    public static void doNanAndInfinity() {
        //System.out.println(100/0);                // exception! by zero
        System.out.println(100.0/0.0);              //Infinity
        System.out.println(100f/0f);                //Infinity
        System.out.println(100d/0d);                //Infinity
        System.out.println((100d/0d + 1));          //Infinity
        System.out.println((100d/0d * 10));         //Infinity
        System.out.println(-100.0/0.0);             //-Infinity

        System.out.println(0.0/0.0);                //NaN
        System.out.println((0.0/0.0 + 10));         //NaN
        System.out.println((100d/0d + 0.0/0.0));    //Infinity + NaN = NaN
        double a  = 1.0/0.0;
        System.out.println("Infinity / Infinity = " + a/a);   // Infinity / Infinity = NaN

    }

    public static void doBooleanOperations() {

        String s = null;

        if (s != null && s.length() > 10){      // && - безопасная форма записи, так как выражение вычисляется ленивым методом
            System.out.println("s != null , second part of expr won't calcutate");
        }else{
            System.out.println("s = null, stop work");
        }

        //if (s != null & s.length() > 10){       // exception here
        //    System.out.println("s = null, stop work");
        //}
    }

    public static void doUnixPathToWindowsChars() {
        String path_in = "/var/user/programm/unit1/";

        char[] pathArr = path_in.toCharArray();

        for (int i = 0; i < pathArr.length; i++) {
            if (pathArr[i] == '/'){   // обрати внимание , что в случае с чарами сравнение идет не через equals , а в прямую
                pathArr[i] = '\\';
            }
        }

        String path_out = new String(pathArr);
        System.out.println();
        System.out.println("Преобразование unix пути " + path_in);
        System.out.println("в windows " + path_out);

    }

    public static void doUnixPathToWindowsSplitJoin() {
        String path_in = "/var/user/programm/unit1/";

        String[] pathArr = path_in.split("/");

        String path_out = String.join("\\", pathArr);
        /* \\var\\user\\programm\\unit1  -- теряется конечный бэкслеш
         *   и тут в комментах пришлось использовать экранирование бэкслеша потому что вылетает ошибка о_О
         *   java: illegal unicode escape
         *   а это происходит из-за комбинации символов <backslash>u  :))
         * */

        System.out.println();
        System.out.println("Разделение и сбор пути с помощью Split и Join : " + path_out);

    }

    public static void doUnixPathToWindowsReplace() {
        String path_in = "/var/user/programm/unit1/";

        String path_out = path_in.replace("/", "\\");

        System.out.println();
        System.out.println("Замена пути с помощью Replace : " + path_out);
    }

    public static void doStringOperations() {
        System.out.println();
        System.out.println("Лексикографическое сравнение : " + "abcde".compareTo("abcde"));                                     // = 0
        System.out.println("Лексикографическое сравнение : " + "abcde".compareTo("abcdf"));                                     // < 0
        System.out.println("Лексикографическое сравнение : " + "abcde".compareTo("abcda"));                                     // > 0
        System.out.println("Проверка пути : " + "/usr/bin/logstash/logs/access.log".startsWith("/usr"));                        //true
        System.out.println("Проверка пути : " + "/usr/bin/logstash/logs/access.log".endsWith("/usr"));                          //false
        System.out.println("Ищем второе вхождение log: " + "/usr/bin/logstash/logs/access.log".indexOf("log",15)); //18 , индекс считает от 0, 18 это номер буквы l в log

        System.out.println("Использование substring : " + "Использование substring : ".substring(0,4));                         //Испо - Как и во всех интервалах в Java, символ с номером endIndex в интервал не входит.
        System.out.println("Repeat       : " + "repeat".repeat(3));
        System.out.println("replaceFirst : " + "repeat".replaceFirst("e","X"));                                 //rXpeat
        System.out.println("replaceAll   : " + "repeat".replaceAll("e","X"));                                   //rXpXat
        System.out.println("regex more difficult: " + "repeat here is text".replaceFirst("(e)(.+)","X"));       //rX

        System.out.println("Example of using StringTokenizer");
        String greating = "Good news everyone!";
        var tokenizer = new StringTokenizer(greating, "ne");  //разделителем считается каждый символ строки, переданный второй строкой в конструктор
        while (tokenizer.hasMoreTokens()){
            System.out.println(tokenizer.nextToken());
        }
        //        Good
        //        ws
        //        v
        //        ryo
        //        !

        String s1 = String.format("Language = %s, MonthPeriod = %d, severity = %c", "java", 7, 'A');
        String s2 = String.format("Language = %2$s, MonthPeriod = %1$d, severity = %3$c", 1, "python", 'B');
        System.out.println("Course #1, details : " + s1);
        System.out.println("Course #2, details : " + s2);

        String aa = new String("Java lesson");
        String bb = new String("Java lesson");
        System.out.println("сравним ссылки aa и bb : " + (aa == bb));  // false

        String t1 = aa.intern();
        String t2 = bb.intern();
        System.out.println("сравним ссылки t1 и t2 : " + (t1 == t2));  // true


    }

    public static void castIntToObject(Object ob){
        System.out.println("Преобразование int к Object:" + ob);
    }


}
