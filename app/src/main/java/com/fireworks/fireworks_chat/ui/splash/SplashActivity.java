package com.fireworks.fireworks_chat.ui.splash;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import com.fireworks.fireworks_chat.ui.homepagetab.HomePageTabActivity;
import com.fireworks.fireworks_chat.ui.login.LoginActivity;
import com.qiscus.sdk.Qiscus;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int splashInterval = 10;
        new Handler().postDelayed(() -> {
            if (!Qiscus.hasSetupUser()) {
                startActivity(new Intent(SplashActivity.this, LoginActivity.class));
            } else {
                startActivity(new Intent(SplashActivity.this, HomePageTabActivity.class));
            }
        }, splashInterval);
    }
}
