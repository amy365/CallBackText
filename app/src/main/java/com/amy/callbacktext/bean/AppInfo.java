package com.amy.callbacktext.bean;

import android.graphics.drawable.Drawable;

/*
 *  @项目名：  CallBackText 
 *  @包名：    com.amy.callbacktext.bean
 *  @文件名:   AppInfo
 *  @创建者:   amy
 *  @创建时间:  17/3/6 下午4:53
 *  @描述：    TODO
 */
public class AppInfo {

    public Drawable icon;
    public String   label;
    public long     apkSize;
    public boolean  isSystem; //是否是系统程序
    public boolean  isSdcard; //是否安装在SD卡
    public String   packageName;  //应用程序的包名

    public String apkPath; //这是APK的路径

    @Override
    public String toString() {
        return "AppInfo [icon=" + icon + ", label=" + label + ", apkSize=" + apkSize + ", isSystem=" + isSystem + ", isSdcard=" + isSdcard + "]";
    }

}