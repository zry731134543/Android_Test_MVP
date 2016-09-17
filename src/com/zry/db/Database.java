package com.zry.db;

import com.zry.engine.User;
import com.zry.interfaces.OnDatabaseListener;
import com.zry.util.Tools;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class Database {
	private static Database database;
	private SQLiteDatabase db;
	private OnDatabaseListener databaseListener;
	private Database(Context context) {
		db = new MyDatabaseHelper(context, "mvp.db", 1).getWritableDatabase();
	}
	
	public void setDatabaseListener(OnDatabaseListener databaseListener){
		this.databaseListener=databaseListener;
	}
	/**
	 * 获取Database实例
	 * 
	 * @param context
	 * @return Database实例
	 */
	public static synchronized Database getInstance(Context context) {
		if (database == null) {
			database = new Database(context);
		}
		return database;
	}

	/**
	 * 插入数据
	 * 
	 * @param object
	 *            表对象
	 */
	public void insert(Object object) {
		try {
			String tableName = Tools.getTableName(object);
			ContentValues values = Tools.getValues(object, tableName);
			db.insert(tableName, null, values);
		} catch (Exception e) {
			Log.d("ryzh", "保存失败");
			if(database!=null){
				databaseListener.error("保存失败");
			}
		}
		Log.d("ryzh", "保存成功");
	}
	
	/**
	 * 查找数据
	 * @param object
	 * @return
	 */
	public User query(){
		String tableName = "user";
		Cursor cursor=db.query(tableName, null, null, null, null, null, null);
		cursor.moveToFirst();
		User user=new User();
		user.setName(cursor.getString(cursor.getColumnIndex("name")));
		user.setPw(cursor.getString(cursor.getColumnIndex("pw")));
		cursor.close();
		return user;
	}
	
}
