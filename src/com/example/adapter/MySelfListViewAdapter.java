package com.example.adapter;

import java.util.List;

import com.example.bean.MySelfData;
import com.example.umylife.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MySelfListViewAdapter extends BaseAdapter {
	private Context context;
	private List<MySelfData> list;

	public MySelfListViewAdapter(Context context, List<MySelfData> list) {
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
		int currentType = getItemViewType(position);
		ViewHolder holder = null;
		switch (currentType) {
		case 0:
			if (convertView == null) {
				convertView = LayoutInflater.from(context).inflate(
						R.layout.myself_list_item_one, null);
				holder = new ViewHolder();
				holder.img = (ImageView) convertView.findViewById(R.id.img);
				holder.content = (TextView) convertView
						.findViewById(R.id.content);
				convertView.setTag(holder);
			} else {
				holder = (ViewHolder) convertView.getTag();
			}
			break;
		case 1:
			if (convertView == null) {
				convertView = LayoutInflater.from(context).inflate(
						R.layout.myself_list_item_one, null);
				holder = new ViewHolder();
				holder.img = (ImageView) convertView.findViewById(R.id.img);
				holder.content = (TextView) convertView
						.findViewById(R.id.content);
				convertView.setTag(holder);
			} else {
				holder = (ViewHolder) convertView.getTag();
			}
			break;
		case 2:
			if (convertView == null) {
				convertView = LayoutInflater.from(context).inflate(
						R.layout.myself_list_item_one, null);
				holder = new ViewHolder();
				holder.img = (ImageView) convertView.findViewById(R.id.img);
				holder.content = (TextView) convertView
						.findViewById(R.id.content);
				convertView.setTag(holder);
			} else {
				holder = (ViewHolder) convertView.getTag();
			}
			break;
		case 3:
			if (convertView == null) {
				convertView = LayoutInflater.from(context).inflate(
						R.layout.myself_list_item_one, null);
				holder = new ViewHolder();
				holder.img = (ImageView) convertView.findViewById(R.id.img);
				holder.content = (TextView) convertView
						.findViewById(R.id.content);
				convertView.setTag(holder);
			} else {
				holder = (ViewHolder) convertView.getTag();
			}
			break;
		case 4:
			if (convertView == null) {
				convertView = LayoutInflater.from(context).inflate(
						R.layout.myself_list_item_one, null);
				holder = new ViewHolder();
				holder.img = (ImageView) convertView.findViewById(R.id.img);
				holder.content = (TextView) convertView
						.findViewById(R.id.content);
				convertView.setTag(holder);
			} else {
				holder = (ViewHolder) convertView.getTag();
			}
			break;
		case 5:
			if (convertView == null) {
				convertView = LayoutInflater.from(context).inflate(
						R.layout.myself_list_item_two, null);
				holder = new ViewHolder();
				holder.img = (ImageView) convertView.findViewById(R.id.img);
				holder.content = (TextView) convertView
						.findViewById(R.id.content);
				convertView.setTag(holder);
			} else {
				holder = (ViewHolder) convertView.getTag();
			}
			break;
		default:
			break;
		}

		MySelfData mData = list.get(position);
		holder.img.setBackgroundResource(mData.getImg());
		holder.content.setText(mData.getContent());
		
		return convertView;
	}

	static class ViewHolder {
		ImageView img;
		TextView content;
	}

	public int getItemViewType(int position) {
		return list.get(position).getType();
	}
}
