package com.ui.ApkSteady;

import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.ui.ApkSteady.ui.BaseCommonActivity;
import com.ui.ApkSteady.ui.data.req.Index;
import com.ui.ApkSteady.ui.data.res.IndexRes;
import com.ui.ApkSteady.ui.fragment.AttentionFragment;
import com.ui.ApkSteady.ui.fragment.HomeFragment;
import com.ui.ApkSteady.ui.fragment.MatchFragment;
import com.ui.ApkSteady.ui.fragment.MyFragment;
import com.ui.ApkSteady.ui.utils.ConstantsUtils;
import com.ui.ApkSteady.ui.utils.LogUtils;
import com.ui.ApkSteady.ui.utils.SSLHUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import okhttp3.CipherSuite;
import okhttp3.ConnectionSpec;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.TlsVersion;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

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

    private void getcontent() throws IOException {

//        ConnectionSpec spec = new ConnectionSpec.Builder(ConnectionSpec.COMPATIBLE_TLS)
//                .tlsVersions(TlsVersion.TLS_1_2, TlsVersion.TLS_1_1, TlsVersion.TLS_1_0)
//                .cipherSuites(
//                        CipherSuite.TLS_AES_128_GCM_SHA256,
//                        CipherSuite.TLS_AES_256_GCM_SHA384,
//                        CipherSuite.TLS_CHACHA20_POLY1305_SHA256,
//                        CipherSuite.TLS_AES_128_CCM_SHA256,
//                        CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256,
//                        CipherSuite.TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256,
//                        CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384,
//                        CipherSuite.TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384,
//                        CipherSuite.TLS_ECDHE_ECDSA_WITH_CHACHA20_POLY1305_SHA256,
//                        CipherSuite.TLS_ECDHE_RSA_WITH_CHACHA20_POLY1305_SHA256,
//                        CipherSuite.TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA,
//                        CipherSuite.TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA,
//                        CipherSuite.TLS_RSA_WITH_AES_128_GCM_SHA256,
//                        CipherSuite.TLS_RSA_WITH_AES_256_GCM_SHA384,
//                        CipherSuite.TLS_RSA_WITH_AES_128_CBC_SHA,
//                        CipherSuite.TLS_RSA_WITH_AES_256_CBC_SHA,
//                        CipherSuite.TLS_RSA_WITH_3DES_EDE_CBC_SHA)
//                .allEnabledCipherSuites()
//                .build();
//        ConnectionSpec spec1 = new ConnectionSpec.Builder(ConnectionSpec.CLEARTEXT).build();
////        ConnectionSpec spec2 = new ConnectionSpec.Builder(ConnectionSpec.MODERN_TLS).build();
//        final OkHttpClient okHttpClient = new OkHttpClient.Builder()
//                .readTimeout(180, TimeUnit.SECONDS)
//                .connectTimeout(180, TimeUnit.SECONDS)
////                .addInterceptor(logging)
//                .connectionSpecs(Arrays.asList(spec, spec1))
//                .build();
//
//
//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl(ConstantsUtils.BASEURL)
//                .addConverterFactory(GsonConverterFactory.create())
//                .client(SSLHUtils.getUnsafeOkHttpClient())
////                .client(okHttpClient)
//                .build();
//        Index service = retrofit.create(Index.class);
//        Call<IndexRes> call = service.getIndex("0");
//        call.enqueue(new Callback<IndexRes>() {
//            @Override
//            public void onResponse(Call<IndexRes> call, retrofit2.Response<IndexRes> response) {
////                LogUtils.e("得到数据" + response.body().toString());
////                Toast.makeText(getApplicationContext(), "得到数据" + response.body().toString(), Toast.LENGTH_SHORT).show();
//            }
//
//            @Override
//            public void onFailure(Call<IndexRes> call, Throwable t) {
////                LogUtils.e("得到数据" + t.toString());
////                Toast.makeText(getApplicationContext(), "得到数据" + t.toString(), Toast.LENGTH_SHORT).show();
//            }
//        });


//        OkHttpClient client = new OkHttpClient().newBuilder()
//                .build();
//        MediaType mediaType = MediaType.parse("text/plain");
//        RequestBody body = RequestBody.create(mediaType, "");
//        Request request = new Request.Builder()
//                .url("http://34.80.205.147:12300/Api/Index?sportsId=0")
//                .method("GET", body)
//                .build();
////        Response response = client.newCall(request).execute();
//        LogUtils.e("得到数据" + client.newCall(request).execute().toString());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//        ButterKnife.bind(this);
//        if (!immersionModel) {
//            ImmersionBar.with(this).statusBarColor(R.color.white).statusBarDarkFont(true).fitsSystemWindows(true).init();
//        } else {
//            if (darkStatusBar) {
//                ImmersionBar.with(this).statusBarDarkFont(true).init();
//            } else {
//                ImmersionBar.with(this).init();
//            }
//        }

    }

    @Override
    protected int setLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void initData() {
        try {
            getcontent();
        } catch (Exception e) {
            e.printStackTrace();
        }

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