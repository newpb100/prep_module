package com.ams.train.oop1;

public class Cclass {

    public static void main(String[] args){

        /**
         *  Доступ к protected, none, private - полям класса из класса-Наследника (Bclass)    этого же пакета    напрямую к полям
         *
         * */
        System.out.println("protected int field in Aclass through Bclass  = " + (new Bclass()).protected_field_Aclass);
        // 111
        System.out.println("no_modifier_field int in Aclass through Bclass = " + (new Bclass()).no_modifier_field_Aclass);
        // 222
        // System.out.println("private_field int in Aclass = " + (new Bclass()).private_field_Aclass);
        // Error: 'private_field_Aclass' has private access in 'com.ams.train.oop1.Aclass'..

        /**
         *  Доступ к protected, none, private - полям класса этого же пакета (Aclass)     напрямую к полям
         *
         * */
        System.out.println();
        System.out.println("protected int field in Aclass through Aclass   = " + (new Aclass()).protected_field_Aclass);

        System.out.println("no_modifier_field int in Aclass through Aclass = " + (new Aclass()).no_modifier_field_Aclass);

        //System.out.println("private_field_Aclass int in Aclass directly = " + (new Aclass()).private_field_Aclass);
        // Error:

        /**
         *  Доступ к protected, none - методам класса из класса-Наследника (Bclass)   этого же пакета
         *
         * */
        System.out.println();
        System.out.println("func_protected() in Aclass through Bclass        = " + (new Bclass()).func_protected());
        // 111
        System.out.println("func2_none() in Aclass through Bclass            = " + (new Bclass()).func2_none());
        // 222

        /**
         *  Доступ к protected, none - методам класса этого же пакета (Aclass)
         *
         * */
        System.out.println();
        System.out.println("func_protected() method in Aclass through Aclass  = " + (new Aclass()).func_protected());
        // 111
        System.out.println("func2_none() method in Aclass through Aclass      = " + (new Aclass()).func2_none());
        // 222
    }
}
