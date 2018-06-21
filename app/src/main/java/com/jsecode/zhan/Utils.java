package com.jsecode.zhan;

import android.content.Context;
import android.os.Environment;
import android.util.Log;

import java.io.File;
import java.io.IOException;

public class Utils {

    public static String TAG = "Utils";


    /**
     *  获取下载路径存储位置
     */
    public static File getCacheDirectory(Context context, String packagename) {
        File appCacheDir = null;
        if (Environment.getExternalStorageState().equals(
                android.os.Environment.MEDIA_MOUNTED)) {

            appCacheDir = getExternal2CacheDir(context,BuildConfig.APPLICATION_ID,"update");

            if(appCacheDir == null){
                appCacheDir = getExternal0CacheDir(context,BuildConfig.APPLICATION_ID, "update");
            }
        }

        if (appCacheDir == null) {
            appCacheDir = context.getCacheDir();
        }
        return appCacheDir;
    }

    /**
     *  获取系统更新根目录存储位置
     */
    public static File getCacheDirectory(Context context) {
        File appCacheDir = null;
        if (Environment.getExternalStorageState().equals(
                android.os.Environment.MEDIA_MOUNTED)) {

            appCacheDir = getExternal2CacheDir(context,"sysupdate");

            if(appCacheDir == null){
                appCacheDir = getExternal0CacheDir(context, "sysupdate");
            }
        }

        if (appCacheDir == null) {
            appCacheDir = context.getCacheDir();
        }
        return appCacheDir;
    }
    private static File getExternal2CacheDir(Context context,String packagename,String file) {
        File dataDir = new File(new File("/sdcard2", "Android"), "Data");
        // File appCacheDir = new File(new File(dataDir, context.getPackageName()), file);
        File appCacheDir = new File(new File(dataDir, packagename), file);
        if (!appCacheDir.exists()) {
            try {
                new File(dataDir, ".nomedia").createNewFile();
            } catch (IOException e) {
                Log.e(TAG, "Can't create \".nomedia\" file in application external2 cache directory");
            }
            if (!appCacheDir.mkdirs()) {
                Log.w(TAG,"Unable to create external2 cache directory");
                return null;
            }
        }
        return appCacheDir;
    }


    private static File getExternal2CacheDir(Context context,String file) {

        File dataDir =new File("/sdcard2");

        File appCacheDir = new File("/sdcard2", file);

        if (!appCacheDir.exists()) {
            try {
                new File(dataDir, ".nomedia").createNewFile();
            } catch (IOException e) {
                Log.e(TAG, "Can't create \".nomedia\" file in application external2 cache directory");
            }
            if (!appCacheDir.mkdirs()) {
                Log.w(TAG,"Unable to create external2 cache directory");
                return null;
            }
        }
        return appCacheDir;
    }


    private static File getExternal0CacheDir(Context context,String packagename,String file) {
        File dataDir = new File(new File(Environment.getExternalStorageDirectory(), "Android"), "Data");
        //    File appCacheDir = new File(new File(dataDir, context.getPackageName()), file);
        File appCacheDir = new File(new File(dataDir, packagename), file);
        if (!appCacheDir.exists()) {
            try {
                new File(dataDir, ".nomedia").createNewFile();
            } catch (IOException e) {
                Log.e(TAG, "Can't create \".nomedia\" file in application external0 cache directory");
            }
            if (!appCacheDir.mkdirs()) {
                Log.w(TAG,"Unable to create external0 cache directory");
                return null;
            }
        }
        return appCacheDir;
    }


    private static File getExternal0CacheDir(Context context,String file) {

        File appCacheDir = new File(Environment.getExternalStorageDirectory(),file);

        if (!appCacheDir.exists()) {
            try {
                new File(Environment.getExternalStorageDirectory(), ".nomedia").createNewFile();
            } catch (IOException e) {
                Log.e(TAG, "Can't create \".nomedia\" file in application external0 cache directory");
            }
            if (!appCacheDir.mkdirs()) {
                Log.w(TAG,"Unable to create external0 cache directory");
                return null;
            }
        }
        return appCacheDir;
    }

}
