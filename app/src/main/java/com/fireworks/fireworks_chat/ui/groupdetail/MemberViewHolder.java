package com.fireworks.fireworks_chat.ui.groupdetail;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.fireworks.fireworks_chat.R;
import com.fireworks.fireworks_chat.ui.common.OnItemClickListener;
import com.qiscus.nirmana.Nirmana;
import com.qiscus.sdk.data.model.QiscusRoomMember;

/**
 * Created on : August 18, 2019
 * Author     : alifhaikal
 * Name       : Alif Haikal
 */
public class MemberViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    private TextView nameTextView;
    private ImageView avatarImageView;

    private OnItemClickListener onItemClickListener;

    public MemberViewHolder(View itemView, OnItemClickListener onItemClickListener) {
        super(itemView);
        itemView.setOnClickListener(this);
        this.onItemClickListener = onItemClickListener;
        nameTextView = itemView.findViewById(R.id.textViewName);
        avatarImageView = itemView.findViewById(R.id.imageViewProfile);
    }

    public void bind(QiscusRoomMember qiscusRoomMember) {
        nameTextView.setText(qiscusRoomMember.getUsername());
        Nirmana.getInstance().get().load(qiscusRoomMember.getAvatar()).into(avatarImageView);
    }

    @Override
    public void onClick(View v) {
        if (onItemClickListener != null) {
            onItemClickListener.onItemClick(getAdapterPosition());
        }
    }
}
