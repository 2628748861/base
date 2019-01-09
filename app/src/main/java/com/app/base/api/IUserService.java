package com.app.base.api;


import com.app.library.frame.request.entity.BaseResponseEntity;
import com.google.gson.internal.LinkedTreeMap;
import java.util.List;
import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by cample on 2018/6/12.
 */

public interface IUserService {
    @GET("/api/community/article/list/categories")
    Observable<BaseResponseEntity<List<LinkedTreeMap<String,String>>>> getArticleCategory();

}
