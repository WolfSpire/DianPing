package com.hyx.dianping;

import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.lidroid.xutils.view.annotation.event.OnClick;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {
//	@ViewInject(R.id.btn)
//	private Button btn;// ����Button��ť��

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ViewUtils.inject(this);
		// ��ť�ĳ�ʼ����
		// btn=(Button)findViewById(R.id.btn);//�����õ�һ��Button��ť
		// btn.setOnClickListener(new View.OnClickListener() {
		// //ΪButton��ť���һ������¼���
		// @Override
		// public void onClick(View v) {
		// Toast.makeText(MainActivity.this, "ʵ���˵��",
		// Toast.LENGTH_SHORT).show();
		// //��Toast����ʾһ�仰����ǰ�����Ķ�����MainActivity.this��
		// }
		// });
	}
//
//	@OnClick(R.id.btn)
//	// ���¼�����һ���󶨣�
//	public void click(View view) {
//		Toast.makeText(MainActivity.this, "ʵ���˵��", Toast.LENGTH_SHORT).show();
//	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
