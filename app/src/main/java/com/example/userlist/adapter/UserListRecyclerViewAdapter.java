package com.example.userlist.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.userlist.R;
import com.example.userlist.databinding.UserCardBinding;
import com.example.userlist.model.UserModel;

import java.util.List;

public class UserListRecyclerViewAdapter extends RecyclerView.Adapter<UserListRecyclerViewAdapter.ViewHolder> {
    List<UserModel> userList;

    public UserListRecyclerViewAdapter(List<UserModel> userList) {
        this.userList = userList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        UserCardBinding userCardBinding = UserCardBinding.inflate(layoutInflater, parent, false);
        return new ViewHolder(userCardBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        UserModel user = userList.get(position);
        holder.userCardBinding.setUser(user);
        holder.userCardBinding.executePendingBindings();
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        UserCardBinding userCardBinding;
        public ViewHolder(@NonNull UserCardBinding itemView) {
            super(itemView.getRoot());
            this.userCardBinding = itemView;
        }

    }
}
