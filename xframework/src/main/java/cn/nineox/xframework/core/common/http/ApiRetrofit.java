package cn.nineox.xframework.core.common.http;

import android.content.Context;
import android.util.Log;

import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;


import cn.nineox.xframework.core.common.basebeen.APPDataPersistent;
import cn.nineox.xframework.core.common.basebeen.UserBean;
import okhttp3.Cache;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * Created by Administrator on 2017/11/14.
 */

public class ApiRetrofit {

    private static ApiRetrofit mApiRetrofit;
    private OkHttpClient mClient;


    public class AddCookiesInterceptor implements Interceptor {

        public AddCookiesInterceptor() {
            super();
        }

        @Override
        public Response intercept(Chain chain) throws IOException {
            if (chain == null)
                Log.d("http", "Addchain == null");
            final Request.Builder builder = chain.request().newBuilder();
            UserBean bean = APPDataPersistent.getInstance().getUserBean();
            if (bean.hasLogin()) {
                builder.addHeader("token", bean.getToken());
            }
            return chain.proceed(builder.build());
        }
    }

    public ApiRetrofit(Context context) {

        File httpCacheDirectory = new File(context.getCacheDir(), "responses");
        int cacheSize = 10 * 1024 * 1024; // 10 MiB
        Cache cache = new Cache(httpCacheDirectory, cacheSize);

        mClient = new OkHttpClient.Builder()
                .addInterceptor(new AddCookiesInterceptor())//添加头部信息拦截器
                .cache(cache)
                .connectTimeout(20, TimeUnit.SECONDS)
                .readTimeout(20, TimeUnit.SECONDS)
                .build();


    }

    public static ApiRetrofit getInstance(Context context) {
        if (mApiRetrofit == null) {
            synchronized (Object.class) {
                if (mApiRetrofit == null) {
                    mApiRetrofit = new ApiRetrofit(context);
                }
            }
        }
        return mApiRetrofit;
    }

    public Retrofit getmApiRetrofit(String BaseUrl) {
        return new Retrofit.Builder()
                .baseUrl(BaseUrl)
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(new GsonBuilder().create()))
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())//支持RxJava
                .client(mClient)
                .build();
    }
}

