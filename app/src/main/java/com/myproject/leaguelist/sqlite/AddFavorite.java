package com.myproject.leaguelist.sqlite;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.myproject.leaguelist.pojo.LeaguePojo;

import java.util.ArrayList;
import java.util.List;

public class AddFavorite extends SQLiteOpenHelper {

    private static final int VERSIONLEAGUE= 1;
    private static final String DBNAMELEAGUE= "db_league";
    private static final String TABLENAMELEAGUE = "league_list";

    private static String colIDLea = "id_lea";
    private static String colLea = "lea";
    private static String colSport = "sport";
    private static String colAlter = "alternative";

    public AddFavorite(Context context) {
        super(context, DBNAMELEAGUE, null, VERSIONLEAGUE);
    }



    public AddFavorite(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String createTable = "CREATE TABLE " + TABLENAMELEAGUE + " (" +
                colIDLea + " INTEGER PRIMARY KEY AUTOINCREMENT, " + colLea + " TEXT," + colSport + " TEXT," + colAlter + " TEXT)";
        sqLiteDatabase.execSQL(createTable);


    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+ TABLENAMELEAGUE);
        onCreate(sqLiteDatabase);


    }

    public void insertDataLeague(String league, String sport, String alternate){
        String insertData = "INSERT INTO "+ TABLENAMELEAGUE + " ("+ colLea +","+ colSport+","+colAlter+") VALUES ('"+league +"', '"+sport+"','"+alternate+"')";
        this.getWritableDatabase().execSQL(insertData);
    }

    public LeaguePojo getDataLeague(int id){
        LeaguePojo leaguePojo = null;
        String selectData = "SELECT * FROM "+ TABLENAMELEAGUE + " WHERE id_lea="+String.valueOf(id);
        Cursor data = this.getWritableDatabase().rawQuery(selectData, null);
        if(data.moveToFirst()){
            leaguePojo = new LeaguePojo(Integer.parseInt(data.getString(data.getColumnIndex(colIDLea))),
                    data.getString(data.getColumnIndex(colLea)), data.getString(data.getColumnIndex(colSport)),data.getString(data.getColumnIndex(colAlter)));
        }
        return leaguePojo;
    }

    public List<LeaguePojo> getAllLeague(){
        List<LeaguePojo> leaguePojoList = new ArrayList<>();
        String selectData = "SELECT * FROM "+TABLENAMELEAGUE;
        Cursor data = this.getWritableDatabase().rawQuery(selectData, null);
        if(data.moveToFirst()){
            do{
                leaguePojoList.add(new LeaguePojo(Integer.parseInt(data.getString(data.getColumnIndex(colIDLea))),
                        data.getString(data.getColumnIndex(colLea)), data.getString(data.getColumnIndex(colSport)),data.getString(data.getColumnIndex(colAlter))));
            }while (data.moveToNext());
        }
        return leaguePojoList;
    }



}
