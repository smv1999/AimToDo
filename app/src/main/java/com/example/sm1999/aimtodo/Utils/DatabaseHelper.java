package com.example.sm1999.aimtodo.Utils;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.design.widget.TabLayout;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DB_NAME= "todo.db";
    private static final String TABLE_NAME= "user_todo";
    private static final String COL1 = "ID";
    private static final String COL2 = "TRAVEL";
    private static final String COL3 = "GROCERIES";
    private static final String COL4 = "MOVIES_TO_WATCH";
    private static final String COL5 = "WORK";
    private static final String COL6 = "FAMILY";
    private static final String COL7 = "PRIVATE";
    private static final String COL8 = "STUDIES";
    private static final String COL9 = "MUSIC";



    public DatabaseHelper(Context context) {
        super(context,DB_NAME,null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String createTable = "CREATE TABLE " + TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, TRAVEL TEXT,GROCERIES TEXT,MOVIES_TO_WATCH TEXT,WORK TEXT,FAMILY TEXT,PRIVATE TEXT,STUDIES TEXT,MUSIC TEXT)";
        db.execSQL(createTable);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME);
            onCreate(db);
    }

    public boolean addData(String travel, String groceries, String movies, String work
    ,String family, String Private, String studies, String music){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL2,travel);
        contentValues.put(COL3,groceries);
        contentValues.put(COL4,movies);
        contentValues.put(COL5,work);
        contentValues.put(COL6,family);
        contentValues.put(COL7,Private);
        contentValues.put(COL8,studies);
        contentValues.put(COL9,music);

        long result = db.insert(TABLE_NAME,null,contentValues);
         if(result==-1){
             return false;
         }
         else{
             return true;
         }

         }
    public boolean updateData(String id, String Travel, String Groceries, String Movies, String Work
          , String Family,  String Private, String Studies, String Music){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL1,id);
        contentValues.put(COL2,Travel);
        contentValues.put(COL3,Groceries);
        contentValues.put(COL4,Movies);
        contentValues.put(COL5,Work);
        contentValues.put(COL6,Family);
        contentValues.put(COL7,Private);
        contentValues.put(COL8,Studies);
        contentValues.put(COL9,Music);
        db.update(TABLE_NAME, contentValues, "ID = ?", new String[] {id});
        return true;
    }

         public Cursor showData(String colName){
            SQLiteDatabase db = this.getWritableDatabase();
            Cursor data = db.rawQuery(" SELECT * FROM "+ TABLE_NAME,null);

            return data;
         }
         public Integer deleteData(String id)
         {
                    SQLiteDatabase db = getWritableDatabase();
                    return db.delete(TABLE_NAME,"ID = ?",new String[] {id});
         }
}
