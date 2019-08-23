package com.fireworks.fireworks_chat.ui.groupdetail;

import com.fireworks.fireworks_chat.data.model.User;
import com.fireworks.fireworks_chat.data.repository.ChatRoomRepository;
import com.qiscus.sdk.data.model.QiscusChatRoom;

/**
 * Created on : August 18, 2019
 * Author     : alifhaikal
 * Name       : Alif Haikal
 */
public class GroupDetailPresenter {
    private View view;
    private ChatRoomRepository chatRoomRepository;

    public GroupDetailPresenter(View view, ChatRoomRepository chatRoomRepository) {
        this.view = view;
        this.chatRoomRepository = chatRoomRepository;
    }

    public void removeMember(long roomId, User user) {
        view.showLoading();
        chatRoomRepository.removeMember(roomId, user,
                aVoid -> {
                    view.dismissLoading();
                    view.onMemberRemoved(user);
                },
                throwable -> {
                    view.dismissLoading();
                    view.showErrorMessage(throwable.getMessage());
                });
    }

    public void updateRoomName(long roomId, String roomName) {
        view.showLoading();
        chatRoomRepository.updateGroupChatRoomName(roomId, roomName,
                qiscusChatRoom -> {
                    view.dismissLoading();
                    view.onRoomNameUpdated(qiscusChatRoom);
                }, throwable -> {
                    view.dismissLoading();
                    view.showErrorMessage(throwable.getMessage());
                });
    }

    public interface View {
        void onMemberRemoved(User user);

        void showLoading();

        void dismissLoading();

        void showErrorMessage(String errorMessage);

        void onRoomNameUpdated(QiscusChatRoom qiscusChatRoom);
    }
}
