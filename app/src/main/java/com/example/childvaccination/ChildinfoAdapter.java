package com.example.childvaccination;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class ChildinfoAdapter extends RecyclerView.Adapter<ChildinfoAdapter.MyViewHolder> {
    private Context context;
    private List<Childinfo> details ;

    public class MyViewHolder extends RecyclerView.ViewHolder{
        public TextView name, dob, gender, delete;

        public MyViewHolder(View view){
            super(view);

            name = (TextView) itemView.findViewById(R.id.name);
            dob = (TextView) itemView.findViewById(R.id.dob);
            gender = (TextView) itemView.findViewById(R.id.gender);

        }
    }

    public ChildinfoAdapter(Context context, ArrayList<Childinfo> details){
        this.context = context;
        this.details = details;
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
View itemView = LayoutInflater.from(parent.getContext())
.inflate(R.layout.fieldset, parent, false );

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Childinfo childinfo = details.get(position);
        holder.name.setText(childinfo.getName());
        holder.dob.setText(childinfo.getDob());
        holder.gender.setText(childinfo.getGender());
    }

    @Override
    public int getItemCount() {
        return details.size();
    }

}
