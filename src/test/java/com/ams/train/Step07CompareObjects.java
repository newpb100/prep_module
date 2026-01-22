package com.ams.train;

public class Step07CompareObjects {
        public int age;
        public String name;

        public static void main(String[] args){

            System.out.println("Inside main() of Compare2");

            Step07CompareObjects scObj1 = new Step07CompareObjects();
            scObj1.age = 41;
            scObj1.name = "Stepan";

            Step07CompareObjects scObj2 = new Step07CompareObjects();
            scObj2.age = 41;
            scObj2.name = "Stepan";

            System.out.println(scObj1 == scObj2 ? "objects are equal" : "objects are NOT equal");

            System.out.println(scObj1.equals(scObj2) ? "objects are equal" : "objects are NOT equal");
            //in equals 1
            //objects are equal

            Object scObj3 = new Step07CompareObjects();
            ((Step07CompareObjects) scObj3).age = 42;

            System.out.println(scObj1.equals(scObj3) ? "objects are equal" : "objects are NOT equal");
            //in equals 2
            //objects are NOT equal

        }

        /// Переписываем метод для сравнения
        public boolean equals(Step07CompareObjects obj1){
            System.out.println("in equals 1");
            return (obj1.age == this.age)&&(obj1.name.equals(this.name));
        }

        /// Продвинутый вариант для сравнения
        public boolean equals(Object o){
            System.out.println("in equals 2");

            if (this == o) return true;

            if ((o == null) || (o.getClass() != this.getClass())) return false;

            Step07CompareObjects step07CompareObjects = (Step07CompareObjects) o;

            if (step07CompareObjects.age != this.age) return false;

            /// Тут тернарная операция, по приоритету читается также как и написано - слева направо
            return name != null ? name.equals(step07CompareObjects.name) : step07CompareObjects.name == null;
        }

}
