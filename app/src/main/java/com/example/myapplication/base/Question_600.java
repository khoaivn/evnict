package com.example.myapplication.base;

import org.json.JSONArray;

/**
 * Created by anhkh on 12/30/2016.
 */

public class Question_600 {
    int _id;
    int _type;
    int _yesno;
    String _introdution;
    String _image;
    JSONArray _question;
    int _answer;
    String _note;
    public Question_600(){
        this._question = new JSONArray();;
    }
    public Question_600(int id, int type, int yesno, String introdution, String image, JSONArray question, int answer, String note){
        this._id = id;
        this._type = type;
        this._yesno = yesno;
        this._introdution = introdution;
        this._image = image;
        this._question = question;
        this._answer = answer;
        this._note = note;
    }
    public Question_600(int type, int yesno, String introdution, String image, JSONArray question, int answer, String note){
        this._type = type;
        this._yesno = yesno;
        this._introdution = introdution;
        this._image = image;
        this._question = question;
        this._answer = answer;
        this._note = note;
    }
    void setID(int id){ this._id = id; }
    void setType(int type){ this._type = type; }
    void setYesno(int type){ this._yesno = type; }
    void setIntrodution(String introdution){ this._introdution = introdution; }
    void setImage(String image){ this._image = image; }
    void setQuestion(JSONArray question){ this._question = question; }
    void setAnswer(int answer){ this._answer = answer; }
    void setNote(String note){ this._note = note; }

    public int getID(){ return this._id; }
    public int getType(){ return this._type; }
    public int getYesno(){ return this._yesno; }
    public String getIntrodution(){ return this._introdution; }
    public String getImage(){ return this._image; }
    public JSONArray getQuestion(){ return this._question; }
    public int getAnswer(){ return this._answer; }
    public String getNote(){ return this._note; }



}
