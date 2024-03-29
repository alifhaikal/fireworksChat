package com.fireworks.fireworks_chat.ui.privatechatcreation;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.fireworks.fireworks_chat.R;
import com.fireworks.fireworks_chat.data.model.User;
import com.fireworks.fireworks_chat.ui.common.OnItemClickListener;
import com.fireworks.fireworks_chat.ui.common.SortedRecyclerViewAdapter;

/**
 * Created on : August 18, 2019
 * Author     : alifhaikal
 * Name       : Alif Haikal
 */
public class ContactAdapter extends SortedRecyclerViewAdapter<User, ContactViewHolder> {
    private Context context;
    private OnItemClickListener onItemClickListener;

    public ContactAdapter(Context context, OnItemClickListener onItemClickListener) {
        super();
        this.context = context;
        this.onItemClickListener = onItemClickListener;
    }

    @Override
    protected Class<User> getItemClass() {
        return User.class;
    }

    @Override
    protected int compare(User item1, User item2) {
        if (item1.getId().equals(PrivateChatCreationActivity.STRANGER_CHAT_ID)) {
            return -1;
        }

        if (item2.getId().equals(PrivateChatCreationActivity.STRANGER_CHAT_ID)) {
            return 1;
        }

        if (item1.getId().equals(PrivateChatCreationActivity.GROUP_CHAT_ID)) {
            return -1;
        }

        if (item2.getId().equals(PrivateChatCreationActivity.GROUP_CHAT_ID)) {
            return 1;
        }

        return item1.getName().compareTo(item2.getName());
    }

    @NonNull
    @Override
    public ContactViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ContactViewHolder(
                LayoutInflater.from(context).inflate(R.layout.item_contact, parent, false), onItemClickListener
        );
    }

    @Override
    public void onBindViewHolder(@NonNull ContactViewHolder holder, int position) {
        holder.bind(getData().get(position));
    }
}
