package com.ams.train.supply;

public class WideVarArgs {

    static public void methodWideVar( int i1, int i2 ) {
        System.out.println("Сработал метод по Расширению типа, передали short и short в параметры int и int");
    }

    static public void methodWideVar( Integer... i ) {
        System.out.println("Сработал метод по Упаковке типа, передали short и short в параметр Integer... i");
    }

    static public void methodWideVar( Integer i1, Integer i2) {
        System.out.println("Сработал метод с параметрами Integer i1, Integer i2, передали Integer и Integer");
    }
}
