package com.app.base.db;

import android.content.Context;

import com.app.base.db.table.DaoMaster;
import com.app.base.db.table.DaoSession;
import com.app.library.frame.database.AbstractDaoApi;
import org.greenrobot.greendao.AbstractDao;

public class GreenDaoApi extends AbstractDaoApi {
    private DaoSession daoSession;
    public GreenDaoApi(Context mContext,String dbName) {
        DaoMaster.OpenHelper openHelper = new DaoMaster.DevOpenHelper(
                mContext.getApplicationContext(),dbName, null);
        DaoMaster daoMaster = new DaoMaster(openHelper.getWritableDatabase());
        this.daoSession=daoMaster.newSession();
    }

    public <T> AbstractDao<T, String> getDao(Class<?> entity) {
        return (AbstractDao<T, String>) this.daoSession.getDao(entity);
    }
}
