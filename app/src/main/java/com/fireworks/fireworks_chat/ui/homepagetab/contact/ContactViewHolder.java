package com.fireworks.fireworks_chat.ui.homepagetab.contact;

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
//    private TextView itemEmail;
    private ImageView picture;

    private OnItemClickListener onItemClickListener;

    public ContactViewHolder(View itemView, OnItemClickListener onItemClickListener) {
        super(itemView);
        this.onItemClickListener = onItemClickListener;
        itemView.setOnClickListener(this);

        itemName = itemView.findViewById(R.id.textViewName);
//        itemEmail = itemView.findViewById(R.id.textViewEmail);
        picture = itemView.findViewById(R.id.imageViewProfile);
    }

    public void bind(User user) {
        Nirmana.getInstance().get()
                .load(user.getAvatarUrl())
                .placeholder(R.drawable.ic_qiscus_avatar)
                .error(R.drawable.ic_qiscus_avatar)
                .dontAnimate()
                .into(picture);
        itemName.setText(user.getName());
//        itemEmail.setText(user.getId());
    }

    @Override
    public void onClick(View v) {
        if (onItemClickListener != null) {
            onItemClickListener.onItemClick(getAdapterPosition());
        }
    }
}
