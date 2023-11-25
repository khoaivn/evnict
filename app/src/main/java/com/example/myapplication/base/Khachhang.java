package com.example.myapplication.base;

public class Khachhang {
    int _id;
    String _name;
    String _code;
    String _note;


    public Khachhang(String name, String code, String note){
        this._name = name;
        this._code = code;
        this._note = note;
    }

    public Khachhang() {
    }

    public Khachhang(String _name) {
        this._name = _name;
    }

    public String get_note() {
        return _note;
    }

    public void set_note(String _note) {
        this._note = _note;
    }

    public String get_code() {
        return _code;
    }

    public void set_code(String _code) {
        this._code = _code;
    }

    public String get_name() {
        return _name;
    }

    public void set_name(String _name) {
        this._name = _name;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }
}
