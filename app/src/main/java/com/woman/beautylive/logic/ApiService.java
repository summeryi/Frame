package com.woman.beautylive.logic;

import cn.nineox.xframework.core.common.basebeen.BaseResponse;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

public interface ApiService {

    String LOGIN_DATA = "/wxLogin";

    /**
     * 登录
     *
     * @return
     */
    @GET(LOGIN_DATA)
    Observable<BaseResponse<LoginInfoBean>> login(@Query("code") String code);


}
