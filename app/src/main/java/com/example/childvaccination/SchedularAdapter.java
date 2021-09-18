package com.example.childvaccination;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.vaccine.R;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class SchedularAdapter extends RecyclerView.Adapter<SchedularAdapter.MyViewHolder> {

    private List<scheduleinfo> scheduledetails ;

    public class MyViewHolder extends RecyclerView.ViewHolder{
        public TextView reminderdate, remindertime, reminderhospital, questionsford;

        public MyViewHolder(View view){
            super(view);

            reminderdate = (TextView) itemView.findViewById(R.id.Reminderdate);
            remindertime = (TextView) itemView.findViewById(R.id.Remindertime);
            reminderhospital = (TextView) itemView.findViewById(R.id.Reminderhospital);
            questionsford = (TextView) itemView.findViewById(R.id.Questionsford);
        }
    }

    public SchedularAdapter(ArrayList<scheduleinfo> scheduledetails){

        this.scheduledetails = scheduledetails;
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.schedulefield, parent, false );

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        scheduleinfo scheduleinfo = scheduledetails.get(position);
        holder.reminderdate.setText(scheduleinfo.getReminderdate());
        holder.remindertime.setText(scheduleinfo.getRemindertime());
        holder.reminderhospital.setText(scheduleinfo.getReminderhospital());
        holder.questionsford.setText(scheduleinfo.getQuestionsford());
    }

    @Override
    public int getItemCount() {
        return scheduledetails.size();
    }

}
