package com.ui.ApkSteady;

import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.ui.ApkSteady.ui.BaseCommonActivity;
import com.ui.ApkSteady.ui.fragment.AttentionFragment;
import com.ui.ApkSteady.ui.fragment.HomeFragment;
import com.ui.ApkSteady.ui.fragment.MatchFragment;
import com.ui.ApkSteady.ui.fragment.MyFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseCommonActivity {

    @BindView(R.id.viewpage_main)
    ViewPager viewPager;
    @BindView(R.id.radiogroup_main_bottom)
    RadioGroup radioGroup;
    @BindView(R.id.radiobutton_main_home_bottom)
    RadioButton rbHome;
    @BindView(R.id.radiobutton_main_match_bottom)
    RadioButton rbMatch;
    @BindView(R.id.radiobutton_main_attention_bottom)
    RadioButton rbAttention;
    @BindView(R.id.radiobutton_main_my_bottom)
    RadioButton rbMy;


    private List<Fragment> pagelist;
    public boolean darkStatusBar = true;//当是沉浸式状态栏时，状态栏字体是否黑色字体，false时表示白色字体，true表示黑色字体
    boolean immersionModel = true;//是否是沉浸式状态栏，true时表示是沉浸式

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
//        if (!immersionModel) {
//            ImmersionBar.with(this).statusBarColor(R.color.white).statusBarDarkFont(true).fitsSystemWindows(true).init();
//        } else {
//            if (darkStatusBar) {
//                ImmersionBar.with(this).statusBarDarkFont(true).init();
//            } else {
//                ImmersionBar.with(this).init();
//            }
//        }
        pagelist = new ArrayList<>();
        //为viewpager设置适配器
        pagelist = new ArrayList<>();
        pagelist.add(new HomeFragment());
        pagelist.add(new MatchFragment());
        pagelist.add(new AttentionFragment());
        pagelist.add(new MyFragment());

        radioGroup.setClickable(true);
        //设置选中
        rbHome.setChecked(true);
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