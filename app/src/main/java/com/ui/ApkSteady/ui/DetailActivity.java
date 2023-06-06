package com.ui.ApkSteady.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.ui.ApkSteady.R;

public class DetailActivity extends BaseCommonActivity {

    private ImageView mBackIv;

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
    }
}