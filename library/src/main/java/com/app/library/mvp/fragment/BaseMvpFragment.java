package com.app.library.mvp.fragment;

import com.app.library.mvp.presenter.MvpPresenter;
import com.app.library.mvp.view.MvpView;
import com.app.library.mvp.view.delegate.DefaultViewDelegateImp;

public abstract class BaseMvpFragment<Presenter extends MvpPresenter> extends MvpFragment<Presenter> {
    @Override
    protected MvpView applyViewDelegate() {
        return new DefaultViewDelegateImp(this);
    }
}
