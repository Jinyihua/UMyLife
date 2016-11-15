package com.example.umylife;

import java.util.List;

import com.example.bean.User;
import com.example.utils.LoginDao;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class LoginActivity extends Activity implements OnClickListener {
	private EditText username;
	private EditText password;
	private Button register;
	private Button login;
	private ImageView return_img;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		return_img = (ImageView) findViewById(R.id.return_img);
		username = (EditText) findViewById(R.id.username_et);
		password = (EditText) findViewById(R.id.password_et);
		login = (Button) findViewById(R.id.login_btn);
		register = (Button) findViewById(R.id.register_btn);
		return_img.setOnClickListener(this);
		username.setOnClickListener(this);
		password.setOnClickListener(this);
		login.setOnClickListener(this);
		register.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.return_img:
			Intent intent = new Intent(this, MySelfActivity.class);
			startActivity(intent);
			break;
		case R.id.login_btn:
			UserisEmpty();
			break;
		case R.id.register_btn:

			break;

		default:
			break;
		}
	}
	//判断用户名密码是否为空
	private void UserisEmpty(){
		String Username = username.getText().toString();
		String Password = password.getText().toString();
		if (Username.equals("")||Password.equals("")) {
			Toast.makeText(this, "用户名或密码不能为空", Toast.LENGTH_SHORT).show();
		} 
	}
	//用户登录

	// 用户注册
	private void registerUser() {
		boolean isRegister = false;
		String Username = username.getText().toString();
		String Password = password.getText().toString();
		
		LoginDao dao = new LoginDao(this);
		List<User> list = dao.queryAll();
		for (int i = 0; i < list.size(); i++) {
			User user = list.get(i);
			if (user.getUsername().equals(Username)) {
				isRegister = true;
				break;
			}
		}
		if (isRegister) {
			Toast.makeText(this, "用户已存在", Toast.LENGTH_SHORT).show();
			isRegister = false;
		} else {
			Toast.makeText(this, "注册成功", Toast.LENGTH_SHORT).show();
			dao.addUser(new User(Username, Password));
		}
	}
}
