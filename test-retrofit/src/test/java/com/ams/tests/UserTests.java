package com.ams.tests;

import com.ams.endpoints.UserService;
import com.ams.models.*;
import okhttp3.Credentials;
import org.junit.jupiter.api.Test;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserTests {

    private final Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://reqres.in")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    private final UserService userService = retrofit.create(UserService.class);


    @Test
    public void testUserListPage() throws IOException {

        int page = 2;

        Response<UserListRootResponse> resp = userService.getUserList(page).execute();
//        System.out.println(resp.code());
//        System.out.println(resp.message());
        assertTrue(resp.isSuccessful());


        UserListRootResponse rootResponse = resp.body();
        assertEquals(page, rootResponse.getPage());

        List<UserResponse> uresp = rootResponse.getData();
        assertTrue(uresp.size() > 0);
    }


    @Test
    public void testGetUserById() throws IOException {

        int id = 2;

        Response<SingleUserResponse> resp = userService.getUserById(id).execute();
        assertTrue(resp.isSuccessful());

        assertEquals(id, resp.body().getData().getId());
    }

    @Test
    public void testCreateUser() throws IOException {
        String correctTimePattern = "\\d{4}-\\d{2}-\\d{2}T\\d{2}:\\d{2}:\\d{2}.\\d{3}Z";
        //                             2025-06-24T15:27:41.925Z
        String name = "Oleg";
        String job = "ThreadQA Батя";
        String token = "reqres-free-v1";
        UserRequest userRequest = new UserRequest(name, job);

        Response<CreateUserResponse> response = userService.createUser(token, userRequest).execute();
        assertTrue(response.isSuccessful());

        System.out.println();
        System.out.println("response.raw()        = " + response.raw());

        CreateUserResponse userResponse = response.body();
        assertEquals(name, userResponse.getName());
        assertEquals(job, userResponse.getJob());
        assertTrue(userResponse.getCreatedAt().matches(correctTimePattern));
    }

    @Test
    public void testUpdateUser() throws IOException {
        String correctTimePattern = "\\d{4}-\\d{2}-\\d{2}T\\d{2}:\\d{2}:\\d{2}.\\d{3}Z";
        //                             2025-06-24T15:27:41.925Z
        String name = "Neo";
        String job = "Zion resident";
        int id = 1;
        String token = "reqres-free-v1";

        UserRequest userRequest = new UserRequest(name, job);

        Response<UserUpdateResponse> response = userService.updateUserById(token, id, userRequest).execute();
        System.out.println(response.code());
        assertTrue(response.isSuccessful());
        assertTrue(response.body().getUpdatedAt().matches(correctTimePattern));
    }

    @Test
    public void testDeleteUser() throws IOException {
        String token = "reqres-free-v1";

        /// В качестве типа возможно указать как Void , так и знак вопроса
        //Response<Void> resp = userService.deleteUserById(2).execute();
        Response<?> resp = userService.deleteUserById(token,2).execute();

        assertTrue(resp.isSuccessful());
        assertEquals(resp.code(), 204);
    }

}
