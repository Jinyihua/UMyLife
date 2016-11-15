package com.example.umylife;

import java.util.ArrayList;
import java.util.List;

import com.example.adapter.MySelfListViewAdapter;
import com.example.bean.MySelfData;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MySelfActivity extends Activity implements OnClickListener{
	private ImageView head_img;
	private ListView listView;
	private List<MySelfData> list;
	private MySelfListViewAdapter adapter;
	private int[] imgs;
	private String[] contents;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_myself);
		imgs = new int[] { R.drawable.price, R.drawable.evaluate,
				R.drawable.address, R.drawable.collect, R.drawable.update,
				R.drawable.phone_tip };
		contents = new String[] { "价格清单", "商品评价", "常规地址管理", "我的收藏", "版本更新",
				"客服热线 : 95060" };
		initView();
		initData();
	}

	private void initData() {
		head_img.setOnClickListener(this);
		adapter = new MySelfListViewAdapter(this, getData());
		listView.setAdapter(adapter);
	}

	private List<MySelfData> getData() {
		list = new ArrayList<MySelfData>();
		for (int i = 0; i < imgs.length; i++) {
			MySelfData data = new MySelfData();
			if (i==5) {
				data.setImg(imgs[i]);
				data.setContent(contents[i]);
				data.setType(i);
			} else {
				data.setImg(imgs[i]);
				data.setContent(contents[i]);
				data.setType(i);
			}
			list.add(data);
		}
		return list;
	}

	private void initView() {
		head_img = (ImageView) findViewById(R.id.head_img);
		listView = (ListView) findViewById(R.id.listview);

	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.head_img:
			Intent intent = new Intent();
			intent.setClass(this, LoginActivity.class);
			startActivity(intent);
			break;

		default:
			break;
		}
	}
}
