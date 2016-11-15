package com.example.umylife;

import java.util.ArrayList;
import java.util.List;

import com.example.adapter.HomePageAdapter;

import android.R.integer;
import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;

/**
 * 
 * 首页
 * 
 */

public class HomeAvtivity extends Activity implements OnPageChangeListener,
		OnClickListener {
	private ViewPager viewPager;
	private List<ImageView> imglist;
	private HomePageAdapter adapter;
	private int[] imgRes;
	private LinearLayout spots;
	private int lastposition;
	public static int viewpagercount;
	private boolean isRunning = false;
	private Handler handler = new Handler() {
		public void handleMessage(android.os.Message msg) {
			int currentItem = (Integer) msg.obj;
			viewPager.setCurrentItem(currentItem + 1);
		};
	};
	private RadioButton air;
	private RadioButton wash;
	private RadioButton lamp;
	private RadioButton hour_clean;
	private RadioButton plum;
	private RadioButton more;
	private ImageView man1;
	private ImageView man2;

	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_home);
		long currentTimeMillis = System.currentTimeMillis();
		viewpagercount = (int) (currentTimeMillis / 1000);
		initView();
		initData();
		initAdapter();
		new Thread() {
			public void run() {
				while (!isRunning) {
					try {
						Thread.sleep(3000);
						Message msg = handler.obtainMessage();
						int currentItem = viewPager.getCurrentItem();
						msg.obj = currentItem;
						handler.sendMessage(msg);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			};
		}.start();
	}

	// 初始化控件
	private void initView() {
		viewPager = (ViewPager) findViewById(R.id.home_viewpager);
		spots = (LinearLayout) findViewById(R.id.spots);
		air = (RadioButton) findViewById(R.id.air);
		wash = (RadioButton) findViewById(R.id.wash);
		lamp = (RadioButton) findViewById(R.id.lamp);
		hour_clean = (RadioButton) findViewById(R.id.hour_clean);
		plum = (RadioButton) findViewById(R.id.plum);
		more = (RadioButton) findViewById(R.id.more);
		man1 = (ImageView) findViewById(R.id.man1);
		man2 = (ImageView) findViewById(R.id.man2);
		air.setOnClickListener(this);
		wash.setOnClickListener(this);
		lamp.setOnClickListener(this);
		hour_clean.setOnClickListener(this);
		plum.setOnClickListener(this);
		more.setOnClickListener(this);
		man1.setOnClickListener(this);
		man2.setOnClickListener(this);
		viewPager.setOnPageChangeListener(this);
	}

	// 初始化数据
	private void initData() {
		imglist = new ArrayList<ImageView>();
		imgRes = new int[] { R.drawable.start_image1, R.drawable.start_image2,
				R.drawable.start_image3, R.drawable.start_image4,
				R.drawable.start_image5 };
		ImageView imageView;

		View view;
		for (int i = 0; i < imgRes.length; i++) {
			imageView = new ImageView(this);
			imageView.setBackgroundResource(imgRes[i]);
			imglist.add(imageView);
			view = new View(this);
			view.setBackgroundResource(R.drawable.selector_point);
			LayoutParams params = new LayoutParams(5, 5);
			params.leftMargin = 10;
			spots.addView(view, params);
			spots.getChildAt(i).setEnabled(false);

		}
		adapter = new HomePageAdapter(imglist);
		viewPager.setAdapter(adapter);

	}

	private void initAdapter() {
		spots.getChildAt(0).setEnabled(true);
		lastposition = 0;
		int pos = viewpagercount / 2 - (viewpagercount / 2 % imglist.size());
		viewPager.setCurrentItem(pos);

	}

	@Override
	public void onPageScrollStateChanged(int arg0) {
	}

	public void onPageScrolled(int arg0, float arg1, int arg2) {
	}

	@Override
	public void onPageSelected(int arg0) {
		int newposition = arg0 % imglist.size();
		spots.getChildAt(lastposition).setEnabled(false);
		spots.getChildAt(newposition).setEnabled(true);
		lastposition = newposition;
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.air:
			Toast.makeText(this, "空调清洗", Toast.LENGTH_SHORT).show();
			break;
		case R.id.wash:
			Toast.makeText(this, "洗衣机清洗", Toast.LENGTH_SHORT).show();
			break;
		case R.id.lamp:
			Toast.makeText(this, "油烟机清洗", Toast.LENGTH_SHORT).show();
			break;
		case R.id.hour_clean:
			Toast.makeText(this, "钟点保洁", Toast.LENGTH_SHORT).show();
			break;
		case R.id.plum:
			Toast.makeText(this, "管道疏通", Toast.LENGTH_SHORT).show();
			break;
		case R.id.more:
			Toast.makeText(this, "更多服务", Toast.LENGTH_SHORT).show();
			break;
		case R.id.man1:
			Toast.makeText(this, "U我钟点工", Toast.LENGTH_SHORT).show();
			break;
		case R.id.man2:
			Toast.makeText(this, "洗衣机清洗", Toast.LENGTH_SHORT).show();
			break;

		default:
			break;
		}

	}

	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		isRunning = true;
	}

}
