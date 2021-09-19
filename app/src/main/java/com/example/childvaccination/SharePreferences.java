package com.example.childvaccination;

import android.content.Context;
import android.content.SharedPreferences;

//import com.google.gson.Gson;
//import com.google.gson.reflect.TypeToken;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class SharePreferences {

    public static SharedPreferences sharePrefs(Context context) {
        return context.getSharedPreferences("Sched", Context.MODE_PRIVATE) ;
    }

    public static void setChild(Context context,String name, String dob, String gender) {
        SharedPreferences.Editor editor = sharePrefs(context).edit();
        editor.putString("name", name);
        editor.putString("dob", dob);
        editor.putString("gender", gender);
        editor.apply();
    }

    public static void setCompoundButtonPref(Context context,ArrayList<CompoundButtonClass> checkList) {
        SharedPreferences.Editor editor = sharePrefs(context).edit();
        Gson gson = new Gson();
        String json = gson.toJson(checkList);
        editor.putString("CHECKLISTARRAY", json);
        editor.apply();
    }


    public static ArrayList<CompoundButtonClass> getCompountButtonPref(Context context){
        SharedPreferences prefs = sharePrefs(context);
        Gson gson = new Gson();
        String json = prefs.getString("CHECKLISTARRAY", null);
        Type type = new TypeToken<ArrayList<CompoundButtonClass>>() {}.getType();
        return gson.fromJson(json, type);
    }



    public static void setArrayList(Context context, ArrayList<Childinfo> detail){
        SharedPreferences.Editor editor = sharePrefs(context).edit();
        Gson gson = new Gson();
        String json = gson.toJson(detail);
        editor.putString("ARRAYLIST", json);
        editor.apply();
    }


    public static void setReminderArrayList(Context context, ArrayList<scheduleinfo> detail){
        SharedPreferences.Editor editor = sharePrefs(context).edit();
        Gson gson = new Gson();
        String json = gson.toJson(detail);
        editor.putString("REMINDERARRAYLIST", json);
        editor.apply();
    }

    public static ArrayList<Childinfo> getArrayList(Context context){
        SharedPreferences prefs = sharePrefs(context);
        Gson gson = new Gson();
        String json = prefs.getString("ARRAYLIST", null);
        Type type = new TypeToken<ArrayList<Childinfo>>() {}.getType();
        return gson.fromJson(json, type);
    }

    public static ArrayList<scheduleinfo> getReminderArrayList(Context context){
        SharedPreferences prefs = sharePrefs(context);
        Gson gson = new Gson();
        String json = prefs.getString("REMINDERARRAYLIST", null);
        Type type = new TypeToken<ArrayList<scheduleinfo    >>() {}.getType();
        return gson.fromJson(json, type);
    }

    public static ArrayList<Childinfo> removeArrayList(Context context, int position){
        ArrayList<Childinfo> arrayList =  getArrayList(context);
        arrayList.remove(position);
        setArrayList(context, arrayList);
        return getArrayList(context);
    }

    public static ArrayList<scheduleinfo> removeReminderArrayList(Context context, int position){
        ArrayList<scheduleinfo> arrayList =  getReminderArrayList(context);
        arrayList.remove(position);
        setReminderArrayList(context, arrayList);
        return getReminderArrayList(context);
    }

        public static String getName(Context context){
            SharedPreferences prefs = sharePrefs(context);
            return prefs.getString("name", "");
        }

        public static String getDob(Context context){
            SharedPreferences prefs = sharePrefs(context);
            return prefs.getString("dob", "");
        }

        public static String getGender(Context context){
            SharedPreferences prefs = sharePrefs(context);
            return prefs.getString("gender", "");
        }


        public static void setUserdata(Context context, String date, String time, String hospital, String question){
        SharedPreferences.Editor editor = sharePrefs(context).edit();
        editor.putString("date", date);
        editor.putString("time", time);
        editor.putString("hospital", hospital);
        editor.putString("question", question);
        editor.apply();
    }

    public static String getDate(Context context){
        SharedPreferences prefs = sharePrefs(context);
        return prefs.getString("date", "");
    }

    public static String getTime(Context context){
        SharedPreferences prefs = sharePrefs(context);
        return prefs.getString("time", "");
    }

    public static String getHospital(Context context){
        SharedPreferences prefs = sharePrefs(context);
        return prefs.getString("hospital", "");
    }

    public static String getQuestion(Context context){
        SharedPreferences prefs = sharePrefs(context);
        return prefs.getString("question", "");
    }


}


