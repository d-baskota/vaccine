package com.example.childvaccination;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.vaccine.R;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class ChildinfoAdapter extends RecyclerView.Adapter<ChildinfoAdapter.MyViewHolder> {
    private Context context;
    private List<Childinfo> details;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView name, dob, gender, delete;
        private Button btnDelete;

        public MyViewHolder(View view) {
            super(view);

            name = (TextView) itemView.findViewById(R.id.name);
            dob = (TextView) itemView.findViewById(R.id.dob);
            gender = (TextView) itemView.findViewById(R.id.gender);
            btnDelete = (Button) view.findViewById(R.id.delete_child);
        }
    }

    public ChildinfoAdapter(Context context, ArrayList<Childinfo> details) {
        this.context = context;
        this.details = details;
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fieldset, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, @SuppressLint("RecyclerView") int position) {
        Childinfo childinfo = details.get(position);
        holder.name.setText(childinfo.getName());
        holder.dob.setText(childinfo.getDob());
        holder.gender.setText(childinfo.getGender());
        holder.btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharePreferences.removeArrayList(context, position);
                ArrayList<Childinfo> childList = SharePreferences.getArrayList(context);
                if (childList == null) {
                    childList = new ArrayList<>();
                }
                details.clear();
                details.addAll(childList);
                notifyDataSetChanged();
            }
        });

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent scheduleIntent = new Intent(context, ScheduleActivity.class);
                ((Activity) context).startActivity(scheduleIntent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return details.size();
    }

}
