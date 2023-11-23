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


    public static final String TABLE_QUESTION = "tbl_question";
    public static final String TABLE_QUESTION_600 = "tbl_question_600";
    private static final String TABLE_DETHI = "tbl_dethi";
    private static final String TABLE_DETHI_600 = "tbl_dethi_600";
//    private static final String TABLE_EXAM_A1 = "tbl_exam_a1";
//    private static final String TABLE_EXAM_A2 = "tbl_exam_a2";
    private static final String TABLE_LAW = "tbl_law";
    private static final String TABLE_LAW_CHUONG = "tbl_law_chuong";
    private static final String TABLE_LAW_DIEU = "tbl_law_dieu";
    private static final String TABLE_LAW_DIEM = "tbl_law_diem";
    private static final String TABLE_LAW_KHOAN = "tbl_law_khoan";
    private static final String TABLE_TRAFFICE_SIGN = "tbl_traffice_sign";
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
    private static final String KEY_DESCRIPTION = "description";
    private static final String KEY_NOTE = "note";
    private static final String KEY_YESNO = "yesno";

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
    public void addQuestion(Question question) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(KEY_TYPE, question.getType());
        values.put(KEY_INTRODUTION, question.getIntrodution());
        values.put(KEY_IMAGE, question.getImage());
        values.put(KEY_QUESTION, question.getQuestion().toString());
        values.put(KEY_ANSWER, question.getAnswer().toString());

        db.insert(TABLE_QUESTION, null, values);
        db.close();
    }
    public void addDeThi(DeThi dethi) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(KEY_NUMBER_QUESTION, dethi.getNumberQuestion());
        values.put(KEY_SECONDS_TIME, dethi.getSecondsTime());
        values.put(KEY_PASS, dethi.getPass());
        values.put(KEY_QUESTION, convertArraytoString(dethi.getQuestion()));
        values.put(KEY_TASK, convertJsontoString(dethi.getTask()));
        values.put(KEY_TASK_TIME, Integer.toString(dethi.getTaskTime()));

        db.insert(TABLE_DETHI, null, values);
        db.close();
    }
    public void addTrafficeSign(TrafficeSign trafficeSign) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(KEY_CODE, trafficeSign.get_code());
        values.put(KEY_TYPE, Integer.toString(trafficeSign.get_type()));
        values.put(KEY_IMAGE, trafficeSign.get_image());
        values.put(KEY_NAME, trafficeSign.get_name());
        values.put(KEY_DESCRIBE, trafficeSign.get_describe());

        db.insert(TABLE_TRAFFICE_SIGN, null, values);
        db.close();
    }
    public Question getQuestion(int id) {
        Question question = new Question();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_QUESTION,
                new String[] {KEY_ID, KEY_TYPE, KEY_INTRODUTION, KEY_IMAGE, KEY_QUESTION, KEY_ANSWER},
                KEY_ID + "=?",
                new String[] {String.valueOf(id)}, null, null, null, null);
        if  (cursor != null) {
            cursor.moveToFirst(); //De sai
            question.setID(Integer.parseInt(cursor.getString(0)));
            question.setType(Integer.parseInt(cursor.getString(1)));
            question.setIntrodution(cursor.getString(2));
            question.setImage(cursor.getString(3));
            try {
                question.setQuestion(new JSONArray(cursor.getString(4)));
            } catch (JSONException e) {
                e.printStackTrace();
            }
            try {
                question.setAnswer(new JSONArray(cursor.getString(5)));
            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
        cursor.close();
        db.close();
        return question;
    }
    public Question_600 getQuestion600(int id) {
        Question_600 question = new Question_600();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_QUESTION_600, new String[] {KEY_ID, KEY_TYPE, KEY_YESNO, KEY_INTRODUTION, KEY_IMAGE, KEY_QUESTION, KEY_ANSWER, KEY_NOTE},
                KEY_ID + "=?",
                new String[] {String.valueOf(id)}, null, null, null, null);
        if  (cursor != null) {
            cursor.moveToFirst(); //De sai
            question.setID(Integer.parseInt(cursor.getString(0)));
            question.setType(Integer.parseInt(cursor.getString(1)));
            question.setYesno(Integer.parseInt(cursor.getString(2)));
            question.setIntrodution(cursor.getString(3));
            question.setImage(cursor.getString(4));
            try {
                question.setQuestion(new JSONArray(cursor.getString(5)));
            } catch (JSONException e) {
                e.printStackTrace();
            }
            question.setAnswer(Integer.parseInt(cursor.getString(6)));
            question.setNote(cursor.getString(7));
        }
        cursor.close();
        db.close();
        return question;
    }
    public ArrayList<Question> getQuestionType(int type) {
        ArrayList<Question> questionArrayList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_QUESTION, new String[] {KEY_ID, KEY_TYPE, KEY_INTRODUTION, KEY_IMAGE, KEY_QUESTION, KEY_ANSWER},
                KEY_TYPE + "=?",
                new String[] {String.valueOf(type)}, null, null, null, null);
        if  (cursor != null) {
            cursor.moveToFirst(); //De sai
            while (!cursor.isAfterLast()) {
                Question question = new Question();
                question.setID(Integer.parseInt(cursor.getString(0)));
                question.setType(Integer.parseInt(cursor.getString(1)));
                question.setIntrodution(cursor.getString(2));
                question.setImage(cursor.getString(3));
                try {
                    question.setQuestion(new JSONArray(cursor.getString(4)));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                try {
                    question.setAnswer(new JSONArray(cursor.getString(5)));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                questionArrayList.add(question);
                cursor.moveToNext();
            }

        }
        cursor.close();
        db.close();
        return questionArrayList;
    }
    public ArrayList<Question_600> getQuestion600Type(int type) {
        ArrayList<Question_600> questionArrayList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_QUESTION_600, new String[] {KEY_ID, KEY_TYPE, KEY_YESNO, KEY_INTRODUTION, KEY_IMAGE, KEY_QUESTION, KEY_ANSWER},
                KEY_TYPE + "=?",
                new String[] {String.valueOf(type)}, null, null, null, null);
        if  (cursor != null) {
            cursor.moveToFirst(); //De sai
            while (!cursor.isAfterLast()) {
                Question_600 question = new Question_600();
                question.setID(Integer.parseInt(cursor.getString(0)));
                question.setType(Integer.parseInt(cursor.getString(1)));
                question.setYesno(Integer.parseInt(cursor.getString(2)));
                question.setIntrodution(cursor.getString(3));
                question.setImage(cursor.getString(4));
                try {
                    question.setQuestion(new JSONArray(cursor.getString(5)));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                question.setAnswer(Integer.parseInt(cursor.getString(6)));
                question.setNote(cursor.getString(7));
                questionArrayList.add(question);
                cursor.moveToNext();
            }

        }
        cursor.close();
        db.close();
        return questionArrayList;
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
    public ArrayList<Integer> getListIDQuestionYesno(String tbl) {
        ArrayList<Integer> questionArrayList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(tbl, new String[] {KEY_ID},
                KEY_YESNO + "=?",
                new String[] {String.valueOf(1)}, null, null, null, null);
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
    public DeThi getDeThi(int id) {
        DeThi deThi = new DeThi();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_DETHI,
                new String[] {KEY_ID, KEY_NUMBER_QUESTION, KEY_SECONDS_TIME, KEY_PASS, KEY_QUESTION, KEY_TASK, KEY_TASK_TIME},
                KEY_ID + "=?",
                new String[] {String.valueOf(id)}, null, null, null, null);
        if  (cursor != null) {
            cursor.moveToFirst(); //De sai
            deThi.setID(Integer.parseInt(cursor.getString(0)));
            deThi.setNumberQuestion(Integer.parseInt(cursor.getString(1)));
            deThi.setSecondsTime(Integer.parseInt(cursor.getString(2)));
            deThi.setPass(Integer.parseInt(cursor.getString(3)));
            deThi.setQuestion(convertStringtoArray(cursor.getString(4), deThi.getNumberQuestion()));
            deThi.setTask(convertStringtoJson(cursor.getString(5), deThi.getNumberQuestion()));
            deThi.setTaskTime(Integer.valueOf(cursor.getString(6)));
        }
        cursor.close();
        db.close();
        return deThi;
    }
    public DeThi_600 getDeThi600(int id) {
        DeThi_600 deThi = new DeThi_600();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_DETHI_600,
                new String[] {KEY_ID, KEY_NUMBER_QUESTION, KEY_SECONDS_TIME, KEY_PASS, KEY_QUESTION, KEY_TASK, KEY_TASK_TIME},
                KEY_ID + "=?",
                new String[] {String.valueOf(id)}, null, null, null, null);
        if  (cursor != null) {
            cursor.moveToFirst(); //De sai
            deThi.setID(Integer.parseInt(cursor.getString(0)));
            deThi.setNumberQuestion(Integer.parseInt(cursor.getString(1)));
            deThi.setSecondsTime(Integer.parseInt(cursor.getString(2)));
            deThi.setPass(Integer.parseInt(cursor.getString(3)));
            deThi.setQuestion(convertStringtoArray(cursor.getString(4), deThi.getNumberQuestion()));
            deThi.setTask(convertStringtoArray(cursor.getString(5), deThi.getNumberQuestion()));
            if (cursor.getString(6) != null)
                deThi.setTaskTime(Integer.valueOf(cursor.getString(6)));
        }
        cursor.close();
        db.close();
        return deThi;
    }
//    public DeThi getDeThiA2(int id) {
//        DeThi deThi = new DeThi();
//        SQLiteDatabase db = this.getReadableDatabase();
//        Cursor cursor = db.query(TABLE_EXAM_A2,
//                new String[] {KEY_ID, KEY_NUMBER_QUESTION, KEY_SECONDS_TIME, KEY_PASS, KEY_QUESTION, KEY_TASK, KEY_TASK_TIME},
//                KEY_ID + "=?",
//                new String[] {String.valueOf(id)}, null, null, null, null);
//        if  (cursor != null) {
//            cursor.moveToFirst(); //De sai
//            deThi.setID(Integer.parseInt(cursor.getString(0)));
//            deThi.setNumberQuestion(Integer.parseInt(cursor.getString(1)));
//            deThi.setSecondsTime(Integer.parseInt(cursor.getString(2)));
//            deThi.setPass(Integer.parseInt(cursor.getString(3)));
//            deThi.setQuestion(convertStringtoArray(cursor.getString(4), deThi.getNumberQuestion()));
//            deThi.setTask(convertStringtoJson(cursor.getString(5), deThi.getNumberQuestion()));
//            deThi.setTaskTime(Integer.valueOf(cursor.getString(6)));
//        }
//        cursor.close();
//        db.close();
//        return deThi;
//    }
    public TrafficeSign get_traffice_sign(int id) {
        TrafficeSign trafficeSign = new TrafficeSign();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_TRAFFICE_SIGN, new String[] {KEY_ID, KEY_CODE, KEY_TYPE, KEY_IMAGE, KEY_NAME, KEY_DESCRIBE},
                KEY_ID + "=?",
                new String[] {String.valueOf(id)}, null, null, null, null);
        if  (cursor != null) {
            cursor.moveToFirst(); //De sai
            trafficeSign.setID(Integer.parseInt(cursor.getString(0)));
            trafficeSign.set_code(cursor.getString(1));
            trafficeSign.set_type(Integer.parseInt(cursor.getString(2)));
            trafficeSign.set_image(cursor.getString(3));
            trafficeSign.set_name(cursor.getString(4));
            trafficeSign.set_describe(cursor.getString(5));
        }
        cursor.close();
        db.close();
        return trafficeSign;
    }
    public ArrayList<TrafficeSign> get_traffice_sign_typpe(int type) {
        ArrayList<TrafficeSign> listTrafficeSign = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_TRAFFICE_SIGN, new String[] {KEY_ID, KEY_CODE, KEY_TYPE, KEY_IMAGE, KEY_NAME, KEY_DESCRIBE},
                KEY_TYPE + "=?",
                new String[] {String.valueOf(type)}, null, null, KEY_CODE, null);
        if  (cursor != null) {
            cursor.moveToFirst(); //De sai
            while (!cursor.isAfterLast()) {
                TrafficeSign trafficeSign = new TrafficeSign();
                trafficeSign.setID(Integer.parseInt(cursor.getString(0)));
                trafficeSign.set_code(cursor.getString(1));
                trafficeSign.set_type(Integer.parseInt(cursor.getString(2)));
                trafficeSign.set_image(cursor.getString(3));
                trafficeSign.set_name(cursor.getString(4));
                trafficeSign.set_describe(cursor.getString(5));
                listTrafficeSign.add(trafficeSign);
                cursor.moveToNext();
            }
        }
        cursor.close();
        db.close();
        return listTrafficeSign;
    }
    public ArrayList<TrafficeSign> get_all_traffice_sign() {
        ArrayList<TrafficeSign> listTrafficeSign = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_TRAFFICE_SIGN, new String[] {KEY_ID, KEY_CODE, KEY_TYPE, KEY_IMAGE, KEY_NAME, KEY_DESCRIBE},
                null, null, null, null, null);
        if  (cursor != null) {
            cursor.moveToFirst(); //De sai
            while (!cursor.isAfterLast()) {
                TrafficeSign trafficeSign = new TrafficeSign();
                trafficeSign.setID(Integer.parseInt(cursor.getString(0)));
                trafficeSign.set_code(cursor.getString(1));
                trafficeSign.set_type(Integer.parseInt(cursor.getString(2)));
                trafficeSign.set_image(cursor.getString(3));
                trafficeSign.set_name(cursor.getString(4));
                trafficeSign.set_describe(cursor.getString(5));
                listTrafficeSign.add(trafficeSign);
                cursor.moveToNext();
            }
        }
        cursor.close();
        db.close();
        return listTrafficeSign;
    }

    public List<String> getAllName(){
        List<String> list_name = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_TRAFFICE_SIGN,
                new String[] {KEY_NAME},null, null, null, null, null);
        if  (cursor != null) {
            cursor.moveToFirst(); //De sai
            while (!cursor.isAfterLast()) {
                list_name.add(cursor.getString(0));
//                TrafficeSign trafficeSign = new TrafficeSign();
//                trafficeSign.setID(Integer.parseInt(cursor.getString(0)));
//                trafficeSign.set_code(cursor.getString(1));
//                trafficeSign.set_type(Integer.parseInt(cursor.getString(2)));
//                trafficeSign.set_image(cursor.getString(3));
//                trafficeSign.set_name(cursor.getString(4));
//                trafficeSign.set_describe(cursor.getString(5));
//                listTrafficeSign.add(trafficeSign);
                cursor.moveToNext();
            }
        }
        cursor.close();
        db.close();
        return list_name;
    }
    public Law get_law(int id) {
        Law law = new Law();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_LAW, new String[] {KEY_ID, KEY_NAME, KEY_SHORT_NAME, KEY_TYPE},
                KEY_ID + "=?",
                new String[] {String.valueOf(id)}, null, null, null, null);
        if  (cursor != null) {
            cursor.moveToFirst(); //De sai
            law.set_id(Integer.parseInt(cursor.getString(0)));
            law.set_name(cursor.getString(1));
            law.set_short_name(cursor.getString(2));
            law.set_type(Integer.parseInt(cursor.getString(3)));
        }
        cursor.close();
        db.close();
        return law;
    }
    public Chuong get_chuong(int id) {
        Chuong chuong = new Chuong();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_LAW_CHUONG, new String[] {KEY_ID, KEY_NUMBER, KEY_NAME, KEY_ID_LAW},
                KEY_ID + "=?",
                new String[] {String.valueOf(id)}, null, null, null, null);
        if  (cursor != null) {
            cursor.moveToFirst(); //De sai
            chuong.set_id(Integer.parseInt(cursor.getString(0)));
            chuong.set_number(Integer.parseInt(cursor.getString(1)));
            chuong.set_name(cursor.getString(2));
            chuong.set_id_law(Integer.parseInt(cursor.getString(3)));
        }
        cursor.close();
        db.close();
        return chuong;
    }
    public Dieu get_dieu(int id) {
        Dieu dieu = new Dieu();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_LAW_DIEU, new String[] {KEY_ID, KEY_NAME, KEY_NUMBER, KEY_DESCRIPTION, KEY_ID_CHUONG, KEY_NOTE},
                KEY_ID + "=?",
                new String[] {String.valueOf(id)}, null, null, null, null);
        if  (cursor != null) {
            cursor.moveToFirst(); //De sai
            dieu.set_id(Integer.parseInt(cursor.getString(0)));
            dieu.set_name(cursor.getString(1));
            dieu.set_number(Integer.parseInt(cursor.getString(2)));
            dieu.set_description(cursor.getString(3));
            dieu.set_id_chuong(Integer.parseInt(cursor.getString(4)));
            dieu.set_note(cursor.getString(5));
        }
        cursor.close();
        db.close();
        return dieu;
    }
    public ArrayList<Dieu> get_all_dieu() {
        ArrayList<Dieu> list_dieu = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_LAW_DIEU, new String[] {KEY_ID, KEY_NAME, KEY_NUMBER, KEY_DESCRIPTION, KEY_ID_CHUONG, KEY_NOTE, KEY_ID_DIEM},
                null,
                null, null, null, null, null);
        if  (cursor != null) {
            cursor.moveToFirst(); //De sai
            while (!cursor.isAfterLast()) {
                Dieu dieu = new Dieu();
                dieu.set_id(Integer.parseInt(cursor.getString(0)));
                dieu.set_name(cursor.getString(1));
                dieu.set_number(Integer.parseInt(cursor.getString(2)));
                dieu.set_description(cursor.getString(3));
                dieu.set_id_chuong(Integer.parseInt(cursor.getString(4)));
                dieu.set_note(cursor.getString(5));
                try {
                    dieu.set_id_diem(new JSONArray(cursor.getString(6)));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                list_dieu.add(dieu);
                cursor.moveToNext();
            }
        }
        cursor.close();
        db.close();
        return list_dieu;
    }
    public ArrayList<Diem> get_all_diem() {
        ArrayList<Diem> list_diem = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_LAW_DIEM, new String[] {KEY_ID, KEY_NAME, KEY_NUMBER, KEY_DESCRIPTION, KEY_ID_DIEU, KEY_ID_KHOAN},
                null,
                null, null, null, null, null);
        if  (cursor != null) {
            cursor.moveToFirst(); //De sai
            while (!cursor.isAfterLast()) {
                Diem diem = new Diem();
                diem.set_id(Integer.parseInt(cursor.getString(0)));
                diem.set_name(cursor.getString(1));
                diem.set_number(Integer.parseInt(cursor.getString(2)));
                diem.set_description(cursor.getString(3));
                diem.set_id_dieu(Integer.parseInt(cursor.getString(4)));
                try {
                    diem.set_id_khoan(new JSONArray(cursor.getString(5)));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                list_diem.add(diem);
                cursor.moveToNext();
            }
        }
        cursor.close();
        db.close();
        return list_diem;
    }
    public ArrayList<Khoan> get_all_khoan() {
        ArrayList<Khoan> list_khoan = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_LAW_KHOAN, new String[] {KEY_ID, KEY_NAME, KEY_NUMBER, KEY_ID_DIEM},
                null,
                null, null, null, null, null);
        if  (cursor != null) {
            cursor.moveToFirst(); //De sai
            while (!cursor.isAfterLast()) {
                Khoan diem = new Khoan();
                diem.set_id(Integer.parseInt(cursor.getString(0)));
                diem.set_name(cursor.getString(1));
                diem.set_number(cursor.getString(2));
                diem.set_id_diem(Integer.parseInt(cursor.getString(3)));

                list_khoan.add(diem);
                cursor.moveToNext();
            }
        }
        cursor.close();
        db.close();
        return list_khoan;
    }
    public int get_id_law(int id_chuong) {
        int id = -1;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_LAW_CHUONG, new String[] {KEY_ID_LAW},
                KEY_ID + "=?",
                new String[] {String.valueOf(id_chuong)}, null, null, null, null);
        if  (cursor != null) {
            cursor.moveToFirst();
            id = Integer.parseInt(cursor.getString(0));
        }
        cursor.close();
        db.close();
        return id;
    }
    public ArrayList<Law> get_all_law() {
        ArrayList<Law> list_law = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_LAW, new String[] {KEY_ID, KEY_NAME, KEY_SHORT_NAME, KEY_TYPE},
                null,
                null, null, null, null, null);
        if  (cursor != null) {
            cursor.moveToFirst(); //De sai
            while (!cursor.isAfterLast()) {
                Law chuong = new Law();
                chuong.set_id(Integer.parseInt(cursor.getString(0)));
                chuong.set_name(cursor.getString(1));
                chuong.set_short_name(cursor.getString(2));
                chuong.set_type(Integer.parseInt(cursor.getString(3)));
                list_law.add(chuong);
                cursor.moveToNext();
            }
        }
        cursor.close();
        db.close();
        return list_law;
    }
    public ArrayList<Chuong> get_chuong_id_law(int id) {
        ArrayList<Chuong> list_chuong = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_LAW_CHUONG, new String[] {KEY_ID, KEY_NAME, KEY_NUMBER, KEY_ID_LAW},
                KEY_ID_LAW + "=?",
                new String[] {String.valueOf(id)}, null, null, null, null);
        if  (cursor != null) {
            cursor.moveToFirst(); //De sai
            while (!cursor.isAfterLast()) {
                Chuong chuong = new Chuong();
                chuong.set_id(Integer.parseInt(cursor.getString(0)));
                chuong.set_name(cursor.getString(1));
                chuong.set_number(Integer.parseInt(cursor.getString(2)));
                chuong.set_id_law(Integer.parseInt(cursor.getString(3)));
                list_chuong.add(chuong);
                cursor.moveToNext();
            }
        }
        cursor.close();
        db.close();
        return list_chuong;
    }
    public ArrayList<Dieu> get_dieu_id_chuong(int id) {
        ArrayList<Dieu> dieuArrayList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_LAW_DIEU, new String[] {KEY_ID, KEY_NAME, KEY_NUMBER, KEY_DESCRIPTION, KEY_ID_CHUONG, KEY_NOTE},
                KEY_ID_CHUONG + "=?",
                new String[] {String.valueOf(id)}, null, null, null, null);
        if  (cursor != null) {
            cursor.moveToFirst(); //De sai
            while (!cursor.isAfterLast()) {
                Dieu dieu = new Dieu();
                dieu.set_id(Integer.parseInt(cursor.getString(0)));
                dieu.set_name(cursor.getString(1));
                dieu.set_number(Integer.parseInt(cursor.getString(2)));
                dieu.set_description(cursor.getString(3));
                dieu.set_id_chuong(Integer.parseInt(cursor.getString(4)));
                dieu.set_note(cursor.getString(5));
                dieuArrayList.add(dieu);
                cursor.moveToNext();
            }
        }
        cursor.close();
        db.close();
        return dieuArrayList;
    }
    public ArrayList<Diem> get_diem_id_dieu(int id) {
        ArrayList<Diem> diemArrayList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_LAW_DIEM, new String[] {KEY_ID, KEY_NAME, KEY_NUMBER, KEY_DESCRIPTION, KEY_ID_DIEU},
                KEY_ID_DIEU + "=?",
                new String[] {String.valueOf(id)}, null, null, null, null);
        if  (cursor != null) {
            cursor.moveToFirst(); //De sai
            while (!cursor.isAfterLast()) {
                Diem diem = new Diem();
                diem.set_id(Integer.parseInt(cursor.getString(0)));
                diem.set_name(cursor.getString(1));
                diem.set_number(Integer.parseInt(cursor.getString(2)));
                diem.set_description(cursor.getString(3));
                diem.set_id_dieu(Integer.parseInt(cursor.getString(4)));
                diemArrayList.add(diem);
                cursor.moveToNext();
            }
        }
        cursor.close();
        db.close();
        return diemArrayList;
    }
    public ArrayList<Khoan> get_khoan_id_diem(int id) {
        ArrayList<Khoan> khoanArrayList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_LAW_KHOAN, new String[] {KEY_ID, KEY_NAME, KEY_NUMBER, KEY_ID_DIEM},
                KEY_ID_DIEM + "=?",
                new String[] {String.valueOf(id)}, null, null, null, null);
        if  (cursor != null) {
            cursor.moveToFirst(); //De sai
            while (!cursor.isAfterLast()) {
                Khoan khoan = new Khoan();
                khoan.set_id(Integer.parseInt(cursor.getString(0)));
                khoan.set_name(cursor.getString(1));
                khoan.set_number(cursor.getString(2));
                khoan.set_id_diem(Integer.parseInt(cursor.getString(3)));
                khoanArrayList.add(khoan);
                cursor.moveToNext();
            }
        }
        cursor.close();
        db.close();
        return khoanArrayList;
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