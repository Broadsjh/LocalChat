package com.ffchat.localchat;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class HomeActivity extends Activity implements OnClickListener{
	
	TextView tv_gridview_demo;
	TextView tv_login_demo;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);
		tv_login_demo=(TextView) findViewById(R.id.tv_login_demo);
		tv_gridview_demo=(TextView) findViewById(R.id.tv_gridview_demo);
		tv_login_demo.setOnClickListener(this);
		tv_gridview_demo.setOnClickListener(this);
	}
	
	
	
	
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.tv_login_demo:
			Intent intent=new Intent();
			intent.setClass(this, LoginActivity.class);
			startActivity(intent);
			break;
		case R.id.tv_gridview_demo:
			Intent intent2=new Intent();
			intent2.setClass(this, GridViewActivity.class);
			startActivity(intent2);
			break;

		default:
			break;
		}
		
	}
	

}
