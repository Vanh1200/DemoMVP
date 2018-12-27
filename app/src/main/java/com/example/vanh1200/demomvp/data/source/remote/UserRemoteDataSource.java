package com.example.vanh1200.demomvp.data.source.remote;

import android.support.annotation.NonNull;

import com.example.vanh1200.demomvp.data.model.User;
import com.example.vanh1200.demomvp.data.source.UserDataSource;

public class UserRemoteDataSource implements UserDataSource.RemoteDatasource {
    private static final String MESSAGE_LOGIN_FAILED = "login failed";
    public static UserRemoteDataSource instance;

    public UserRemoteDataSource(){

    }

    public static UserRemoteDataSource getInstance() {
        if (instance == null)
            instance = new UserRemoteDataSource();
        return instance;
    }

    @Override
    public void checkLogin(@NonNull User user, OnLoginCallback callback) {
        if (callback != null) {
            if (user.getUsername().equals("username") && user.getPassword().equals("password")) {
                callback.onSuccess();
            } else {
                callback.onFailed(MESSAGE_LOGIN_FAILED);
            }
        }
    }

    public interface OnLoginCallback {
        void onSuccess();

        void onFailed(String message);
    }
}
