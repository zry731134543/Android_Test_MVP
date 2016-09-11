package com.zry.mvp;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
/**
 * Activity基类
 * @author zry
 *
 */
public abstract class BaseActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);
	}
	/**
	 * 初始化变量
	 */
	public abstract void initVariables();
	/**
	 * 初始化view
	 */
	public abstract void initView();
	/**
	 * 加载数据
	 */
	public abstract void loadData();
}
