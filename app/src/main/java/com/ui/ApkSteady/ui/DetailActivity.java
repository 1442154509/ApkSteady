package com.ui.ApkSteady.ui;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ui.ApkSteady.R;
import com.ui.ApkSteady.ui.adapter.DetailMatchAdapter;
import com.ui.ApkSteady.ui.data.MyData;

import java.util.ArrayList;
import java.util.List;

public class DetailActivity extends BaseCommonActivity {

    private ImageView mBackIv;
    private ViewStub stubNoDiscuss, stubMatchData;
    private int CONTAINSTATE = 2;//0无评论，1有评论，2比赛数据
    private List<MyData> list;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.my_fragment);
        setContentView(R.layout.match_detail_activity);

        mBackIv = findViewById(R.id.imageView_detail_back);
        mBackIv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        switch (CONTAINSTATE) {
            case 0:
                stubNoDiscuss = (ViewStub) findViewById(R.id.viewstub_detail_contain_nodiscuss);
                stubNoDiscuss.inflate();
                break;
            case 1:
                break;
            case 2:
                stubMatchData = (ViewStub) findViewById(R.id.viewstub_detail_contain_matchdata);
                stubMatchData.inflate();

                RecyclerView recyclerView = (RecyclerView) findViewById(R.id.detail_match_item);
                recyclerView.setLayoutManager(new LinearLayoutManager(this));
                createData();
                DetailMatchAdapter adapter = new DetailMatchAdapter(this, list);
                recyclerView.setAdapter(adapter);

                break;
            default:
                stubNoDiscuss = (ViewStub) findViewById(R.id.viewstub_detail_contain_nodiscuss);
                stubNoDiscuss.inflate();
        }

    }

    //创造数据
    private void createData() {
        list = new ArrayList<>();
        MyData data1 = new MyData("布莱顿", R.mipmap.detail_team_logo_england, 0);
        MyData data2 = new MyData("莱斯特城", R.mipmap.detail_team_logo_england, 0);
        MyData data3 = new MyData("布莱顿", R.mipmap.detail_team_logo_england, 0);
        MyData data7 = new MyData("进球分布", R.mipmap.detail_team_logo_england, 0);
        MyData data8 = new MyData("莱斯特城", R.mipmap.detail_team_logo_england, 0);
        MyData data4 = new MyData("hey,woman", R.mipmap.team_logo_brighton, 1);
        MyData data5 = new MyData("what are you 弄啥呢", R.mipmap.detail_team_logo_england, 1);
        MyData data6 = new MyData("I want to 那个", R.mipmap.team_logo_brighton, 0);

        list.add(data1);
        list.add(data2);
        list.add(data3);
        list.add(data7);
        list.add(data8);
        list.add(data4);
        list.add(data5);
        list.add(data6);


    }
}