package com.zry.engine;

/**
 * 用户账号信息类
 * @author zry
 */
public class User {
	/** 用户名 **/
	private String name;
	/** 密码 **/
	private String pw;

	public User() {
	};

	/**
	 * 
	 * @param name
	 *            用户名
	 * @param pw
	 *            密码
	 */
	public User(String name, String pw) {
		this.name = name;
		this.pw = pw;
	}

	/** ----------------getter、setter------------------------- **/
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	};
}
