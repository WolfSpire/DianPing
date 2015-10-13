package com.hyx.dianping;

import java.util.Timer;
import java.util.TimerTask;

import com.hyx.dianping.utils.SharedUtils;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

public class Welcome extends Activity {
	// 延时跳转可以使用handler;
	@Override
	// 重写onCreate方法
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.welcome);
		// 把这个页面关联一个布局 需要拿一个页面布局出来；
		// 这种延时跳转其实就相当于handler延时去发送一些消息和接收一些消息
		/*
		 * new Handler(new Handler.Callback() { //处理接收到的消息的方法
		 * 
		 * @Override public boolean handleMessage(Message msg) {
		 * //这里呢回调本身的handlerMessage方法； //实现页面的跳转 startActivity(new
		 * Intent(getApplicationContext(),MainActivity.class)); return false; }
		 * }).sendEmptyMessageDelayed(0, 3000);//表示延时3秒进行任务的执行。
		 */
		// .sendEmptyMessageDelayed()前面的一大块都看作一个对象，然后调用这个对象的方法；
		// 使用java中的定时器进行处理；
		Timer timer = new Timer(); // new一个定时器对象；
		timer.schedule(new Task(), 3000);// 定时器延时执行任务的方法；
	}

	class Task extends TimerTask {// 给它一个内部类来添加一个新的任务
		// 其实它的内部相当于封装了一个线程对象；
		@Override
		public void run() {
			// 实现页面的跳转
			if (SharedUtils.getWelcomeBoolean(getBaseContext())) {
				// 条件判断不是第一次启动；
				startActivity(new Intent(getBaseContext(), MainActivity.class));
			} else {
				startActivity(new Intent(Welcome.this, WelcomeGuide.class));
				// 保存访问记录；
				SharedUtils.putWelcomeBoolean(getBaseContext(), true);
			}
			finish();
		}

	}

}
