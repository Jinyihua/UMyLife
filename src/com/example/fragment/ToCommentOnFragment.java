package com.example.fragment;

import java.util.ArrayList;
import java.util.List;

import com.example.adapter.TCOListViewAdapter;
import com.example.bean.OrderData;
import com.example.umylife.R;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
/*
 * 待评论
 */
public class ToCommentOnFragment extends Fragment {
	
	private ListView listView;
	private List<OrderData> mList;
	private TCOListViewAdapter adapter;
	private int[] imgs;
	private String[] titles;
	private String[] contents;
	private String[] prices;
	private String [] evaluates;
	@Override
	public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState){
		super.onCreateView(inflater, container, savedInstanceState);
		imgs = new int[] { R.drawable.kongtiao, R.drawable.hour_clean };
		titles = new String[] { "空调清洗", "油烟机清洗" };
		contents = new String[] {
				"上门服务时间：2015年4月22日(周二)上午11:00 北京海淀区上地硅谷亮城",
				"上门服务时间：2015年4月24日(周四)下午17:05 福州鼓楼区华林路海都大厦" };
		prices = new String[] { "¥18.90", "¥32.50" };
		evaluates = new String[]{"追加评价","服务评价"};
		View chatView = inflater.inflate(R.layout.fragment_tocommenton, container,false);
		listView = (ListView) chatView.findViewById(R.id.order_tocom_listview);
		adapter = new TCOListViewAdapter(getActivity(), getData());
		listView.setAdapter(adapter);
		return chatView;
		
		
	}
	private List<OrderData> getData() {
		mList = new ArrayList<OrderData>();
		for (int i = 0; i < imgs.length; i++) {
			OrderData mData = new OrderData();
			mData.setNumber("12345678"+i);
			mData.setState("交易成功");
			mData.setImg(imgs[i]);
			mData.setTitle(titles[i]);
			mData.setContent(contents[i]);
			mData.setPrive(prices[i]);
			if (i==0) {
				mData.setBtn_content(evaluates[i]);
			}else {
				mData.setBtn_content(evaluates[i]);
			}
			
			mList.add(mData);
		}
		return mList;
	}
	
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState){
		super.onActivityCreated(savedInstanceState);
	}
}
