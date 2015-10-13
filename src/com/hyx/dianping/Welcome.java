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
	// ��ʱ��ת����ʹ��handler;
	@Override
	// ��дonCreate����
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.welcome);
		// �����ҳ�����һ������ ��Ҫ��һ��ҳ�沼�ֳ�����
		// ������ʱ��ת��ʵ���൱��handler��ʱȥ����һЩ��Ϣ�ͽ���һЩ��Ϣ
		/*
		 * new Handler(new Handler.Callback() { //������յ�����Ϣ�ķ���
		 * 
		 * @Override public boolean handleMessage(Message msg) {
		 * //�����ػص������handlerMessage������ //ʵ��ҳ�����ת startActivity(new
		 * Intent(getApplicationContext(),MainActivity.class)); return false; }
		 * }).sendEmptyMessageDelayed(0, 3000);//��ʾ��ʱ3����������ִ�С�
		 */
		// .sendEmptyMessageDelayed()ǰ���һ��鶼����һ������Ȼ������������ķ�����
		// ʹ��java�еĶ�ʱ�����д���
		Timer timer = new Timer(); // newһ����ʱ������
		timer.schedule(new Task(), 3000);// ��ʱ����ʱִ������ķ�����
	}

	class Task extends TimerTask {// ����һ���ڲ��������һ���µ�����
		// ��ʵ�����ڲ��൱�ڷ�װ��һ���̶߳���
		@Override
		public void run() {
			// ʵ��ҳ�����ת
			if (SharedUtils.getWelcomeBoolean(getBaseContext())) {
				// �����жϲ��ǵ�һ��������
				startActivity(new Intent(getBaseContext(), MainActivity.class));
			} else {
				startActivity(new Intent(Welcome.this, WelcomeGuide.class));
				// ������ʼ�¼��
				SharedUtils.putWelcomeBoolean(getBaseContext(), true);
			}
			finish();
		}

	}

}
