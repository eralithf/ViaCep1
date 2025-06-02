package com.example.viacep;

import android.content.*;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class HistoricoDAO {

    private SQLiteDatabase db;
    private DBHelper helper;

    public HistoricoDAO(Context context) {
        helper = new DBHelper(context);
        db = helper.getWritableDatabase();
    }

    public void inserir(String cep, String logradouro, String bairro, String cidade, String uf) {
        ContentValues values = new ContentValues();
        values.put(DBHelper.COL_CEP, cep);
        values.put(DBHelper.COL_LOGRADOURO, logradouro);
        values.put(DBHelper.COL_BAIRRO, bairro);
        values.put(DBHelper.COL_CIDADE, cidade);
        values.put(DBHelper.COL_UF, uf);
        db.insert(DBHelper.TABLE_NAME, null, values);
    }

    public ArrayList<String> listarTodos() {
        ArrayList<String> lista = new ArrayList<>();
        Cursor cursor = db.query(DBHelper.TABLE_NAME, null, null, null, null, null, "id DESC");

        if (cursor.moveToFirst()) {
            do {
                String item = "CEP: " + cursor.getString(1) + "\n" +
                        cursor.getString(2) + ", " + cursor.getString(3) + "\n" +
                        cursor.getString(4) + " - " + cursor.getString(5);
                lista.add(item);
            } while (cursor.moveToNext());
        }
        cursor.close();
        return lista;
    }
}
