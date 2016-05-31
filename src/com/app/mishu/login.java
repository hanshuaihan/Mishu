package com.app.mishu;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class login extends Activity{
	private Button zhuce1;
	private Button back;
	private Button login;
	private EditText gonghao_dl;
	private EditText pswd;
	private MishuDB dbHelper;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.login);
		
		zhuce1=(Button)findViewById(R.id.zhuce1);
		back=(Button)findViewById(R.id.back);
		login=(Button)findViewById(R.id.login);
		gonghao_dl=(EditText)findViewById(R.id.gonghao_dl);
		pswd=(EditText)findViewById(R.id.pswd);
		dbHelper=new MishuDB(this,"Mishu.db",null,1);
		
		zhuce1.setOnClickListener(new OnClickListener(){
        	@Override
        	public void onClick(View v){
        	Intent intent=new Intent(login.this,zhuce.class);
    		startActivity(intent);
        	}
        });
		back.setOnClickListener(new OnClickListener(){
        	@Override
        	public void onClick(View v){
        		finish();
        	}
        });
		login.setOnClickListener(new OnClickListener(){
        	@Override
        	public void onClick(View v){
        		String gonghao=gonghao_dl.getText().toString();
        		String mima=pswd.getText().toString();
        		if(gonghao == null || gonghao.equals("")){
        			Toast.makeText(getApplication(), "«Î ‰»Îπ§∫≈",Toast.LENGTH_SHORT).show();
        		}
        		else if(mima == null || mima.equals("")){
        			Toast.makeText(getApplication(), "«Î ‰»Î√‹¬Î",Toast.LENGTH_SHORT).show();
        		}
        		else{
        			SQLiteDatabase db=dbHelper.getWritableDatabase();
        	        Cursor cursor=db.query("Login", null, null, null, null, null,null);
        	        if(cursor.moveToFirst()){
        	        	do{
        	        		String gonghao0=cursor.getString(cursor.getColumnIndex("gonghao"));
        	        		String mima0=cursor.getString(cursor.getColumnIndex("pswd"));
        	        		if((gonghao==gonghao0 || gonghao.equals(gonghao0)) && (mima==mima0 || mima.equals(mima0))){
        	        			Toast.makeText(getApplication(), "µ«¬º≥…π¶", Toast.LENGTH_SHORT).show();
        	        			Intent intent=new Intent(login.this,MainActivity.class);
        	            		startActivity(intent);	
        	            		
        	            		ContentValues values = new ContentValues();
        						values.put("zt", "1");
        						db.insert("Login", null, values);
        	            		
        	        		}
        	        		else{
        	        			Toast.makeText(getApplication(), "π§∫≈ªÚ√‹¬Î≤ª’˝»∑", Toast.LENGTH_SHORT).show();
        	        		}
        	        	}
        	        	
        	        	while(cursor.moveToNext());
        	        	cursor.close();
        	        }
        	        else{
        	        	Toast.makeText(getApplication(), "ƒ˙…–Œ¥◊¢≤·", Toast.LENGTH_SHORT).show();
        	        }
        		}
        	}
        });
	}
}
