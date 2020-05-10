package com.example.transferdata.data.preferences;

import android.content.Context;
import android.content.SharedPreferences;

public class AppPreferenceHelper implements PreferencesHelper
{
    private SharedPreferences mPrefs;
    private static AppPreferenceHelper preferenceHelper;
    public static final String PREF_KEY_TITLE="pref_key_title";
    public static final String PREF_KEY_BODY="pref_key_body";
    public static final String PREF_KEY_uid="pref_key_uid";
    public static final String  KEY_ID="pref_id";
    private Context context;

    public AppPreferenceHelper(Context context)
    {
        this.context = context;
        mPrefs=context.getSharedPreferences("",Context.MODE_PRIVATE);

    }
    public static PreferencesHelper getInstance(Context context)
    {
        if(preferenceHelper==null)
        {
            synchronized (AppPreferenceHelper.class)
            {
                if(preferenceHelper==null)
                    preferenceHelper=new AppPreferenceHelper(context);

            }
        }
        return preferenceHelper;

    }

    @Override
    public String gettitle() {
        return mPrefs.getString(PREF_KEY_TITLE,"");
    }

    @Override
    public String getbody() {
        return mPrefs.getString(PREF_KEY_BODY,"");
    }

    @Override
    public Integer getid() {
        return mPrefs.getInt(KEY_ID,1);
    }

    @Override
    public Integer getuid() {
        return mPrefs.getInt(PREF_KEY_uid,1);
    }

    @Override
    public void settitle(String title) {
        mPrefs.edit().putString(PREF_KEY_TITLE,title).apply();

    }

    @Override
    public void setbody(String body)
    {
        mPrefs.edit().putString(PREF_KEY_BODY,body).apply();

    }

    @Override
    public void setuid(Integer uid) {
        mPrefs.edit().putInt(PREF_KEY_uid,uid).apply();

    }

    @Override
    public void setid(Integer id) {
        mPrefs.edit().putInt(KEY_ID,id).apply();

    }


    /*@Override
    public String getemail() {
       return mPrefs.getString(PREF_KEY_EMAIL,"");
    }

    @Override
    public String getfirstname() {
        return mPrefs.getString(PREF_KEY_firstname,"");
    }

    @Override
    public String getage() {
        return mPrefs.getString(PREF_KEY_AGE,"");
    }

    @Override
    public Integer getid() {
        return mPrefs.getInt(KEY_ID,1);
    }

    @Override
    public void setage(String age)
    {
        mPrefs.edit().putString(PREF_KEY_AGE,age).apply();

    }


    @Override
    public void setemail(String email) {
        mPrefs.edit().putString(PREF_KEY_EMAIL, email).apply();
    }

    @Override
    public void setfirstname(String firstname)
    {
        mPrefs.edit().putString(PREF_KEY_firstname,firstname).apply();
    }

    @Override
    public void setid(Integer id)
    {
        mPrefs.edit().putInt(KEY_ID,id).apply();
    }

     */

}
