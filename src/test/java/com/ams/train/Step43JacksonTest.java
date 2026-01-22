package com.ams.train;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class Step43JacksonTest {

    /// прихлопы, чтобы зарегать и начать использовать jackson-datatype-jsr310
    ObjectMapper objectMapper = new ObjectMapper().findAndRegisterModules();


   @Test
    void pojoToJsonString() throws JsonProcessingException {

        /// для записи в файл важно наличие геттеров у класса Employee, сеттеры не нужны
        Employee employee = new Employee("Mark", "James", 20);

        String json = objectMapper.writeValueAsString(employee);

        System.out.println("pojoToJsonString():");
        System.out.println(json);
    }

    @Test
    void jsonStringToPojo1() throws JsonProcessingException {

        String employeeJson = "{\n" +
                " \"firstName\" : \"Jalil\",\n" +
                " \"lastName\" : \"Jarjanazy\",\n" +
                " \"age\" : 30\n" +
                "}";

        /// для записи в объект достаточно наличие сеттеров, но! если заменить сеттер на геттер - тоже будет ОК
        /// получается, @Getter - универсальная конструкция, годится для записи и в объект и в файл
        /// внимание! тут даже @Getter можно убрать..
        Employee2 employee = objectMapper.readValue(employeeJson, Employee2.class);

        System.out.println("firstName = " + employee.firstName +
                           "; lastName = " + employee.lastName +
                            "; age = " + employee.age);
    }

    @Test
    @DisplayName("Создание POJO из строки или из массива байт в формате JSON")
    void jsonStringToPojo2() throws IOException {
        String employeeJson = "{\n" +
                " \"firstName\" : \"Jalil\",\n" +
                " \"lastName\" : \"Jarjanazy\",\n" +
                " \"age\" : 30\n" +
                "}";

        Employee employee = objectMapper.readValue(employeeJson, Employee.class);
        Assertions.assertEquals("Jalil", employee.getFirstName());

        // or
        employee = objectMapper.readValue(employeeJson.getBytes(), Employee.class);
        assertThat(employee.getFirstName()).isEqualTo("Jalil");
    }

    @Test
    @DisplayName("Создание POJO из файла")
    void jsonFileToPojo() throws IOException {
        File file = new File("src/test/resources/employee.json");

        Employee employee = objectMapper.readValue(file, Employee.class);

        assertThat(employee.getAge()).isEqualTo(44);
        assertThat(employee.getLastName()).isEqualTo("Simpson");
        assertThat(employee.getFirstName()).isEqualTo("Homer");
    }

    @Test
    @DisplayName("Создание списка POJO из JSON")
    void fileToListOfPojos() throws IOException {
        File file = new File("src/test/resources/employeeList.json");
        List<Employee> employeeList = objectMapper.readValue(file, new TypeReference<>() {});
        /// по сути
        /// List<Employee> employeeList = objectMapper.readValue(file, new TypeReference<>(List<Employee>) {});

        assertThat(employeeList).hasSize(2);
        assertThat(employeeList.get(0).getAge()).isEqualTo(33);
        assertThat(employeeList.get(0).getLastName()).isEqualTo("Simpson");
        assertThat(employeeList.get(0).getFirstName()).isEqualTo("Marge");
    }

    @Test
    @DisplayName("Создание Map из JSON")
    void fileToMap() throws IOException {
        File file = new File("src/test/resources/employee.json");
        Map<String, Object> employee = objectMapper.readValue(file, new TypeReference<>() {});

        assertThat(employee.keySet()).containsExactly("firstName", "lastName", "age");

        assertThat(employee.get("firstName")).isEqualTo("Homer");
        assertThat(employee.get("lastName")).isEqualTo("Simpson");
        assertThat(employee.get("age")).isEqualTo(44);

        /// Можно даже так, типа мы знаем, что в файле массив каких-то объектов, можем спарсить в сложную стуктуру List<Map<String, Object>>
        file = new File("src/test/resources/employeeList.json");
        List<Map<String, Object>> employee1 = objectMapper.readValue(file, new TypeReference<>() { });
    }

    @Test
    @DisplayName("Игнорирование неизвестных полей JSON")
    void fileToPojoWithUnknownProperties() throws IOException {
        File file = new File("src/test/resources/employeeWithUnknownProperties.json");
        /// objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        /// если убрать будет ERR: com.fasterxml.jackson.databind.exc.UnrecognizedPropertyException: Unrecognized field "department" ...
        /// есть еще вариант это сделать аналогичную настройку спец. аннотацией
        /// @JsonIgnoreProperties(ignoreUnknown = true) - добавил

        Employee employee = objectMapper.readValue(file, Employee.class);

        assertThat(employee.getFirstName()).isEqualTo("Homer");
        assertThat(employee.getLastName()).isEqualTo("Simpson");
        assertThat(employee.getAge()).isEqualTo(44);
    }

    @Test
    @DisplayName("Записать дату в JSON")
    void orderToJson() throws JsonProcessingException {
        Order order = new Order(1, LocalDate.of(1999,2,1));

        String json = objectMapper.writeValueAsString(order);

        System.out.println("Записать дату в JSON :" + json);
        /// Записать дату в JSON :{"id":1,"date":[1999,2,1]}

        OrderWithFormat orderWithFormat = new OrderWithFormat(1, LocalDate.of(1999,2,1));

        json = objectMapper.writeValueAsString(orderWithFormat);

        System.out.println("Записать дату в JSON :" + json);
        /// Записать дату в JSON :{"id":1,"date":"01/02/1999"}
    }

    @Test
    @DisplayName("Преобразовать JSON в дату")
    void fileToOrder() throws IOException {
            File file = new File("src/test/resources/order.json");

            OrderWithFormat orderWithFormat = objectMapper.readValue(file, OrderWithFormat.class);
            /// Чтобы этот код сработал, необходимо чтобы
            /// класс OrderWithFormat имел аннотацию @NoArgsConstructor
            /// иначе objectMapper не сможет сконструировать объект

            assertThat(orderWithFormat.getDate().getYear()).isEqualTo(2000);
            assertThat(orderWithFormat.getDate().getMonthValue()).isEqualTo(4);
            assertThat(orderWithFormat.getDate().getDayOfMonth()).isEqualTo(30);
    }

    @Test
    @DisplayName("Проверка работы @JsonProperty")
    void jsonPropertyCheck() throws IOException {
        /// Deserialization
        ObjectMapper om = new ObjectMapper();
        File file = new File("src/test/resources/user.json");

        UserDTO userDTO = om.readValue(file, UserDTO.class);

        Assertions.assertEquals("Donald", userDTO.getFirstName());
        Assertions.assertEquals("Duck", userDTO.getLastName());

        /// Serialization
        String json = om.writeValueAsString(userDTO);
        System.out.println(json);
    }


    @Getter
    @NoArgsConstructor
    public static class UserDTO {
        @JsonProperty(value = "first_name")
        private String firstName;

        @JsonProperty(value = "last_name")
        private String lastName;
    }

    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Employee {
        private String firstName;
        private String lastName;
        private int age;
    }

    //@Getter                               // умышленно отключено, и эксепшн не возникает
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Employee2 {
        public String firstName;
        public String lastName;
        public int age;
    }

    @Getter
    @AllArgsConstructor
    public static class Order {
        private int id;
        private LocalDate date;
    }

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class OrderWithFormat {
        private int id;
        @JsonFormat(pattern = "dd/MM/yyyy")
        private LocalDate date;
    }

    @AllArgsConstructor
    @NoArgsConstructor
    public static class Cat {
        @JsonAnyGetter  							// ставится на Поле, но у нас тут и имена полей пишутся с те ми же именами
        Map<String, String> map = Map.of(
                "name", "Jack",
                "surname", "wolfskin"
        );
    }
}
