package supe.com.tabtest;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    private FirstFragment firstFragment =new FirstFragment();
    private SecondFragment secondFragment =new SecondFragment();
    private TabAdapter tabAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initToolbar();
        initView();
    }

    private void initView() {
        ArrayList<String> tabList= new ArrayList<>();
        tabList.add("TabOne");
        tabList.add("TabTow");
        ArrayList<Fragment> fragments =new ArrayList<>();
        fragments.add(firstFragment);
        fragments.add(secondFragment);
        tabAdapter = new TabAdapter(getSupportFragmentManager(),tabList,fragments);

        tabLayout = findViewById(R.id.tabLayout);
        viewPager = findViewById(R.id.viewPager);
        //给tabLayout添加图标 没有实现
//        tabLayout.addTab(tabLayout.newTab().setText(tabList.get(0)).setIcon(R.mipmap.ic_launcher));
//        tabLayout.addTab(tabLayout.newTab().setText(tabList.get(1)).setIcon(R.mipmap.ic_launcher));
        viewPager.setAdapter(tabAdapter);//给viewPager设置适配器
        viewPager.setCurrentItem(1);
        tabLayout.setupWithViewPager(viewPager);//关联viewPager宇tabLayout
        tabLayout.setTabsFromPagerAdapter(tabAdapter); //给tabLayout设置适配器

    }

    private void initToolbar() {
        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("TabTest");
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }
}