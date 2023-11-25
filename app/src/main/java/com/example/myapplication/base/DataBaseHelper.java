package com.example.myapplication.base;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

public class DataBaseHelper extends SQLiteOpenHelper
{
    private static String TAG = "DataBaseHelper"; // Tag just for the LogCat window
    //destination path (location) of our database on device
    private static String DB_PATH = "";
    private static String DB_NAME ="testoto.sqlite";// Database name
    private SQLiteDatabase mDataBase;
    private final Context mContext;
    public static final String TABLE_KHACHHANG = "tbl_khachhang";
    public static final String TABLE_DU_LIEU_THANG = "tbl_du_lieu_thang";
    private static final String KEY_ID = "_id";
    private static final String KEY_INTRODUTION = "introdution";
    private static final String KEY_IMAGE = "image";
    private static final String KEY_QUESTION = "question";
    private static final String KEY_ANSWER = "answer";
    private static final String KEY_TASK = "task";
    private static final String KEY_TASK_TIME = "task_time";
    private static final String KEY_CODE = "code";
    private static final String KEY_TYPE = "type";
    private static final String KEY_NAME = "name";
    private static final String KEY_DESCRIBE = "describe";
    private static final String KEY_NUMBER_QUESTION = "number_question";
    private static final String KEY_SECONDS_TIME = "seconds_time";
    private static final String KEY_PASS = "pass";
    private static final String KEY_SHORT_NAME = "short_name";
    private static final String KEY_NUMBER = "number";
    private static final String KEY_ID_LAW = "id_law";
    private static final String KEY_ID_CHUONG = "id_chuong";
    private static final String KEY_ID_DIEU = "id_dieu";
    private static final String KEY_ID_DIEM = "id_diem";
    private static final String KEY_ID_KHOAN = "id_khoan";
    private static final String KEY_ID_KHACHHANG = "id_khachhang";
    private static final String KEY_DESCRIPTION = "description";
    private static final String KEY_NOTE = "note";
    private static final String KEY_YESNO = "yesno";
    private static final String KEY_THANG = "thang";
    private static final String KEY_NAM = "nam";
    private static final String KEY_CHI_SO = "chi_so";
    public DataBaseHelper(Context context)
    {
        super(context, DB_NAME, null, 94);// 1? Its database Version
        if(android.os.Build.VERSION.SDK_INT >= 17){
            DB_PATH = context.getApplicationInfo().dataDir + "/databases/";
        }
        else
        {
            DB_PATH = "/data/data/" + context.getPackageName() + "/databases/";
        }
        this.mContext = context;
    }



    public void createDataBase() throws IOException
    {
        //If the database does not exist, copy it from the assets.

        boolean mDataBaseExist = checkDataBase();
//        if(!mDataBaseExist)
//        {
            this.getReadableDatabase();
            this.close();
            try
            {
                //Copy the database from assests
                copyDataBase();
                Log.e(TAG, "createDatabase database created");
            }
            catch (IOException mIOException)
            {
                throw new Error("ErrorCopyingDataBase");
            }
//        }
    }

    //Check that the database exists here: /data/data/your package/databases/Da Name
    public boolean checkDataBase()
    {
        File dbFile = new File(DB_PATH + DB_NAME);
        //Log.v("dbFile", dbFile + "   "+ dbFile.exists());
        return dbFile.exists();
    }

    //Copy the database from assets
    private void copyDataBase() throws IOException
    {
        InputStream mInput = mContext.getAssets().open(DB_NAME);
        String outFileName = DB_PATH + DB_NAME;
        OutputStream mOutput = new FileOutputStream(outFileName);
        byte[] mBuffer = new byte[1024];
        int mLength;
        while ((mLength = mInput.read(mBuffer))>0)
        {
            mOutput.write(mBuffer, 0, mLength);
        }
        mOutput.flush();
        mOutput.close();
        mInput.close();
    }

    //Open the database, so we can query it
    public boolean openDataBase() throws SQLException
    {
        String mPath = DB_PATH + DB_NAME;
        //Log.v("mPath", mPath);
        mDataBase = SQLiteDatabase.openDatabase(mPath, null, SQLiteDatabase.CREATE_IF_NECESSARY);
        //mDataBase = SQLiteDatabase.openDatabase(mPath, null, SQLiteDatabase.NO_LOCALIZED_COLLATORS);
        return mDataBase != null;
    }

    @Override
    public synchronized void close()
    {
        if(mDataBase != null)
            mDataBase.close();
        super.close();
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
    public void addKhanhhang(Khachhang khachhang) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(KEY_NAME, khachhang.get_name());
        values.put(KEY_CODE, khachhang.get_code());
        values.put(KEY_NOTE, khachhang.get_note());

        db.insert(TABLE_KHACHHANG, null, values);
        db.close();
    }
    public void add_du_lieu_thang(Du_lieu_thang duLieuThang) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(KEY_ID_KHACHHANG, duLieuThang.get_id_khach_hang());
        values.put(KEY_THANG, duLieuThang.get_thang());
        values.put(KEY_NAM, duLieuThang.get_nam());
        values.put(KEY_CHI_SO, duLieuThang.get_chi_so());
        values.put(KEY_NOTE, duLieuThang.get_note());

