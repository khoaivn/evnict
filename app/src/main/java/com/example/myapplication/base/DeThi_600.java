package com.example.myapplication.base;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by TruDu on 1/3/17.
 */

public class DeThi_600 {
    String question = "question";
    String task = "task";

    int _id;
    int _number_question = 0;
    int _seconds_time;
    int _pass;
    int[] _question;
    int[] _task;
    int _task_time;

    public DeThi_600(){}

    public DeThi_600(int number_question, int seconds_time, int pass){
        this._number_question = number_question;
        this._seconds_time = seconds_time;
        this._pass = pass;

        for (int i = 0; i < this._number_question; ++i)
            this._task[i] = 0;

    }

    public DeThi_600(int number_question, int seconds_time, int pass, int[] question, int[] task, int task_time){
        this._number_question = number_question;
        this._seconds_time = seconds_time;
        this._pass = pass;
        this._question = question;
        this._task = task;
        this._task_time = task_time;
    }
    public DeThi_600(int id, int number_question, int seconds_time, int pass, int[] question, int[] task, int task_time){
        this._id = id;
        this._number_question = number_question;
        this._seconds_time = seconds_time;
        this._pass = pass;
        this._question = question;
        this._task = task;
        this._task_time = task_time;
    }
    public DeThi_600(JSONObject jsonObject){
        try {
            JSONArray json_question = (JSONArray) jsonObject.get(question);
            JSONArray json_task = (JSONArray) jsonObject.get(task);
            this._id = jsonObject.getInt("id");
            this._number_question = jsonObject.getInt("number_question");
            this._seconds_time = jsonObject.getInt("seconds_time");
            this._pass = jsonObject.getInt("pass");
            this._question = new int[this._number_question];
            this._task = new int[this._number_question];
            for (int i = 0; i < this._number_question; ++i){
                this._question[i] = json_question.getInt(i);
                this._task[i] = json_task.getInt(i);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
    public int getID(){ return this._id; }
    public int getNumberQuestion(){ return this._number_question; }
    public int getSecondsTime(){ return this._seconds_time; }
    public int getPass(){ return this._pass; }
    public int[] getQuestion(){ return this._question; }
    public int[] getTask(){ return this._task; }
    int getTaskTime(){ return this._task_time; }

    void setID(int id){ this._id = id; }
    public void setNumberQuestion(int number_question){ this._number_question = number_question; }
    public void setSecondsTime(int seconds_time){ this._seconds_time = seconds_time; }
    public void setPass(int pass){ this._pass = pass; }
    public void setQuestion(int[] id){ this._question = id; }
    public void setTask(int[] id){ this._task = id; }

    public void setTaskOne(int jsonArray, int location){
        this._task[location] = jsonArray;
    }
    void setTaskTime(int id){ this._task_time = id; }
    public String getString(){
        JSONObject jsonObject = new JSONObject();
        try {
            JSONArray json_question = new JSONArray();
            JSONArray json_task = new JSONArray();
            for (int i = 0; i < this._number_question; ++i){
                json_question.put(i, this._question[i]);
                json_task.put(i, this._task[i]);
            }
            jsonObject.put(question, json_question);
            jsonObject.put(task, json_task);
            jsonObject.put("id",this._id);
            jsonObject.put("number_question",this._number_question);
            jsonObject.put("seconds_time",this._seconds_time);
            jsonObject.put("pass",this._pass);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jsonObject.toString();
    }
}
