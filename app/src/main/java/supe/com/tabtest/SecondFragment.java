package supe.com.tabtest;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.blankj.utilcode.util.SPUtils;
import com.blankj.utilcode.util.ToastUtils;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import model.LoginMessage;
import network.NetworkManager;


public class SecondFragment extends Fragment {


    public SecondFragment() {
        // Required empty public constructor
    }
    private TextView tv;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final View view = inflater.inflate(R.layout.fragment_second, container,false);
        tv = view.findViewById(R.id.tv);

        final SPUtils spUtils = SPUtils.getInstance("file");
        String name = spUtils.getString("name");
        tv.setText(name);
        final String userName="admin";
        final String password = "123456";
        NetworkManager.getInstance().getRequestHttpApi().login(userName,password)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<LoginMessage>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(LoginMessage loginMessage) {
                        Snackbar.make(view,"登陆成功",5000).show();
                        if (loginMessage!=null){
                            spUtils.put("username",userName);
                            spUtils.put("passwor",password);
                            spUtils.put("sessionId",loginMessage.getData().getSessionId());
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        ToastUtils.showShort("登陆失败");
                    }

                    @Override
                    public void onComplete() {

                    }
                });
        return view;
    }

}
