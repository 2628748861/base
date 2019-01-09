package com.app.library.mvp.fragment;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;

import com.app.library.mvp.presenter.MvpPresenter;
import com.app.library.mvp.view.MvpView;


/**
 * Created by cample on 2018/6/21.
 */

public abstract class MvpFragment<Presenter extends MvpPresenter> extends LazyFrament implements MvpView
{
    protected Presenter p;
    protected Context mContext;
    private MvpView viewDelegate;

    @Override
    protected void onCreateViewLazy(Bundle savedInstanceState) {
        super.onCreateViewLazy(savedInstanceState);
        mContext=getContext();
        if(applyContent()!=0) {
            setContentView(applyContent());
        }
        //设置View代理实现 [用户自由设置]
        viewDelegate=applyViewDelegate();
        //设置Presenter [用户自由设置]
        p=createPresenter();
    }

    public abstract int applyContent();
    public abstract Presenter createPresenter();
    protected MvpView applyViewDelegate()
    {
        return null;
    }
    @Override
    protected void onDestroyViewLazy() {
        super.onDestroyViewLazy();
        if (viewDelegate!=null)
            viewDelegate.onDetach();
        if(p!=null)
        p.onDetach();
        p=null;
        viewDelegate=null;
        mContext=null;
    }
    @Override
    public void showTip( String msg) {
        if(check())return;
         viewDelegate.showTip(msg);
    }
    @Override
    public void showCommiting() {
        if(check())return;
        viewDelegate.showCommiting();
    }

    @Override
    public void dissmissCommiting() {
        if(check())return;
        viewDelegate.dissmissCommiting();
    }

    @Override
    public void showConfirmDialog(String msg, String cancle, DialogInterface.OnClickListener cancleListener, String confirm, DialogInterface.OnClickListener confirmListener) {
        if(check())return;
        viewDelegate.showConfirmDialog(msg, cancle, cancleListener, confirm, confirmListener);
    }

    @Override
    public void showLoading() {
        if(check())return;
        viewDelegate.showLoading();
    }

    @Override
    public void showContent() {
        if(check())return;
        viewDelegate.showContent();
    }

    @Override
    public void showEmpty() {
        if(check())return;
        viewDelegate.showEmpty();
    }

    @Override
    public void showError() {
        if(check())return;
        viewDelegate.showError();
    }
    private boolean check()
    {
        return viewDelegate==null||isDetached();
    }

}
