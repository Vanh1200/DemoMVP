package com.example.vanh1200.demomvp.signin;

import com.example.vanh1200.demomvp.base.BasePresenter;
import com.example.vanh1200.demomvp.data.model.User;

public interface SignInContract {

    interface View {
        void showLoadIndicator();

        void hideLoadIndicator();

        void showMessage(String message);

        void showLoginSuccess();

        void showLoginFailed();
    }

    interface Presenter extends BasePresenter<SignInActivity> {
        void signInUser(User user);

        void signUp();
    }

}
