package com.zry.util;

import com.zry.engine.User;

import android.content.ContentValues;

public class Tools {
	/**
	 * 通过object对象获取表名
	 * 
	 * @param object
	 * @return
	 */
	public static String getTableName(Object object) {
		String ob = object.getClass().toString();
		String names[] = ob.split("\\.");
		return names[names.length - 1];
	}

	/**
	 * 获取value
	 * 
	 * @param object
	 * @param tableName
	 * @return
	 */
	public static ContentValues getValues(Object object, String tableName) {
		ContentValues values = new ContentValues();
		values.put("name", ((User) object).getName());
		values.put("pw", ((User) object).getPw());
		return values;
	}

}
