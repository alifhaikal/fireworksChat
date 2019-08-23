package com.fireworks.fireworks_chat.ui.groupdetail;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.fireworks.fireworks_chat.R;
import com.fireworks.fireworks_chat.ui.common.OnItemClickListener;
import com.fireworks.fireworks_chat.ui.common.SortedRecyclerViewAdapter;
import com.qiscus.sdk.data.model.QiscusRoomMember;

/**
 * Created on : August 18, 2019
 * Author     : alifhaikal
 * Name       : Alif Haikal
 */
public class MemberAdapter extends SortedRecyclerViewAdapter<QiscusRoomMember, MemberViewHolder> {
    private Context context;
    private OnItemClickListener onItemClickListener;

    public MemberAdapter(Context context, OnItemClickListener onItemClickListener) {
        super();
        this.context = context;
        this.onItemClickListener = onItemClickListener;
    }

    @Override
    protected Class<QiscusRoomMember> getItemClass() {
        return QiscusRoomMember.class;
    }

    @Override
    protected int compare(QiscusRoomMember item1, QiscusRoomMember item2) {
        return item1.getUsername().compareTo(item2.getUsername());
    }

    @NonNull
    @Override
    public MemberViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MemberViewHolder(LayoutInflater.from(context).inflate(R.layout.item_room_member, parent, false), onItemClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull MemberViewHolder holder, int position) {
        holder.bind(getData().get(position));
    }
}
