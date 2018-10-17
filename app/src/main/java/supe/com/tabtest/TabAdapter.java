package supe.com.tabtest;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

public class TabAdapter extends FragmentPagerAdapter {
    private ArrayList<String> tabList;
    private ArrayList<Fragment> fragmentList;
    public TabAdapter(FragmentManager fm ,ArrayList<String> tabList,ArrayList<Fragment> fragmentList) {
        super(fm);
        this.tabList = tabList;
        this.fragmentList = fragmentList;
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return tabList.get(position);
    }
}
