package com.example.vanh1200.demomvp.signin;

import com.example.vanh1200.demomvp.data.model.User;
import com.example.vanh1200.demomvp.data.repository.UserRepository;
import com.example.vanh1200.demomvp.data.source.remote.UserRemoteDataSource;

public class SignInPresenter implements SignInContract.Presenter, UserRemoteDataSource.OnLoginCallback {
    private SignInContract.View mView;
    private UserRepository mUserRepository;

    public SignInPresenter(UserRepository userRepository) {
        mUserRepository = userRepository;
    }

    @Override
    public void signInUser(User user) {
        mUserRepository.checkLogin(user, this);
    }

    @Override
    public void signUp() {

    }

    @Override
    public void setView(SignInActivity view) {
        mView = view;
    }

    @Override
    public void onSuccess() {
        mView.showLoginSuccess();
    }

    @Override
    public void onFailed(String message) {
        mView.showLoginFailed();
    }
}
