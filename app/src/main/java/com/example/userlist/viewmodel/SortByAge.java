package com.example.userlist.viewmodel;

import com.example.userlist.model.UserModel;

import java.util.Comparator;

public class SortByAge implements Comparator<UserModel> {

    @Override
    public int compare(UserModel u1, UserModel u2) {
        return u1.getAge() - u2.getAge();
    }
}
