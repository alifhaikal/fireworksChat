package com.fireworks.fireworks_chat.ui.groupchatcreation;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.fireworks.fireworks_chat.R;
import com.fireworks.fireworks_chat.data.model.User;
import com.fireworks.fireworks_chat.ui.common.OnItemClickListener;
import com.qiscus.nirmana.Nirmana;

/**
 * Created on : August 18, 2019
 * Author     : alifhaikal
 * Name       : Alif Haikal
 */
public class ContactViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    private TextView itemName;
    private ImageView picture;
    private View viewCheck;

    private OnItemClickListener onItemClickListener;

    public ContactViewHolder(View itemView, OnItemClickListener onItemClickListener) {
        super(itemView);
        this.onItemClickListener = onItemClickListener;
        itemView.setOnClickListener(this);

        itemName = itemView.findViewById(R.id.textViewName);
        picture = itemView.findViewById(R.id.imageViewProfile);
        viewCheck = itemView.findViewById(R.id.imageViewCheck);
    }

    public void bind(SelectableUser selectableUser) {
        Nirmana.getInstance().get()
                .load(selectableUser.getUser().getAvatarUrl())
                .placeholder(R.drawable.ic_qiscus_avatar)
                .error(R.drawable.ic_qiscus_avatar)
                .dontAnimate()
                .into(picture);
        itemName.setText(selectableUser.getUser().getName());
        viewCheck.setVisibility(selectableUser.isSelected() ? View.VISIBLE : View.GONE);
    }

    @Override
    public void onClick(View v) {
        if (onItemClickListener != null) {
            onItemClickListener.onItemClick(getAdapterPosition());
        }
    }
}
