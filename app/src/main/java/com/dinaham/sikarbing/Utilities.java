package com.dinaham.sikarbing;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.design.widget.TabLayout;
import android.util.Log;
import android.widget.Toast;

public class Utilities {

    public static void putPrefName (String DBNAME, String Tablekey, String value, Context context){

        SharedPreferences settings;
        SharedPreferences.Editor editor;
        settings = context.getSharedPreferences(DBNAME, Context.MODE_PRIVATE);
        editor = settings.edit();
        editor.putString(Tablekey, value);
        editor.commit();
    }

    public static String getValueName (String DBNAME, String Tablekey, Context context){

        SharedPreferences settings;
        String text;
        settings = context.getSharedPreferences(DBNAME, Context.MODE_PRIVATE);
        text = settings.getString(Tablekey, null);
        return text;
    }

    public static void clearSharedPreferance (String DBNAME, Context context){

        SharedPreferences settings;
        SharedPreferences.Editor editor;
        settings = context.getSharedPreferences(DBNAME, Context.MODE_PRIVATE);
        editor = settings.edit();
        editor.clear();
        editor.commit();
    }

    public static void ShowLog(String message, String value) {
        Log.e("Gohajj-ticket", message + " : " + value);
    }

    public static void ShowToast(Activity activity, String message) {
        Toast.makeText(activity, message, Toast.LENGTH_SHORT).show();

    }

    public static void ShowToast(Context context, String message) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();

    }

    public static boolean cek_status(Activity cek) {
        ConnectivityManager cm = (ConnectivityManager) cek.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info = cm.getActiveNetworkInfo();
        if (info != null && info.isConnected()) {
            return true;
        } else {
            ShowToast(cek, "Please check your network connection!");
            return false;
        }
    }

    public static boolean network_status(Activity cek) {
        ConnectivityManager cm = (ConnectivityManager) cek.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info = cm.getActiveNetworkInfo();
        if (info != null && info.isConnected()) {
            return true;
        } else {
            //ShowToast(cek,"Please check your network connection!");
            return false;
        }
    }
}

