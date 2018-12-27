package com.example.vanh1200.demomvp.data.source.local;

import android.content.Context;
import android.support.annotation.NonNull;

import com.example.vanh1200.demomvp.data.model.User;
import com.example.vanh1200.demomvp.data.source.UserDataSource;

public class UserLocalDataSource implements UserDataSource.LocalDatasource {
    public static UserLocalDataSource instance;
    private Context mContext;

    public UserLocalDataSource(Context context) {
        mContext = context;
    }

    public static UserLocalDataSource getInstance(Context context) {
        if (instance == null)
            instance = new UserLocalDataSource(context);
        return instance;
    }

    @Override
    public void insertUser(@NonNull User user) {

    }

    @Override
    public void updateUser(@NonNull User user) {

    }

    @Override
    public void deleteUser(@NonNull User user) {

    }
}
