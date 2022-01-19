package com.example.userlist.model;

import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.bumptech.glide.Glide;

import de.hdodenhof.circleimageview.CircleImageView;

public class UserModel {
    String firstName, lastName, email, profilePicUrl;
    int age;

    public UserModel(String firstName, String lastName, String email, String profilePicUrl, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.profilePicUrl = profilePicUrl;
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getProfilePicUrl() {
        return profilePicUrl;
    }

    public void setProfilePicUrl(String profilePicUrl) {
        this.profilePicUrl = profilePicUrl;
    }

    @BindingAdapter("android:loadImage")
    public static void loadImage(CircleImageView imageView, String imgUrl){
        Glide.with(imageView)
                .load(imgUrl)
                .into(imageView);
    }
}
