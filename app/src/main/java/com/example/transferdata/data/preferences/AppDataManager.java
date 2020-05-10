package com.example.transferdata.data.preferences;

import android.content.Context;

import com.example.transferdata.data.api.ApiHelper;
import com.example.transferdata.data.models.UserResponse;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;

public class AppDataManager implements DataManagerHelper
{

  private AppPreferenceHelper preferenceHelper;
  private ApiHelper apiHelper;


  private Context context;
  private static final String TAG="AppDataManager";

  private static AppDataManager instance;
    public AppDataManager(Context context)
    {
        this.context = context;
        apiHelper=ApiHelper.getInstance(context);
       preferenceHelper= (AppPreferenceHelper) AppPreferenceHelper.getInstance(context);

    }
   /* public static AppDataManager getInstance(Context context)
    {
        if(instance==null)
        {
            synchronized (AppDataManager.class)
            {
                if(instance==null)
                {
                    instance=new AppDataManager(context);

                }
            }
        }
        return instance;

    }*/

    @Override
    public Call<ArrayList<UserResponse>> getUserList()
    {
        return apiHelper.getUserList();

    }
    @Override
    public String gettitle() {
        return preferenceHelper.gettitle();
    }

    @Override
    public String getbody() {
        return preferenceHelper.getbody();
    }

    @Override
    public Integer getid() {
        return preferenceHelper.getid();
    }

    @Override
    public Integer getuid() {
        return preferenceHelper.getuid();
    }

    @Override
    public void settitle(String title) {
        preferenceHelper.settitle(title);
    }

    @Override
    public void setbody(String body) {
        preferenceHelper.setbody(body);
    }
    @Override
    public void setuid(Integer uid) {
        preferenceHelper.setuid(uid);
    }

    @Override
    public void setid(Integer id) {
        preferenceHelper.setid(id);

    }


    /*
    @Override
    public String getemail()
    {
       return preferenceHelper.getemail();
    }

    @Override
    public String getfirstname() {
       return preferenceHelper.getfirstname();
    }

    @Override
    public String getage() {
      return   preferenceHelper.getage();
    }

    @Override
    public Integer getid() {
        return preferenceHelper.getid();
    }

    @Override
    public void setage(String age)
    {
        preferenceHelper.setage(age);
    }

    @Override
    public void setemail(String email)
    {
        preferenceHelper.setemail(email);

    }

    @Override
    public void setfirstname(String firstname)
    {
        preferenceHelper.setfirstname(firstname);

    }

    @Override
    public void setid(Integer id)
    {
        preferenceHelper.setid(id);

    }
    */

}
