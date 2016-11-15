package com.example.utils;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.bean.User;
import com.example.db.UMyLiteSQLite;

public class LoginDao {
	private UMyLiteSQLite mSqLite;

	public LoginDao(Context context) {
		mSqLite = new UMyLiteSQLite(context);
	}

	// ���Ӳ���
	public void addUser(User user) {
		SQLiteDatabase mDatabase = mSqLite.getReadableDatabase();
		ContentValues values = new ContentValues();
		values.put("username", user.getUsername());
		values.put("password", user.getPassword());
		mDatabase.insert("userinfo", null, values);
		mDatabase.close();
	}

	// ɾ������
	public void deleteUser(int id) {
		SQLiteDatabase mDatabase = mSqLite.getReadableDatabase();
		mDatabase.delete("userinfo", "_id=?", new String[] { id + "" });
		mDatabase.close();
	}
	//���²���
	public void updateUser(User user){
		SQLiteDatabase mDatabase = mSqLite.getReadableDatabase();
		ContentValues values = new ContentValues();
		values.put("username", user.getUsername());
		values.put("password", user.getPassword());
		mDatabase.update("userinfo", values, "_id=?", new String[]{user.getUserid()+""});
		mDatabase.close();
		
	}
	
	//������ѯ
	public User queryUser(int id){
		SQLiteDatabase mDatabase = mSqLite.getReadableDatabase();
		Cursor query = mDatabase.query("userinfo",null, "_id=?", new String[]{id+""}, null, null, null);
		User user = null;
		if (query.moveToFirst()) {
			int _id = query.getInt(query.getColumnIndex("_id"));
			String username = query.getString(query.getColumnIndex("username"));
			String password = query.getString(query.getColumnIndex("password"));
			user = new User(username, password);
			user.setUserid(_id);
		}
		query.close();
		mDatabase.close();
		return user;
	}
	//ȫ����ѯ
	public List<User> queryAll(){
		SQLiteDatabase mDatabase = mSqLite.getReadableDatabase();
		List<User> list = new ArrayList<User>();
		Cursor query = mDatabase.query("userinfo", null,null,null,null,null,null);
		User user = null;
		while (query.moveToNext()) {
			int _id = query.getInt(query.getColumnIndex("_id"));
			String username = query.getString(query.getColumnIndex("username"));
			String password = query.getString(query.getColumnIndex("password"));
			user = new User(username, password);
			user.setUserid(_id);
			list.add(user);
		}
		query.close();
		mDatabase.close();
		return list;
	}

}
