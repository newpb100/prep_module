package com.ams.train.oop2;

import com.ams.train.oop1.Aclass;
import com.ams.train.oop1.Bclass;

public class CclassOop2 {

    public static void main(String[] args) {

        /**  ДОСТУП К ПОЛЯМ */

        /**
         *  Доступ к protected, none, private - полям класса другого пакета (Aclass) через класс-Наследник (BclassOop2) в этом пакете
         *
         * */
        //System.out.println("protected int field in Aclass through BclassOop2     = " + (new BclassOop2()).protected_field_Aclass);
        // Error: protected_field_Aclass    has protected access in com.ams.train.oop1.Aclass;

        //System.out.println("no_modifier_field int in Aclass through BclassOop2 = " + (new BclassOop2()).no_modifier_field_Aclass);
        // Error: no_modifier_field    is not public in 'com.ams.train.oop1.Aclass'. Cannot be accessed from outside package

        /**
         *  Доступ к protected, none, private - полям класса другого пакета (Aclass) через класс-Наследник (Bclass) того же пакета
         *
         * */
        //System.out.println("protected int field in Aclass through Bclass     = " + (new Bclass()).protected_field_Aclass);
        // Error: protected_field_Aclass    has protected access in com.ams.train.oop1.Aclass;

        // System.out.println("no_modifier_field int in Aclass through Bclass = " + (new Bclass()).no_modifier_field_Aclass);
        // Error: no_modifier_field    is not public in 'com.ams.train.oop1.Aclass'. Cannot be accessed from outside package

        /**
         *  Доступ к protected, none, private - полям класса другого пакета (Aclass) напрямую из этого пакета
         *
         * */
        //System.out.println();
        //System.out.println("protected int field in Aclass through Aclass   = " + (new Aclass()).protected_field_Aclass);
        // Error: protected_field_Aclass    has protected access in com.ams.train.oop1.Aclass;

        //System.out.println("no_modifier_field int in Aclass through Aclass = " + (new Aclass()).no_modifier_field_Aclass);
        // Error: no_modifier_field    is not public in 'com.ams.train.oop1.Aclass'. Cannot be accessed from outside package


        /**  ДОСТУП К МЕТОДАМ */


        /**
         *  Доступ к protected, none, private - методам класса другого пакета (Aclass) через класс-Наследник (BclassOop2) в этом пакете
         *
         * */
        //System.out.println("protected int field in Aclass through BclassOop2     = " + (new BclassOop2()).func_protected());
        // Error: func_protected()    has protected access in com.ams.train.oop1.Aclass;

        //System.out.println("no_modifier_field int in Aclass through BclassOop2 = " + (new BclassOop2()).func2_none());
        // Error: func2_none()    is not public in 'com.ams.train.oop1.Aclass'. Cannot be accessed from outside package

        /**
         *  Доступ к protected, none - методам класса другого пакета (Aclass) через класс-Наследник (Bclass) того же пакета
         *
         * */
        //System.out.println();
        //System.out.println("func_protected() in Aclass through Bclass        = " + (new Bclass()).func_protected());
        // Error: func_protected()    has protected access in com.ams.train.oop1.Aclass;

        //System.out.println("func2_none() in Aclass through Bclass            = " + (new Bclass()).func2_none());
        // Error: func2_none()    is not public in 'com.ams.train.oop1.Aclass'. Cannot be accessed from outside package

        /**
         *  Доступ к protected, none - методам класса другого пакета (Aclass) напрямую из этого пакета
         *
         * */
        //System.out.println();
        //System.out.println("func_protected() in Aclass through Bclass        = " + (new Aclass()).func_protected());
        // Error: func_protected()    has protected access in com.ams.train.oop1.Aclass;

        //System.out.println("func2_none() in Aclass through Bclass            = " + (new Aclass()).func2_none());
        // Error: func2_none()    is not public in 'com.ams.train.oop1.Aclass'. Cannot be accessed from outside package


        /**
         *  Доступ к public методу и полю класса другого пакета (Aclass) напрямую из этого пакета
         *
         * */
        System.out.println();
        System.out.println("fpublic_field_Aclass in Aclass through Aclass            = " + (new Aclass()).public_field_Aclass);

        //System.out.println("fpublic_field_Aclass in Aclass through Aclass            = " + (new Aclass(100)).public_field_Aclass);
        // err: Aclass(int) has protected access...

        /**
         *  Доступ к protected полю и методу  класса другого пакета (Aclass) через класс-наследник (BclassOop2) этого пакета,
         *  но через специальный метод внутри BclassOop2
         *
         * */
        System.out.println();
        (new BclassOop2()).workWithProtected();
        // Несмотря на то, что в BclassOop2() вызов super() закоменчен, он все равно вызывается неявно!
        // Причем, такой же результат будет, даже если в BclassOop2 не будет задано НИ одного конструктора вообще
        // inside <none> BclassOop2 конструктор
        // inside BclassOop2 class, print  protected_field_Aclass        = 111
        // inside BclassOop2 class, call   Aclass.func_protected()       = 111

        //(new BclassOop2(1000)).workWithProtected();
        // Тут, если супер вызывается с пробросом 1000, то:
        // inside protected BclassOop2 конструктор
        // inside BclassOop2 class, print  protected_field_Aclass        = 1000
        // inside BclassOop2 class, call   Aclass.func_protected()       = 1000
        //
        // а если супера нет, то опять неявно вызывается super() без аргументов
        // inside protected BclassOop2 конструктор
        // inside BclassOop2 class, print  protected_field_Aclass        = 111
        // inside BclassOop2 class, call   Aclass.func_protected()       = 111

    }
}
