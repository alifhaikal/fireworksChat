package com.fireworks.fireworks_chat.ui.profile;

import com.fireworks.fireworks_chat.data.model.User;
import com.fireworks.fireworks_chat.data.repository.UserRepository;

/**
 * Created on : August 18, 2019
 * Author     : alifhaikal
 * Name       : Alif Haikal
 */
public class ProfilePresenter {
    private View view;
    private UserRepository userRepository;

    public ProfilePresenter(View view, UserRepository userRepository) {
        this.view = view;
        this.userRepository = userRepository;
    }

    public void loadUser() {
        userRepository.getCurrentUser(
                view::showUser,
                throwable -> {
                });
    }

    public void logout() {
        userRepository.logout();
        view.showLoginPage();
    }

    public void uploadPhoto(String realPathFromURI) {
        userRepository.uploadPhoto(realPathFromURI, total -> {
                },
                user -> view.showUser(user),
                throwable -> view.showError(throwable.getMessage()));
    }

    public interface View {
        void showUser(User user);

        void showLoginPage();

        void showError(String message);
    }
}
