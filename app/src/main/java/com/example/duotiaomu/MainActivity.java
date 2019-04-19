package com.example.duotiaomu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.duotiaomu.adapter.ShowAdapter;
import com.example.duotiaomu.api.Api;
import com.example.duotiaomu.bean.Show;
import com.example.duotiaomu.contract.ContractInteface;
import com.example.duotiaomu.contract.p.ShowPresenter;
import com.google.gson.Gson;

public class MainActivity extends AppCompatActivity implements ContractInteface.ShowView {

    private RecyclerView recy_view;

    public ShowAdapter showAdapter;
    public ShowPresenter showPresenter;
    public Show show;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //初始化
         recy_view = findViewById(R.id.recy_view);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recy_view.setLayoutManager(linearLayoutManager);

        showPresenter=new ShowPresenter();
        showPresenter.bind(this,Api.ShowUrl,MainActivity.this);

        //点击跳转

    }

    @Override
    public void gerShowPresenter(String data) {
        Gson gson = new Gson();
        Show show = gson.fromJson(data, Show.class);

        showAdapter = new ShowAdapter(MainActivity.this, show);
        recy_view.setAdapter(showAdapter);

    }
}
