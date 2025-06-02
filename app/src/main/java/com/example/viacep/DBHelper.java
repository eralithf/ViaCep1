package com.example.viacep;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    public static final String DB_NAME = "cepDB.db";
    public static final int DB_VERSION = 1;

    public static final String TABLE_NAME = "historico";
    public static final String COL_ID = "id";
    public static final String COL_CEP = "cep";
    public static final String COL_LOGRADOURO = "logradouro";
    public static final String COL_BAIRRO = "bairro";
    public static final String COL_CIDADE = "cidade";
    public static final String COL_UF = "uf";

    public DBHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE " + TABLE_NAME + " (" +
                COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COL_CEP + " TEXT, " +
                COL_LOGRADOURO + " TEXT, " +
                COL_BAIRRO + " TEXT, " +
                COL_CIDADE + " TEXT, " +
                COL_UF + " TEXT)";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}
