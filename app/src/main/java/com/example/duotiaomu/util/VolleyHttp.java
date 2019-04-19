package com.example.duotiaomu.util;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.duotiaomu.MyApp;

/**
 * Time:2019/4/19
 * Author:秦超蒙
 * Description:
 */
public class VolleyHttp {

    private static VolleyHttp volleyHttp=new VolleyHttp();
    //饿汉式
    public static VolleyHttp getInstance(){
        return volleyHttp;
    }

    //请求数据
    public void getVolley(String url, final VolleyCallBack callBack){
       StringRequest stringRequest= new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
callBack.success(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                callBack.fail(error);
            }
        });
        stringRequest.setTag("volley");
        MyApp.getVolley().add(stringRequest);
    }


    //接口
    public interface VolleyCallBack{
        void success(String name);
        void fail(VolleyError error);
    }
}
