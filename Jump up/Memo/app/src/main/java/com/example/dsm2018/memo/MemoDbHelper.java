package com.example.dsm2018.memo;

import android.content.Context;
        import android.database.sqlite.SQLiteDatabase;
        import android.database.sqlite.SQLiteOpenHelper;

public class MemoDbHelper extends SQLiteOpenHelper {
    private static MemoDbHelper sInstance;

    private static final int DB_YERSION = 1;

    private static final String DB_NAME = "Memo.db";

    private static final String SQL_CREATE_ENTRIES =
            String .format("CREATE TABLE %s (%s INTEGER PRIMARY KEY AUTOINCREMENT, %s TEXT, %s TEXT)",
                    MemoContract.MemoEntry.TABLE_NAME,
                    MemoContract.MemoEntry._ID,
                    MemoContract.MemoEntry.COLUMN_NAME_TITLE,
                    MemoContract.MemoEntry.COLUMN_NAME_CONTENTS
            );

    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + MemoContract.MemoEntry.TABLE_NAME;

    public static synchronized MemoDbHelper getsInstance(Context context){
        if(sInstance == null) {
            sInstance = new MemoDbHelper(context.getApplicationContext());
        }
        return sInstance;
    }

    private  MemoDbHelper(Context context) {
        super(context, DB_NAME, null, DB_YERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
    }
}