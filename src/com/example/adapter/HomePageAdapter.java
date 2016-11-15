package com.example.adapter;

import java.util.List;

import com.example.umylife.HomeAvtivity;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class HomePageAdapter extends PagerAdapter {
	private List<ImageView> list;

	public HomePageAdapter(List<ImageView> list) {
		this.list = list;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return HomeAvtivity.viewpagercount;
	}

	@Override
	public boolean isViewFromObject(View arg0, Object arg1) {
		// TODO Auto-generated method stub
		return arg0 == arg1;
	}

	@Override
	public void destroyItem(ViewGroup container, int position, Object object) {
		// TODO Auto-generated method stub
		container.removeView((View) object);
	}

	@Override
	public Object instantiateItem(ViewGroup container, int position) {
		int newposition = position % list.size();
		ImageView imageView = list.get(newposition);
		container.addView(imageView);
		return imageView;
	}

}
