package com.example.childvaccination;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class InfoAdapter extends RecyclerView.Adapter<InfoAdapter.MyViewHolder>{
    private List<InfoDetail> brief ;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title, source;

        public MyViewHolder(View view) {
            super(view);
            
            title = (TextView) itemView.findViewById(R.id.title);
            source = (TextView) itemView.findViewById(R.id.source);
        }
    }

    public InfoAdapter(ArrayList<InfoDetail> brief) {
        this.brief = brief;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.informationtitle, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        InfoDetail infoDetail = brief.get(position);
        holder.title.setText(infoDetail.getTitle());
        holder.source.setText(infoDetail.getSource());
    }

    @Override
    public int getItemCount() { return brief.size(); }
}
