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
	// 注释关联id
	private Button btn;
	@ViewInject(R.id.welcome_pager)
	private ViewPager pager;
	private List<View> list;// 定义一个list集合，里面放View对象，用来填充imageview;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.welcome_guide);
		ViewUtils.inject(this);
		initViewPager();// 调用ViewPager方法；
	}

	@OnClick(R.id.welcome_guide_btn)
	public void click(View view) {
		// 实现页面的跳转
		startActivity(new Intent(getBaseContext(), MainActivity.class));
		finish();// 跳转完毕之后呢，也要对跳转的页面进行关闭。调用finish()方法结束当前页面。
	}

	// 初始化ViewPager的方法；
	public void initViewPager() {
		list = new ArrayList<View>();
		ImageView iv = new ImageView(this);
		iv.setImageResource(R.drawable.guide_01);// 设置我们的图片资源
		list.add(iv);
		ImageView iv1 = new ImageView(this);
		iv1.setImageResource(R.drawable.guide_02);
		list.add(iv1);
		ImageView iv2 = new ImageView(this);
		iv2.setImageResource(R.drawable.guide_03);
		list.add(iv2);
		// 数据源就放在这里了，list集合就初始化完毕。
		pager.setAdapter(new MyPagerAdapter());// 将页卡进行显示；
		// 监听ViewPager滑动效果
		pager.setOnPageChangeListener(new OnPageChangeListener() {
			// 页卡被选中的方法；
			@Override
			public void onPageSelected(int arg0) {
				// 如果是第三个页面
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

	// 定义ViewPager的适配器
	class MyPagerAdapter extends PagerAdapter {
		// 计算需要多少个item显示；
		@Override
		public int getCount() {
			return list.size();
		}

		@Override
		public boolean isViewFromObject(View arg0, Object arg1) {
			return arg0 == arg1;
		}

		// 重写初始化item实例的方法
		@Override
		public Object instantiateItem(ViewGroup container, int position) {
			// 这里参数定义的container其实传进来的就是我们的ViewPager;
			container.addView(list.get(position));
			// 利用container对象来添加view对象进来；根椐传过来的索引位置来拿到索引位置上的view对象；
			return list.get(position);// 这里返回的也是我们的view对象
			// 返回的是Object，正好与前面的isViewFromObject形成对比。
		}

		// 重写item销毁的方法
		@Override
		public void destroyItem(ViewGroup container, int position, Object object) {
			// super.destroyItem(container, position, object);
			// 我们这里用的Item销毁的方法不同于系统自带的super.dest...方法；
			// 所以没有注释掉的话，会出错。
			container.removeView(list.get(position));
		}
	}
}
