package com.sqllitedatabaseapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DatabaseHandler extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION =1;
    private static final String DATABASE_NAME ="SQLiteDatabase.db";
    private static final String TABLE_NAME = "PEOPLE";
    private static final String TABLE_NAME_1 = "USER";
    private static final String COLUMN_ID = "ID";
    private static final String COLUMN_USER_ID = "ID";
    private static final String COLUMN_FIRST_NAME = "FIRST_NAME";
    private static final String COLUMN_LAST_NAME = "LAST_NAME";
    private static final String COLUMN_FIRST_NAME_USER = "FIRST_NAME";
    private static final String COLUMN_LAST_NAME_USER = "LAST_NAME";
    private static final String COLUMN_EMAILID_USER = "FIRST_NAME";
    private static final String COLUMN_PASSWORD_USER = "LAST_NAME";
    private SQLiteDatabase database;

    public DatabaseHandler(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table " + TABLE_NAME +
                "(" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + COLUMN_FIRST_NAME + " VARCHAR,"
                + COLUMN_LAST_NAME  + " VARCHAR);");

        sqLiteDatabase.execSQL("create table " + TABLE_NAME +
                "(" + COLUMN_USER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + COLUMN_FIRST_NAME_USER + " VARCHAR,"
                + COLUMN_LAST_NAME_USER  + " VARCHAR,"
                + COLUMN_EMAILID_USER + " VARCHAR, "
                + COLUMN_PASSWORD_USER + " VARCHAR );" );

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldversion, int newversion) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(sqLiteDatabase);

    }

    public void insertRecord(UserModel userModel){
        database = this.getReadableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_FIRST_NAME,userModel.getFirstname());
        contentValues.put(COLUMN_LAST_NAME,userModel.getLastname());
        database.insert(TABLE_NAME,null,contentValues);
        database.close();
    }

    public void insertRecordUser(User1Model user1Model){
        database = this.getReadableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_FIRST_NAME_USER,user1Model.getFirstname());
        contentValues.put(COLUMN_LAST_NAME_USER,user1Model.getLastname());
        contentValues.put(COLUMN_EMAILID_USER,user1Model.getEmail());
        contentValues.put(COLUMN_PASSWORD_USER,user1Model.getPassword());
        database.insert(TABLE_NAME,null,contentValues);
        database.close();
    }

    public ArrayList<UserModel> getAllRecords(){
        database = this.getReadableDatabase();
        Cursor cursor = database.query(TABLE_NAME,null,null,null,null,null,null);
        ArrayList<UserModel> users = new ArrayList<UserModel>();
        UserModel userModel;
        if(cursor.getCount() > 0){
            for(int i = 0 ; i<cursor.getCount() ; i++){
                cursor.moveToNext();
                userModel = new UserModel();
                userModel.setID(cursor.getString(0));
                userModel.setFirstname(cursor.getString(1));
                userModel.setLastname(cursor.getString(2));
                users.add(userModel);
            }
        }
        cursor.close();
        database.close();
        return users;
    }

    public void updateRecord(UserModel userModel){
        database = this.getReadableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put( COLUMN_FIRST_NAME , userModel.getFirstname());
        contentValues.put(COLUMN_LAST_NAME , userModel.getLastname());
        database.update(TABLE_NAME,contentValues,COLUMN_ID  + " = ?",
                new String[]{userModel.getID()});
        database.close();
    }


    public void deleteRecord(UserModel userModel) {
        database = this.getReadableDatabase();
        ContentValues contentValues = new ContentValues();
        database.delete(TABLE_NAME,COLUMN_ID + " = ?",
                new String[]{userModel.getID()});
        database.close();
    }
}
