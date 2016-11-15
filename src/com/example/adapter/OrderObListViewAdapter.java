package com.example.adapter;

import java.util.List;

import com.example.bean.HotStyleData;
import com.example.bean.MySelfData;
import com.example.bean.OrderData;
import com.example.umylife.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class OrderObListViewAdapter extends BaseAdapter {
	private Context context;
	private List<OrderData> list;

	public OrderObListViewAdapter(Context context, List<OrderData> list) {
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
					R.layout.order_list_item, null);
			holder = new ViewHolder();
			holder.img = (ImageView) convertView.findViewById(R.id.order_img_display);
			holder.order_number = (TextView) convertView.findViewById(R.id.order_number);
			holder.order_state = (TextView) convertView.findViewById(R.id.order_state);
			holder.order_title = (TextView) convertView.findViewById(R.id.order_title);
			holder.order_content = (TextView) convertView.findViewById(R.id.order_content);
			holder.order_price = (TextView) convertView.findViewById(R.id.order_price);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}

		OrderData mData = list.get(position);
		holder.order_number.setText(mData.getNumber());
		holder.order_state.setText(mData.getState());
		holder.img.setBackgroundResource(mData.getImg());
		holder.order_title.setText(mData.getTitle());
		holder.order_content.setText(mData.getContent());
		holder.order_price.setText(mData.getPrive());
		return convertView;
	}

	static class ViewHolder {
		ImageView img;
		TextView order_number, order_state, order_title, order_content,
				order_price;
	}

}
