package com.amstest.test.service;

import com.ams.main.dto.User;
import com.ams.main.service.UserService;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


@TestInstance(TestInstance.Lifecycle.PER_METHOD)
//@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class UserServiceTest {

    private UserService userService;

    @BeforeAll
    static void init(){
        System.out.println("Before all");
    }

    @BeforeEach
    void  prepare(){
        System.out.println("Before each: " + this);
        userService = new UserService();
    }

    @Test
    void usersEmptyIfNoUserAdded(){
        System.out.println("Test 1: " + this);
        var users = userService.getAll();
        
        assertTrue(users.isEmpty());
        //assertFalse(users.isEmpty(),"custom string ERROR");
    }

    @Test
    void usersSizeIfUserAdded(){
        System.out.println("Test 2: " + this);

        userService.add(new User());
        userService.add(new User());

        var users = userService.getAll();
        assertEquals(3, users.size());
    }

    @AfterEach
    void deleteDataFromDatabase(){
        System.out.println("After each : " + this);
    }

    @AfterAll
    static void closeConnectionPool(){
        System.out.println("After all");
    }

}
