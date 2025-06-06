package com.ams.train;

public class Step39ClassCastObjectAndPrimitive {

    public static void main(String[] args) {

        /// https://stackoverflow.com/questions/74169353/how-to-cast-an-object-to-a-primitive-value (Спрошено 2 года, 6 месяцев назад)
        String val = "true";

        if (getValue(Boolean.class, val) instanceof Boolean){
            System.out.println("returning Boolean value");
        }

        Boolean b1 = getValue(Boolean.class, val);
        boolean b2 = getValue(Boolean.class, val);                  // возвращаем Boolean и распаковываем в примитив

        //boolean b3 = getValue(boolean.class, val);                // err: Cannot cast java.lang.Boolean to boolean


        /// Пробуем метод без типа Т
        //boolean b3 = getValueTypeWithoutT(boolean.class, val);    // err: Cannot cast java.lang.Boolean to boolean

        /// Если передавать не примитив, а обертку, то все работает, каст внутри происходит без ошибок, возвращается Boolean и распаковывается в boolean
        boolean b3 = getValueTypeWithoutT(Boolean.class, val);      // Ок


        /// Внутри данного метода можем определить примитивный передан класс или Обертка, а вот вернуть получится только Boolean
        Boolean b4 = getValueGetSimpleName(boolean.class, val);
        Boolean b5 = getValueGetSimpleName(Boolean.class, val);


        /// Подход со StackOver: Попробуем метод с дженериком, передачей примитива и кастованием через cast()
        //boolean b6 = getValueAsStack(boolean.class, val);         // err: Cannot cast java.lang.Boolean to boolean

        /// Подход со StackOver: Там еще один предлагает через стрингу зайти
        /// его подход не скомпилировался т.к. он делал впрямую
        /// (T) this.value  , где   private final String value;
        ///
        /// я использовал
        /// (T) Boolean.valueOf(val);
        ///
        System.out.println();
        boolean b7 = getValueAsStack2(boolean.class, val);          // Ок
        boolean b8 = getValueAsStack2(Boolean.class, val);          // Ок

    }



    public static <T> T getValue(Class<T> type, String v){
        /// в дебаге, когда вызов идет
        /// getValue(Boolean.class, val);
        /// type: class java.lang.Boolean
        ///
        /// когда вызов идет
        /// getValue(boolean.class, val);
        /// type: boolean
        ///
        T a = (T) type.cast("true".equals(v));          // когда приходит boolean , тут ошибка
        ///
        /// не получится ее решить даже если переписать на
        // boolean bb = (boolean) type.cast("true".equals(v));
        // Boolean bb = (Boolean) type.cast("true".equals(v));
        // Object bb = (Object) type.cast("true".equals(v));
        /// казалось бы type внутри содержит boolean, но из-за того что мы приняли эту переменную как Class<T> type возникает какая-то хрень
        /// на этапе кастования

        return a;
    }

    public static Boolean getValueTypeWithoutT(Class type, String v){
        /// пробуем без типа Т, примем Object и отправим его в Boolean
        ///
        return (Boolean)type.cast("true".equals(v));            // Err: Cannot cast java.lang.Boolean to boolean
        /// а если сразу в boolean
        //return (boolean)type.cast("true".equals(v));          // Err: Cannot cast java.lang.Boolean to boolean

    }

    public static <T> T getValueGetSimpleName(Class<Boolean> type, String v){
        System.out.println();
        System.out.println("Inside method getBooleanValueGetSimpleName()");

        T a;
        Boolean bObj = true;                                      // Автоупаковка boolean в Boolean
        boolean bl = bObj;                                        // Автораспаковка Boolean в boolean

        /// Первая странность:
        /// вот тут так нельзя делать:
        // Class<T> clazz = boolean.class;                        // Err: Required Class<T>, provided Class<Boolean>
        /// при этом можно в метод c сигнатурой
        /// ..(Class<T> type, String v)
        /// пробрасывать вызовы
        /// ...(boolean.class, val)

        /// Вторая странность:
        /// Оказывается оба вызова возвращают переменную типа Class<Boolean>, нельзя вернуть переменную типа Class<boolean>
        Class<Boolean> clazz_prim = boolean.class;
        Class<Boolean> clazz_obj = Boolean.class;

        /// Но при этом!
        /// System.out.println(clazz_prim.getSimpleName());
        /// boolean
        ///
        /// Метод getSimpleName() класса java.lang.Class используется для получения простого (без информации о пакете) имени этого класса.
        /// Метод возвращает простое имя этого класса в виде строки. Если этот класс является анонимным, то метод возвращает пустую строку.
        ///

        /// а вот и корень проблемы
        /// вызываем снаружи
        /// getBooleanValue3(boolean.class, val);
        //
        //        boolean a1 = clazz_prim.cast(bl);                   // Err: Cannot cast java.lang.Boolean to boolean
        //        System.out.println("a1 = " + a1);

        /// Т.к. кастование булевого значения с помощью экземпляра clazz_prim вылетает с эксепшеном, то можно применить обходной маневр.
        /// Через getSimpleName() и сравнение.
        /// Таким образом внутри метода реально выделить из универсальной переменой типа Class - какой именно тип передали Boolean или boolean
        if (type.getSimpleName().equals("boolean")){
            boolean a2 = bl;
            System.out.println("boolean a2 = " + a2);

            /// а вот вернуть получится только Boolean
            return (T)((Boolean) a2);

        }else if (type.getSimpleName().equals("Boolean")){
            Boolean a2 = bl;
            System.out.println("Boolean a2 = " + a2);

            return (T) a2;
        }

        return null;
    }

    public static <T> T getValueAsStack(Class<T> type, String v){
        String V = "true";

        if (type == boolean.class){
            System.out.println();
            System.out.println("inside getValueAsStack , type == boolean.class");
            /// предлагаемый вариант на стеке, но он не компилится, там пишут:
            /// ...
            /// Вы можете сделать то же самое здесь: напишите 8 вложенных операторов if/elseif:
            ///
            /// if (type == boolean.class           /* or Boolean.TYPE - same thing */) {
            ///   return (T) "true".equals(value);
            /// }
            /// ...
            /// (в итоге) Код будет делать то, что вам нужно:
            ///
            /// boolean v = new Literal("true").getValue(boolean.class);
            ///
            //return (T) "true".equals(v);                        // Err: cannot cast boolean to T

            /// проблема в том, что через <T> вообще не получается вернуть примитив (код даже не компилируется)
            //return (T) true;                                    // Err: cannot cast boolean to T

            /// итого: не заводится ни через (Type), ни через cast()
            //return type.cast("true".equals(v));                 // Err: Cannot cast java.lang.Boolean to boolean (по сути базовый: getValue())

        }

        return type.cast("true".equals(v));
    }

    private static <T> T getValueAsStack2(Class<T> type, String val) {
        /// сейчас тут вставлен один и тот же код, но это для простоты
        /// по сути, в условиях if смогли определить какой именно тип нам передали
        /// это альтернативный подход методу getValueGetSimpleName()
        if (type == boolean.class) {
            System.out.println("inside getValueAsStack2() , type == boolean.class");
            T a = (T) Boolean.valueOf(val);
            return a;
        }else if (type == Boolean.class){
            System.out.println("inside getValueAsStack2() , type == Boolean.class");
            T a = (T) Boolean.valueOf(val);
            return a;
        }

        return  null;
    }

}
