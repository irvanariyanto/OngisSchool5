package com.example.bay.ongisschool5;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Created by BAY on 6/1/2016.
 */
public class DatabaseHelper extends SQLiteOpenHelper{

    public static final String DATABASE_NAME="MyDb.db";
    public static final String PERSON_TABLE_NAME="person";
    public static final String PERSON_COLUMN_ID="id";
    public static final String PERSON_COLUMN_NAME="nama";
    public static final String PERSON_COLUMN_ADDRESS="address";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table "+PERSON_TABLE_NAME+" (id integer primary key, " +
                "nama text, address text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists "+PERSON_TABLE_NAME);
        onCreate(db);
    }

    public void addPerson(Person person){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(PERSON_COLUMN_NAME,person.getName());
        contentValues.put(PERSON_COLUMN_ADDRESS,person.getAddress());
        db.insert(PERSON_TABLE_NAME,null,contentValues);
    }

    public void updatePerson(Person person){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(PERSON_COLUMN_NAME,person.getName());
        contentValues.put(PERSON_COLUMN_ADDRESS,person.getAddress());
        db.update(PERSON_TABLE_NAME,contentValues,"id = ?",new String[]{Integer.toString(person.getId())});
    }

    public void deletePerson(int id){
        SQLiteDatabase db=this.getWritableDatabase();
        db.delete(PERSON_TABLE_NAME,"id = ?",new String[]{Integer.toString(id)});
    }

    public ArrayList<Person> getAll(){
        ArrayList<Person> arrayList=new ArrayList<>();
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor=db.rawQuery("select * from "+PERSON_TABLE_NAME,null);
        cursor.moveToFirst();
        while (cursor.isAfterLast()==false){
            Person person=new Person();
            person.setId(cursor.getInt(0));
            person.setName(cursor.getString(1));
            person.setAddress(cursor.getString(2));
            arrayList.add(person);
            cursor.moveToNext();
        }
        return arrayList;
    }

    public Person getPerson(int id){
        Person person=new Person();
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor=db.rawQuery("select * from "+PERSON_TABLE_NAME+" where id = "+id,null);
        cursor.moveToFirst();
        if(cursor.getCount()<=0){
            return null;
        }else {
            person.setId(cursor.getInt(0));
            person.setName(cursor.getString(1));
            person.setAddress(cursor.getString(2));
            return person;
        }
    }

}
