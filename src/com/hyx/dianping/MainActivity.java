package com.hyx.dianping;

import java.security.acl.Group;

import com.hyx.dianping.fragment.FragmentHome;
import com.hyx.dianping.fragment.FragmentMy;
import com.hyx.dianping.fragment.FragmentSearch;
import com.hyx.dianping.fragment.FragmentTuan;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.lidroid.xutils.view.annotation.event.OnClick;

import android.app.Activity;
import android.os.Bundle;
import android.os.TransactionTooLargeException;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.Toast;

<<<<<<< HEAD
public class MainActivity extends Activity {

//	@ViewInject(R.id.btn)
//	private Button btn;// 声明Button按钮；

=======
public class MainActivity extends FragmentActivity implements OnCheckedChangeListener{
	@ViewInject(R.id.main_botton_tabs)
    private RadioGroup group;
    @ViewInject(R.id.main_home)
    private  RadioButton main_home;
    private FragmentManager fragmentmanager;//管理fragment的类
>>>>>>> refs/remotes/origin/Pengxy
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
<<<<<<< HEAD
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
=======
	    ViewUtils.inject(this);
	    //初始化 fragmentmanager
	    fragmentmanager=getSupportFragmentManager();
	    //设置默认选中
	    main_home.setChecked(true);
	    group.setOnCheckedChangeListener(this);
	    //切换不同的fragement
        changeFragment(new FragmentHome(), false);
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) { {
	switch (checkedId) {
	case R.id.main_home:
       changeFragment(new FragmentHome(), true);		
	   break;
	case R.id.main_my:
		changeFragment(new FragmentMy(),true);
		break;
	case R.id.main_search:
		changeFragment(new FragmentSearch(), true);
		break;
	case R.id.main_tuan:
		changeFragment(new FragmentTuan(), true);
		break;
	default:
		break;
>>>>>>> refs/remotes/origin/Pengxy
	}
   }
}
//切换不同的fragment
public void changeFragment(Fragment fragment,boolean isInit){
 //开启事务	
       FragmentTransaction transaction =fragmentmanager.beginTransaction();
       transaction.replace(R.id.main_content, fragment);
       if(!isInit){
    	  transaction.addToBackStack(null);
    	}
       transaction.commit();
      }
    }


