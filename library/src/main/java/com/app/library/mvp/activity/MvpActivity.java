package com.app.library.mvp.activity;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.View;

import com.app.library.mvp.presenter.MvpPresenter;
import com.app.library.mvp.view.MvpView;


/**
 * Created by cample on 2018/6/21.
 */
public abstract class MvpActivity<Presenter extends MvpPresenter> extends FragmentActivity implements MvpView
{
    protected Presenter p;
    protected Context mContext;
    protected View contentView;
    private MvpView viewDelegate;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext=this;
        if(applyContent()!=0)
        {
            contentView=getLayoutInflater().inflate(applyContent(),null,false);
            setContentView(contentView);
        }
        //设置View代理实现 [用户自由设置]
        viewDelegate=applyViewDelegate();
        p=createPresenter();
    }
    public abstract int applyContent();
    public abstract Presenter createPresenter();
    protected MvpView applyViewDelegate()
    {
        return null;
    }

    public View getContentView() {
        return contentView;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(p!=null)
        p.onDetach();
        if(viewDelegate!=null)
            viewDelegate.onDetach();
        viewDelegate=null;
        p=null;
        mContext=null;
    }
    @Override
    public void showConfirmDialog(String msg, String cancle, DialogInterface.OnClickListener cancleListener, String confirm, DialogInterface.OnClickListener confirmListener) {
        if(check())return;
        viewDelegate.showConfirmDialog(msg, cancle, cancleListener, confirm, confirmListener);
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
    public void showEmpty() {
        if(check())return;
        viewDelegate.showEmpty();
    }

    @Override
    public void showContent() {
        if(check())return;
        viewDelegate.showContent();
    }

    @Override
    public void showLoading() {
        if(check())return;
        viewDelegate.showLoading();
    }

    @Override
    public void showError() {
        if(check())return;
        viewDelegate.showError();
    }

    @Override
    public void onDetach() {
        if(check())return;
        viewDelegate.onDetach();
    }

    private boolean check()
    {
        return viewDelegate==null||isFinishing();
    }
}
