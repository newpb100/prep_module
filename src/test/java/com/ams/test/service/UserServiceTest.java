package com.ams.test.service;

import com.ams.main.dto.User;
import com.ams.main.service.UserService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserServiceTest {

    private UserService userService;

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
        assertEquals(2, users.size());
    }

    @AfterEach
    void deleteDataFromDatabase(){
        System.out.println("After each : " + this);
    }

}
