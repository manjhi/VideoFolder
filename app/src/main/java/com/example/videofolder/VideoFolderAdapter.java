package com.example.videofolder;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import java.util.ArrayList;

public class VideoFolderAdapter extends RecyclerView.Adapter<VideoFolderAdapter.MyViewHolder> {

    ArrayList<ModelVideo> allvideos;
    Context context;
    Activity activity;

    public VideoFolderAdapter(ArrayList<ModelVideo> allvideos, Context context, Activity activity) {
        this.allvideos = allvideos;
        this.context = context;
        this.activity = activity;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_video_layout,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {


    }

    @Override
    public int getItemCount() {
        return allvideos.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        RelativeLayout relativeLayout;
        public MyViewHolder(View itemView) {
            super(itemView);
            itemView=itemView.findViewById(R.id.videoimage);
            relativeLayout=itemView.findViewById(R.id.relative);
        }
    }
}
