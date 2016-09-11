package com.zry.interfaces;

public interface OnDatabaseListener {
	/**
	 * 数据库操作错误
	 * @param error 错误原因
	 */
	void error(String error);
}
