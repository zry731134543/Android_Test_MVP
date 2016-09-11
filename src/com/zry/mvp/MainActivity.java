package com.zry.mvp;

import com.zry.engine.User;
import com.zry.interfaces.OnLoginListener;
import com.zry.presenter.Presenter;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends BaseActivity implements OnLoginListener {
	/**用户名输入框**/
	private EditText et_name;
	/**密码输入框**/
	private EditText et_pw; 
	/**用户名输入框登陆按钮**/
	private Button btn_login;
	/** 主持类对象* */
	private Presenter presenter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initVariables();
		initView();
		loadData();
		login_setOnClick();
	}

	/**
	 * 登陆按钮点击事件
	 */
	private void login_setOnClick() {
		btn_login.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				User user = new User(et_name.getText().toString(), et_pw.getText().toString());
				presenter.setUser(user);
				presenter.setLoginListener(MainActivity.this);
				presenter.validate();
//				presenter.insert();
			}
		});
	}

	/*-----------BaseActivity-------------*/
	@Override
	public void initVariables() {
		presenter = new Presenter(MainActivity.this);
	}

	@Override
	public void initView() {
		et_name = (EditText) findViewById(R.id.et_name);
		et_pw = (EditText) findViewById(R.id.et_pw);
		btn_login = (Button) findViewById(R.id.btn_login);
	}

	@Override
	public void loadData() {
	}

	/*----------OnLoginListener-----------*/
	@Override
	public void onError(String error) {
		Toast.makeText(MainActivity.this, error, Toast.LENGTH_SHORT).show();
	}

	@Override
	public void onSuccess() {
		Toast.makeText(MainActivity.this, "登陆成功", Toast.LENGTH_SHORT).show();
	}

}
