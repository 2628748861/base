package com.app.library.mvp.activity;
import com.app.library.mvp.presenter.MvpPresenter;
import com.app.library.mvp.view.MvpView;
import com.app.library.mvp.view.delegate.DefaultViewDelegateImp;

public abstract class BaseMvpActivity<Presenter extends MvpPresenter> extends MvpActivity<Presenter> {
    @Override
    protected MvpView applyViewDelegate() {
        return new DefaultViewDelegateImp(this);
    }
}
