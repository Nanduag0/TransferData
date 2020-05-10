package com.example.transferdata.retrofit;

import android.content.Context;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    private static Retrofit.Builder builder;
    private static Retrofit instance = null;

    public static Retrofit getInstance() {
        if (instance == null) {
            synchronized (RetrofitClient.class) {
                if (instance == null) {
                  OkHttpClient okHttpClient = new OkHttpClient.Builder().addInterceptor(new Interceptor() {
                        @Override
                        public Response intercept(Chain chain) throws IOException
                        {
                            Request original = chain.request();
                            Request request = original.newBuilder().method(original.method(), original.body()).build();
                            return chain.proceed(request);
                        }
                    }).readTimeout(60, TimeUnit.SECONDS).connectTimeout(60, TimeUnit.SECONDS).build();

                    builder = new Retrofit.Builder()
                            .baseUrl("http://jsonplaceholder.typicode.com/")
                            .client(okHttpClient)
                            .addConverterFactory(GsonConverterFactory.create());
                    instance = builder.build();
                }
            }
        }
        return instance;
    }
}
