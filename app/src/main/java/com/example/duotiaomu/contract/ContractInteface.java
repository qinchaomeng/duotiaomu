package com.example.duotiaomu.contract;

import android.content.Context;

/**
 * Time:2019/4/19
 * Author:秦超蒙
 * Description:
 */
public interface ContractInteface {
    //showmodel
    public interface ShowModel{
        public void ShowModelData(String url, Context context, ShowModel.CallBack callBack );
        public interface CallBack{
            public void success(String data);
            public void fail();
        }
    }
    //showview
    public interface ShowView{
        public void gerShowPresenter(String data);

    }
    //showpresenter
    public interface ShowPresenter{

        public void bind(Context context,String url,ShowView view);

        public void unbind();
    }
}
