package com.zry.util;

import com.zry.db.Database;
import com.zry.engine.User;
import com.zry.interfaces.OnDatabaseListener;

/**
 * 登陆验证类
 * @author zry
 *
 */
public class Validate {
	private OnDatabaseListener databaseListener;
	private Database db;
	public Validate(Database db){
		this.db=db;
	}
	/**
	 *  判断账号是否存在
	 * @return
	 */
	public boolean isName(String name) {
		boolean flag=name.equals(db.query().getName());
		if(!flag){
			databaseListener.error("账号不存在");
		}
		return flag;
	}
	
	/**
	 *  判断密码是否正确
	 * @return
	 */
	public boolean isPw(String pw) {
		boolean flag=pw.equals(db.query().getPw());
		if(!flag){
			databaseListener.error("密码不正确");
		}
		return flag;
	}

	/**
	 * 验证登录
	 */
	public boolean validate(User user){
		if (isName(user.getName()) &&isPw(user.getPw())) {
			return true;
		} 
		return false;
	}
	
	public void setDatabaseListener(OnDatabaseListener databaseListener){
		this.databaseListener=databaseListener;
	}
}
