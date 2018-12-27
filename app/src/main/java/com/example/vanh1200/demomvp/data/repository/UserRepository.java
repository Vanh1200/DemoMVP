package com.example.vanh1200.demomvp.data.repository;

import android.support.annotation.NonNull;

import com.example.vanh1200.demomvp.data.model.User;
import com.example.vanh1200.demomvp.data.source.UserDataSource;
import com.example.vanh1200.demomvp.data.source.local.UserLocalDataSource;
import com.example.vanh1200.demomvp.data.source.remote.UserRemoteDataSource;

public class UserRepository implements UserDataSource.LocalDatasource, UserDataSource.RemoteDatasource {
    public static UserRepository instance;

    @NonNull
    private UserLocalDataSource mUserLocalDataSource;

    @NonNull
    private UserRemoteDataSource mUserRemoteDataSource;

    public UserRepository(@NonNull UserLocalDataSource userLocalDataSource, @NonNull UserRemoteDataSource userRemoteDataSource) {
        mUserLocalDataSource = userLocalDataSource;
        mUserRemoteDataSource = userRemoteDataSource;
    }

    public static UserRepository getInstance(@NonNull UserLocalDataSource userLocalDataSource,
                                             @NonNull UserRemoteDataSource userRemoteDataSource) {
        if (instance == null)
            instance = new UserRepository(userLocalDataSource, userRemoteDataSource);
        return instance;
    }

    @Override
    public void insertUser(@NonNull User user) {
        mUserLocalDataSource.insertUser(user);
    }

    @Override
    public void updateUser(@NonNull User user) {
        mUserLocalDataSource.updateUser(user);
    }

    @Override
    public void deleteUser(@NonNull User user) {
        mUserLocalDataSource.deleteUser(user);
    }

    @Override
    public void checkLogin(@NonNull User user, UserRemoteDataSource.OnLoginCallback callback) {
        mUserRemoteDataSource.checkLogin(user, callback);
    }
}
