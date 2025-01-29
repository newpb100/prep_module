package com.ams.train.oop1;

import java.io.FileNotFoundException;

public class StaticException {

    public static int field1;

    static {
        field1 = 3;

        if (field1 == 2) {
            throw new RuntimeException("this UNchecked-exception");
        }else if (field1 == 3) {
            // throw new Exception("this checked-exception");
            // так нельзя , пишет Unhandled exception

            try {
                // допустим у нас тут код/вызов метода, который пробрасывает наверх какое-то checked-исключение
                throw new FileNotFoundException();
            }catch (FileNotFoundException e){

                throw new RuntimeException(e);  // упаковываем его в RuntimeException и пробрасываем наверх, наверху будет ExceptionInInitializerError
            }
        }
    }


}
