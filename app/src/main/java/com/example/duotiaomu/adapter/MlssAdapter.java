package com.example.duotiaomu.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.duotiaomu.R;
import com.example.duotiaomu.bean.Show;


/**
 * @Author：dongshaobo
 * @Date：2019/4/18 20:51:51
 * @Description：描述信息
 */
public class MlssAdapter extends RecyclerView.Adapter<MlssAdapter.holder3> {

    Context context;
    Show.ResultBean.MlssBean mlssBean;
    public View inflate;
    private Show.ResultBean.MlssBean.CommodityListBeanXX commodityListBeanXX;

    public MlssAdapter(Context context, Show.ResultBean.MlssBean mlssBean) {
        this.context = context;
        this.mlssBean = mlssBean;
    }

    @NonNull
    @Override
    public holder3 onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        inflate = LayoutInflater.from(context).inflate(R.layout.show_mlss_item, viewGroup, false);
        return new holder3(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull holder3 holder3, int i) {
        commodityListBeanXX = mlssBean.getCommodityList().get(i);
        holder3.ntv.setText(commodityListBeanXX.getCommodityName());
        holder3.ptv.setText(commodityListBeanXX.getPrice());

        Glide.with(context).load(commodityListBeanXX.getMasterPic()).into(holder3.imageView);
    }

    @Override
    public int getItemCount() {
        return mlssBean.commodityList.size();
    }

    public class holder3 extends RecyclerView.ViewHolder {

        private final ImageView imageView;
        private final TextView ntv, ptv;

        public holder3(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.show_mlss_item_iv);
            ntv = itemView.findViewById(R.id.show_mlss_item_ntv);
            ptv = itemView.findViewById(R.id.show_mlss_item_ptv);
        }
    }
}
