package com.app.mishu;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class MishuDB extends SQLiteOpenHelper{
	
	
	public static final String CREATE_LOGIN="create table Login("
			+"id integer primary key autoincrement,"
			+"gonghao text," //工号
			+"pswd text,"   //密码
			+"lv text,"   //级别 
			+"zt integer," //登录状态
			+"myname text)";    //我的姓名
	public static final String CREATE_MYJILU="create table Myjilu("
			+"id integer primary key autoincrement,"
			+"mybumen text,"
			+"ydts text," //应到天数
			+"sdts text," //实到天数
			+"ccts text," //出差天数
			+"qjts text," //请假天数
			+"jbts text,"//加班天数
			+"sfwsj text)"; //是否为事假

public MishuDB(Context context,String name,CursorFactory factory,int version){
	super(context,name,factory,version);
}
@Override
public void onCreate(SQLiteDatabase db){
	
	db.execSQL(CREATE_LOGIN);
	db.execSQL(CREATE_MYJILU);

}
@Override
public void onUpgrade(SQLiteDatabase db,int oldVersion,int newVersion)
{
	
}
}