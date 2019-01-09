package com.app.base.mvp.presenter;

import com.app.base.api.IUserService;
import com.app.base.db.DbApiProxy;
import com.app.base.db.table.User;
import com.app.base.mvp.view.MainView;
import com.app.base.request.HttpApiProxy;
import com.app.library.frame.request.after.AppResultObservable;
import com.app.library.frame.request.entity.BaseResponseEntity;
import com.app.library.mvp.presenter.MvpPresenter;
import com.app.library.util.RxUtils;
import com.google.gson.internal.LinkedTreeMap;
import java.util.List;


public class MainPresenter extends MvpPresenter<MainView.View> implements MainView.Presenter {
    public MainPresenter(MainView.View view) {
        super(view);
    }

    @Override
    public void request(String params) {
        HttpApiProxy.getInstance()
                .create(IUserService.class)
                .getArticleCategory()
                .compose(RxUtils.schedulerWithDialog(compositeDisposable,v))
                .subscribe(new AppResultObservable<BaseResponseEntity<List<LinkedTreeMap<String,String>>>>() {
                    @Override
                    public void onSuccess(BaseResponseEntity<List<LinkedTreeMap<String, String>>> listBaseResponseEntity) {
                        v.notifyTextView("success："+listBaseResponseEntity.getData().size());
                    }
                    @Override
                    public void onErrors(String msg) {
                        v.notifyTextView(msg);
                    }
                });
    }

    @Override
    public void addUser(User user) {
        DbApiProxy.getInstance().insert(user);
    }

    @Override
    public List<User> queryAll() {
        return DbApiProxy.getInstance().loadAll(User.class);
    }
}
