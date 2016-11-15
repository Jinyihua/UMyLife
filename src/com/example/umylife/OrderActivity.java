package com.example.umylife;

import java.util.ArrayList;
import java.util.List;

import com.example.adapter.FragmentAdapter;
import com.example.fragment.AllFragment;
import com.example.fragment.ObligationFragment;
import com.example.fragment.ForTheGoodsFragment;
import com.example.fragment.ToCommentOnFragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RadioButton;

public class OrderActivity extends FragmentActivity implements OnClickListener,
		OnPageChangeListener {
	private ViewPager viewPager;
	private RadioButton all_rb;
	private RadioButton obligation_rb;
	private RadioButton for_the_goods_rb;
	private RadioButton to_comment_on_rb;
	private List<Fragment> mFragmentList = new ArrayList<Fragment>();
	private FragmentAdapter mFragmentAdapter;
	private AllFragment mAllFg;
	private ForTheGoodsFragment mForTheGoodsFg;
	private ObligationFragment mObligationFg;
	private ToCommentOnFragment mCommentOnFg;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_order);
		initView();
		init();
		initClick();

	}

	private void init() {
		mAllFg = new AllFragment();
		mObligationFg = new ObligationFragment();
		mForTheGoodsFg = new ForTheGoodsFragment();
		mCommentOnFg = new ToCommentOnFragment();
		mFragmentList.add(mAllFg);
		mFragmentList.add(mObligationFg);
		mFragmentList.add(mForTheGoodsFg);
		mFragmentList.add(mCommentOnFg);
		mFragmentAdapter = new FragmentAdapter(
				this.getSupportFragmentManager(), mFragmentList);
		viewPager.setAdapter(mFragmentAdapter);
		all_rb.setEnabled(false);

	}

	private void initClick() {
		all_rb.setOnClickListener(this);
		obligation_rb.setOnClickListener(this);
		for_the_goods_rb.setOnClickListener(this);
		to_comment_on_rb.setOnClickListener(this);
		viewPager.setOnPageChangeListener(this);

	}

	private void initView() {
		viewPager = (ViewPager) findViewById(R.id.viewpager_order);
		all_rb = (RadioButton) findViewById(R.id.all_rb);
		obligation_rb = (RadioButton) findViewById(R.id.obligation_rb);
		for_the_goods_rb = (RadioButton) findViewById(R.id.for_the_goods_rb);
		to_comment_on_rb = (RadioButton) findViewById(R.id.to_comment_on_rb);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.all_rb:
			viewPager.setCurrentItem(0);
			all_rb.setTextColor(getResources().getColor(R.color.my_green));
			obligation_rb.setTextColor(getResources().getColor(
					R.color.text_color));
			for_the_goods_rb.setTextColor(getResources().getColor(
					R.color.text_color));
			to_comment_on_rb.setTextColor(getResources().getColor(
					R.color.text_color));
			all_rb.setEnabled(false);
			obligation_rb.setEnabled(true);
			for_the_goods_rb.setEnabled(true);
			to_comment_on_rb.setEnabled(true);
			break;
		case R.id.obligation_rb:
			viewPager.setCurrentItem(1);
			all_rb.setTextColor(getResources().getColor(R.color.text_color));
			obligation_rb.setTextColor(getResources()
					.getColor(R.color.my_green));
			for_the_goods_rb.setTextColor(getResources().getColor(
					R.color.text_color));
			to_comment_on_rb.setTextColor(getResources().getColor(
					R.color.text_color));
			all_rb.setEnabled(true);
			obligation_rb.setEnabled(false);
			for_the_goods_rb.setEnabled(true);
			to_comment_on_rb.setEnabled(true);
			break;
		case R.id.for_the_goods_rb:
			viewPager.setCurrentItem(2);
			all_rb.setTextColor(getResources().getColor(R.color.text_color));
			obligation_rb.setTextColor(getResources().getColor(
					R.color.text_color));
			for_the_goods_rb.setTextColor(getResources().getColor(
					R.color.my_green));
			to_comment_on_rb.setTextColor(getResources().getColor(
					R.color.text_color));
			all_rb.setEnabled(true);
			obligation_rb.setEnabled(true);
			for_the_goods_rb.setEnabled(false);
			to_comment_on_rb.setEnabled(true);
			break;
		case R.id.to_comment_on_rb:
			viewPager.setCurrentItem(3);
			all_rb.setTextColor(getResources().getColor(R.color.text_color));
			obligation_rb.setTextColor(getResources().getColor(
					R.color.text_color));
			for_the_goods_rb.setTextColor(getResources().getColor(
					R.color.text_color));
			to_comment_on_rb.setTextColor(getResources().getColor(
					R.color.my_green));
			all_rb.setEnabled(true);
			obligation_rb.setEnabled(true);
			for_the_goods_rb.setEnabled(true);
			to_comment_on_rb.setEnabled(false);
			break;

		default:
			break;
		}

	}

	@Override
	public void onPageScrollStateChanged(int arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onPageScrolled(int arg0, float arg1, int arg2) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onPageSelected(int arg0) {
		// TODO Auto-generated method stub
		int currentItem = viewPager.getCurrentItem();
		switch (arg0) {
		case 0:
			all_rb.setTextColor(getResources().getColor(R.color.my_green));
			obligation_rb.setTextColor(getResources().getColor(
					R.color.text_color));
			for_the_goods_rb.setTextColor(getResources().getColor(
					R.color.text_color));
			to_comment_on_rb.setTextColor(getResources().getColor(
					R.color.text_color));
			all_rb.setEnabled(false);
			obligation_rb.setEnabled(true);
			for_the_goods_rb.setEnabled(true);
			to_comment_on_rb.setEnabled(true);
			break;
		case 1:
			all_rb.setTextColor(getResources().getColor(R.color.text_color));
			obligation_rb.setTextColor(getResources()
					.getColor(R.color.my_green));
			for_the_goods_rb.setTextColor(getResources().getColor(
					R.color.text_color));
			to_comment_on_rb.setTextColor(getResources().getColor(
					R.color.text_color));
			all_rb.setEnabled(true);
			obligation_rb.setEnabled(false);
			for_the_goods_rb.setEnabled(true);
			to_comment_on_rb.setEnabled(true);
			break;
		case 2:
			all_rb.setTextColor(getResources().getColor(R.color.text_color));
			obligation_rb.setTextColor(getResources().getColor(
					R.color.text_color));
			for_the_goods_rb.setTextColor(getResources().getColor(
					R.color.my_green));
			to_comment_on_rb.setTextColor(getResources().getColor(
					R.color.text_color));
			all_rb.setEnabled(true);
			obligation_rb.setEnabled(true);
			for_the_goods_rb.setEnabled(false);
			to_comment_on_rb.setEnabled(true);
			break;
		case 3:
			all_rb.setTextColor(getResources().getColor(R.color.text_color));
			obligation_rb.setTextColor(getResources().getColor(
					R.color.text_color));
			for_the_goods_rb.setTextColor(getResources().getColor(
					R.color.text_color));
			to_comment_on_rb.setTextColor(getResources().getColor(
					R.color.my_green));
			all_rb.setEnabled(true);
			obligation_rb.setEnabled(true);
			for_the_goods_rb.setEnabled(true);
			to_comment_on_rb.setEnabled(false);
			break;
		default:
			break;

		}
	}

}
