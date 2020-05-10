package com.example.transferdata.data.api;

import android.content.Context;

import com.example.transferdata.data.models.UserResponse;
import com.example.transferdata.retrofit.RetrofitClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;

public class ApiHelper implements ApiService
{
    private static ApiHelper instance;
    private ApiService api;
    public ApiHelper()
    {
        api= RetrofitClient.getInstance().create(ApiService.class);
    }
    public static ApiHelper getInstance(Context context)
    {
        if(instance==null)
        {
            synchronized (ApiHelper.class)
            {
                if(instance==null)
                {
                    instance=new ApiHelper();

                }
            }
        }
        return instance;

    }

    @Override
    public Call<ArrayList<UserResponse>> getUserList()
    {
        return api.getUserList();

    }
}
