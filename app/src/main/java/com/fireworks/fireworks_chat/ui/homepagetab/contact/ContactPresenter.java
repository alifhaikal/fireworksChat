package com.fireworks.fireworks_chat.ui.homepagetab.contact;

import com.fireworks.fireworks_chat.data.model.User;
import com.fireworks.fireworks_chat.data.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created on : August 18, 2019
 * Author     : alifhaikal
 * Name       : Alif Haikal
 */
public class ContactPresenter {
    private View view;
    private UserRepository userRepository;
    private List<User> contacts;

    public ContactPresenter(View view, UserRepository userRepository) {
        this.view = view;
        this.userRepository = userRepository;
        contacts = new ArrayList<>();
    }

    public void loadContacts() {
        userRepository.getUsers(users -> {
                    contacts = users;
                    view.showContacts(users);
                },
                throwable -> view.showErrorMessage(throwable.getMessage())
        );
    }

    public void search(String keyword) {
        Observable.from(contacts)
                .filter(user -> user.getName().toLowerCase().contains(keyword.toLowerCase()))
                .toList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(users -> view.showContacts(users), throwable -> view.showErrorMessage(throwable.getMessage()));

    }

    public interface View {
        void showContacts(List<User> contacts);

        void showErrorMessage(String errorMessage);
    }
}
