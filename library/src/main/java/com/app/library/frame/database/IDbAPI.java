package com.app.library.frame.database;
import java.util.List;

/**
 * Created by cample on 2018/3/21.
 */

public interface IDbAPI
{

    /**添加单条数据
     * @param t
     * @return
     */
    long insert(Object t);
    /**添加单条数据
     * @param t
     * @return
     */
    long insertOrUpdate(Object t);

    /**添加多条数据
     * @param s
     */
    void insertOrReplaceTx(Object... s);

    /**删除单条数据
     * @param t
     */
    void delete(Object t);

    /**删除整张表数据
     * @param t
     */
    void deleteAll(Class<?> t);

    /**修改单条数据
     * @param t
     */
    void update(Object t);


    /**查询主键为{id}的实体
     * @param claz
     * @param id
     * @param <T>
     * @return
     */
    <T> T loadById(Class<T> claz, Long id);

    /**加载整张表数据
     * @param t
     * @param <T>
     * @return
     */
    <T> List<T> loadAll(Class<T> t);

    /**加载第一条数据
     * @param t
     * @param <T>
     * @return
     */
    <T> T loadFirst(Class<T> t);

    /**获取总条数
     * @param t
     * @return
     */
    long size(Class<Object> t);

    /**自定义查询
     * @param
     * @param t
     * @param <T>
     * @return
     */
    <T> List<T> customQuery(Class<T> t, String where, String... selectionArg);

}