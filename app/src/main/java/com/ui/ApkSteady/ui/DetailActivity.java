package com.ui.ApkSteady.ui;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.ViewStub;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ui.ApkSteady.R;
import com.ui.ApkSteady.ui.adapter.DetailMatchAdapter;
import com.ui.ApkSteady.ui.data.HomeAllBean;
import com.ui.ApkSteady.ui.data.MyData;
import com.ui.ApkSteady.ui.view.LinearSpacingItemDecoration;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DetailActivity extends BaseCommonActivity {
    @BindView(R.id.vs_nodiscuss)
    ViewStub vsNodiscuss;
    @BindView(R.id.vs_matchdata)
    ViewStub vsMatchdata;
    private int CONTAINSTATE = 2;//0无评论，1有评论，2比赛数据
    private List<MyData> list;
    private Bundle mBundle;
    private HomeAllBean homeAllBean;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.my_fragment);
        setContentView(R.layout.activity_matchdetail);
        ButterKnife.bind(this);
        mBundle = getIntent().getExtras();
        homeAllBean = (HomeAllBean) mBundle.getSerializable("homeallbean");


//        mBackIv.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                finish();
//            }
//        });

        switch (CONTAINSTATE) {
            case 0:
                vsNodiscuss = (ViewStub) findViewById(R.id.vs_nodiscuss);
                vsNodiscuss.inflate();
                break;
            case 1:
                break;
            case 2:
                vsMatchdata = (ViewStub) findViewById(R.id.vs_matchdata);
                vsMatchdata.inflate();

                RecyclerView recyclerView = (RecyclerView) findViewById(R.id.detail_match_item);
                recyclerView.setLayoutManager(new LinearLayoutManager(this));
                createData();
                recyclerView.addItemDecoration(new LinearSpacingItemDecoration(this, 10));
                DetailMatchAdapter adapter = new DetailMatchAdapter(this, list);
                recyclerView.setAdapter(adapter);

                break;
            default:
                vsNodiscuss = (ViewStub) findViewById(R.id.vs_nodiscuss);
                vsNodiscuss.inflate();
        }

    }

    //创造数据
    private void createData() {
        //球队排名,进球分布,历史交锋,近期战绩,对战详情
        list = new ArrayList<>();
        MyData data1 = new MyData("球队排名", R.mipmap.detail_team_logo_england, 0);
        MyData data2 = new MyData("莱斯特城", R.mipmap.detail_team_logo_england, 0);
        MyData data3 = new MyData("布莱顿", R.mipmap.detail_team_logo_england, 0);
        MyData data4 = new MyData("进球分布", R.mipmap.detail_team_logo_england, 1);
        MyData data5 = new MyData("布莱顿VS", R.mipmap.detail_team_logo_england, 1);
        MyData data6 = new MyData("布莱顿", R.mipmap.detail_team_logo_england, 1);
        MyData data7 = new MyData("莱斯特城", R.mipmap.detail_team_logo_england, 1);
        MyData data8 = new MyData("莱斯特城", R.mipmap.detail_team_logo_england, 1);
        MyData data9 = new MyData("莱斯特城", R.mipmap.detail_team_logo_england, 1);
        MyData data10 = new MyData("莱斯特城", R.mipmap.detail_team_logo_england, 1);
        MyData data11 = new MyData("莱斯特城", R.mipmap.detail_team_logo_england, 1);
        MyData data12 = new MyData("历史交锋", R.mipmap.detail_team_logo_england, 2);
        MyData data13 = new MyData("莱斯特城his", R.mipmap.detail_team_logo_england, 2);
        MyData data14 = new MyData("莱斯特城", R.mipmap.detail_team_logo_england, 2);
        MyData data15 = new MyData("莱斯特城", R.mipmap.detail_team_logo_england, 2);
        MyData data16 = new MyData("莱斯特城", R.mipmap.detail_team_logo_england, 2);
        MyData data17 = new MyData("近期战绩", R.mipmap.detail_team_logo_england, 3);
        MyData data18 = new MyData("莱斯特城绩VS", R.mipmap.detail_team_logo_england, 3);
        MyData data19 = new MyData("布莱顿VS", R.mipmap.detail_team_logo_england, 3);
        MyData data20 = new MyData("对战详情", R.mipmap.detail_team_logo_england, 4);
        MyData data21 = new MyData("莱斯特城his", R.mipmap.detail_team_logo_england, 4);
        MyData data22 = new MyData("莱斯特城", R.mipmap.detail_team_logo_england, 4);
        MyData data23 = new MyData("莱斯特城", R.mipmap.detail_team_logo_england, 4);
        MyData data24 = new MyData("莱斯特城", R.mipmap.detail_team_logo_england, 4);
        MyData data25 = new MyData("布莱顿his", R.mipmap.detail_team_logo_england, 4);
        MyData data26 = new MyData("布莱顿", R.mipmap.detail_team_logo_england, 4);
        MyData data27 = new MyData("布莱顿", R.mipmap.detail_team_logo_england, 4);
        MyData data28 = new MyData("布莱顿", R.mipmap.detail_team_logo_england, 4);

        list.add(data1);
        list.add(data2);
        list.add(data3);
        list.add(data4);
        list.add(data5);
        list.add(data6);
        list.add(data7);
        list.add(data8);
        list.add(data9);
        list.add(data10);
        list.add(data11);
        list.add(data12);
        list.add(data13);
        list.add(data14);
        list.add(data15);
        list.add(data16);
        list.add(data17);
        list.add(data18);
        list.add(data19);
        list.add(data20);
        list.add(data21);
        list.add(data22);
        list.add(data23);
        list.add(data24);
        list.add(data25);
        list.add(data26);
        list.add(data27);
        list.add(data28);

    }

    @OnClick(R.id.iv_detail_back)
    public void onClick() {
        finish();
    }
}