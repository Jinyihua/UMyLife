package com.example.adapter;

import java.util.List;

import com.example.bean.HotStyleData;
import com.example.bean.MySelfData;
import com.example.umylife.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class HotStyleListViewAdapter extends BaseAdapter {
	private Context context;
	private List<HotStyleData> list;

	public HotStyleListViewAdapter(Context context, List<HotStyleData> list) {
		super();
		this.context = context;
		this.list = list;
	}

	public int getCount() {
		// TODO Auto-generated method stub
		return list == null || list.isEmpty() ? 0 : list.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder = null;

		if (convertView == null) {
			convertView = LayoutInflater.from(context).inflate(
					R.layout.hot_style_list_item, null);
			holder = new ViewHolder();
			holder.img = (ImageView) convertView.findViewById(R.id.display_img);
			holder.title = (TextView) convertView
					.findViewById(R.id.title_hot);
			holder.content = (TextView) convertView
					.findViewById(R.id.content_hot);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}

		HotStyleData mData = list.get(position);
		holder.img.setBackgroundResource(mData.getImg());
		holder.title.setText(mData.getTitle());
		holder.content.setText(mData.getContent());
		return convertView;
	}

	static class ViewHolder {
		ImageView img;
		TextView title, content;
	}

}
