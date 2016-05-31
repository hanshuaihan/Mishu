package com.app.mishu;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class zhuce extends Activity{
	private Button back;
	private Button zhuce;
	private EditText gonghao;
	private EditText mima;
	private EditText xingming;
	private EditText mima2;
	private MishuDB dbHelper;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.zhuce);
		back=(Button)findViewById(R.id.back);
		gonghao=(EditText)findViewById(R.id.gonghao);
		mima=(EditText)findViewById(R.id.mima);
		xingming=(EditText)findViewById(R.id.xingming);
		mima2=(EditText)findViewById(R.id.mima2);
		zhuce=(Button)findViewById(R.id.zhuce);
		

		dbHelper=new MishuDB(this,"Mishu.db",null,1);
		
		
		
		back.setOnClickListener(new OnClickListener(){
        	@Override
        	public void onClick(View v){
        		finish();
        	}
        });
		
		
		zhuce.setOnClickListener(new OnClickListener(){
			@Override
        	public void onClick(View v){
        		
        		String gonghao1=gonghao.getText().toString();
        		String mima0=mima.getText().toString();
        		String mima1=mima2.getText().toString();
        		String xingming1=xingming.getText().toString();
        		
        		if(gonghao1 == null || gonghao1.equals("")){
        			Toast.makeText(getApplication(), "请输入工号",Toast.LENGTH_SHORT).show();
        		}
        		else if(xingming1 == null || xingming1.equals("")){
        			Toast.makeText(getApplication(), "请输入姓名",Toast.LENGTH_SHORT).show();
        		}
        		else if(mima0 == null || mima0.equals("")){
        			Toast.makeText(getApplication(), "请输入密码",Toast.LENGTH_SHORT).show();
        		}
        		else if(mima1 == null || mima1.equals("")){
        			Toast.makeText(getApplication(), "请输入确认密码",Toast.LENGTH_SHORT).show();
        		}
        		else if(!mima0.equals(mima1)){
        			Toast.makeText(getApplication(), "两次密码输入不一致", Toast.LENGTH_SHORT).show();
        		}
        		else {
        			Intent intent=new Intent(zhuce.this,login.class);
            		startActivity(intent);		
            		Toast.makeText(getApplication(), "注册成功",Toast.LENGTH_SHORT).show();
            		
            		SQLiteDatabase db=dbHelper.getWritableDatabase();
					ContentValues values = new ContentValues();
					values.put("gonghao", gonghao1);
					values.put("pswd", mima0);
					values.put("myname", xingming1);
					db.insert("Login", null, values);
            		
        		}
        		
        	}
        });
		
	}

}
