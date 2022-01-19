package com.example.userlist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.DividerItemDecoration;

import android.os.Bundle;

import com.example.userlist.adapter.UserListRecyclerViewAdapter;
import com.example.userlist.databinding.ActivityMainBinding;
import com.example.userlist.model.UserModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding mainBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBinding = DataBindingUtil
                .setContentView(this, R.layout.activity_main);

        UserListRecyclerViewAdapter userListRecyclerViewAdapter = new UserListRecyclerViewAdapter(getUserList());
        mainBinding.userListRecyclerView.setAdapter(userListRecyclerViewAdapter);
        mainBinding.userListRecyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
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