package com.example.childvaccination;

import android.os.Parcel;
import android.os.Parcelable;
import android.widget.TextView;

public class scheduleinfo implements Parcelable {
    public String reminderdate, remindertime, reminderhospital, questionsford;

        public scheduleinfo(String reminderdate, String remindertime, String reminderhospital, String questionsford){
            this.reminderdate = reminderdate;
            this.remindertime = remindertime;
            this.reminderhospital = reminderhospital;
            this.questionsford = questionsford;
        }

    protected scheduleinfo(Parcel in) {
        reminderdate = in.readString();
        remindertime = in.readString();
        reminderhospital = in.readString();
        questionsford = in.readString();
    }

    public static final Creator<scheduleinfo> CREATOR = new Creator<scheduleinfo>() {
        @Override
        public scheduleinfo createFromParcel(Parcel in) {
            return new scheduleinfo(in);
        }

        @Override
        public scheduleinfo[] newArray(int size) {
            return new scheduleinfo[size];
        }
    };

    public String getReminderdate(){ return reminderdate; }

        public void setReminderdate(String reminderdate) { this.reminderdate = reminderdate; }

        public String getRemindertime() { return remindertime; }

        public void setRemindertime(String remindertime) { this.remindertime = remindertime; }

        public String getReminderhospital() { return reminderhospital; }

        public void setReminderhospital(String reminderhospital) { this.reminderhospital = reminderhospital; }

    public String getQuestionsford() { return questionsford; }

    public void setQuestionsford(String questionsford) { this.questionsford = questionsford; }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(reminderdate);
        dest.writeString(remindertime);
        dest.writeString(reminderhospital);
        dest.writeString(questionsford);
    }

}
