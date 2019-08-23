package com.fireworks.fireworks_chat.ui.groupchatcreation.groupinfo;

import com.fireworks.fireworks_chat.data.model.User;
import com.fireworks.fireworks_chat.data.repository.ChatRoomRepository;
import com.fireworks.fireworks_chat.data.repository.UserRepository;
import com.qiscus.sdk.data.model.QiscusChatRoom;
import com.qiscus.sdk.util.QiscusErrorLogger;

import java.util.List;

/**
 * Created on : August 18, 2019
 * Author     : alifhaikal
 * Name       : Alif Haikal
 */
public class GroupInfoPresenter {
    private View view;
    private ChatRoomRepository chatRoomRepository;

    public GroupInfoPresenter(View view, ChatRoomRepository chatRoomRepository) {
        this.view = view;
        this.chatRoomRepository = chatRoomRepository;
    }

    public void createGroup(String name, List<User> members) {
        view.showLoading();
        chatRoomRepository.createGroupChatRoom(name, members,
                qiscusChatRoom -> {
                    view.dismissLoading();
                    view.showGroupChatRoomPage(qiscusChatRoom);
                },
                throwable -> {
                    view.dismissLoading();
                    view.showErrorMessage(QiscusErrorLogger.getMessage(throwable));
                }
        );
    }

    public interface View {

        void showLoading();

        void dismissLoading();

        void showGroupChatRoomPage(QiscusChatRoom chatRoom);

        void showErrorMessage(String errorMessage);
    }
}