        db.insert(TABLE_DU_LIEU_THANG, null, values);
        db.close();
    }

    public Khachhang getKhanhhang(int id) {
        Khachhang khachhang = new Khachhang();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_KHACHHANG,
                new String[] {KEY_ID, KEY_NAME, KEY_CODE, KEY_NOTE},
                KEY_ID + "=?",
                new String[] {String.valueOf(id)},
                null,
                null,
                null,
                null);

        if  (cursor != null) {
            cursor.moveToFirst(); //De sai
            khachhang.set_id(Integer.parseInt(cursor.getString(0)));
            khachhang.set_name(cursor.getString(1));
            khachhang.set_code(cursor.getString(2));
            khachhang.set_note(cursor.getString(3));
        }
        cursor.close();
        db.close();
        return khachhang;
    }

    public Khachhang getKhanhhangByCode(String code_khachhang) {
        Khachhang khachhang = new Khachhang();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_KHACHHANG,
                new String[] {KEY_ID, KEY_NAME, KEY_CODE, KEY_THANG, KEY_NAM, KEY_CHI_SO, KEY_NOTE},
                KEY_CODE + "=?",
                new String[] {code_khachhang},
                null,
                null,
                null,
                null);

        if  (cursor != null) {
            cursor.moveToFirst(); //De sai
            khachhang.set_id(Integer.parseInt(cursor.getString(0)));
            khachhang.set_name(cursor.getString(1));
            khachhang.set_code(cursor.getString(2));
            khachhang.set_note(cursor.getString(3));
        }
        cursor.close();
        db.close();
        return khachhang;
    }
    public Du_lieu_thang get_du_lieu_thang(int id_khachhang, int thang, int nam) {
        Du_lieu_thang duLieuThang = new Du_lieu_thang();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_DU_LIEU_THANG,
                new String[] {KEY_ID, KEY_ID_KHACHHANG, KEY_THANG, KEY_NAM, KEY_CHI_SO, KEY_NOTE},
                 KEY_ID_KHACHHANG + "=? AND " + KEY_THANG + "=? AND " + KEY_NAM + "=?" ,
                new String[] {String.valueOf(id_khachhang), String.valueOf(thang), String.valueOf(nam)},
                null,
                null,
                null,
                null);

        if  (cursor != null) {
            cursor.moveToFirst(); //De sai
            duLieuThang.set_id(Integer.parseInt(cursor.getString(0)));
            duLieuThang.set_id_khach_hang(Integer.parseInt(cursor.getString(1)));
            duLieuThang.set_thang(Integer.parseInt(cursor.getString(2)));
            duLieuThang.set_nam(Integer.parseInt(cursor.getString(3)));
            duLieuThang.set_chi_so(Integer.parseInt(cursor.getString(4)));
            duLieuThang.set_note(cursor.getString(5));
        }
        cursor.close();
        db.close();
        return duLieuThang;
    }


    public ArrayList<Integer> getListIDQuestionType(int type, String tbl) {
        ArrayList<Integer> questionArrayList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(tbl, new String[] {KEY_ID},
                KEY_TYPE + "=?",
                new String[] {String.valueOf(type)}, null, null, null, null);
        if  (cursor != null) {
            cursor.moveToFirst(); //De sai
            while (!cursor.isAfterLast()) {
                questionArrayList.add(Integer.parseInt(cursor.getString(0)));
                cursor.moveToNext();
            }
        }
        cursor.close();
        db.close();
        return questionArrayList;
    }



    public int getVersion(){
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "PRAGMA user_version";
        Cursor cursor = db.rawQuery(query, null);
        cursor.moveToFirst();
        int version = Integer.parseInt(cursor.getString(0));
        db.close();
        return version;
    }
    static String convertArraytoString(int[] array){
        int length = array.length;
        String string = Integer.toString(array[0]);
        for (int i = 1; i < length; ++i)
            string += " " + Integer.toString(array[i]);
        return string;
    }
    static String convertJsontoString(JSONArray[] jsonArrays){
        int length = jsonArrays.length;
        String string = jsonArrays[0].toString();
        for (int i = 1; i < length; ++i)
            string += " " + jsonArrays[i].toString();
        return string;
    }
    static int[] convertStringtoArray(String string, int number_question){
        int[] array = new int[number_question];
        String[] number = string.split(" ");
        for (int i = 0; i < number_question; ++i)
            array[i] = Integer.valueOf(number[i]);
        return array;
    }
    static JSONArray[] convertStringtoJson(String string, int number_question){
        JSONArray[] array = new JSONArray[number_question];
        String[] number = string.split(" ");
        for (int i = 0; i < number_question; ++i)
            try {
                array[i] = new JSONArray(number[i]);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        return array;
    }
}