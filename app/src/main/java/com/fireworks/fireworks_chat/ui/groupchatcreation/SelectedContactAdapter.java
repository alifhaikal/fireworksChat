package com.fireworks.fireworks_chat.ui.groupchatcreation;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.fireworks.fireworks_chat.R;
import com.fireworks.fireworks_chat.ui.common.OnItemClickListener;
import com.fireworks.fireworks_chat.ui.common.SortedRecyclerViewAdapter;

/**
 * Created on : August 18, 2019
 * Author     : alifhaikal
 * Name       : Alif Haikal
 */
public class SelectedContactAdapter extends SortedRecyclerViewAdapter<SelectableUser, SelectedContactViewHolder> {
    private Context context;
    private OnItemClickListener onItemClickListener;

    public SelectedContactAdapter(Context context, OnItemClickListener onItemClickListener) {
        super();
        this.context = context;
        this.onItemClickListener = onItemClickListener;
    }

    @Override
    protected Class<SelectableUser> getItemClass() {
        return SelectableUser.class;
    }

    @Override
    protected int compare(SelectableUser item1, SelectableUser item2) {
        return item1.getUser().getName().compareTo(item2.getUser().getName());
    }

    @NonNull
    @Override
    public SelectedContactViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new SelectedContactViewHolder(
                LayoutInflater.from(context).inflate(R.layout.item_selected_contact, parent, false), onItemClickListener
        );
    }

    @Override
    public void onBindViewHolder(@NonNull SelectedContactViewHolder holder, int position) {
        holder.bind(getData().get(position));
    }
}

