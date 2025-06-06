package com.ams.train;

import com.ams.train.supply.Child;
import com.ams.train.supply.Parent;

public class Step39ClassCast {

    public static void main(String[] args) {

        ///    на основе
        ///    https://codegym.cc/groups/posts/java-class-cast-method     (плохо)

        Parent prn = new Parent();
        Child chl = new Child();
        Object a = chl;

        System.out.println(a.getClass());
        /**
         *  Метод getClass() в Java позволяет получить класс объекта во время выполнения программы.
         *  Он является частью механизма Reflection API и возвращает объект типа Class, который привязан к экземпляру, для которого вызван метод.
         * */
        ///      class com.ams.train.supply.Child

        ///      через a. нет доступа ни к методу doPrintInChild(), ни к doPrintInParent()

        /// Попытаемся скастить ссылку на Child к типам Parent/Object и посмотреть, что вернет getClass() и к каким методом будет доступ
        Object b = Parent.class.cast(chl);     // redundant call to cast
        System.out.println(b.getClass());
        ///      class com.ams.train.supply.Child

        ///      через b. нет доступа ни к методу doPrintInChild(), ни к doPrintInParent()


         Object c = (Parent)chl;
         System.out.println(c.getClass());
        ///      class com.ams.train.supply.Child

        ///      через c. нет доступа ни к методу doPrintInChild(), ни к doPrintInParent()


        Parent pp = Parent.class.cast(chl);
        System.out.println(pp.getClass());
        ///      class com.ams.train.supply.Child

        ///      теперь через pp. есть доступ к pp.doPrintInParent();


        ///  Без всяких кастов ссылку на объект можно присваивать только РОДИТЕЛЬСКИМ классам (неявное преобразование ссылки Вверх или Апкастинг), если в обратную сторону,
        ///  то возможны баги см. ниже
        a = chl;
        a = prn;
        prn = chl;
        if (a instanceof Child){
            System.out.println("a is instance of Child");
        }else if (a instanceof Parent){
            System.out.println("a is instance of Parent");
        }

        /// prn = a;        Err: Required Parent provided Object
        /// chl = prn;      Err: Required Child provided Parent

        /// Понижение (Даункастинг) типов с присваиванием не работает
        /// chl = (Child) a;                 // Err: class com.ams.train.supply.Parent cannot be cast to class com.ams.train.supply.Child
        /// chl = ((Child) a);               // Err: class com.ams.train.supply.Parent cannot be cast to class com.ams.train.supply.Child
        /// chl = Child.class.cast(a);       // аналогично

        /// chl = Child.class.cast(prn);     // Err: Cannot cast com.ams.train.supply.Parent to com.ams.train.supply.Child
        /// chl = (Child) prn;               // Err: Cannot cast com.ams.train.supply.Parent to com.ams.train.supply.Child


        /// Но работает:
        System.out.println("Эти конструкции для понижения типа работают:");
        ((Child) prn).doPrintInChild();
        /// или
        var chlVar = (Child) prn;
        chlVar.doPrintInChild();

        a = prn;

        /// через обжектовую ссылку тоже работает!
        ((Child) a).doPrintInChild();
        var chlVar2 = (Child) a;
        chlVar2.doPrintInChild();


        /// https://www.geeksforgeeks.org/class-cast-method-in-java-with-examples/
        Class<?> myClass = null;
        try {
            myClass = Class.forName("com.ams.train.supply.Parent");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        Object a1 = myClass.cast(chl);
        // a1 = chl;                    можно и так написать

        System.out.println();
        System.out.println(a1.getClass());
        // class com.ams.train.supply.Child             Почему Child ???
    }

}
