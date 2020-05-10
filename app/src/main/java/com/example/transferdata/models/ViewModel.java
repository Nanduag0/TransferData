package com.example.transferdata.models;

import android.app.Application;
import android.content.Context;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.transferdata.R;
import com.example.transferdata.data.models.UserResponse;
import com.example.transferdata.data.preferences.AppDataManager;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ViewModel extends AndroidViewModel {


    private static final String TAG = "ViewModel";
    private AppDataManager appDataManager;
    private MutableLiveData<ArrayList<UserResponse>> userList;

    public ViewModel(@NonNull Application application)
    {
        super(application);
        appDataManager = ((MyApplication) application).getDataManager();
        userList = new MutableLiveData<>();

    }

    public MutableLiveData<ArrayList<UserResponse>> getUserList()
    {
        return userList;
    }

    public void getusers()
    {
        appDataManager.getUserList().enqueue(new Callback<ArrayList<UserResponse>> () {
            @Override

            public void onResponse(Call<ArrayList<UserResponse>> call, Response<ArrayList<UserResponse>> response) {

                if (response.code() == 200)
                {
                    userList.setValue(response.body());
                }
                else
                    userList.setValue(null);
                //Toast.makeText(getApplication(),"Response::"+response.body(),Toast.LENGTH_LONG).show();
                ArrayList<UserResponse> posts=response.body();
                for(UserResponse post : posts)
                {
                    String s = post.getTitle();
                    String si=post.getBody();
                    int x=post.getId();
                  //  Toast.makeText(getApplication(),"Title"+s,Toast.LENGTH_LONG).show();
                    //Toast.makeText(getApplication(),"Body"+si,Toast.LENGTH_LONG).show();
                    //Toast.makeText(getApplication(),"no"+x,Toast.LENGTH_LONG).show();
                    //Log.d(TAG,si);
                    //Log.d("Title",s);
                }
            }

            @Override
            public void onFailure(Call<ArrayList<UserResponse>> call, Throwable t) {
                userList.setValue(null);
                Log.d(TAG,"Error fetching events");

                Toast.makeText(getApplication(),"mkwdene"+t.toString(),Toast.LENGTH_LONG).show();
            }
        });
    }
}

                /*UserResponse>() {
            @Override
            public void onResponse(Call<UserResponse> call, Response<UserResponse> response)
            {
                if(response.code()<300)
                {
                    userList.postValue(response.body());
                }
                else
                    userList.postValue(null);

            }

            @Override
            public void onFailure(Call<UserResponse> call, Throwable t)
            {
                userList.postValue(null);

            }
        });
    }*/



