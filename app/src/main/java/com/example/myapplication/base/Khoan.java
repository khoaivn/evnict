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
public class Khoan {
    int _id;
    String _name;
    String _number;
    int _id_diem;
    
    public Khoan(){}
    
    public Khoan(String name, String number, int id_diem){
        this._name = name;
        this._number = number;
        this._id_diem = id_diem;
    }
    public Khoan(int id, String name, String number, int id_diem){
        this._id = id;
        this._name = name;
        this._number = number;
        this._id_diem = id_diem;
    }
    void set_id(int id){ this._id = id; }
    void set_name(String name){ this._name = name; }
    void set_number(String id){ this._number = id; }
    void set_id_diem(int id){ this._id_diem = id; }
    
    public int get_id(){ return this._id;}
    public String get_name(){ return this._name;}
    public String get_number(){ return this._number;}
    public int get_id_diem(){ return this._id_diem;}
}
