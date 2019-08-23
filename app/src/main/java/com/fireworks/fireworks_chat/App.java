package com.fireworks.fireworks_chat;

import android.app.Application;
import android.os.Build;
import android.support.v4.content.ContextCompat;

import com.facebook.stetho.Stetho;
import com.fireworks.fireworks_chat.ui.homepagetab.HomePageTabActivity;
import com.fireworks.fireworks_chat.util.ChatRoomNavigator;
import com.fireworks.fireworks_chat.util.Configuration;
import com.fireworks.fireworks_chat.BuildConfig;
import com.qiscus.sdk.Qiscus;
import com.qiscus.sdk.data.model.QiscusReplyPanelConfig;

/**
 * Created by alifhaikal on 15/8/19.
 */
public class App extends Application {
    private static App INSTANCE;

    private AppComponent component;

    public static App getInstance() {
        return INSTANCE;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        INSTANCE = this;
        component = new AppComponent(this);

        if (BuildConfig.DEBUG) {
            Stetho.initializeWithDefaults(this);
        }

        Qiscus.setEnableLog(BuildConfig.DEBUG);
        Qiscus.init(this, Configuration.QISCUS_APP_ID);
        Qiscus.getChatConfig()
                .setStatusBarColor(R.color.colorPrimaryDark)
                .setAppBarColor(R.color.colorPrimary)
                .setLeftBubbleColor(R.color.emojiSafeYellow)
                .setRightBubbleColor(R.color.colorPrimary)
                .setRightBubbleTextColor(R.color.qiscus_white)
                .setRightBubbleTimeColor(R.color.qiscus_white)
                .setReadIconColor(R.color.colorAccent)
                .setReplyBarColor(R.color.colorPrimary)
                .setReplySenderColor(R.color.colorPrimary)
                .setStartReplyInterceptor(comment ->
                        new QiscusReplyPanelConfig().setBarColor(ContextCompat.getColor(this, R.color.colorPrimary)))
                .setRoomReplyBarColorInterceptor(qiscusComment -> R.color.colorPrimary)
                .setEmptyRoomImageResource((R.drawable.ic_room_empty))
                .setEnableFcmPushNotification(true)
                .setNotificationBigIcon(R.mipmap.ic_launcher_foreground)
                .setNotificationSmallIcon(R.mipmap.ic_launcher_foreground)
                .setNotificationClickListener((context, qiscusComment) -> ChatRoomNavigator
                        .openChatQiscusCommentRoom(context, qiscusComment)
                        .withParentClass(HomePageTabActivity.class)
                        .start())
                .setOnlyEnablePushNotificationOutsideChatRoom(true)
                .setInlineReplyColor(R.color.colorPrimary)
                .setEnableAddLocation(true)
                .setEmptyRoomTitleColor(R.color.orangeIcon)
                .setAccentColor(R.color.colorAccent)
                .getDeleteCommentConfig().setEnableDeleteComment(true);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            Qiscus.getChatConfig().setEnableReplyNotification(true);
        }
    }

    public AppComponent getComponent() {
        return component;
    }
}
