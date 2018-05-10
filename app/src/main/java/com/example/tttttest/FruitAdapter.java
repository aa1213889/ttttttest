package com.example.tttttest;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.tttttest.db.Fruit;

import java.util.List;



public class FruitAdapter extends RecyclerView.Adapter<FruitAdapter.MyViewHolder> {
    private Context mContext;
    private List<Fruit> mFruitList;
    class MyViewHolder extends RecyclerView.ViewHolder{
        CardView cardView;
        ImageView fruitImage;
        TextView furitName;
         MyViewHolder(View itemView) {
            super(itemView);
            cardView = (CardView) itemView;
            fruitImage = (ImageView) itemView.findViewById(R.id.fruit_image);
            furitName = (TextView) itemView.findViewById(R.id.fruit_name);
        }
    }
    public FruitAdapter(List<Fruit> fruitList,Context context) {
        mFruitList = fruitList;
        mContext = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final MyViewHolder holder = new MyViewHolder(LayoutInflater.from(mContext).inflate(R.layout.layout,parent,false));
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
                Fruit fruit = mFruitList.get(position);
                Intent intent = new Intent(mContext,FruitActivity.class);
                intent.putExtra("fruit_data",fruit);
                mContext.startActivity(intent);
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(FruitAdapter.MyViewHolder holder, int position) {
        Fruit fruit = mFruitList.get(position);
        holder.furitName.setText(fruit.getName());
        Glide.with(mContext).load(fruit.getImageId()).into(holder.fruitImage);
        //为什么要用Glide 因为每张图片像素不一样可能会内存溢出
    }

    @Override
    public int getItemCount() {
        return mFruitList.size();
    }
}
