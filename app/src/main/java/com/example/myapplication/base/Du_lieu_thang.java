package com.example.myapplication.base;

public class Du_lieu_thang {
    int _id;
    int _id_khach_hang;
    int _thang;
    int _nam;
    int _chi_so;
    String _note;

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public int get_id_khach_hang() {
        return _id_khach_hang;
    }

    public void set_id_khach_hang(int _id_khach_hang) {
        this._id_khach_hang = _id_khach_hang;
    }

    public int get_thang() {
        return _thang;
    }

    public void set_thang(int _thang) {
        this._thang = _thang;
    }

    public int get_nam() {
        return _nam;
    }

    public void set_nam(int _nam) {
        this._nam = _nam;
    }

    public int get_chi_so() {
        return _chi_so;
    }

    public void set_chi_so(int _chi_so) {
        this._chi_so = _chi_so;
    }

    public String get_note() {
        return _note;
    }

    public void set_note(String _note) {
        this._note = _note;
    }

    public Du_lieu_thang(int id_khach_hang, int thang, int nam, int chi_so, String note){
        this._id_khach_hang = id_khach_hang;
        this._thang = thang;
        this._nam = nam;
        this._chi_so = chi_so;
        this._note = note;
    }

}
