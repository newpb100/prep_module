package com.ams.train.oop1;

//public class CheckConstructor extends PrivateConstructor {
    // ошибка:  there is no parameterless constructor available in 'com.ams.train.oop1;'
    //       из-за наличия private-конструктора!

    // Причем, если будет еще один, допустим, public-конструктор, то от такого класса уже можно будет отнаследоваться без ошибок
    // public CheckConstructor(int a) {
    //     super(a);
    // }
//}

public class CheckConstructor{

        //PrivateConstructor a = new PrivateConstructor();
        //ошибка: PrivateConstructor() has private access..


       // Как происходят вызовы конструкторов из класса наследника, расположенного в другом пакете по отношению к целевому классу см. в
       // com/ams/train/oop2/CclassOop2.java
}
