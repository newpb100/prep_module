package com.ams.train;

public class Step07CompareObjects {
        public int age;

        public boolean equals(Step07CompareObjects obj){
            return obj.age == this.age;
        }

        public static void main(String[] args){

            System.out.println("Inside main() of Compare2");

            Step07CompareObjects scObj1 = new Step07CompareObjects();
            scObj1.age = 41;

            Step07CompareObjects scObj2 = new Step07CompareObjects();
            scObj2.age = 41;

            System.out.println(scObj1 == scObj2 ? "objects are equal" : "objects are NOT equal");

            System.out.println(scObj1.equals(scObj2) ? "objects are equal" : "objects are still NOT equal");

        }
}
