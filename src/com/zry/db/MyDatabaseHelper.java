package com.zry.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
/**
 * 数据库辅助类
 * @author zry
 *
 */
public class MyDatabaseHelper extends SQLiteOpenHelper{
	private static final String USER="create table user (name text,pw text)";
	public MyDatabaseHelper(Context context, String name, int version) {
		super(context, name,null, version);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(USER);
		Log.d("ryzh", "创建表成功");
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL("drop table if exists user");
		onCreate(db);
		Log.d("ryzh", "升级表成功");
	}

}
