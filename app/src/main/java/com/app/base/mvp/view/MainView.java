package com.app.base.mvp.view;

import com.app.base.db.table.User;
import com.app.library.mvp.view.MvpView;
import java.util.List;

public interface MainView {
    interface Presenter{
        void request(String params);
        void addUser(User user);
        List<User> queryAll();
    }
    interface View extends MvpView
    {
        void notifyTextView(String str);
        void refreshImg();
    }
}
