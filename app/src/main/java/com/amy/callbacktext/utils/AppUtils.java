package com.amy.callbacktext.utils;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;

import com.amy.callbacktext.bean.AppInfo;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/*
 *  @项目名：  CallBackText 
 *  @包名：    com.amy.callbacktext.utils
 *  @文件名:   AppUtils
 *  @创建者:   amy
 *  @创建时间:  17/3/6 下午4:54
 *  @描述：    TODO
 */
public class AppUtils {


    /**
     * 获取所有的应用程序
     * @param context
     * @return List<AppInfo>
     */
    public static List<AppInfo> getAllApps(Context context){
        //获取所有的应用程序
        List<AppInfo> infos = new ArrayList<AppInfo>();

        //1. 得到包管理器
        PackageManager pm = context.getPackageManager();


        //2. 获取到安装的所有程序
        List<ApplicationInfo> appInfos = pm.getInstalledApplications(PackageManager.GET_UNINSTALLED_PACKAGES);

        //3. 遍历集合，取出每一个具体的应用程序

        for (ApplicationInfo appInfo : appInfos) {


            AppInfo info = new AppInfo();
			/*
			 * icon
			 * 应用程序名称
			 * APK大小
			 * 安装位置
			 * 是否是系统程序
			 */
            info.packageName = appInfo.packageName;
            info.icon = appInfo.loadIcon(pm);
            info.label = (String) appInfo.loadLabel(pm);

            //APK文件路径
            // 用户： data /app/xxx.apk  , 系统： system/app/xxx.apk
            String dir = appInfo.sourceDir;
           // LogUtils.Logd("vivi", "dir==="+dir);

            info.apkPath = dir;
            info.apkSize = new File(dir).length();

            info.isSystem =( appInfo.flags & ApplicationInfo.FLAG_SYSTEM  )
                    == ApplicationInfo.FLAG_SYSTEM ;

            //SD卡安装
            info.isSdcard =( appInfo.flags & ApplicationInfo.FLAG_EXTERNAL_STORAGE  )
                    == ApplicationInfo.FLAG_EXTERNAL_STORAGE ;

            infos.add(info);
        }

        return infos;
    }


    /**
     * 根据应用程序包名获取该程序的信息
     * @param context
     * @param packageName
     * @return ApplicationInfo
     */
    public static ApplicationInfo getAppInfo(Context context , String packageName){
        PackageManager pm = context.getPackageManager();
        try {
            return pm.getApplicationInfo(packageName, PackageManager.GET_UNINSTALLED_PACKAGES);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}

