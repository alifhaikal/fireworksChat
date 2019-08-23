package com.fireworks.fireworks_chat.ui.login;

import com.fireworks.fireworks_chat.data.repository.UserRepository;

/**
 * Created on : August 18, 2019
 * Author     : alifhaikal
 * Name       : Alif Haikal
 */
public class LoginPresenter {
    private View view;
    private UserRepository userRepository;

    public LoginPresenter(View view, UserRepository userRepository) {
        this.view = view;
        this.userRepository = userRepository;
    }

    public void login(String name, String email, String password) {
        view.showLoading();
        userRepository.login(name, email, password,
                user -> {
                    view.dismissLoading();
                    view.showHomePage();
                },
                throwable -> {
                    view.dismissLoading();
                    view.showErrorMessage(throwable.getMessage());
                });
    }

    public interface View {
        void showHomePage();

        void showLoading();

        void dismissLoading();

        void showErrorMessage(String errorMessage);
    }
}
