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
public class Chuong {
    int _id;
    String _name;
    int _number;
    int _id_law;

    public Chuong(){}

    public Chuong(String name, int number, int id_law){
        this._name = name;
        this._number = number;
        this._id_law = id_law;
    }
    public Chuong(int id, String name, int number, int id_law){
        this._id = id;
        this._name = name;
        this._number = number;
        this._id_law = id_law;
    }
    void set_id(int id){ this._id = id; }
    void set_name(String name){ this._name = name; }
    void set_number(int id){ this._number = id; }
    void set_id_law(int id){ this._id_law = id; }
    
    public int get_id(){ return this._id;}
    public String get_name(){ return this._name;}
    public int get_number(){ return this._number;}
    public int get_id_law(){ return this._id_law;}
}
