package com.ams.train;

import com.ams.train.supply.Zoo;
import com.ams.train.supply.dto.PersonDTO;
import com.ams.train.supply.dto.PersonDTOWithType;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


public class Step43JacksonTypeInfoTest {

    @Test
    @DisplayName("Десериализация данных с преобразованием целочисленного типа по конкретному полю в Long")
    void givenJsonWithDifferentValueTypes_whenDeserialize_thenLongValue() throws JsonProcessingException {
        String json = "{\"person\": [{\"key\": \"name\", \"value\": \"John\"}, {\"key\": \"id\", \"value\": 25}]}";
        PersonDTO personDTO = readJsonWithCustomDeserializer(json);
        Assertions.assertEquals(String.class, personDTO.getPerson().get(0).getValue().getClass());
        Assertions.assertEquals(Long.class, personDTO.getPerson().get(1).getValue().getClass());
    }

    @Test
    @DisplayName("Десериализация данных с преобразованием всех целочисленных типов в Long")
    void givenJsonWithDifferentValueTypes_whenDeserializeWithLongForInts_thenLongValue() throws JsonProcessingException {
        String json = "{\"person\": [{\"key\": \"name\", \"value\": \"John\"}, {\"key\": \"id\", \"value\": 25}, {\"key\": \"id\", \"value\": 99999999}]}";
        PersonDTO personDTO = readJsonWithLongForInts(json);
        Assertions.assertEquals(String.class, personDTO.getPerson().get(0).getValue().getClass());
        Assertions.assertEquals(Long.class, personDTO.getPerson().get(1).getValue().getClass());
        Assertions.assertEquals(Long.class, personDTO.getPerson().get(2).getValue().getClass());
    }

    @Test
    @DisplayName("Десериализация данных, в которых тип указан вместе с данными. Используем тут JsonTypeInfo")
    void givenJsonWithDifferentValueTypes_whenDeserializeWithTypeInfo_thenSuccess() throws IOException {
        String json = "{\"person\": [{\"key\": \"name\", \"type\": \"string\", \"value\": \"John1\"}, {\"key\": \"id\", \"type\": \"long\", \"value\": 26}, {\"key\": \"age\", \"type\": \"int\", \"value\": 30}]}";
        PersonDTOWithType personDTO = readJsonWithValueType(json);

        /// Данные ассерты подтверждают, что типы данных из поля type были корректно считаны и преобразованы в Java-типы
        Assertions.assertEquals(String.class, personDTO.getPerson().get(0).getValue().getClass());
        Assertions.assertEquals(Long.class, personDTO.getPerson().get(1).getValue().getClass());
        Assertions.assertEquals(Integer.class, personDTO.getPerson().get(2).getValue().getClass());

        /// Сериализуем в строку
        ObjectMapper objectMapper = new ObjectMapper();
        String str = objectMapper.writeValueAsString(personDTO);
        System.out.println(str);
        /// {"person":[{"key":"name","type":"string","value":"John1"},{"key":"id","type":"long","value":26},{"key":"age","type":"int","value":30}]}

        /// или в файл
        File file = new File("target/person.json");
        objectMapper.writeValue(file, personDTO);
    }

    @Test
    @DisplayName("Включение данных о типе")
    public void testTypeInclude() throws JsonProcessingException {

        System.out.println("1. Когда аннотация установлена на уровне класса");
        /// 1. Когда аннотация установлена на уровне класса
        MyPojo2 myPojo = new MyPojo2();
        myPojo.mp1 = new MyPojo1();
        myPojo.mp2 = new MyPojo1();

        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(myPojo);

        System.out.println(json);
        ///
        /// {"type":"mpj2","mp1":{"strv":null},"mp2":{"strv":null}}


        /// 2. Когда аннотация установлена на уровне поля
        System.out.println();
        System.out.println("2. Когда аннотация установлена на уровне поля");
        MyPojo3 myPojo3 = new MyPojo3();
        myPojo3.myPojo_name = new MyPojo1();
        myPojo3.myPojo_class = new MyPojo1();
        json = objectMapper.writeValueAsString(myPojo3);

        System.out.println(json);
        /// {"myPojo_name":{"type":"mpj1","strv":null},"myPojo_class":{"@class":"com.ams.train.Step43JacksonTypeInfoTest$MyPojo1","strv":null},"strval":null}
    }

