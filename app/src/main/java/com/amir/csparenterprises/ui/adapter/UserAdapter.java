package com.amir.csparenterprises.ui.adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.amir.csparenterprises.R;
import com.amir.csparenterprises.model.SuccessItem;
import com.amir.csparenterprises.ui.activity.UserProfileActivity;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder> {

    List<SuccessItem> list;

    public UserAdapter(List<SuccessItem> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.user, parent, false);
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        SuccessItem successItem = list.get(position);
        if (successItem != null) {
            holder.email.setText(successItem.getName());
            holder.address.setText(successItem.getAddress());
            Picasso.get().load(successItem.getImage()).placeholder(R.drawable.placeholder).resize(100, 100).centerCrop().into(holder.circleImageView);

            holder.layout.setOnClickListener(view -> {
                Intent intent = new Intent(holder.layout.getContext(), UserProfileActivity.class);
                intent.putExtra("user",new Gson().toJson(successItem));
                holder.layout.getContext().startActivity(intent);
            });
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class UserViewHolder extends RecyclerView.ViewHolder {

        TextView address, email;
        CircleImageView circleImageView;
        LinearLayout layout;

        public UserViewHolder(@NonNull View itemView) {
            super(itemView);

            address = itemView.findViewById(R.id.address);
            email = itemView.findViewById(R.id.email);
            circleImageView = itemView.findViewById(R.id.image);
            layout = itemView.findViewById(R.id.linear);
        }
    }
}
