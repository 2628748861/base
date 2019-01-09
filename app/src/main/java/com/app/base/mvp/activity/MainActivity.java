package com.app.base.mvp.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ImageView;
import android.widget.TextView;
import com.app.base.R;
import com.app.base.db.DbApiProxy;
import com.app.base.db.GreenDaoApi;
import com.app.base.mvp.presenter.MainPresenter;
import com.app.base.mvp.view.MainView;
import com.app.base.request.HttpApiProxy;
import com.app.base.request.RetrofitApi;
import com.app.library.mvp.activity.BaseMvpActivity;
import butterknife.BindView;

public class MainActivity extends BaseMvpActivity<MainPresenter> implements MainView.View {

    @BindView(R.id.textview)
    TextView textview;

    @BindView(R.id.imageview)
    ImageView imageview;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        HttpApiProxy.init(new RetrofitApi());
        DbApiProxy.init(new GreenDaoApi(mContext,"a.db"));

        refreshImg();

        p.request("");

//        User user=new User();
//        user.setName("张三");
//        p.addUser(user);

//        List<User> users=p.queryAll();
//        Log.e("TAG","users:"+users);

    }

    @Override
    public int applyContent() {
        return R.layout.activity_main;
    }

    @Override
    public MainPresenter createPresenter() {
        return new MainPresenter(this);
    }

    @Override
    public void notifyTextView(String str) {
        textview.setText(str);
    }

    @Override
    public void refreshImg() {
       // ImageLoaderProxy.getInstance().display(mContext,"https://ss1.baidu.com/6ONXsjip0QIZ8tyhnq/it/u=3402268747,3143931720&fm=85&app=57&f=JPEG?w=121&h=75&s=B103D014D4B4CF861F66D9CA030020BF",imageview);
    }
}
