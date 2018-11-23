package com.dinaham.sikarbing;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by him on 5/13/2018.
 */

public class Database extends SQLiteOpenHelper {

    private static final String DatabaseName = "sikambing";
    private static final int DatabaseVersion = 1;

    public Database(Context context) {
        super(context, DatabaseName, null, DatabaseVersion);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE tabelriwayat ( id_riwayat INTEGER PRIMARY KEY AUTOINCREMENT, penyakit TEXT NOT NULL, tanggal TEXT NOT NULL, nilai TEXT NOT NULL ); ");
        db.execSQL("CREATE TABLE tabelhasil ( id_hasil INTEGER PRIMARY KEY AUTOINCREMENT, penyakit TEXT NOT NULL, nilai TEXT NOT NULL ); ");

    }

    @Override

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS tabelriwayat");
        db.execSQL("DROP TABLE IF EXISTS tabelhasil");

        onCreate(db);
    }

    public void insertgejala(RiwayatClassData classData) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put("id_riwayat", classData.getId_riwayar());
        cv.put("penyakit", classData.getPenyakit());
        cv.put("tanggal", classData.getTanggal());
        cv.put("nilai", classData.getNilai());

        db.insert("tabelriwayat", null,cv);
        db.close();

    }

    public void deletegejala(String id) {

        SQLiteDatabase db = this.getWritableDatabase();
        String[] args = {id};
        ContentValues cv = new ContentValues();

        db.delete("tabelriwayat", "id_riwayat=?", args);
        db.close();
    }

    public List<RiwayatClassData> getallriwayat() {
        List<RiwayatClassData> dataArray = new ArrayList<RiwayatClassData>();
        String query = "SELECT * FROM tabelriwayat";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        if (cursor.moveToFirst()) {
            do {
                RiwayatClassData datalist = new RiwayatClassData(cursor.getInt(0), cursor.getString(1), cursor.getString(2), cursor.getString(3));
                dataArray.add(datalist);

            } while (cursor.moveToNext());
        }
        return dataArray;
    }

    public void inserthasil(DiagnosaHasilClassData classData) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put("id_hasil", classData.getId_hasil());
        cv.put("penyakit", classData.getHasilPenyakit());
        cv.put("nilai", classData.getHasilNilai());

        db.insert("tabelhasil", null,cv);
        db.close();

    }

    public List<DiagnosaHasilClassData> getallhasil() {
        List<DiagnosaHasilClassData> dataArray = new ArrayList<DiagnosaHasilClassData>();
        String query = "SELECT * FROM tabelhasil";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        if (cursor.moveToFirst()) {
            do {
                DiagnosaHasilClassData datalist = new DiagnosaHasilClassData(cursor.getInt(0), cursor.getString(1), cursor.getString(2));
                dataArray.add(datalist);

            } while (cursor.moveToNext());
        }
        return dataArray;
    }


    public void hapushasil() {

        SQLiteDatabase db = this.getWritableDatabase();

        db.delete("tabelhasil", null, null);
        db.execSQL("delete from "+ "tabelhasil");
        db.close();

    }

}
