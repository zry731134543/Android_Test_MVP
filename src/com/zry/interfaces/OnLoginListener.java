package com.zry.interfaces;
/**
 * 监听登陆是否成功的接口
 * @author zry
 *
 */
public interface OnLoginListener {
	/**
	 * 登陆失败
	 * @param error 失败原因
	 */
	void onError(String error);
	/**
	 * 登陆成功
	 */
	void onSuccess();
}
