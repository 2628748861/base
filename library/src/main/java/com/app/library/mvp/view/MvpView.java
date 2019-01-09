package com.app.library.mvp.view;
import android.content.DialogInterface;

/**
 * Created by cample on 2018/5/12.
 */
public interface MvpView
{
     void onDetach();
    //加载状态[加载中,加载失败,无数据,加载成功]
     void showLoading();
     void showError();
     void showEmpty();
     void showContent();

    //提交状态[提交中]
     void showCommiting();
     void dissmissCommiting();
     //显示确认框
     void showConfirmDialog(String msg, String cancel, DialogInterface.OnClickListener cancelListener, String confirm, DialogInterface.OnClickListener confirmListener);
     void showTip(String msg);


}
