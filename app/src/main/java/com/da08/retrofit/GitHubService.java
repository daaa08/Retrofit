package com.da08.retrofit;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Da08 on 2017. 8. 22..
 */

public interface GitHubService {
    @GET("users/{username}")
    Call<User> getUser(@Path("username") String username);
}
