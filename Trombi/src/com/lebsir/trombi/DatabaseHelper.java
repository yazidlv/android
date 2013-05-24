package com.lebsir.trombi;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
  

public class DatabaseHelper extends SQLiteOpenHelper {  
  
public SQLiteDatabase formationDB;

private static final String DATABASE_NAME = "Formation";  
private static final String DATABASE_TABLE = "filieres";  
private static final int DATABASE_VERSION = 1;  


private static final String DATABASE_CREATE = "create table "  
        + DATABASE_TABLE + " (_id integer primary key autoincrement, "  
        + "nom text not null, prenom text not null, photo int);";  
    public DatabaseHelper(Context context) {  
        super(context, DATABASE_NAME, null, DATABASE_VERSION);  
    }  
  
    @Override  
    public void onCreate(SQLiteDatabase db) {  
        db.execSQL(DATABASE_CREATE);  
    }  
  
    @Override  
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {  
        Log.w("Content provider database",  
                "Upgrading database from version " + oldVersion + " to "  
                        + newVersion + ", which will destroy all old data");  
        db.execSQL("DROP TABLE IF EXISTS titles");  
        onCreate(db);  
  
    }  
  
} 