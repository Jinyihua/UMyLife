package com.example.adapter;

import java.util.List;

import com.example.adapter.OrderObListViewAdapter.ViewHolder;
import com.example.bean.HotStyleData;
import com.example.bean.MySelfData;
import com.example.bean.OrderData;
import com.example.umylife.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class AllListViewAdapter extends BaseAdapter {
	private Context context;
	private List<OrderData> list;

	public AllListViewAdapter(Context context, List<OrderData> list) {
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
		OrderData mData = list.get(position);
		if (mData.getState().equals("待付款")) {
			if (convertView == null) {
				convertView = LayoutInflater.from(context).inflate(
						R.layout.order_list_item, null);
				holder = new ViewHolder();
				holder.img = (ImageView) convertView
						.findViewById(R.id.order_img_display);
				holder.order_number = (TextView) convertView
						.findViewById(R.id.order_number);
				holder.order_state = (TextView) convertView
						.findViewById(R.id.order_state);
				holder.order_title = (TextView) convertView
						.findViewById(R.id.order_title);
				holder.order_content = (TextView) convertView
						.findViewById(R.id.order_content);
				holder.order_price = (TextView) convertView
						.findViewById(R.id.order_price);
				convertView.setTag(holder);
			} else {
				holder = (ViewHolder) convertView.getTag();
			}
			holder.order_number.setText(mData.getNumber());
			holder.order_state.setText(mData.getState());
			holder.img.setBackgroundResource(mData.getImg());
			holder.order_title.setText(mData.getTitle());
			holder.order_content.setText(mData.getContent());
			holder.order_price.setText(mData.getPrive());
		} else if (mData.getState().equals("已派人上门服务")) {
			if (convertView == null) {
				convertView = LayoutInflater.from(context).inflate(
						R.layout.order_list_item, null);
				holder = new ViewHolder();
				holder.img = (ImageView) convertView
						.findViewById(R.id.order_img_display);
				holder.order_number = (TextView) convertView
						.findViewById(R.id.order_number);
				holder.order_state = (TextView) convertView
						.findViewById(R.id.order_state);
				holder.order_title = (TextView) convertView
						.findViewById(R.id.order_title);
				holder.order_content = (TextView) convertView
						.findViewById(R.id.order_content);
				holder.order_price = (TextView) convertView
						.findViewById(R.id.order_price);
				holder.service_completed = (Button) convertView
						.findViewById(R.id.service_completed);
				holder.service_evaluate = (Button) convertView
						.findViewById(R.id.service_evaluate);
				holder.delete_order = (Button) convertView
						.findViewById(R.id.delete_order);
				holder.order_pay = (Button) convertView
						.findViewById(R.id.order_pay);
				convertView.setTag(holder);
			} else {
				holder = (ViewHolder) convertView.getTag();
			}
			holder.order_number.setText(mData.getNumber());
			holder.order_state.setText(mData.getState());
			holder.img.setBackgroundResource(mData.getImg());
			holder.order_title.setText(mData.getTitle());
			holder.order_content.setText(mData.getContent());
			holder.order_price.setText(mData.getPrive());
			holder.order_pay.setText(mData.getBtn_content());
			holder.service_completed.setVisibility(View.GONE);
			holder.service_evaluate.setVisibility(View.GONE);
			holder.delete_order.setVisibility(View.GONE);
		} else if (mData.getState().equals("交易成功")) {
			if (convertView == null) {
				convertView = LayoutInflater.from(context).inflate(
						R.layout.order_list_item, null);
				holder = new ViewHolder();
				holder.img = (ImageView) convertView
						.findViewById(R.id.order_img_display);
				holder.order_number = (TextView) convertView
						.findViewById(R.id.order_number);
				holder.order_state = (TextView) convertView
						.findViewById(R.id.order_state);
				holder.order_title = (TextView) convertView
						.findViewById(R.id.order_title);
				holder.order_content = (TextView) convertView
						.findViewById(R.id.order_content);
				holder.order_price = (TextView) convertView
						.findViewById(R.id.order_price);
				holder.service_completed = (Button) convertView
						.findViewById(R.id.service_completed);
				holder.service_evaluate = (Button) convertView
						.findViewById(R.id.service_evaluate);
				holder.delete_order = (Button) convertView
						.findViewById(R.id.delete_order);
				holder.order_pay = (Button) convertView
						.findViewById(R.id.order_pay);
				convertView.setTag(holder);
			} else {
				holder = (ViewHolder) convertView.getTag();
			}
			holder.order_number.setText(mData.getNumber());
			holder.order_state.setText(mData.getState());
			holder.img.setBackgroundResource(mData.getImg());
			holder.order_title.setText(mData.getTitle());
			holder.order_content.setText(mData.getContent());
			holder.order_price.setText(mData.getPrive());
			holder.service_evaluate.setText(mData.getBtn_content());
			holder.delete_order.setVisibility(View.GONE);
			holder.order_pay.setVisibility(View.GONE);
		}
		return convertView;
	}

	static class ViewHolder {
		ImageView img;
		TextView order_number, order_state, order_title, order_content,
				order_price;
		Button service_completed, service_evaluate, delete_order, order_pay;
	}

}
