package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.widget.TextView;

import com.example.myapplication.base.DataBaseHelper;
import com.example.myapplication.base.Law;
import com.example.myapplication.base.Question;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setDatabase();

        DataBaseHelper dataBaseHelper = new DataBaseHelper(this);

        Question question = dataBaseHelper.getQuestion(1);

        String image = question.getImage();

        TextView textView = (TextView) findViewById(R.id.tv);

        textView.setText(image);

    }
    void setDatabase(){
        SharedPreferences mPref = getPreferences(MODE_PRIVATE);
        int version = mPref.getInt("versionCode", 0);
        int version_now = getVersionCode();

        DataBaseHelper myDbHelper = new DataBaseHelper(this);//        int version = myDbHelper.getVersion();
        if (version < version_now  || !myDbHelper.checkDataBase()) {
            mPref.edit().putInt("versionCode", version_now).apply();
            try {
                myDbHelper.createDataBase();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        myDbHelper.openDataBase();
        myDbHelper.close();
    }
    int getVersionCode(){
        PackageInfo pInfo = null;
        try {
            pInfo = getPackageManager().getPackageInfo(getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        int versionCode = pInfo.versionCode;
        return versionCode;
    }
}