package com.example.childvaccination;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
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
    private Context context;

    public class MyViewHolder extends RecyclerView.ViewHolder{
        public TextView reminderdate, remindertime, reminderhospital, questionsford;
        private Button btnDelete;
        public MyViewHolder(View view){
            super(view);

            reminderdate = (TextView) itemView.findViewById(R.id.Reminderdate);
            remindertime = (TextView) itemView.findViewById(R.id.Remindertime);
            reminderhospital = (TextView) itemView.findViewById(R.id.Reminderhospital);
            questionsford = (TextView) itemView.findViewById(R.id.Questionsford);
            btnDelete = view.findViewById(R.id.delete_reminder);
        }
    }

    public SchedularAdapter(Context context, ArrayList<scheduleinfo> scheduledetails){
        this.context = context;
        this.scheduledetails = scheduledetails;
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.schedulefield, parent, false );

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, @SuppressLint("RecyclerView") int position) {
        scheduleinfo scheduleinfo = scheduledetails.get(position);
        holder.reminderdate.setText(scheduleinfo.getReminderdate());
        holder.remindertime.setText(scheduleinfo.getRemindertime());
        holder.reminderhospital.setText(scheduleinfo.getReminderhospital());
        holder.questionsford.setText(scheduleinfo.getQuestionsford());
        holder.btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharePreferences.removeReminderArrayList(context, position);
                ArrayList<scheduleinfo> scheduleList = SharePreferences.getReminderArrayList(context);
                if(scheduleList == null){
                    scheduleList = new ArrayList<>();
                }
                scheduledetails.clear();
                scheduledetails.addAll(scheduleList);
                notifyDataSetChanged();
            }
        });
    }

    @Override
    public int getItemCount() {
        return scheduledetails.size();
    }

}
