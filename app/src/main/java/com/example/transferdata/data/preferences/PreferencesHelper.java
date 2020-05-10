package com.example.transferdata.data.preferences;

public interface PreferencesHelper
{



    Integer getuid();
    Integer getid();
    String gettitle();
    String  getbody();

    void settitle(String title);
    void setbody(String  body);
    void setuid(Integer uid);
    void setid(Integer id);

}
