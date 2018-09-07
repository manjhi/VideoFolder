package com.example.videofolder;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {

    List<Model> models;
    Context context;

    myclick myc;

    public interface myclick{
        public void myonclick(int postion);
    }

    public Adapter(List<Model> models, Context context,myclick myc) {
        this.models = models;
        this.context = context;
        this.myc=myc;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_layout,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Model model=models.get(position);
        holder.folder.setText(model.folder);
    }

    @Override
    public int getItemCount() {
        return models.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView folder;
        public MyViewHolder(View itemView) {
            super(itemView);
            folder=itemView.findViewById(R.id.foldername);
            folder.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            myc.myonclick(getLayoutPosition());
        }
    }
}
