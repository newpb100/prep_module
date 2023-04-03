package com.ams.train;

public class Step07Compare2 {
        public int age;

        public boolean equals(Step07Compare2 obj){
            return obj.age == this.age;
        }

        public static void main(String[] args){

            System.out.println("Inside main() of Compare2");

            Step07Compare2 scObj1 = new Step07Compare2();
            scObj1.age = 41;

            Step07Compare2 scObj2 = new Step07Compare2();
            scObj2.age = 41;

            System.out.println(scObj1 == scObj2 ? "objects are equal" : "objects are NOT equal");

            System.out.println(scObj1.equals(scObj2) ? "objects are equal" : "objects are still NOT equal");

        }
}
