/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.myapplication.base;

import org.json.JSONArray;

/**
 *
 * @author TruDu
 */
public class Diem {
    int _id;
    String _name;
    int _number;
    String _description;
    int _id_dieu;
    JSONArray _id_khoan;

    public Diem(){
        this._id_khoan = new JSONArray();
    }

    public Diem(String name, int number, String description, int id_dieu, JSONArray id_khoan){
        this._name = name;
        this._number = number;
        this._description = description;
        this._id_dieu = id_dieu;
        this._id_khoan = id_khoan;
    }
    public Diem(int id, String name, int number, String description, int id_dieu, JSONArray id_khoan){
        this._id = id;
        this._name = name;
        this._number = number;
        this._description = description;
        this._id_dieu = id_dieu;
        this._id_khoan = id_khoan;
    }
    void set_id(int id){ this._id = id; }
    void set_name(String name){ this._name = name; }
    void set_number(int id){ this._number = id; }
    void set_description(String name){ this._description = name; }
    void set_id_dieu(int id){ this._id_dieu = id; }
    void set_id_khoan(JSONArray name){ this._id_khoan = name; }
    void add_id_khoan(int id_khoan){
        this._id_khoan.put(id_khoan);
    }
    
    public int get_id(){ return this._id;}
    public String get_name(){ return this._name;}
    public int get_number(){ return this._number;}
    public String get_description(){ return this._description;}
    public int get_id_dieu(){ return this._id_dieu;}
    JSONArray get_id_khoan(){ return this._id_khoan; }
}
