package com.app.library.mvp.view.delegate;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ProgressBar;
import com.app.library.mvp.activity.MvpActivity;
import com.app.library.mvp.fragment.LazyFrament;
import com.app.library.mvp.view.MvpView;
import com.app.library.widght.Toasty;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import ezy.ui.layout.LoadingLayout;

public class DefaultViewDelegateImp implements MvpView {
    protected Context mContext;
    private Unbinder unbinder;
    private AlertDialog alertDialog;
    private LoadingLayout loadinglayout;

    public DefaultViewDelegateImp(LazyFrament t) {
        this.mContext=t.getContext();
        unbinder= ButterKnife.bind(t,t.getContentView());
        loadinglayout=(LoadingLayout) getChildA(t.getContentView());
    }
    public DefaultViewDelegateImp(Activity t) {
        this.mContext=t;
        unbinder= ButterKnife.bind(t);
        loadinglayout=(LoadingLayout) getChildA(((MvpActivity)t).getContentView());
    }
    private View getChildA(View view) {
        if (view instanceof ViewGroup) {
            ViewGroup vp = (ViewGroup) view;
            for (int i = 0; i < vp.getChildCount(); i++) {
                View viewchild = vp.getChildAt(i);
                if(viewchild instanceof LoadingLayout)
                {
                    return viewchild;
                }
                else{
                    getChildA(viewchild);
                }
            }
        }
        return null;
    }


    @Override
    public void onDetach() {
        unbinder.unbind();
        unbinder=null;
        loadinglayout=null;
    }

    @Override
    public void showLoading() {
        if(isNull())return;
        loadinglayout.showLoading();
    }

    @Override
    public void showError() {
        if(isNull())return;
        loadinglayout.showError();
    }

    @Override
    public void showEmpty() {
        if(isNull())return;
        loadinglayout.showEmpty();
    }

    @Override
    public void showContent() {
        if(isNull())return;
        loadinglayout.showContent();
    }

    @Override
    public void showCommiting() {
        alertDialog=new AlertDialog.Builder(mContext)
                .setView(new ProgressBar(mContext))
                .setCancelable(false)
                .create();
        alertDialog.show();
        Window window=alertDialog.getWindow();
        window.setBackgroundDrawableResource(android.R.color.transparent);
    }

    @Override
    public void dissmissCommiting() {
        if(alertDialog!=null&&alertDialog.isShowing())
            alertDialog.dismiss();
    }

    @Override
    public void showConfirmDialog(String msg, String cancel, DialogInterface.OnClickListener cancelListener, String confirm, DialogInterface.OnClickListener confirmListener) {
        alertDialog=new AlertDialog.Builder(mContext)
                .setMessage(msg)
                .setNegativeButton(cancel,cancelListener)
                .setPositiveButton(confirm,confirmListener)
                .create();
        alertDialog.show();
    }

    @Override
    public void showTip(String msg) {
        Toasty.showTip(mContext,msg);
    }

    private boolean isNull(){
        return loadinglayout==null;
    }
}

