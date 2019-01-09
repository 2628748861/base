package com.app.library.util;


import com.app.library.mvp.view.MvpView;

import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by REN.BIN on 2018/8/22.
 */
public class RxUtils {
    public static <T> ObservableTransformer<T, T> scheduler(CompositeDisposable compositeDisposable) {
        return upstream -> upstream.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe(d->compositeDisposable.add(d));
    }


    public static <T> ObservableTransformer<T, T> schedulerWithDialog(CompositeDisposable compositeDisposable, MvpView mvpView) {
        return upstream -> upstream.doOnSubscribe(disposable -> mvpView.showCommiting())
                .subscribeOn(AndroidSchedulers.mainThread())
                .observeOn(AndroidSchedulers.mainThread())
                .doFinally(mvpView::dissmissCommiting)
                .doOnSubscribe(d->compositeDisposable.add(d));
    }
}
