package com.fireworks.fireworks_chat.ui.groupchatcreation;

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
public class GroupChatCreationPresenter {
    private View view;
    private UserRepository userRepository;
    private List<SelectableUser> contacts;

    public GroupChatCreationPresenter(View view, UserRepository userRepository) {
        this.view = view;
        this.userRepository = userRepository;
        contacts = new ArrayList<>();
    }

    public void loadContacts() {
        userRepository.getUsers(users -> {
                    for (User user : users) {
                        SelectableUser selectableUser = new SelectableUser(user);
                        int index = contacts.indexOf(selectableUser);
                        if (index >= 0) {
                            contacts.get(index).setUser(user);
                        } else {
                            contacts.add(selectableUser);
                        }
                    }
                    view.showContacts(contacts);
                },
                throwable -> view.showErrorMessage(throwable.getMessage())
        );
    }

    public void search(String keyword) {
        Observable.from(contacts)
                .filter(selectableUser -> selectableUser.getUser().getName().toLowerCase().contains(keyword.toLowerCase()))
                .toList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(users -> view.showContacts(users), throwable -> view.showErrorMessage(throwable.getMessage()));

    }

    public void selectContact(SelectableUser contact) {
        int index = contacts.indexOf(contact);
        if (index >= 0) {
            contacts.get(index).setSelected(!contacts.get(index).isSelected());
            view.onSelectedContactChange(contacts.get(index));
        }
    }

    public interface View {
        void showContacts(List<SelectableUser> contacts);

        void onSelectedContactChange(SelectableUser contact);

        void showErrorMessage(String errorMessage);
    }
}
