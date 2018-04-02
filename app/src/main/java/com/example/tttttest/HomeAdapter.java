package com.example.tttttest;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tttttest.CustomView.SelfDialog;

import java.util.List;

/**
 * Created by Administrator on 2018/3/6.
 */

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.MyViewHolder> {
    private List<String> mList;
    private Context mContext;
    private SelfDialog selfDialog;


    class MyViewHolder extends  RecyclerView.ViewHolder{
        TextView tv;
        public MyViewHolder(View itemView) {
            super(itemView);
            tv=(TextView)itemView.findViewById(R.id.textView2);
        }
    }

    public HomeAdapter(Context context,List<String> list){
        this.mContext = context;
        this.mList = list;
    }
    public  void removeData(int position){
         mList.remove(position);
         notifyDataSetChanged();
    }

    @Override
    public HomeAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        MyViewHolder holder = new  MyViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_recyclerview,parent,false));
        return holder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder,final int position) {
                holder.tv.setText(mList.get(position));
        holder.tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int postion = holder.getAdapterPosition();
                Toast.makeText(v.getContext(),"you clicked "+postion,Toast.LENGTH_SHORT).show();
            }
        });
        holder.tv.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                selfDialog =  new SelfDialog(mContext);
                selfDialog.setTitle("提示");
                selfDialog.setMessage("确认删除吗？");
                selfDialog.setYesOnclickListener("确定", new SelfDialog.onYesOnclickListener() {
                    @Override
                    public void onYesClick() {
                        removeData(position);
                        selfDialog.dismiss();
                    }
                });
                selfDialog.setNoOnclickListener("取消", new SelfDialog.onNoOnclickListener() {
                    @Override
                    public void onNoClick() {

                        selfDialog.dismiss();
                    }
                });
                selfDialog.show();
//                View mView = LayoutInflater.from(mContext).inflate(R.layout.add_layout, null);
//                   new AlertDialog.Builder(v.getContext()).setTitle("确认删除吗？")
//                           .setNegativeButton("取消",null)
//                           .setView(mView)  //引用自定义提示框
//                           .setPositiveButton("确定", new DialogInterface.OnClickListener() {
//                       @Override
//                       public void onClick(DialogInterface dialog, int which) {
//                           removeData(position);
//                       }
//                   }).show();
                return false;
            }
        });
    }
    @Override
    public int getItemCount() {
        return mList.size();
    }

}
