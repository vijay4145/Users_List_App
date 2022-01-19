package com.example.userlist.viewmodel;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.userlist.adapter.UserListRecyclerViewAdapter;
import com.example.userlist.model.UserModel;
import com.example.userlist.model.UserModelList;
import com.example.userlist.retrofit.ApiService;
import com.example.userlist.retrofit.RetroInstance;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserListViewModel extends ViewModel {
    private  MutableLiveData<List<UserModel>> userList;

    public UserListViewModel() {
        this.userList = new MutableLiveData<>();
    }

     public MutableLiveData<List<UserModel>> getUserListObserver() {
        return userList;
     }



    public void makeApiCall(Context context){
        ApiService apiService = RetroInstance.getRetrofitClient().create(ApiService.class);
        Call<UserModelList> call = apiService.getUserList();
        call.enqueue(new Callback<UserModelList>() {
            @Override
            public void onResponse(Call<UserModelList> call, Response<UserModelList> response) {
                List<UserModel> userModel = response.body().getUsers();
                Collections.sort(userModel, new SortByAge());
                userList.postValue(userModel);
            }

            @Override
            public void onFailure(Call<UserModelList> call, Throwable throwable) {
                userList.postValue(null);
                Toast.makeText(context,"Api call failed",Toast.LENGTH_SHORT).show();
                Log.d("myErrors", throwable.toString());
            }
        });
    }
}
