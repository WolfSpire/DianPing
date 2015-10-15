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
//	private Button btn;// ����Button��ť��

=======
public class MainActivity extends FragmentActivity implements OnCheckedChangeListener{
	@ViewInject(R.id.main_botton_tabs)
    private RadioGroup group;
    @ViewInject(R.id.main_home)
    private  RadioButton main_home;
    private FragmentManager fragmentmanager;//����fragment����
>>>>>>> refs/remotes/origin/Pengxy
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
<<<<<<< HEAD
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
=======
	    ViewUtils.inject(this);
	    //��ʼ�� fragmentmanager
	    fragmentmanager=getSupportFragmentManager();
	    //����Ĭ��ѡ��
	    main_home.setChecked(true);
	    group.setOnCheckedChangeListener(this);
	    //�л���ͬ��fragement
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
//�л���ͬ��fragment
public void changeFragment(Fragment fragment,boolean isInit){
 //��������	
       FragmentTransaction transaction =fragmentmanager.beginTransaction();
       transaction.replace(R.id.main_content, fragment);
       if(!isInit){
    	  transaction.addToBackStack(null);
    	}
       transaction.commit();
      }
    }


