package com.example.vanh1200.demomvp.data.source;

import android.support.annotation.NonNull;

import com.example.vanh1200.demomvp.data.model.User;
import com.example.vanh1200.demomvp.data.source.remote.UserRemoteDataSource;

public class UserDataSource {
    public interface LocalDatasource {
        void insertUser(@NonNull User user);

        void updateUser(@NonNull User user);

        void deleteUser(@NonNull User user);
    }

    public interface RemoteDatasource {
        void checkLogin(@NonNull User user, UserRemoteDataSource.OnLoginCallback callback);
    }
}
