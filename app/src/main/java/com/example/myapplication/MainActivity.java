package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.widget.TextView;

import com.example.myapplication.base.DataBaseHelper;
import com.example.myapplication.base.Khachhang;
import com.example.myapplication.base.Law;
import com.example.myapplication.base.Question;

import java.io.IOException;
import java.util.Arrays;

import javax.crypto.SecretKey;

public class MainActivity extends AppCompatActivity {

    DataBaseHelper dataBaseHelper;
    int don_gia = 3300;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setDatabase();

        dataBaseHelper = new DataBaseHelper(this);

//        Khachhang khachhang = new Khachhang("Nguyen Duy Anh", "HN01", 10, 2023, 210, "");
//        Khachhang khachhang1 = new Khachhang("Nguyen Duy Anh", "HN01", 11, 2023, 450, "");

//        dataBaseHelper.addKhanhhang(new Khachhang("Pham Hong Phuc", "HN05", 11, 2023, 4550, ""));
//        dataBaseHelper.addKhanhhang(khachhang1);

//        String name = dataBaseHelper.getKhanhhang(1).get_name();
//
//        TextView tv = (TextView) findViewById(R.id.tv_name);
//
//        tv.setText(name);
//        setLayoutbyCode("HN05");

        dataBaseHelper.close();


    }
    void setLayout(int id_khach_hang){
        Khachhang khachhang = dataBaseHelper.getKhanhhang(id_khach_hang);
        ((TextView) findViewById(R.id.tv_name)).setText(khachhang.get_name());
//        String thang_nam = khachhang.get_thang() + "/" + khachhang.get_nam();
//        ((TextView) findViewById(R.id.tv_thang_nam)).setText(thang_nam);
        ((TextView) findViewById(R.id.tv_chi_so_thang_truoc)).setText("0");
//        ((TextView) findViewById(R.id.tv_chi_so_thang_nay)).setText(Integer.toString(khachhang.get_chi_so()));
        ((TextView) findViewById(R.id.tv_don_gia)).setText(Integer.toString(don_gia));
//        ((TextView) findViewById(R.id.tv_thanh_tien)).setText(Integer.toString(don_gia * khachhang.get_chi_so()));
    }
    void setLayoutbyCode(String code_khachhang){
        Khachhang khachhang = dataBaseHelper.getKhanhhangByCode(code_khachhang);
        ((TextView) findViewById(R.id.tv_name)).setText(khachhang.get_name());
//        String thang_nam = khachhang.get_thang() + "/" + khachhang.get_nam();
//        ((TextView) findViewById(R.id.tv_thang_nam)).setText(thang_nam);
        ((TextView) findViewById(R.id.tv_chi_so_thang_truoc)).setText("0");
//        ((TextView) findViewById(R.id.tv_chi_so_thang_nay)).setText(Integer.toString(khachhang.get_chi_so()));
        ((TextView) findViewById(R.id.tv_don_gia)).setText(Integer.toString(don_gia));
//        ((TextView) findViewById(R.id.tv_thanh_tien)).setText(Integer.toString(don_gia * khachhang.get_chi_so()));
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