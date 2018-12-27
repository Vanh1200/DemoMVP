package com.example.vanh1200.demomvp.signin;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.vanh1200.demomvp.R;
import com.example.vanh1200.demomvp.base.BaseActivity;
import com.example.vanh1200.demomvp.data.model.User;
import com.example.vanh1200.demomvp.data.repository.UserRepository;
import com.example.vanh1200.demomvp.data.source.local.UserLocalDataSource;
import com.example.vanh1200.demomvp.data.source.remote.UserRemoteDataSource;
import com.example.vanh1200.demomvp.signup.SignUpActivity;
import com.example.vanh1200.demomvp.utils.KeyUtils;

public class SignInActivity extends BaseActivity implements SignInContract.View, View.OnClickListener {
    private static final String MESSAGE_LOGIN_SUCCESS = "Login successfully";
    private static final String MESSAGE_LOGIN_FAILED = "Login failed";
    private TextView mEditUserName;
    private TextView mEditPassword;
    private Button mButtonLogin;
    private TextView mTextSignUpSuggestion;
    SignInPresenter mSignInPresenter;
    UserRepository mUserRepository;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        initViews();
        registerEvents();
        mUserRepository = UserRepository.getInstance(UserLocalDataSource.getInstance(this),
                UserRemoteDataSource.getInstance());
        mSignInPresenter = new SignInPresenter(mUserRepository);
        mSignInPresenter.setView(this);
    }

    private void registerEvents() {
        mButtonLogin.setOnClickListener(this);
        mTextSignUpSuggestion.setOnClickListener(this);
    }

    private void initViews() {
        mEditUserName = findViewById(R.id.edit_user_name);
        mEditPassword = findViewById(R.id.edit_password);
        mButtonLogin = findViewById(R.id.button_login);
        mTextSignUpSuggestion = findViewById(R.id.text_sign_up_suggestion);
    }

    @Override
    public void showLoadIndicator() {

    }

    @Override
    public void hideLoadIndicator() {

    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showLoginSuccess() {
        showMessage(MESSAGE_LOGIN_SUCCESS);
    }

    @Override
    public void showLoginFailed() {
        showMessage(MESSAGE_LOGIN_FAILED);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_login:
                loginUser();
                break;
            case R.id.text_sign_up_suggestion:
                openSignUpActivity();
                break;
            default:
                break;
        }
    }

    private void openSignUpActivity() {
        User user = new User(mEditUserName.getText().toString()
                , mEditPassword.getText().toString());
        Intent intent = SignUpActivity.getSignUpActivity(this);
        intent.putExtra(KeyUtils.KEY_USER, user);
        startActivityForResult(intent, KeyUtils.REQUEST_SIGN_UP_USER);
    }

    private void loginUser() {
        User user = new User(mEditUserName.getText().toString()
                , mEditPassword.getText().toString());
        mSignInPresenter.signInUser(user);
    }
}
