package com.example.myapplication.base;

import org.json.JSONArray;

/**
 * Created by anhkh on 12/30/2016.
 */

public class Question {
    int _id;
    int _type;
    String _introdution;
    String _image;
    JSONArray _question;
    JSONArray _answer;
    String _note;
    public Question(){
        JSONArray jsonArray = new JSONArray();
        this._answer = jsonArray;
        this._question = jsonArray;
    }
    public Question(int id, String introdution, String image, JSONArray question, JSONArray answer, String note){
        this._id = id;
        this._introdution = introdution;
        this._image = image;
        this._question = question;
        this._answer = answer;
        this._note = note;
    }
    public Question(String introdution, String image, JSONArray question, JSONArray answer, String note){
        this._introdution = introdution;
        this._image = image;
        this._question = question;
        this._answer = answer;
        this._note = note;
    }
    void setID(int id){ this._id = id; }
    public void setType(int type){ this._type = type; }
    void setIntrodution(String introdution){ this._introdution = introdution; }
    void setImage(String image){ this._image = image; }
    void setQuestion(JSONArray question){ this._question = question; }
    void setAnswer(JSONArray answer){ this._answer = answer; }
    void setNote(String note){ this._note = note; }

    public int getID(){ return this._id; }
    int getType(){ return this._type; }
    public String getIntrodution(){ return this._introdution; }
    public String getImage(){ return this._image; }
    public JSONArray getQuestion(){ return this._question; }
    public JSONArray getAnswer(){ return this._answer; }
    public String getNote(){ return this._note; }



}
