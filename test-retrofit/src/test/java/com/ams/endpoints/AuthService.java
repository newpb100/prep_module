package com.ams.endpoints;

import com.ams.models.AuthBasicDummyJsonRequest;
import com.ams.models.AuthBasicDummyJsonResponse;
import com.ams.models.CreateUserResponse;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface AuthService {

    /// Basic авторизация на сайте https://dummyjson.com/
    @POST("auth/login")
    Call<AuthBasicDummyJsonResponse> authLoginBasic(@Body AuthBasicDummyJsonRequest authBasicDummyJsonRequest);
}
