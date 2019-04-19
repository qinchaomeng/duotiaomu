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
 * @Date：2019/4/18 20:38:38
 * @Description：描述信息
 */
public class PzshAdapter extends RecyclerView.Adapter<PzshAdapter.holder2> {

    Context context;
    Show.ResultBean.PzshBean pzshBean;
    public View inflate;
    private Show.ResultBean.PzshBean.CommodityListBeanX commodityListBeanX;

    public PzshAdapter(Context context, Show.ResultBean.PzshBean pzshBean) {
        this.context = context;
        this.pzshBean = pzshBean;
    }

    @NonNull
    @Override
    public holder2 onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        inflate = LayoutInflater.from(context).inflate(R.layout.show_pzsh_item, viewGroup, false);
        return new holder2(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull holder2 holder2, int i) {

        commodityListBeanX=pzshBean.getCommodityList().get(i);
        holder2.ntv.setText(commodityListBeanX.getCommodityName());
        holder2.ptv.setText(commodityListBeanX.getPrice());

        Glide.with(context).load(commodityListBeanX.getMasterPic()).into(holder2.imageView);
    }

    @Override
    public int getItemCount() {
        return pzshBean.getCommodityList().size();
    }

    public class holder2 extends RecyclerView.ViewHolder {

        private final ImageView imageView;
        private final TextView ntv,ptv;

        public holder2(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.show_pzsh_item_iv);
            ntv = itemView.findViewById(R.id.show_pzsh_item_ntv);
            ptv=itemView.findViewById(R.id.show_pzsh_item_ptv);
        }
    }

}
