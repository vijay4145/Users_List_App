package com.example.userlist.retrofit;


import com.example.userlist.model.UserModelList;



import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {
    @GET("api/933015671865098240/")
    Call<UserModelList> getUserList();
}
