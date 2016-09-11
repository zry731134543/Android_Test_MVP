package com.zry.presenter;

import com.zry.db.Database;
import com.zry.engine.User;
import com.zry.interfaces.OnDatabaseListener;
import com.zry.interfaces.OnLoginListener;
import com.zry.util.Validate;

import android.content.Context;
import android.net.wifi.p2p.WifiP2pManager.PeerListListener;
import android.util.Log;

/**
 * 主持类
 * 
 * @author zry
 *
 */
public class Presenter implements OnDatabaseListener {
	private User user;
	private static String error = "";
	private Database db;
	private OnLoginListener loginListener;

	public Presenter(Context context) {
		db = Database.getInstance(context);
		db.setDatabaseListener(this);
	}

	/**
	 * 登录验证
	 */
	public void validate() {
		if (loginListener != null) {
			Validate v=new Validate(db);
			v.setDatabaseListener(Presenter.this);
			if (v.validate(user)) {
				loginListener.onSuccess();
			}else{
				 loginListener.onError(error);
			}
		}
	}
	/**
	 * 插入新用户信息
	 */
	public void insert() {
		db.insert(user);
	}

	/*--------------OnDatabaseListener--------------*/
	@Override
	public void error(String error) {
		Log.d("ryzh", error);
		Presenter.error = error;
	}

	/*----------------getter、setter---------------------*/

	/**
	 * 获取 user
	 * 
	 * @return
	 */
	public User getUser() {
		return user;
	}

	/**
	 * 设置user
	 * 
	 * @param user
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * 设置登录接口
	 * 
	 * @param loginListener
	 */
	public void setLoginListener(OnLoginListener loginListener) {
		this.loginListener = loginListener;
	}
}
