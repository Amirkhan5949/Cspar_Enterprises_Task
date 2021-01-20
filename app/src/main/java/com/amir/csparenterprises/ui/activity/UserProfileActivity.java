package com.amir.csparenterprises.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.amir.csparenterprises.R;
import com.amir.csparenterprises.model.SuccessItem;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;

public class UserProfileActivity extends AppCompatActivity {

    private CircleImageView image;
    private TextView name,address,description,empcode,contact;

    private SuccessItem user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);

        init();

        setValues();
    }

    private void setValues() {
        Picasso.get().load(user.getImage()).placeholder(R.drawable.placeholder).resize(100, 100).centerCrop().into(image);
        name.setText(user.getName());
        address.setText(user.getAddress());
        description.setText(user.getDescription());
        contact.setText(user.getContact());
        empcode.setText(user.getEmpcode());
    }

    private void init() {

        user = new Gson().fromJson(getIntent().getStringExtra("user"),SuccessItem.class);

        image = findViewById(R.id.image);
        name = findViewById(R.id.name);
        address = findViewById(R.id.address);
        description = findViewById(R.id.description);
        empcode = findViewById(R.id.empcode);
        contact = findViewById(R.id.contact);
    }
}