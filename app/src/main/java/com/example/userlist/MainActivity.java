package com.example.userlist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.userlist.adapter.UserListRecyclerViewAdapter;
import com.example.userlist.databinding.ActivityMainBinding;
import com.example.userlist.model.UserModel;
import com.example.userlist.viewmodel.UserListViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding mainBinding;
    List<UserModel> userModelList = new ArrayList<>();
    private UserListViewModel userListViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBinding = DataBindingUtil
                .setContentView(this, R.layout.activity_main);

        UserListRecyclerViewAdapter userListRecyclerViewAdapter = new UserListRecyclerViewAdapter(userModelList);
        mainBinding.userListRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        mainBinding.userListRecyclerView.setAdapter(userListRecyclerViewAdapter);
        mainBinding.userListRecyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));

        userListViewModel = new ViewModelProvider(MainActivity.this).get(UserListViewModel.class);
        userListViewModel.getUserListObserver().observe(this, new Observer<List<UserModel>>() {
            @Override
            public void onChanged(List<UserModel> userModels) {
                if(userModels != null){
                    userModelList = userModels;
                    userListRecyclerViewAdapter.setUserList(userModelList);
                }else{
                    Log.d("myErrors", "Error in MainActivity.java code");
                }
            }
        });

        userListViewModel.makeApiCall(MainActivity.this);


    }

    private List<UserModel> getUserList() {
        List<UserModel> userModelList = new ArrayList<>();
        String imgUrl = "https://cdn.dribbble.com/users/2878951/screenshots/14013747/media/603f0b853c409547dfa51cba996f375c.png";
        UserModel userModel = new UserModel("vijay", "gupta", "vijay@gmail.com", imgUrl, 22);
        userModelList.add(userModel);
        userModelList.add(userModel);
        return userModelList;
    }

    @Override
    public void onBackPressed() {
        finish();
    }
}