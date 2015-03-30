package com.example.wangyi;

import android.app.ActionBar;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

/**
 * Description: <br/>
 * website: <a href="http://www.crazyit.org">crazyit.org</a> <br/>
 * Copyright (C), 2001-2014, Yeeku.H.Lee <br/>
 * This program is protected by copyright laws. <br/>
 * Program Name: <br/>
 * Date:
 * 
 * @author Yeeku.H.Lee kongyeeku@163.com
 * @version 1.0
 */
public class MainActivity extends FragmentActivity
	implements ActionBar.TabListener {
	
	private String [] TabTitles;
	private ViewPager viewPager;
	private ActionBar actionBar;
	private FragmentPagerAdapter pagerAdapter;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		// TabTitles�洢ÿ����ı���
		TabTitles = getResources().getStringArray(R.array.tab_title);
		// ��ȡActionBar����
		actionBar = getActionBar();
		// ��ȡViewPager
		viewPager = (ViewPager) findViewById(R.id.pager);
		// ����һ��FragmentPagerAdapter���󣬸ö�����ΪViewPager�ṩ���Fragment
		pagerAdapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
			// ��ȡ��positionλ�õ�Fragment
			@Override
			public Fragment getItem(int position) {
				Fragment fragment = new DummyFragment();
				Bundle args = new Bundle();
				args.putString(DummyFragment.Title, TabTitles[position]);
				fragment.setArguments(args);
				return fragment;
			}
			// �÷����ķ���ֵi������Adapter�ܹ��������ٸ�Fragment
			@Override
			public int getCount() {
				return TabTitles.length;
			}
		};
		// ����ActionBarʹ��Tab������ʽ
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
		//ΪActionBar���Tab������TabListener
		for(int i=0; i<TabTitles.length; i++) {
			ActionBar.Tab tab = actionBar.newTab();
			tab.setText(TabTitles[i]);
			tab.setTabListener(this);
			actionBar.addTab(tab, i);
		}
		// ΪViewPager�������FragmentPagerAdapter
		viewPager.setAdapter(pagerAdapter);  //��
		// ΪViewPager������¼�������
		viewPager.setOnPageChangeListener(
				new ViewPager.SimpleOnPageChangeListener() {
					// ��ViewPager��ʾ��Fragment�����ı�ʱ�����÷���
					@Override
					public void onPageSelected(int position) {
						actionBar.setSelectedNavigationItem(position);
					}	
				});
		}
	
	@Override
	public void onTabUnselected(ActionBar.Tab tab,
			FragmentTransaction fragmentTransaction) {
		
	}

	// ��ָ��Tab��ѡ��ʱ�����÷���
	@Override
	public void onTabSelected(ActionBar.Tab tab,
			FragmentTransaction fragmentTransaction) {
		viewPager.setCurrentItem(tab.getPosition());
	}

	@Override
	public void onTabReselected(ActionBar.Tab tab,
			FragmentTransaction fragmentTransaction) {
		
	}
}
