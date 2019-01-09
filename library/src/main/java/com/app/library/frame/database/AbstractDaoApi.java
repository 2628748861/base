package com.app.library.frame.database;

import android.content.Context;

import org.greenrobot.greendao.AbstractDao;
import java.util.List;

/**
 * Created by cample on 2018/3/21.
 */

public abstract class AbstractDaoApi implements IDbAPI
{
    public abstract  <T> AbstractDao<T, String> getDao(Class<?> entity);

    @Override
    public long insert(Object t) {
        return getDao(t.getClass()).insert(t);
    }

    @Override
    public long insertOrUpdate(Object t) {
        return getDao(t.getClass()).insertOrReplace(t);
    }

    @Override
    public void insertOrReplaceTx(Object... s) {
        getDao(s[0].getClass()).insertOrReplaceInTx(s);
    }

    @Override
    public void delete(Object t) {
        getDao(t.getClass()).delete(t);
    }

    @Override
    public void deleteAll(Class<?> t) {
        getDao(t).deleteAll();
    }

    @Override
    public void update(Object t) {
        getDao(t.getClass()).update(t);
    }

    @Override
    public <T> T loadById(Class<T> claz, Long id) {
        return (T)getDao(claz).loadByRowId(id);
    }

    @Override
    public <T> List<T> loadAll(Class<T> t) {
        return (List<T>) getDao(t).loadAll();
    }

    @Override
    public <T> T loadFirst(Class<T> t) {
        List<T> list=loadAll(t);
        return list==null||list.isEmpty()?null:list.get(0);
    }

    @Override
    public long size(Class<Object> t) {
        return getDao(t).count();
    }

    @Override
    public <T> List<T> customQuery(Class<T> t,String where, String... selectionArg) {
        return (List<T>)getDao(t).queryRaw(where, selectionArg);
    }
}