    @Test
    @DisplayName("Пример. Работа с полиморфными типами")
    public void workWithPolymorphicTypes() throws JsonProcessingException {

        Zoo.Dog dog = new Zoo.Dog("lacy");
        Zoo zoo = new Zoo(dog);

        /// Интересно то, что запись тут проходит успешно, несмотря на то, что нет аннотации @Getter ни у Zoo, ни у Dog, ни у Animal
        String result = new ObjectMapper()
                            .writeValueAsString(zoo);

        System.out.println("Serialize");
        System.out.println("Zoo = " + result);
        /// Zoo = {"animal":{"type":"dog-type","name":"lacy","barkVolume":0.0}}


        String jsonDog = "{\"animal\":{\"type\":\"dog-type\",\"name\":\"lacy\",\"barkVolume\":11.0}}";
        Zoo zoo1 = new ObjectMapper().readValue(jsonDog, Zoo.class);
        String result1 = new ObjectMapper()
                            .writeValueAsString(zoo1);

        Assertions.assertEquals(Zoo.Dog.class, zoo1.animal.getClass());

        System.out.println();
        System.out.println("Deserialize");
        System.out.println("Zoo = " + result1);
        /// Deserialize
        /// Zoo = {"animal":{"type":"dog-type","name":"lacy","barkVolume":10.0}}
    }

    @Test
    @DisplayName("Пример. Работа с полиморфными типами 2")
    public void workWithPolymorphicTypes2() throws IOException {
        /// На основе
        /// https://urvanov.ru/2016/09/20/jackson-десериализация-полиморфных-типов/

        String dogstr = new String(Files.readAllBytes(Paths.get("src/test/resources/dog.json")));
        /// {"animal":{"type":"dog-type","name":"mitchel","barkVolume":33.0}}

        ObjectMapper om = new ObjectMapper();

        Zoo zoo = om.readValue(new File("src/test/resources/dog.json"), Zoo.class);

        if ( zoo.animal instanceof Zoo.Dog){
            /// Обрати внимание на то, какой именно объект отправляется на Сериализацию/Десериализацию
            /// 1.
            /// String dogFromDeserialization = om.writeValueAsString(zoo.animal);
            /// {"type":"dog-type","name":"mitchel","barkVolume":33.0}

            /// 2
            String dogFromDeserialization = om.writeValueAsString(zoo);
            /// {"animal":{"type":"dog-type","name":"mitchel","barkVolume":33.0}}
            Assertions.assertEquals(dogstr, dogFromDeserialization);
            /// true
        }

    }



    private PersonDTOWithType readJsonWithValueType(String json) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        PersonDTOWithType personDTOWithType = mapper.readValue(json, PersonDTOWithType.class);
        return personDTOWithType;
    }

    private PersonDTO readJsonWithCustomDeserializer(String json) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        PersonDTO personDTO = mapper.readValue(json, PersonDTO.class);
        return personDTO;
    }

    PersonDTO readJsonWithLongForInts(String json) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(DeserializationFeature.USE_LONG_FOR_INTS);
        return mapper.readValue(json, PersonDTO.class);
    }

    @JsonTypeName("mpj1")                                                         // эта установка не влияет на исход
    public static class MyPojo1 {
        public String strv;
    }

    @JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
    @JsonSubTypes({
            @JsonSubTypes.Type(value = MyPojo2.class, name = "mpj2"),
            @JsonSubTypes.Type(value = MyPojo1.class, name = "mpj1")
    })
    public static class MyPojo2 {
        public MyPojo1 mp1;
        public MyPojo1 mp2;
    }


    public static class MyPojo3 {
        @JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
        @JsonSubTypes({
                @JsonSubTypes.Type(value = MyPojo1.class, name = "mpj1"),
                @JsonSubTypes.Type(value = String.class, name = "str"),
        })
        public MyPojo1 myPojo_name;

        @JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.PROPERTY, property = "@class")
        public MyPojo1 myPojo_class;

        @JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type1")
        @JsonSubTypes({
                @JsonSubTypes.Type(value = String.class, name = "str"),
        })
        private String strval;
    }



}
