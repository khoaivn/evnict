/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.myapplication.base;

import org.json.JSONArray;
import org.json.JSONException;

/**
 *
 * @author TruDu
 */
public class Dieu {
    int _id;
    String _name;
    int _number;
    String _description;
    int _id_chuong;
    String _note;
    JSONArray _id_diem;
    
    public Dieu(){
        this._id_diem = new JSONArray();
    }
    
    public Dieu(String name, int number, String description, int id_chuong, String note, JSONArray id_diem){
        this._name = name;
        this._number = number;
        this._description = description;
        this._id_chuong = id_chuong;
        this._note = note;
        this._id_diem = id_diem;
    }
    public Dieu(int id, String name, int number, String description, int id_chuong, String note, JSONArray id_diem){
        this._id = id;
        this._name = name;
        this._number = number;
        this._description = description;
        this._id_chuong = id_chuong;
        this._note = note;
        this._id_diem = id_diem;
    }
    void set_id(int id){ this._id = id; }
    void set_name(String name){ this._name = name; }
    void set_number(int id){ this._number = id; }
    void set_description(String name){ this._description = name; }
    void set_id_chuong(int id){ this._id_chuong = id; }
    void set_note(String name){ this._note = name; }
    public void setDiemOne(int id_diem, int location){
        try {
            this._id_diem.put(location, id_diem);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
    void set_id_diem(JSONArray name){ this._id_diem = name; }
    void add_id_diem(int id_diem){
        this._id_diem.put(id_diem);
    }


    public int get_id(){ return this._id;}
    public String get_name(){ return this._name;}
    public int get_number(){ return this._number;}
    public String get_description(){ return this._description;}
    public int get_id_chuong(){ return this._id_chuong;}
    public String get_note(){ return this._note;}
    public int getOneDiem(int location){
        try {
            return this._id_diem.getInt(location);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return -1;
    }
    JSONArray get_id_diem(){ return this._id_diem; }
}
