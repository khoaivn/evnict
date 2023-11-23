/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.myapplication.base;

/**
 *
 * @author TruDu
 */
public class Law {
    int _id;
    String _name;
    String _short_name;
    int _type;

    public Law(){}

    public Law(String name, String short_name, int type){
        this._name = name;
        this._short_name = short_name;
        this._type = type;
    }
    public Law(int id, String name, String short_name, int type){
        this._id = id;
        this._name = name;
        this._short_name = short_name;
        this._type = type;
    }
    void set_id(int id){ this._id = id; }
    void set_name(String name){ this._name = name; }
    void set_short_name(String name){ this._short_name = name; }
    void set_type(int id){ this._type = id; }
    
    public int get_id(){ return this._id;}
    public String get_name(){ return this._name;}
    public String get_short_name(){ return this._short_name;}
    public int get_type(){ return this._type;}
}
