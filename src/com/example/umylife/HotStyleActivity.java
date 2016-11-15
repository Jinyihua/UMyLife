package com.example.umylife;

import java.util.ArrayList;
import java.util.List;

import com.example.adapter.HotStyleListViewAdapter;
import com.example.adapter.MySelfListViewAdapter;
import com.example.bean.HotStyleData;
import com.example.bean.MySelfData;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

public class HotStyleActivity extends Activity {
	private ListView listView;
	private List<HotStyleData> list;
	private HotStyleListViewAdapter adapter;
	private String contents[];

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_hotstyle);
		contents = new String[] { "�յ���ϴ", "ϴ�»���ϴ", "���̻���ϴ", "�ӵ㱣��",
				"�ܵ���ͨ" };
		initView();
		initData();
	}

	private void initData() {
		adapter = new HotStyleListViewAdapter(this, getData());
		listView.setAdapter(adapter);

	}

	private List<HotStyleData> getData() {
		list = new ArrayList<HotStyleData>();
		HotStyleData data = new HotStyleData();
		for (int i = 0; i < contents.length; i++) {
//			data.setImg(R.drawable.air_clean);
//			data.setTitle(contents[i]);
//			data.setContent("U��ϴ�»���ϴ�������������ö��Ʊ�׼������");
			list.add(new HotStyleData(R.drawable.air_clean, contents[i], "U��ϴ�»���ϴ�������������ö��Ʊ�׼������"));
		}

		return list;
	}

	private void initView() {
		listView = (ListView) findViewById(R.id.hot_listview);

	}
}
