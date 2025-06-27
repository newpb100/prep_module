package com.ams.endpoints;

import com.ams.models.*;
import retrofit2.Call;
import retrofit2.http.*;

public interface UserService {
    /// Разрабатываем каждый метод на основе спеки на странице
    /// https://reqres.in/
    ///
    /// Каждый запрос должен быть представлен
    /// - Типом запроса
    /// - Эндпоинтом
    /// - Необходимыми входными параметрами на основе Query, id или Body-тела
    /// - Возвращаемым результатом, который представляет из себя дженерик-объект Call типизированный конкретным возвращаемым типом
    ///
    /// Возвращаемый тип формируем на основе шаблона ответа и с помощью инструмента
    /// https://json2csharp.com/code-converters/json-to-pojo


    /// Получение списка пользователей
    @GET("api/users")
    Call<UserListRootResponse> getUserList(@Query("page") int pageParam);

    /// Получение пользователя по id
    @GET("api/users/{id}")
    Call<SingleUserResponse> getUserById(@Path("id") int id);

    /// Создание нового пользователя
    @POST("api/users")
    Call<CreateUserResponse> createUser(@Header("x-api-key") String token, @Body UserRequest userRequest);

    /// Обновление пользователя по Id
    @PUT("api/users/{id}")
    Call<UserUpdateResponse> updateUserById(@Header("x-api-key") String token, @Path("id") int id, @Body UserRequest userRequest);

    /// Удаление пользователя по Id
    @DELETE("api/users/{id}")
    Call<Void> deleteUserById(@Header("x-api-key") String token, @Path("id") int id);

}
