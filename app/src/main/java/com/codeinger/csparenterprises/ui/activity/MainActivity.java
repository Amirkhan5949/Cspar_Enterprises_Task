package com.codeinger.csparenterprises.ui.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import com.codeinger.csparenterprises.R;
import com.codeinger.csparenterprises.model.SuccessItem;
import com.codeinger.csparenterprises.model.ViewPortResponse;
import com.codeinger.csparenterprises.network.NetworkRequest;
import com.codeinger.csparenterprises.network.NetworkUrl;
import com.codeinger.csparenterprises.network.RetrofitClient;
import com.codeinger.csparenterprises.ui.adapter.UserAdapter;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recycler;
    private ProgressBar progress;
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
        recycler=findViewById(R.id.recycler);
        progress=findViewById(R.id.progress);
        recycler.setLayoutManager(new LinearLayoutManager(this));
        adapter = new UserAdapter(list);
        recycler.setAdapter(adapter);
    }
}