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

public class MainActivity extends FragmentActivity implements OnCheckedChangeListener{
	@ViewInject(R.id.main_botton_tabs)
    private RadioGroup group;
    @ViewInject(R.id.main_home)
    private  RadioButton main_home;
    private FragmentManager fragmentmanager;//管理fragment的类
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
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


