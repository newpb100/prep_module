package com.ams.train.oop2;

import com.ams.train.oop1.Aclass;

public class BclassOop2 extends Aclass {

    int a;

    //    Несмотря на то, что в Aclass есть конструктор вызывать его тут мы не обязаны (!)
    //    https://ru.stackoverflow.com/questions/1004864/Зачем-добавлять-в-конструктор-дочернего-класса-super-если-компилятор-делает-э

    BclassOop2() {
        // super();  но, он все равно вызовется неявно!
        System.out.println("inside <none> BclassOop2 конструктор ");
    }
    protected BclassOop2(int a) {
        //this.a = a; // до 22,23 java так делать нельзя  : cannot reference before super-class called..
        super(a);     // необязательно, можно и не вызывать, будет тогда вызван просто super();
        System.out.println("inside protected BclassOop2 конструктор ");
    }

    void workWithProtected(){

        System.out.println("inside BclassOop2 class, print  protected_field_Aclass        = " + this.protected_field_Aclass);
        System.out.println("inside BclassOop2 class, call   Aclass.func_protected()       = " + this.func_protected());

        // this.no_modifier_field_Aclass
        // this.func2_none()
        // здесь нет доступ к дефолтовым полям и методам в целевом Aclass т.к. мы из другого пакета смотрим
    }
}
