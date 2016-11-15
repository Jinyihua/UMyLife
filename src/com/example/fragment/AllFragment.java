package com.example.fragment;

import java.util.ArrayList;
import java.util.List;

import com.example.adapter.AllListViewAdapter;
import com.example.adapter.OrderObListViewAdapter;
import com.example.bean.OrderData;
import com.example.umylife.R;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

public class AllFragment extends Fragment {

	private ListView listView;
	private AllListViewAdapter adapter;
	private List<OrderData> mList;
	private int[] imgs;
	private String[] titles;
	private String[] contents;
	private String[] prices;
	private String [] evaluates;
	private String[] states;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		super.onCreateView(inflater, container, savedInstanceState);
		imgs = new int[] { R.drawable.kongtiao, R.drawable.hour_clean };
		titles = new String[] { "空调清洗", "油烟机清洗" };
		contents = new String[] {
				"上门服务时间：2015年4月22日(周二)上午11:00 北京海淀区上地硅谷亮城",
				"上门服务时间：2015年4月24日(周四)下午17:05 福州鼓楼区华林路海都大厦" };
		prices = new String[] { "¥18.90", "¥32.50" };
		evaluates = new String[]{"追加评价","服务评价"};
		states = new String[]{"待付款","已派人上门服务"};
		View chatView = inflater.inflate(R.layout.fragment_all, container,
				false);
		listView = (ListView) chatView.findViewById(R.id.order_all_listview);
		adapter = new AllListViewAdapter(getActivity(), getData());
		listView.setAdapter(adapter);
		return chatView;

	}
	private List<OrderData> getData() {
		mList = new ArrayList<OrderData>();
		for (int i = 0; i < imgs.length; i++) {
			OrderData mData = new OrderData();
			mData.setNumber("12345678"+i);
			mData.setBtn_content("确认收货");
			mData.setImg(imgs[i]);
			mData.setTitle(titles[i]);
			mData.setContent(contents[i]);
			mData.setPrive(prices[i]);
			if (i==0) {
				mData.setState(states[i]);
			}else {
				mData.setState(states[i]);
			}
			
			mList.add(mData);
		}
		return mList;
	}


	
}
