package com.example.duotiaomu.contract.p;

import android.content.Context;

import com.example.duotiaomu.contract.ContractInteface;
import com.example.duotiaomu.contract.m.ShowModel;


/**
 * @Author：dongshaobo
 * @Date：2019/4/18 13:41:41
 * @Description：描述信息
 */
public class ShowPresenter implements ContractInteface.ShowPresenter {
private ShowModel showModel;
private ContractInteface.ShowView showView;

    @Override
    public void bind(Context context, String url, ContractInteface.ShowView view) {
        showModel=new ShowModel();
        this.showView=view;
        showModel.ShowModelData(url, context, new ContractInteface.ShowModel.CallBack() {
            @Override
            public void success(String data) {
                showView.gerShowPresenter(data);
            }

            @Override
            public void fail() {

            }
        });
    }

    @Override
    public void unbind() {

    }
}
