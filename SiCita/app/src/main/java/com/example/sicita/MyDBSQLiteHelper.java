package com.example.sicita;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyDBSQLiteHelper extends SQLiteOpenHelper {
    public MyDBSQLiteHelper (Context context, String nombre, SQLiteDatabase.CursorFactory cursor, int version){
        super(context,nombre,cursor,version);
    }
    @Override
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL("CREATE TABLE vehiculo (Id INTEGER PRIMARY KEY AUTOINCREMENT,Propietario TEXT,Placa TEXT,Marca TEXT,Modelo Text)");
    }
    @Override
    public void onUpgrade(SQLiteDatabase db,int versionant,int versionnueva)
    {
        db.execSQL("DROP TABLE IF EXISTS vehiculo");
        db.execSQL("CREATE TABLE vehiculo (Id INTEGER PRIMARY KEY AUTOINCREMENT,Propietario TEXT,Placa TEXT,Marca TEXT,Modelo Text)");
    }
}
