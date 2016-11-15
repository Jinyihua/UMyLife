package com.example.umylife;

import java.util.ArrayList;
import java.util.List;

import com.example.adapter.MainPageAdapter;
import com.example.bean.MyViewPager;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.app.LocalActivityManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.RadioButton;

public class MainActivity extends Activity implements OnClickListener {

	private MyViewPager viewPager;
	private RadioButton home;
	private RadioButton order;
	private RadioButton hotstyle;
	private RadioButton myselt;
	// private List<View> list = new ArrayList<View>();
	// private pageAdapter adapter = new pageAdapter(list);
	private MainPageAdapter adapter;
	private LocalActivityManager manager;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);
		manager = new LocalActivityManager(this, true);
		manager.dispatchCreate(savedInstanceState);
		initView();
		initClick();

	}

	private void initClick() {
		home.setOnClickListener(this);
		order.setOnClickListener(this);
		hotstyle.setOnClickListener(this);
		myselt.setOnClickListener(this);
		home.setSelected(true);
		viewPager.addOnPageChangeListener(new OnPageChangeListener() {

			@Override
			public void onPageSelected(int arg0) {
				int currentItem = viewPager.getCurrentItem();

				switch (currentItem) {
				case 0:
					home.setSelected(true);
					order.setSelected(false);
					hotstyle.setSelected(false);
					myselt.setSelected(false);
					break;
				case 1:
					home.setSelected(false);
					order.setSelected(true);
					hotstyle.setSelected(false);
					myselt.setSelected(false);
					break;
				case 2:
					home.setSelected(false);
					order.setSelected(false);
					hotstyle.setSelected(true);
					myselt.setSelected(false);
					break;
				case 3:
					home.setSelected(false);
					order.setSelected(false);
					hotstyle.setSelected(false);
					myselt.setSelected(true);
					break;
				default:
					break;

				}
			}

			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
			}

			@Override
			public void onPageScrollStateChanged(int arg0) {
			}
		});
		List<View> mViews = new ArrayList<View>();
		Intent intent = new Intent();

		intent.setClass(this, HomeAvtivity.class);
		intent.putExtra("id", 1);
		mViews.add(getView("1", intent));
		intent.setClass(this, OrderActivity.class);
		intent.putExtra("id", 2);
		mViews.add(getView("2", intent));

		intent.setClass(this, HotStyleActivity.class);
		intent.putExtra("id", 3);
		mViews.add(getView("3", intent));

		intent.setClass(this, MySelfActivity.class);
		intent.putExtra("id", 4);
		mViews.add(getView("4", intent));
		adapter = new MainPageAdapter(mViews);
		viewPager.setAdapter(adapter);

	}

	private View getView(String id, Intent intent) {
		// TODO Auto-generated method stub
		return manager.startActivity(id, intent).getDecorView();
	}

	private void initView() {
		viewPager = (MyViewPager) findViewById(R.id.viewpager);
		home = (RadioButton) findViewById(R.id.home);
		order = (RadioButton) findViewById(R.id.order);
		hotstyle = (RadioButton) findViewById(R.id.hotstyle);
		myselt = (RadioButton) findViewById(R.id.myselt);
	}

	// µã»÷µ×²¿°´Å¥ÇÐ»»
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.home:
			viewPager.setCurrentItem(0);
			home.setSelected(true);

			break;
		case R.id.order:
			viewPager.setCurrentItem(1);
			order.setSelected(true);
			break;
		case R.id.hotstyle:
			viewPager.setCurrentItem(2);
			hotstyle.setSelected(true);
			break;
		case R.id.myselt:
			viewPager.setCurrentItem(3);
			myselt.setSelected(true);
			break;
		default:
			break;
		}

	}

}
