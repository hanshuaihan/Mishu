package com.app.mishu;

import android.app.Activity;
import android.app.AlertDialog;
import android.view.View.OnClickListener;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends Activity {
	private Button login_title;
	private ImageButton wodejilu;
	private ImageButton bumenjilu;
	private ImageButton tongzhi;
	private TextView dlzt;
	private MishuDB dbHelper;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);
		
		login_title=(Button)findViewById(R.id.login_title);
		wodejilu=(ImageButton)findViewById(R.id.wodejilu);
		bumenjilu=(ImageButton)findViewById(R.id.bumenjilu);
		tongzhi=(ImageButton)findViewById(R.id.tongzhi);
		dlzt=(TextView)findViewById(R.id.dlzt);
		dbHelper=new MishuDB(this,"Mishu.db",null,1);
		dlzt.setText("����δ��¼");
		
		 SQLiteDatabase db=dbHelper.getWritableDatabase();
	        Cursor cursor=db.query("Login", null, null, null, null, null,null);
	        if(cursor.moveToFirst()){
	        	do{
	        		int dlzt0=cursor.getInt(cursor.getColumnIndex("zt"));
	        		
	        		if(dlzt0==1){
	        			dlzt.setText("���ѵ�¼");
	        		}
	        		
	        		
	        		
	        	}while(cursor.moveToNext());
	        	cursor.close();
	        }
		
		login_title.setOnClickListener(new OnClickListener(){
        	@Override
        	public void onClick(View v){
        		
        		
        		
        	Intent intent=new Intent(MainActivity.this,login.class);
    		startActivity(intent);
        	}
        });
		wodejilu.setOnClickListener(new OnClickListener(){
        	@Override
        	public void onClick(View v){
        	
        	Intent intent=new Intent(MainActivity.this,myjilu.class);
    		startActivity(intent);
        	}
        });
		bumenjilu.setOnClickListener(new OnClickListener(){
        	@Override
        	public void onClick(View v){
        	Intent intent=new Intent(MainActivity.this,bumen.class);
    		startActivity(intent);
        	}
        });
		tongzhi.setOnClickListener(new OnClickListener(){
        	@Override
        	public void onClick(View v){
        		
        		SQLiteDatabase db=dbHelper.getWritableDatabase();
    	        Cursor cursor=db.query("Login", null, null, null, null, null,null);
    	        if(cursor.moveToFirst()){
    	        	do{
    	        		int dlzt0=cursor.getInt(cursor.getColumnIndex("zt"));
    	        		
    	        		if(dlzt0==1){
    	        			Intent intent=new Intent(MainActivity.this,bumen.class);
    	            		startActivity(intent);
    	        		}
    	        		
    	        		
    	        		
    	        	}while(cursor.moveToNext());
    	        	
    	        	cursor.close();
    	        }
    	        else{
    	        	new AlertDialog.Builder(MainActivity.this).setTitle("ϵͳ��ʾ")//���öԻ������  
	        		  
	          	     .setMessage("���ȵ�¼��")//������ʾ������  
	          	  
	          	     .setPositiveButton("ȷ��",new DialogInterface.OnClickListener() {//���ȷ����ť  
	          	  
	          	          
	          	  
	          	         @Override  
	          	  
	          	         public void onClick(DialogInterface dialog, int which) {//ȷ����ť����Ӧ�¼�  
	          	  
	          	             // TODO Auto-generated method stub  
	          	  
	          	             
	          	  
	          	         }  
	          	     }).show();
    	        }
        		
        	}
        });
		
	}



}
