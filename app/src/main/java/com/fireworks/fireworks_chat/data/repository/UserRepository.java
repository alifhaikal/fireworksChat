package com.fireworks.fireworks_chat.data.repository;

import android.net.Uri;

import com.fireworks.fireworks_chat.data.model.User;
import com.fireworks.fireworks_chat.util.Action;
import com.qiscus.sdk.data.remote.QiscusApi;

import java.util.List;

/**
 * Created on : August 18, 2019
 * Author     : alifhaikal
 * Name       : Alif Haikal
 */
public interface UserRepository {

    void login(String name, String email, String password, Action<User> onSuccess, Action<Throwable> onError);

    void getCurrentUser(Action<User> onSuccess, Action<Throwable> onError);

    void getUsers(Action<List<User>> onSuccess, Action<Throwable> onError);

    void updateProfile(String name, Action<User> onSuccess, Action<Throwable> onError);

    void logout();

    void uploadPhoto(String realPathFromURI, QiscusApi.ProgressListener progressListener,
                     Action<User> onSuccess, Action<Throwable> onError);
}
