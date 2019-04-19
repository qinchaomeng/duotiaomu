package com.example.duotiaomu.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.duotiaomu.R;
import com.example.duotiaomu.ZanActivity;
import com.example.duotiaomu.bean.Show;
import com.example.duotiaomu.bean.Xbanner;
import com.stx.xhb.xbanner.XBanner;
import com.stx.xhb.xbanner.transformers.Transformer;

import java.util.ArrayList;
import java.util.List;


/**
 * @Author：dongshaobo
 * @Date：2019/4/18 14:53:53
 * @Description：描述信息
 */
public class ShowAdapter extends RecyclerView.Adapter {
    private static final String TAG = "ShowAdapter";
    public Context context;
    public Show show;
    public Xbanner xbanner;

    int RxxpType=0;
    int PzshType=1;
    int MlssType=2;
    int XbannerType=3;

    public int itemViewType;
    public View inflaterxxp,inflatepszh,inflatemlss,inflatebanner;
    public int viewHolderItemViewType;
    public Show.ResultBean.RxxpBean rxxpBean;
    public RxxpAdapter rxxpAdapter;
    public Show.ResultBean.PzshBean pzshBean;
    public PzshAdapter pzshAdapter;
    public Show.ResultBean.MlssBean mlssBean;
    public MlssAdapter mlssAdapter;
    private ViewHodelRxxp viewHodelRxxp;



    public ShowAdapter(Context context, Show show) {
        this.context = context;
        this.show = show;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        itemViewType = getItemViewType(i);

        if(itemViewType==RxxpType){
            inflaterxxp = LayoutInflater.from(context).inflate(R.layout.show_rxxp, viewGroup, false);
            return new ViewHodelRxxp(inflaterxxp);

        }else if(itemViewType==MlssType){
            inflatemlss = LayoutInflater.from(context).inflate(R.layout.show_mlss, viewGroup, false);
            return new ViewHodelMlss(inflatemlss);
        }else if (itemViewType==PzshType){
            inflatepszh = LayoutInflater.from(context).inflate(R.layout.show_pzsh, viewGroup, false);
            return new ViewHodelPzsh(inflatepszh);

        }else {
            inflatebanner=LayoutInflater.from(context).inflate(R.layout.show_pzsh, viewGroup, false);

            return new ViewHolderXbanner(inflatebanner);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, final int i) {

        viewHolderItemViewType = viewHolder.getItemViewType();

        if (viewHolderItemViewType == 0) {

            ViewHodelRxxp viewHodelRxxp = (ViewHodelRxxp) viewHolder;
            Log.i(TAG, "onBindViewHolder: "+viewHodelRxxp );

             rxxpBean=show.getResult().getRxxp();
           viewHodelRxxp.rxxptv.setText(show.getResult().getRxxp().getName());
            LinearLayoutManager rxxplinearLayoutManager = new LinearLayoutManager(context);
            rxxplinearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
            viewHodelRxxp.rxxprc.setLayoutManager(rxxplinearLayoutManager);
            rxxpAdapter = new RxxpAdapter(context, rxxpBean);
           viewHodelRxxp.rxxprc.setAdapter(rxxpAdapter);
           rxxpAdapter.setRxxpClick(new RxxpAdapter.RxxpClick() {
               @Override
               public void rxxpTT(int position) {
                   Intent intent = new Intent(context, ZanActivity.class);
                   context.startActivity(intent);
               }
           });

        } else if (viewHolderItemViewType == 1) {
            ViewHodelMlss viewHodelMlss = (ViewHodelMlss) viewHolder;
            mlssBean = show.getResult().getMlss();
             viewHodelMlss.mlsstv.setText(show.getResult().getMlss().getName());

            GridLayoutManager pzshgrid = new GridLayoutManager(context, 2);
            viewHodelMlss.mlssprc.setLayoutManager(pzshgrid);

            mlssAdapter = new MlssAdapter(context, mlssBean);
            viewHodelMlss.mlssprc.setAdapter(mlssAdapter);

        } else if (viewHolderItemViewType == 2) {
            ViewHodelPzsh viewHodelPzsh = (ViewHodelPzsh) viewHolder;
            pzshBean = show.getResult().getPzsh();
            viewHodelPzsh.pzshtv.setText(show.getResult().getPzsh().getName());

            LinearLayoutManager mlsslinearLayoutManager = new LinearLayoutManager(context);
            mlsslinearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
            viewHodelPzsh.pzshprc.setLayoutManager(mlsslinearLayoutManager);

            pzshAdapter = new PzshAdapter(context, pzshBean);
            viewHodelPzsh.pzshprc.setAdapter(pzshAdapter);

        }else {
final ViewHolderXbanner viewHolderXbanner= (ViewHolderXbanner) viewHolder;




        }
    }
    @Override
    public int getItemCount() {
        return 4;
    }
    @Override
    public int getItemViewType(int position) {
        if (position==0){
            return RxxpType;
        }else if(position==1){
            return MlssType;
        }else if (position==2){
            return PzshType;
        }else {
            return XbannerType;
        }
    }

    public static class ViewHodelRxxp extends RecyclerView.ViewHolder{

        private final RecyclerView rxxprc;
        private final TextView rxxptv;

        public ViewHodelRxxp(@NonNull View itemView) {
            super(itemView);
            rxxptv = itemView.findViewById(R.id.show_rxxp_tv);
            rxxprc = itemView.findViewById(R.id.show_rxxp_rc);

        }
    }
    public class ViewHodelPzsh extends RecyclerView.ViewHolder {
        private final RecyclerView pzshprc;
        private final TextView pzshtv;
        public ViewHodelPzsh(@NonNull View itemView) {
            super(itemView);
            pzshtv = itemView.findViewById(R.id.show_pzsh_tv);
            pzshprc= itemView.findViewById(R.id.show_pzsh_rc);
        }
    }
    public class ViewHodelMlss extends RecyclerView.ViewHolder {

        private final RecyclerView mlssprc;
        private final TextView mlsstv;

        public ViewHodelMlss(@NonNull View itemView) {
            super(itemView);
            mlssprc=itemView.findViewById(R.id.show_mlss_rc);
            mlsstv=itemView.findViewById(R.id.show_mlss_tv);
        }
    }

public class ViewHolderXbanner extends RecyclerView.ViewHolder{
XBanner xBanner;
    public ViewHolderXbanner(@NonNull View itemView) {
        super(itemView);
xBanner=itemView.findViewById(R.id.show_xbanner);
    }
}

}
