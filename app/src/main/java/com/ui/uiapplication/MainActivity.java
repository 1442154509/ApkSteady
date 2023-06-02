package com.ui.uiapplication;

import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.ui.uiapplication.ui.dashboard.MatchFragment;
import com.ui.uiapplication.ui.home.HomeFragment;
import com.ui.uiapplication.ui.my.MyFragment;
import com.ui.uiapplication.ui.notifications.AttentionFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    //    private ActivityMainBinding binding;
    private ViewPager viewPager;
    private RadioGroup radioGroup;


    private List<Fragment> pagelist;
    private RadioButton rHome;
    private RadioButton rMatch;
    private RadioButton rAttention;
    private RadioButton rMy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager = findViewById(R.id.home_view);
        radioGroup = findViewById(R.id.rg_vertical);
        pagelist = new ArrayList<>();
        //为viewpager设置适配器
        pagelist = new ArrayList<>();
        pagelist.add(new HomeFragment());
        pagelist.add(new MatchFragment());
        pagelist.add(new AttentionFragment());
        pagelist.add(new MyFragment());

        radioGroup.setClickable(true);
        rHome = (RadioButton) findViewById(R.id.rb_title_home);
        rMatch = (RadioButton) findViewById(R.id.rb_title_home);
        rAttention = (RadioButton) findViewById(R.id.rb_title_home);
        rMy = (RadioButton) findViewById(R.id.rb_title_home);
        //设置选中
        rHome.setChecked(true);
        viewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @NonNull
            @Override
            //得到显示页面的位置
            public Fragment getItem(int position) {
                return pagelist.get(position);
            }

            @Override
            public int getCount() {
                return pagelist.size();
            }
        });
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            //当页面左右滚动时会触发
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            //页面已经滑动成功了，手指抬起来时会触发，position表示当前滑动到的页面，页面从0-len-1
            public void onPageSelected(int position) {
                //radioGroup的getChildAt方法，字button的序号从0开始，按照布局中定义，从0依次递增
                RadioButton radioButton = (RadioButton) radioGroup.getChildAt(position);
                radioButton.setChecked(true);
            }

            @Override
            //state为0 1 2当用手指滑动翻页时，手指按下去的时候会触发这个方法，state值为1，手指抬起时，如果发生了滑动（即使很小），这个值会变为2，
            // 然后最后变为0 。总共执行这个方法三次。一种特殊情况是手指按下去以后一点滑动也没有发生，这个时候只会调用这个方法两次，state值分别是1,0
            public void onPageScrollStateChanged(int state) {

            }
        });
        //设置监听器
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                for (int j = 0; j < radioGroup.getChildCount(); j++) {
                    if (radioGroup.getChildAt(j).getId() == i) {
                        viewPager.setCurrentItem(j);
                        return;
                    }
                }
            }
        });
    }

}