package supe.com.tabtest;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import network.NetworkManager;

/**
 * Created by Zaifeng on 2018/3/1.
 */

public class BaseApplication extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        NetworkManager.getInstance().create();
    }
}
