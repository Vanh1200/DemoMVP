package com.example.vanh1200.demomvp.signup;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.example.vanh1200.demomvp.R;
import com.example.vanh1200.demomvp.base.BaseActivity;

public class SignUpActivity extends BaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
    }

    public static Intent getSignUpActivity(Context context){
        return new Intent(context, SignUpActivity.class);
    }
}
