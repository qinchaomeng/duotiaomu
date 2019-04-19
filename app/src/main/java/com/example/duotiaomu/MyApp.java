package com.example.duotiaomu;

import android.app.Application;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Time:2019/4/19
 * Author:秦超蒙
 * Description:
 */
public class MyApp extends Application {
    private static RequestQueue requestQueue;

    @Override
    public void onCreate() {
        super.onCreate();
         requestQueue = Volley.newRequestQueue(getApplicationContext());
    }
    public static RequestQueue getVolley(){
        return requestQueue;
    }
}
