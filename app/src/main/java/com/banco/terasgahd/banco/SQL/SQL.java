package com.banco.terasgahd.banco.SQL;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class SQL extends SQLiteOpenHelper {

    public static String NOME_DB = "Banco_Usuarios";
    public static String NOME_TABELA = "usuarios";
    public static int VERSION = 1;

    public SQL(Context context) {
        super(context, NOME_DB, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql =
                "CREATE TABLE IF NOT EXISTS " + NOME_TABELA + "(" +
                        "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                        "login TEXT NOT NULL," +
                        "email TEXT NOT NULL," +
                        "senha TEXT NOT NULL" +
                        ");";
        try {
            db.execSQL(sql);
            Log.i("INFO DB","Sucesso ao criar tabela");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
