package com.hyx.dianping;

import java.util.ArrayList;
import java.util.List;

import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.lidroid.xutils.view.annotation.event.OnClick;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

public class WelcomeGuide extends Activity {
	@ViewInject(R.id.welcome_guide_btn)
	// ע�͹���id
	private Button btn;
	@ViewInject(R.id.welcome_pager)
	private ViewPager pager;
	private List<View> list;// ����һ��list���ϣ������View�����������imageview;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.welcome_guide);
		ViewUtils.inject(this);
		initViewPager();// ����ViewPager������
	}

	@OnClick(R.id.welcome_guide_btn)
	public void click(View view) {
		// ʵ��ҳ�����ת
		startActivity(new Intent(getBaseContext(), MainActivity.class));
		finish();// ��ת���֮���أ�ҲҪ����ת��ҳ����йرա�����finish()����������ǰҳ�档
	}

	// ��ʼ��ViewPager�ķ�����
	public void initViewPager() {
		list = new ArrayList<View>();
		ImageView iv = new ImageView(this);
		iv.setImageResource(R.drawable.guide_01);// �������ǵ�ͼƬ��Դ
		list.add(iv);
		ImageView iv1 = new ImageView(this);
		iv1.setImageResource(R.drawable.guide_02);
		list.add(iv1);
		ImageView iv2 = new ImageView(this);
		iv2.setImageResource(R.drawable.guide_03);
		list.add(iv2);
		// ����Դ�ͷ��������ˣ�list���Ͼͳ�ʼ����ϡ�
		pager.setAdapter(new MyPagerAdapter());// ��ҳ��������ʾ��
		// ����ViewPager����Ч��
		pager.setOnPageChangeListener(new OnPageChangeListener() {
			// ҳ����ѡ�еķ�����
			@Override
			public void onPageSelected(int arg0) {
				// ����ǵ�����ҳ��
				if (arg0 == 2) {
					btn.setVisibility(View.VISIBLE);
				} else {
					btn.setVisibility(View.GONE);
				}
			}

			@Override
			public void onPageScrollStateChanged(int arg0) {
			}

			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
			}
		});
	}

	// ����ViewPager��������
	class MyPagerAdapter extends PagerAdapter {
		// ������Ҫ���ٸ�item��ʾ��
		@Override
		public int getCount() {
			return list.size();
		}

		@Override
		public boolean isViewFromObject(View arg0, Object arg1) {
			return arg0 == arg1;
		}

		// ��д��ʼ��itemʵ���ķ���
		@Override
		public Object instantiateItem(ViewGroup container, int position) {
			// ������������container��ʵ�������ľ������ǵ�ViewPager;
			container.addView(list.get(position));
			// ����container���������view�����������駴�����������λ�����õ�����λ���ϵ�view����
			return list.get(position);// ���ﷵ�ص�Ҳ�����ǵ�view����
			// ���ص���Object��������ǰ���isViewFromObject�γɶԱȡ�
		}

		// ��дitem���ٵķ���
		@Override
		public void destroyItem(ViewGroup container, int position, Object object) {
			// super.destroyItem(container, position, object);
			// ���������õ�Item���ٵķ�����ͬ��ϵͳ�Դ���super.dest...������
			// ����û��ע�͵��Ļ��������
			container.removeView(list.get(position));
		}
	}
}
