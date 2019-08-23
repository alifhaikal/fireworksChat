package com.fireworks.fireworks_chat;

import android.content.Context;

import com.fireworks.fireworks_chat.data.repository.ChatRoomRepository;
import com.fireworks.fireworks_chat.data.repository.UserRepository;
import com.fireworks.fireworks_chat.data.repository.impl.ChatRoomRepositoryImpl;
import com.fireworks.fireworks_chat.data.repository.impl.UserRepositoryImpl;

/**
 * Created on : August 15, 2019
 * Author     : alifhaikal
 * Name       : Alif Haikal
 */
public class AppComponent {
    private final UserRepository userRepository;
    private final ChatRoomRepository chatRoomRepository;

    AppComponent(Context context){
        userRepository = new UserRepositoryImpl(context);
        chatRoomRepository = new ChatRoomRepositoryImpl();
    }

    public UserRepository getUserRepository() {
        return userRepository;
    }

    public ChatRoomRepository getChatRoomRepository() {
        return chatRoomRepository;
    }
}
