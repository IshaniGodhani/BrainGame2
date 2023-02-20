package com.example.braingame;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.view_holder> {
    Activity activity;
    String[] level;
    public RecyclerAdapter(Activity activity, String[] level) {
        this.activity=activity;
        this.level=level;

    }

    @NonNull
    @Override
    public RecyclerAdapter.view_holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(activity).inflate(R.layout.level_category,parent,false);
        view_holder viewHolder=new view_holder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapter.view_holder holder, int position) {
        holder.level_title.setText(""+level[position]);

        holder.level_title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(activity,MainActivity3.class);
                intent.putExtra("level",holder.getAdapterPosition()+1);
                activity.startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return level.length;
    }

    public class view_holder extends RecyclerView.ViewHolder {
        TextView level_title;
        public view_holder(@NonNull View itemView) {
            super(itemView);
            level_title=itemView.findViewById(R.id.level);
        }
    }
}
