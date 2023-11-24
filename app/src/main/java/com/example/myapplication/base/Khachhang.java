package com.example.myapplication.base;

public class Khachhang {
    int _id;
    String _name;
    String _code;
    int _thang;
    int _nam;
    int _chi_so;
    String _note;


    public Khachhang(String name, String code, int thang, int nam, int chi_so, String note){
        this._name = name;
        this._code = code;
        this._thang = thang;
        this._nam = nam;
        this._chi_so = chi_so;
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

    public int get_chi_so() {
        return _chi_so;
    }

    public void set_chi_so(int _chi_so) {
        this._chi_so = _chi_so;
    }

    public int get_nam() {
        return _nam;
    }

    public void set_nam(int _nam) {
        this._nam = _nam;
    }

    public int get_thang() {
        return _thang;
    }

    public void set_thang(int _thang) {
        this._thang = _thang;
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
