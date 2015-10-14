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
//	private Button btn;// 声明Button按钮；

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ViewUtils.inject(this);
		// 按钮的初始化；
		// btn=(Button)findViewById(R.id.btn);//这样拿到一个Button按钮
		// btn.setOnClickListener(new View.OnClickListener() {
		// //为Button按钮添加一个点击事件；
		// @Override
		// public void onClick(View v) {
		// Toast.makeText(MainActivity.this, "实现了点击",
		// Toast.LENGTH_SHORT).show();
		// //用Toast来显示一句话，当前上下文对象是MainActivity.this。
		// }
		// });
	}
//
//	@OnClick(R.id.btn)
//	// 对事件进行一个绑定；
//	public void click(View view) {
//		Toast.makeText(MainActivity.this, "实现了点击", Toast.LENGTH_SHORT).show();
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
