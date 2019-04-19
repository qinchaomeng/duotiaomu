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
 * @Date：2019/4/18 20:28:28
 * @Description：描述信息
 */
public class RxxpAdapter extends RecyclerView.Adapter<RxxpAdapter.holder1> {
    RxxpClick rxxpClick;
    Context context;
    Show.ResultBean.RxxpBean rxxpBean;
    public View inflate;
    public Show.ResultBean.RxxpBean.CommodityListBean commodityListBean;

    public RxxpAdapter(Context context, Show.ResultBean.RxxpBean rxxpBean) {
        this.context = context;
        this.rxxpBean = rxxpBean;
    }

    @NonNull
    @Override
    public holder1 onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
       inflate = LayoutInflater.from(context).inflate(R.layout.show_rxxp_item, viewGroup, false);
        return new holder1(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull holder1 holder1, final int i) {
        commodityListBean=rxxpBean.getCommodityList().get(i);

        holder1.ntv.setText(commodityListBean.getCommodityName());
       // holder1.ptv.setText(commodityListBean.getMasterPic()+"");

        Glide.with(context).load(commodityListBean.getMasterPic()).into(holder1.imageView);

        holder1.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rxxpClick.rxxpTT(i);
            }
        });

    }

    @Override
    public int getItemCount() {
        return rxxpBean.getCommodityList().size();

    }

    public class holder1 extends RecyclerView.ViewHolder{

        private final ImageView imageView;
        private final TextView ntv,ptv;

        public holder1(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.show_rxxp_item_iv);
            ntv = itemView.findViewById(R.id.show_rxxp_item_ntv);
            ptv=itemView.findViewById(R.id.show_rxxp_item_ptv);
        }
    }

    public void setRxxpClick(RxxpClick rxxpClick){
        this.rxxpClick=rxxpClick;
    }
    //自定义点击事件
    public interface RxxpClick{
        void rxxpTT(int position);
    }
}
