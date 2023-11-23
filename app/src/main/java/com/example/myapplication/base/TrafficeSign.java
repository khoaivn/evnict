package com.example.myapplication.base;

import org.json.JSONArray;

public class TrafficeSign{
    int _id;
    String _code;
    int _type;
    String _image;
    String _name;
    String _describe;
    public TrafficeSign(){
    }
    public TrafficeSign(int id, String code, int type, String image, String name, String describe){
        this._id = id;
        this._code = code;
        this._type = type;
        this._image = image;
        this._name = name;
        this._describe = describe;
    }
    public TrafficeSign(String code, int type, String image, String name, String describe){
        this._code = code;
        this._type = type;
        this._image = image;
        this._name = name;
        this._describe = describe;
    }
    void setID(int id){ this._id = id; }
    void set_code(String code){ this._code = code; }
    void set_type(int type){ this._type = type; }
    void set_image(String image){ this._image = image; }
    void set_name(String name){ this._name = name; }
    void set_describe(String describe){ this._describe = describe; }

    public int getID(){ return this._id; }
    public String get_code(){ return this._code; }
    public int get_type(){ return this._type; }
    public String get_image(){ return this._image; }
    public String get_name(){ return this._name; }
    public String get_describe(){ return this._describe; }
}
