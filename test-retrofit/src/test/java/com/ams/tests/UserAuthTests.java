package com.ams.tests;

import com.ams.endpoints.AuthService;
import com.ams.models.AuthBasicDummyJsonRequest;
import com.ams.models.AuthBasicDummyJsonResponse;
import org.junit.jupiter.api.Test;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserAuthTests {

    final Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://dummyjson.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    final AuthService authService = retrofit.create(AuthService.class);

    @Test
    public void testGetAccessToken() throws IOException {

        AuthBasicDummyJsonRequest authBasicDummyJsonRequest = new AuthBasicDummyJsonRequest("emilys","emilyspass");

        Response<AuthBasicDummyJsonResponse> resp = authService.authLoginBasic(authBasicDummyJsonRequest).execute();

        System.out.println(resp.code());
        System.out.println(resp.isSuccessful());
        System.out.println(resp.message());

        /// Get access token
        System.out.println(resp.body().getAccessToken());
    }
}
