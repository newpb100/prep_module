package com.ams.train.supply;

public class WideBoxed {
    static public void methodWide( int i ) {
        System.out.println("Сработал метод по Расширению типа, передали short в параметр int");
    }

    static public void methodWide( Integer i ) {
        System.out.println("Сработал метод по Упаковке типа, передали short в параметр Integer");
    }
}
