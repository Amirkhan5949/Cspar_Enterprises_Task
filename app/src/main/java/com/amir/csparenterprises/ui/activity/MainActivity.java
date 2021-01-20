package com.amir.csparenterprises.ui.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import com.amir.csparenterprises.R;
import com.amir.csparenterprises.model.SuccessItem;
import com.amir.csparenterprises.model.ViewPortResponse;
import com.amir.csparenterprises.network.NetworkRequest;
import com.amir.csparenterprises.network.NetworkUrl;
import com.amir.csparenterprises.network.RetrofitClient;
import com.amir.csparenterprises.ui.adapter.UserAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recycler;
    private ProgressBar progress;
    private FloatingActionButton fab;
    private List<SuccessItem> list=new ArrayList<>();
    private UserAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        getviewport();

    }

    private void getviewport() {

        fab.setVisibility(View.GONE);
        progress.setVisibility(View.VISIBLE);
        RetrofitClient.getRetrofit(NetworkUrl.baseUrl)
                .create(NetworkRequest.class)
                .getViewreport()
                .enqueue(new Callback<ViewPortResponse>() {
                    @Override
                    public void onResponse(Call<ViewPortResponse> call, Response<ViewPortResponse> response) {
                        progress.setVisibility(View.GONE);
                        if (response.isSuccessful()) {
                            ViewPortResponse body = response.body();
                            if (body != null) {
                                list.addAll(body.getSuccess());
                                adapter.notifyDataSetChanged();
                                fab.setVisibility(View.VISIBLE);
                                fab.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {
                                        Intent intent = new Intent(MainActivity.this, MapActivity.class);
                                        intent.putExtra("location",new Gson().toJson(body.getLocation()));
                                        startActivity(intent);
                                    }
                                });


                            }
                        }

                    }

                    @Override
                    public void onFailure(Call<ViewPortResponse> call, Throwable t) {
                        progress.setVisibility(View.GONE);
                    }
                });
    }

    private void init() {
        fab=findViewById(R.id.fab);
        recycler=findViewById(R.id.recycler);
        progress=findViewById(R.id.progress);
        recycler.setLayoutManager(new LinearLayoutManager(this));
        adapter = new UserAdapter(list);
        recycler.setAdapter(adapter);
    }
}