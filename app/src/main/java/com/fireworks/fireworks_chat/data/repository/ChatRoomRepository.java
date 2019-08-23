package com.fireworks.fireworks_chat.data.repository;

import com.fireworks.fireworks_chat.data.model.User;
import com.fireworks.fireworks_chat.util.Action;
import com.qiscus.sdk.data.model.QiscusChatRoom;

import java.util.List;

/**
 * Created on : August 18, 2019
 * Author     : alifhaikal
 * Name       : Alif Haikal
 */
public interface ChatRoomRepository {
    void getChatRoom(long roomId, Action<QiscusChatRoom> onSuccess, Action<Throwable> onError);

    void getChatRooms(Action<List<QiscusChatRoom>> onSuccess, Action<Throwable> onError);

    void createChatRoom(User user, Action<QiscusChatRoom> onSuccess, Action<Throwable> onError);

    void createGroupChatRoom(String name, List<User> members, Action<QiscusChatRoom> onSuccess, Action<Throwable> onError);

    void addMember(long roomId, User user, Action<Void> onSuccess, Action<Throwable> onError);

    void removeMember(long roomId, User user, Action<Void> onSuccess, Action<Throwable> onError);

    void updateGroupChatRoomName(long roomId, String name, Action<QiscusChatRoom> onSuccess, Action<Throwable> onError);
}
