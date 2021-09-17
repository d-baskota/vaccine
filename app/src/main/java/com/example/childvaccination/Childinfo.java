package com.example.childvaccination;

import android.os.Parcel;
import android.os.Parcelable;

public class Childinfo implements Parcelable {
    private String name, dob, gender;

    public Childinfo(String name, String dob, String gender){
        this.name = name;
        this.dob = dob;
        this.gender = gender;
    }

    protected Childinfo(Parcel in) {
        name = in.readString();
        dob = in.readString();
        gender = in.readString();
    }

    public static final Creator<Childinfo> CREATOR = new Creator<Childinfo>() {
        @Override
        public Childinfo createFromParcel(Parcel in) {
            return new Childinfo(in);
        }

        @Override
        public Childinfo[] newArray(int size) {
            return new Childinfo[size];
        }
    };

    public String getName(){ return name; }

    public void setName(String name) { this.name = name; }

    public String getDob() { return dob; }

    public void setDob(String dob) { this.dob = dob; }

    public String getGender() { return gender; }

    public void setGender(String gender) { this.gender = gender; }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(dob);
        dest.writeString(gender);
    }
}
