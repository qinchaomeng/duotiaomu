package com.example.duotiaomu.contract.m;

import android.content.Context;

import com.android.volley.VolleyError;
import com.example.duotiaomu.contract.ContractInteface;
import com.example.duotiaomu.util.VolleyHttp;


/**
 * @Author：dongshaobo
 * @Date：2019/4/18 13:41:41
 * @Description：描述信息
 */
public class ShowModel implements ContractInteface.ShowModel {

    @Override
    public void ShowModelData(String url, Context context, final CallBack callBack) {
      VolleyHttp.getInstance().getVolley(url, new VolleyHttp.VolleyCallBack() {
          @Override
          public void success(String name) {
              callBack.success(name);
          }

          @Override
          public void fail(VolleyError error) {

          }
      });
    }
}





