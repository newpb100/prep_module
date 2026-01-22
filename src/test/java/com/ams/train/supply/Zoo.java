package com.ams.train.supply;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor                                                         // здесь важно т.к есть  Zoo zoo = new Zoo(dog);
public class Zoo {

    public Animal animal;

    @NoArgsConstructor
    @AllArgsConstructor                                                     // здесь важно т.к есть  super(name); у собаки
    @JsonTypeInfo(
            use = JsonTypeInfo.Id.NAME,
            include = JsonTypeInfo.As.PROPERTY,
            property = "type")
    @JsonSubTypes({
            @JsonSubTypes.Type(value = Dog.class, name = "dog-type"),
            @JsonSubTypes.Type(value = Cat.class, name = "cat-type")
    })
    public static class Animal {
        public String name;
    }

    /// Очень важно @NoArgsConstructor, без него будет
    /// com.fasterxml.jackson.databind.exc.MismatchedInputException: Cannot construct instance of `com.ams.train.supply.Zoo$Dog` (although at least one Creator exists):...
    @NoArgsConstructor
    // @AllArgsConstructor                                                   // странно, но здесь и без него корректно инициируются и name и barkVolume
    //@JsonTypeName("dog-type")                                              // бесполезно, что есть, что нет - работает корректно
    public static class Dog extends Animal {
        public double barkVolume;

        public Dog(String name){
            super(name);
        }
     }

    @NoArgsConstructor
    public static class Cat extends Animal {
        boolean likesCream;
        public int lives;
    }
}
